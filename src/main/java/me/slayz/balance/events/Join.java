package me.slayz.balance.events;

import me.slayz.balance.utils.Utilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {


    @EventHandler
    public void join(PlayerJoinEvent e){
        if(!Utilities.playerExists(e.getPlayer())){
            Utilities.createPlayer(e.getPlayer());
        }
    }
}
