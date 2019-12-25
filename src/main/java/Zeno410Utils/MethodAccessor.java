package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 *
 * @author Zeno410
 */
public class MethodAccessor<ObjectType>{
    private Method method;
    private final String methodName;
    public MethodAccessor(String _fieldName) {
        methodName = _fieldName;
    }

    private Method method(ObjectType example) {
        Class classObject = example.getClass();
        if (method == null) {
            try {setMethod(classObject);}
            catch(IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return method;
    }

    private void setMethod(Class classObject) throws IllegalAccessException{
        // hunts through the class object and all superclasses looking for the field name
        Method [] methods;
        do {
            methods = classObject.getDeclaredMethods();
            for (int i = 0; i < methods.length;i ++) {
                if (methods[i].getName().contains(methodName)) {
                    method = methods[i];
                    method.setAccessible(true);
                    return;
                }
            }
            classObject = classObject.getSuperclass();
        } while (classObject != Object.class);
        throw new RuntimeException(methodName +" not found in class "+classObject.getName());
    }

    public void run(ObjectType object) {
        try {
            method(object).invoke(object);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }

    }

}