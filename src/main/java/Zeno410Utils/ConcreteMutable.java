
package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

/**
 *
 * @author Zeno410
 */
public class ConcreteMutable<Type> implements Mutable<Type> {
    private Type data;
    private final Trackers<Type> trackers = new Trackers<Type>();

    public ConcreteMutable(Type initialValue) {
        set(initialValue);
    }

    public ConcreteMutable() {}

    public void set(Type newValue) {
        if ((data==null&&newValue != null)||(data.equals(value()))){
            data = newValue;
            trackers.update(data);
        }
    }

    public Type value() {
        return data;
    }

    public void informOnChange(Acceptor<Type> target) {
        trackers.informOnChange(target);
    }

    public void stopInforming(Acceptor<Type> target) {
        trackers.stopInforming(target);
    }


}
