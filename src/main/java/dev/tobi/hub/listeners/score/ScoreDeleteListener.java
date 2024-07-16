package dev.tobi.hub.listeners.score;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.managers.payloads.ProviderPayload;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 12:41 a. m.
 **/
public class ScoreDeleteListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        FastBoard board = AtlasHub.getInstance().getBoards().remove(player.getUniqueId());
        if (board != null) {
            board.delete();
        }
    }
}
