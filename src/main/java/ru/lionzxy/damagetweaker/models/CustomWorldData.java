package ru.lionzxy.damagetweaker.models;

import java.io.File;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import com.google.common.io.Files;

import cpw.mods.fml.common.Loader;
import minetweaker.api.data.IData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.SaveHandler;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by lionzxy on 6/8/16.
 */
@ZenClass("mods.MTUtils.WorldData")
public class CustomWorldData extends CustomData {

    public static File getWorldFolder() {
        MinecraftServer mcServerInstance = MinecraftServer.getServer();
        String folderName = mcServerInstance.getFolderName();
        ISaveFormat saveFormat = mcServerInstance.getActiveAnvilConverter();
        SaveHandler saveHandler = (SaveHandler) saveFormat.getSaveLoader(folderName, false); // You will have to typecast here
        return saveHandler.getWorldDirectory();
    }

    public static CustomWorldData getWorld() {
        return new CustomWorldData();
    }

    @Override
    File getFile() {
        try {
            File worldTemplare = new File(Loader.instance().getConfigDir() + "/MTUtils/data/", "newworld.nbt");
            File worldNow = new File(getWorldFolder(), "MTUtilsData.nbt");
            if (!worldNow.exists())
                if (worldTemplare.exists())
                    Files.copy(worldTemplare, worldNow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File(getWorldFolder(), "MTUtilsData.nbt");
    }

    @ZenMethod
    public static IData get() {
        try {
            return getWorld().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ZenMethod
    public static void set(IData data) {
        try {
            getWorld().setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ZenMethod
    public static boolean exists() {
        return getWorld().getFile().exists();
    }
}
