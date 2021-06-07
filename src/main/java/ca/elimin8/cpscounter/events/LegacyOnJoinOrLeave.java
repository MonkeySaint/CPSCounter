package ca.elimin8.cpscounter.events;

import io.github.theluca98.textapi.ActionBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LegacyOnJoinOrLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        bar(e.getPlayer());
    }
    public void bar(Player p) {
        ActionBar bar = new ActionBar("1.12 and under");
        bar.send(p);
    }
}
