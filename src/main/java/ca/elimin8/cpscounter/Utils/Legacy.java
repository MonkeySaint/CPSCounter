package ca.elimin8.cpscounter.Utils;

import ca.elimin8.cpscounter.CPSCounter;
import ca.elimin8.cpscounter.events.onClick;
import io.github.theluca98.textapi.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Legacy {
    CPSCounter plugin;
    public Legacy(CPSCounter cpsCounter) {
        plugin = cpsCounter;
    }
    onClick cps = new onClick();
    public void runnable(Player p) {
        String msg = plugin.msg.replace("%left%", String.valueOf(plugin.cps.leftCPS.get(p))).replace("%right%", String.valueOf(plugin.cps.rightCPS.get(p)));
        plugin.taskID.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
            @Override
            public void run() {
                ActionBar bar = new ActionBar(msg);
                bar.send(p);
                plugin.cps.rightCPS.put(p, 0);
                plugin.cps.leftCPS.put(p, 0);
            }
        }, 0, 1));
    }
}
