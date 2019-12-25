package ru.lionzxy.damagetweaker.models;

import java.util.List;
import java.util.Random;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

/**
 * Created by nikit_000 on 04.10.2015.
 */
public class DropsObject {

    public static List<DropsObject> dropsObj;

    public ItemStack harvestItem, block;
    ItemStack drops[];
    ItemStack falseDrops[];
    int stackSizes[];
    int stackSizesFalse[];
    float quantyDrop[];

    public DropsObject(ItemStack harvestItem, ItemStack drops[], float quantyDrop[], ItemStack falseDrops[], ItemStack block) {
        this.harvestItem = harvestItem;
        this.drops = drops;
        this.quantyDrop = quantyDrop;
        this.stackSizes = new int[drops.length];
        for (int i = 0; i < stackSizes.length; i++)
            stackSizes[i] = drops[i].stackSize;
        this.stackSizesFalse = new int[falseDrops.length];
        for (int i = 0; i < stackSizesFalse.length; i++)
            stackSizesFalse[i] = falseDrops[i].stackSize;
        this.falseDrops = falseDrops;
        this.block = block;
    }

    public void replaceDrop(List<ItemStack> list, ItemStack harvester) {
        if (isHarvestItem(harvester)) {
            Random random = new Random();
            list.clear();
            for (int i = 0; i < drops.length; i++) {
                if (random.nextDouble() < quantyDrop[i]) {
                    drops[i].stackSize = stackSizes[i];
                    list.add(drops[i]);
                }
            }
        } else for (int i = 0; i < drops.length; i++) {
            falseDrops[i].stackSize = stackSizesFalse[i];
            list.add(falseDrops[i]);
        }
    }

    public boolean isHarvestItem(ItemStack harvester) {
        return (harvester == null && harvestItem == null) || (harvester != null && harvestItem != null && isEqual(harvestItem, harvester));
    }

    public static boolean isEqual(ItemStack one, ItemStack two) {
        if (one.getItem() instanceof ItemTool && two.getItem() instanceof ItemTool && one.getItemDamage() == 0)
            return one.getItem() == two.getItem();
        return one.getItem() == two.getItem() && one.getItemDamage() == two.getItemDamage();
    }

    public boolean isBlockEqual(ItemStack block) {
        return isEqual(block,this.block);
    }

}
