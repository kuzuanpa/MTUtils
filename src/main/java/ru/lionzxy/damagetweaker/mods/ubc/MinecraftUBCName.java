package ru.lionzxy.damagetweaker.mods.ubc;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import Zeno410Utils.MinecraftName;

/**
 * Created by LionZXY on 22.10.2015.
 * BetterWorkbench
 */
public class MinecraftUBCName extends MinecraftName {
    String local;
    public MinecraftUBCName(String unlocalized, String local) {
        super(unlocalized);
        this.local = local;
    }
    @Override
    public String localized() {
        return local;
        //return unlocalized();
    }

    public String unlocalized() {
        return super.unlocalized();
    }

    public boolean legit() {
        return true;
    }
}
