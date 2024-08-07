package dev.tobi.hub.listeners;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:58 p. m.
 **/
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        player.sendMessage(Util.translate(""));
        player.sendMessage(Util.translate("&fYou have been connected to our &5&lHub server."));
        player.sendMessage(Util.translate("&fTo navigate through servers please use &5Server Selector&f."));
        player.sendMessage(Util.translate(""));

        player.getInventory().clear();
        HotbarHandler.onGiveItems(player);
    }



}
