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
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by lionzxy on 6/9/16.
 */
public class FirstLoginHandler {

    public static boolean triedToWarnPlayer = false;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !triedToWarnPlayer) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            player.addChatComponentMessage(new ChatComponentText("[MTUtils] Big Thank for using MTUtils."));
            player.addChatComponentMessage(new ChatComponentText("[MTUtils] " + EnumChatFormatting.RED + "[WARNING]" + EnumChatFormatting.WHITE + " Since 1.5 " + EnumChatFormatting.YELLOW + "mods.MTUtils" + EnumChatFormatting.WHITE + " not work. Rename it to " + EnumChatFormatting.YELLOW + "mods.MTUtils.Utils"));
            triedToWarnPlayer = true;
        }
    }
}
