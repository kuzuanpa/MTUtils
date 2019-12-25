
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
public class Valued<Type> implements Comparable<Valued<Type>> {
    private double value;
    private Type item;

    public Valued(double _count,Type _item) {
        value = _count;
        item  = _item;
    }

    public double vanlue() {return value;}
    public Type item() {return item;}

    public int compareTo(Valued<Type> arg0) {
        if (this.value > arg0.value) return 1;
        if (this.value == arg0.value) return 0;
        return -1;
    }

}