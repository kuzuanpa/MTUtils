package exterminatorJeff.undergroundBiomes.api;

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
public class NamedVanillaItem extends NamedItem {
    public NamedVanillaItem(String name) {
        super(name);
        id = UBIDs.itemID(name);
        item = UBIDs.itemNamed(name);
    }


    public final static NamedItem axeStone = new NamedVanillaItem("stone_pickaxe");
    public final static NamedItem blazeRod = new NamedVanillaItem("blaze_rod");
    public final static NamedItem bow = new NamedVanillaItem("bow");
    public final static NamedItem brewingStand = new NamedVanillaItem("brewing_stand");
    public final static NamedItem clay = new NamedVanillaItem("clay");
    public final static NamedItem coal = new NamedVanillaItem("coal");
    public final static NamedItem dyePowder = new NamedVanillaItem("dye");
    public final static NamedItem flint = new NamedVanillaItem("flint");
    public final static NamedItem goldNugget = new NamedVanillaItem("gold_nugget");
    public final static NamedItem hoeStone = new NamedVanillaItem("stone_hoe");
    public final static NamedItem ingotIron = new NamedVanillaItem("iron_ingot");
    public final static NamedItem pickaxeStone = new NamedVanillaItem("stone_pickaxe");
    public final static NamedItem redstone = new NamedVanillaItem("redstone");
    public final static NamedItem redstoneRepeater = new NamedVanillaItem("repeater");
    public final static NamedItem shovelStone = new NamedVanillaItem("stone_shovel");
    public final static NamedItem stick = new NamedVanillaItem("stick");
    public final static NamedItem swordStone = new NamedVanillaItem("stone_sword");

}
