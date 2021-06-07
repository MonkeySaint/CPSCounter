package ca.elimin8.cpscounter.events;

import ca.elimin8.cpscounter.CPSCounter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class onClick implements Listener {
    public static Map<Player, Integer> leftCPS = new HashMap<Player, Integer>();
    public static Map<Player, Integer> rightCPS = new HashMap<Player, Integer>();
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))
            leftCPS.put(e.getPlayer(), leftCPS.get(e.getPlayer()));
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
            rightCPS.put(e.getPlayer(), rightCPS.get(e.getPlayer()));
    }
}
