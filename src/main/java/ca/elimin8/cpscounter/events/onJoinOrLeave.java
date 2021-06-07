package ca.elimin8.cpscounter.events;

import ca.elimin8.cpscounter.CPSCounter;
import ca.elimin8.cpscounter.Utils.Current;
import ca.elimin8.cpscounter.Utils.Legacy;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onJoinOrLeave implements Listener {
    CPSCounter plugin;
    public onJoinOrLeave(CPSCounter cpsCounter) {
        plugin = cpsCounter;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        plugin.cps.leftCPS.put(e.getPlayer(), 0);
        plugin.cps.rightCPS.put(e.getPlayer(), 0);
        if (plugin.version > 12) {
            Current current = new Current(plugin);
            current.runnable(e.getPlayer());
        }
        else {
            Legacy legacy = new Legacy(plugin);
            legacy.runnable(e.getPlayer());
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Bukkit.getScheduler().cancelTask(plugin.taskID.get(e.getPlayer()));
    }
}
