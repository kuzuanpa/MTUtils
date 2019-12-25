
package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import net.minecraft.util.StatCollector;

/**
 *
 * @author Zeno410
 */
public class MinecraftName {
    private final String unlocalized;
    public MinecraftName(String unlocalized) {
        this.unlocalized = unlocalized;
    }
    public String localized() {
        return StatCollector.translateToLocal(this.unlocalized() + ".name");
        //return unlocalized();
    }
    public String unlocalized() {return unlocalized;}

    public boolean legit() {
        return StatCollector.canTranslate(unlocalized+".name");
    }
}
