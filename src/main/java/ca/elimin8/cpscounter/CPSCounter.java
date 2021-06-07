package ca.elimin8.cpscounter;

import ca.elimin8.cpscounter.Utils.Current;
import ca.elimin8.cpscounter.Utils.Legacy;
import ca.elimin8.cpscounter.events.onClick;
import ca.elimin8.cpscounter.events.onJoinOrLeave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class CPSCounter extends JavaPlugin {
    // Plugin startup logic
    public int version = Integer.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].replace("1_", "").replaceAll("_R[0-9]", "").replaceAll("v", ""));
    public static Map<Player, Integer> taskID = new HashMap<Player, Integer>();
    public onClick cps = new onClick();
    public String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("actionbartext"));
    @Override
    public void onEnable() {
        // Plugin startup logic
        if (version > 12) {
            Current current = new Current(this);
            for (Player p : Bukkit.getOnlinePlayers()) {
                current.runnable(p);
            }
        }
        else {
            Legacy legacy = new Legacy(this);
            for (Player p : Bukkit.getOnlinePlayers()) {
                legacy.runnable(p);
            }
        }
        getServer().getPluginManager().registerEvents(new onJoinOrLeave(this), this);
        getServer().getPluginManager().registerEvents(new onClick(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
