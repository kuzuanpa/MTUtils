package ru.lionzxy.damagetweaker.handlers;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import ru.lionzxy.damagetweaker.models.DropsObject;


/**
 * Created by nikit_000 on 04.10.2015.
 */
public class DropHandler {

    @SubscribeEvent
    public void onBlockDestroy(BlockEvent.HarvestDropsEvent event) {
        if (event.block != null && event.harvester != null && DropsObject.dropsObj != null) {
            ItemStack block = new ItemStack(event.block, 1, event.blockMetadata);
            for (DropsObject dropsObject : DropsObject.dropsObj)
                if (dropsObject.isBlockEqual(block)) {
                    event.drops.clear();
                    dropsObject.replaceDrop(event.drops, event.harvester.getCurrentEquippedItem());

                }
        }
    }
}
