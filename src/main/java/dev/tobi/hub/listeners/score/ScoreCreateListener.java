package dev.tobi.hub.listeners.score;

import dev.tobi.hub.managers.payloads.ProviderPayload;
import dev.tobi.hub.utility.Util;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 12:41 a. m.
 **/
public class ScoreCreateListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);
        board.updateTitle(Util.translate("&4&lHub-01"));
        ProviderPayload.getInstance().getBoards().put(player.getUniqueId(), board);
    }
}
