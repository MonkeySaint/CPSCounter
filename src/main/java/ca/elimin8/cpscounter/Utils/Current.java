package ca.elimin8.cpscounter.Utils;

import ca.elimin8.cpscounter.CPSCounter;
import ca.elimin8.cpscounter.events.onClick;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Current {
    CPSCounter plugin;
    public Current(CPSCounter cpsCounter) {
        plugin = cpsCounter;
    }
    public void runnable(Player p) {
        String msg = plugin.msg.replace("%left%", String.valueOf(plugin.cps.leftCPS.get(p))).replace("%right%", String.valueOf(plugin.cps.rightCPS.get(p)));
        plugin.taskID.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
            @Override
            public void run() {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg));
                plugin.cps.rightCPS.put(p, 0);
                plugin.cps.leftCPS.put(p, 0);
            }
        }, 0, 1));
    }
}
