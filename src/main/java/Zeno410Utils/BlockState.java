
package Zeno410Utils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import net.minecraft.block.Block;

/**
 *
 * @author Zeno410
 */
public class BlockState {
    public final Block block;
    public final int metadata;

    public BlockState(Block block, int metadata) {
        this.block = block;
        this.metadata = metadata;
    }

}
