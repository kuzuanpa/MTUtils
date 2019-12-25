/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Zeno410Utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import net.minecraft.entity.player.EntityPlayer;

/**
 *
 * @author Zeno410
 */
public class PlayerID {

    private String name;

    private PlayerID(String _name) {name = _name;}

    public PlayerID(EntityPlayer player) {
        this(player.getDisplayName());
    }

    public String getName() {return name;}

    public static class PlayerIDStreamer extends Zeno410Utils.Streamer<PlayerID> {

        public PlayerID readFrom(DataInput input) throws IOException {
           String result = input.readUTF();
           return new PlayerID(result);
        }
        public void writeTo(PlayerID written, DataOutput output) throws IOException {
            output.writeUTF(written.name);

        }
    }

    // convenience function for player specific things
    public <Type> PlayerSpecific<Type> specific(Type type) {
        return new PlayerSpecific<Type>(this,type);
    }

    @Override
    public int hashCode() {return name.hashCode();}

    @Override
    public boolean equals(Object compared) {
        if (compared == null) return false;
        if (compared instanceof PlayerID) {
            if (((PlayerID)compared).name.equals(name)) return true;
        }
        return false;
    }


}
