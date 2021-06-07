package ca.elimin8.cpscounter.events;

import ca.elimin8.cpscounter.CPSCounter;
import ca.elimin8.cpscounter.Utils.Current;
import ca.elimin8.cpscounter.Utils.Legacy;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinOrLeave implements Listener {
    CPSCounter plugin;
    public onJoinOrLeave(CPSCounter cpsCounter) {
        plugin = cpsCounter;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (plugin.version > 12) {
            Current current = new Current(plugin);
            current.runnable(e.getPlayer());
        }
        else {
            Legacy legacy = new Legacy(plugin);
            legacy.runnable(e.getPlayer());
        }
    }

    public void bar(Player p) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("1.13 and up"));
    }
}
