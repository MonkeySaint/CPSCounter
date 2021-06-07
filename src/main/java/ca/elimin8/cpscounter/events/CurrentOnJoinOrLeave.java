package ca.elimin8.cpscounter.events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CurrentOnJoinOrLeave implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        bar(e.getPlayer());
    }
    public void bar(Player p) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("1.13 and up"));
    }
}
