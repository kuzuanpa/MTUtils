package exterminatorJeff.undergroundBiomes.api;

import java.util.logging.Logger;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import Zeno410Utils.Zeno410Logger;
import net.minecraft.block.Block;

/**
 *
 * @author Zeno410
 */
public class NamedSlabPair {
    public static final Logger logger = new Zeno410Logger("NamedSlabPair").logger();
    public final NamedBlock half;
    public final NamedBlock full;

    public NamedSlabPair(NamedBlock material) {
        half = new NamedSlab(material.internal()+"HalfSlab");
        full = new NamedSlab(material.internal()+"FullSlab");
    }

    public static class NamedSlab extends NamedBlock {
        public NamedSlab(String name) {super(name);}

        public Block block() {
            // this doesn't register its own items so it doesn't have the block
            Block result =  Block.getBlockFromName(internal());
            if (result == null) {
                result =  Block.getBlockFromName(external());
            }
            return result;
        }

    }

}
