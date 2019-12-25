
package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import java.util.HashMap;

/**
 * This class keeps a registry of keyed objects, generating new ones as necessary
 * Key must be a Keyable but that isn't enforced since I can't put an interface on
 * default classes like String that are the most common keys
 * @author Zeno410
 */
public class KeyedRegistry<Key,Type> {
    private HashMap<Key,Type> items = new HashMap<Key,Type>();
    private final Function<Key,Type> maker;
    public KeyedRegistry(Function<Key,Type> maker) {
        this.maker = maker;
    }
    public Type item(Key key) {
        Type result = items.get(key);
        if (result != null) return result;
        result = maker.result(key);
        items.put(key, result);
        return result;
    }

    public Iterable<Key> keys() {
        return items.keySet();
    }

    public void clear() {
        items = new HashMap<Key,Type>();
    }

    public void remove(Key toRemove) {
        items.remove(toRemove);
    }

    public int size() {return items.size();}

}
