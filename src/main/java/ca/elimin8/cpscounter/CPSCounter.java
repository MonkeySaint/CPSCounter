package ca.elimin8.cpscounter;

import ca.elimin8.cpscounter.events.CurrentOnJoinOrLeave;
import ca.elimin8.cpscounter.events.LegacyOnJoinOrLeave;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CPSCounter extends JavaPlugin {
    // Plugin startup logic
    public int version = Integer.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].replace("1_", "").replaceAll("_R[0-9]", "").replaceAll("v", ""));
    @Override
    public void onEnable() {
        // Plugin startup logic
        if (version > 12)
            getServer().getPluginManager().registerEvents(new CurrentOnJoinOrLeave(), this);
        else
            getServer().getPluginManager().registerEvents(new LegacyOnJoinOrLeave(), this);

        System.out.println(version);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
