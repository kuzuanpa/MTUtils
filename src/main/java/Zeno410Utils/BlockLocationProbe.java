
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
 * This is a class for probing hash sets of BlockLocatable for having blocks
 * it differs in that coordinates can be changed
 * primarily for probing Hashsets
 * @author Zeno410
 */
public class BlockLocationProbe extends BlockLocation{
    public BlockLocationProbe(int x, int y, int z) {
        super(x,y,z);
    }

    public void setX(int newX) {super.setX(newX);}
    public void setY(int newY) {super.setY(newY);}
    public void setZ(int newZ) {super.setZ(newZ);}

    public BlockLocation forStorage() {return new BlockLocation(x(),y(),z());}

}
