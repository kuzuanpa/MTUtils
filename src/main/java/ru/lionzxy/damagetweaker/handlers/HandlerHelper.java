package ru.lionzxy.damagetweaker.handlers;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import gregapi.data.CS;
import minetweaker.MineTweakerAPI;
import net.minecraftforge.common.MinecraftForge;
import ru.lionzxy.damagetweaker.MTUtilsMod;
import ru.lionzxy.damagetweaker.models.CustomGlobalData;
import ru.lionzxy.damagetweaker.models.CustomWorldData;
import ru.lionzxy.damagetweaker.mods.GregTechHandler;

/**
 * Created by lionzxy on 6/9/16.
 */
public class HandlerHelper {

    public static void registerAllHandler() {
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        MineTweakerAPI.registerClass(NBTHandlers.class);
        MineTweakerAPI.registerClass(CustomGlobalData.class);
        MineTweakerAPI.registerClass(CustomWorldData.class);
        MineTweakerAPI.registerClass(MTHandlers.class);
        if (Loader.isModLoaded(CS.ModIDs.GAPI))
            MineTweakerAPI.registerClass(GregTechHandler.class);
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()
                && MTUtilsMod.configuration.get("general", "ThankMessage", true).getBoolean())
            FMLCommonHandler.instance().bus().register(new FirstLoginHandler());
    }
}
