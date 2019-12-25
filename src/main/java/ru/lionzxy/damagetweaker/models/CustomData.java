package ru.lionzxy.damagetweaker.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import cpw.mods.fml.common.FMLLog;
import minetweaker.api.data.IData;
import minetweaker.mc1710.data.NBTConverter;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by lionzxy on 6/8/16.
 */
public abstract class CustomData {

    final static String key = "data";
    private IData data;

    public CustomData() {
    }

    public IData getData() {
        if (!load())
            data = NBTConverter.from(getEmptyTag(), false);
        return data;
    }

    public void setData(IData data) {
        this.data = data;
        save();
    }


    public IData fromString(String nbt) throws Exception {
        NBTTagCompound nbtTagCompound = (NBTTagCompound) JsonToNBT.func_150315_a(nbt);
        IData tmpData = NBTConverter.from(nbtTagCompound.getTag(key), false);
        return tmpData == null ? NBTConverter.from(getEmptyTag(), false) : tmpData;
    }

    public String toString() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        if (data == null)
            data = NBTConverter.from(getEmptyTag(), false);
        nbtTagCompound.setTag(key, NBTConverter.from(data));

        return nbtTagCompound.toString();
    }

    public boolean load() {
        FMLLog.info("Data loading...");
        File jsonFile = getFile();
        if (!jsonFile.exists())
            return false;

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(jsonFile);

            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, "UTF-8");
            data = fromString(writer.toString());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        FMLLog.fine("Data load!");
        return true;
    }

    public void save() {
        FMLLog.info("Data saving...");
        File jsonFile = getFile();
        OutputStream outputStream = null;
        try {
            jsonFile.createNewFile();
            outputStream = new FileOutputStream(jsonFile);

            outputStream.write(toString().getBytes(Charset.forName("UTF-8")));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        FMLLog.fine("Data saved!");
    }

    public NBTTagCompound getEmptyTag() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setString("CustomDataType", getName());
        return nbtTagCompound;
    }

    public String getName() {
        return "Unknown";
    }

    abstract File getFile();
}
