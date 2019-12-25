
package Zeno410Utils;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

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
public class BlockLister {
    public static Logger logger = new Zeno410Logger("BlockLister").logger();

    public void listRegistrations() {
        Set<Object> keys = Block.blockRegistry.getKeys();
        TreeSet<Object> sortedKeys = new TreeSet<Object>();
        for (Object name: Block.blockRegistry.getKeys()) {
            sortedKeys.add(name);
        }
        for (Object name: sortedKeys) {
            Object block = Block.blockRegistry.getObject(name);
            int ID = Block.blockRegistry.getIDForObject(block);
            logger.info(""+ID+","+name+","+block.toString());
        }

    }

}
