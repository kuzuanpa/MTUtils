package ru.lionzxy.damagetweaker.handlers;

/*
 * MTUtils is the software thich is made by LionZXY under GNU Affero General Public License
 * Please see LICENSE file or https://www.gnu.org/licenses/agpl-3.0.en.html
 *
 * This build is modified by monatann under same LICENSE, AGPL.
 * You do not report bugs to original author.
 * You should report to me because your bug is caused by my code.
 * */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lionzxy on 6/9/16.
 */
public class TicksHandler {
    private static List<Runnable> tasks = new ArrayList<Runnable>();
    private static boolean serverStarted = false;

    public static void onServerLoaded() {
        serverStarted = true;
        if(!tasks.isEmpty()){
            for(Runnable runnable : tasks)
                runnable.run();
            tasks.clear();
        }
    }

    public static void addTasksAfterSererLoaded(Runnable runnable){
        if(serverStarted)
            runnable.run();
        else tasks.add(runnable);
    }
}
