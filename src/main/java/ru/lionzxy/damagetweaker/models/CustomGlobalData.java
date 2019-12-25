package ru.lionzxy.damagetweaker.models;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import java.io.File;

import cpw.mods.fml.common.Loader;
import minetweaker.api.data.IData;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by lionzxy on 6/8/16.
 */
@ZenClass("mods.MTUtils.GlobalData")
public class CustomGlobalData extends CustomData {
    private static CustomGlobalData instance = null;

    public static CustomGlobalData getInstance(){
        if(instance == null)
            instance = new CustomGlobalData();
        return instance;

    }

    @Override
    File getFile() {
        return new File(Loader.instance().getConfigDir() + File.separator + "..", "MTUtilsData.nbt");
    }

    @ZenMethod
    public static IData get() {
        try {
            return getInstance().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ZenMethod
    public static void set(IData data) {
        try {
            getInstance().getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ZenMethod
    public static boolean exists(){
        return getInstance().getFile().exists();
    }
}
