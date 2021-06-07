package ca.elimin8.cpscounter.Utils;

import ca.elimin8.cpscounter.CPSCounter;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Current {
    CPSCounter plugin;
    public Current(CPSCounter cpsCounter) {
        plugin = cpsCounter;
    }
    public void runnable(Player p) {
        plugin.taskID.put(p, Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                String msg = plugin.msg.replace("%left%", String.valueOf(plugin.cps.leftCPS.get(p))).replace("%right%", String.valueOf(plugin.cps.rightCPS.get(p)));
                if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                    msg = PlaceholderAPI.setPlaceholders(p, msg);
                }
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(msg));
                plugin.cps.rightCPS.put(p, 0);
                plugin.cps.leftCPS.put(p, 0);
            }
        }, 0, 20));
    }
}
