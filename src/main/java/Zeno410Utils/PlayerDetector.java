
package Zeno410Utils;

import java.util.HashMap;
import java.util.HashSet;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;

/**
 *
 * @author Zeno410
 */

public class PlayerDetector {
    private HashMap<PlayerID,EntityPlayerMP> activePlayers = new HashMap<PlayerID,EntityPlayerMP>();
    private HashSet<Acceptor<EntityPlayerMP>> onLogin = new HashSet<Acceptor<EntityPlayerMP>>();
    private HashSet<Acceptor<EntityPlayerMP>> onLogout = new HashSet<Acceptor<EntityPlayerMP>>();
    private Dispatcher dispatcher = new Dispatcher();

    public PlayerDetector() {
        // note: registers itself
        FMLCommonHandler.instance().bus().register(dispatcher);
        MinecraftForge.EVENT_BUS.register(dispatcher);
    }


    public void addLoginAction(Acceptor<EntityPlayerMP> action) {
        onLogin.add(action);
    }

    public void addLogoutAction(Acceptor<EntityPlayerMP> action) {
        onLogin.add(action);
    }

    public class Dispatcher {
        private Dispatcher() {}
        @SubscribeEvent
        public void onJoinWorlds(PlayerEvent.PlayerLoggedInEvent e) {
             activePlayers.put(new PlayerID(e.player), (EntityPlayerMP)e.player);
             for (Acceptor<EntityPlayerMP> action: onLogin) {
                 action.accept((EntityPlayerMP)e.player);
             }
        }

        @SubscribeEvent
        public void onLeaveWorlds(PlayerEvent.PlayerLoggedOutEvent e) {
            activePlayers.remove(new PlayerID(e.player));
             for (Acceptor<EntityPlayerMP> action: onLogout) {
                 action.accept((EntityPlayerMP)e.player);
             }
        }
    }
}