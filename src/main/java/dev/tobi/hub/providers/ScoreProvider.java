package dev.tobi.hub.providers;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.task.TaskManager;
import dev.tobi.hub.task.payload.ScoreFooterPayload;
import dev.tobi.hub.task.payload.ScoreTitlePayload;
import dev.tobi.hub.utility.Util;
import fr.mrmicky.fastboard.FastBoard;
import me.activated.core.api.player.PlayerData;
import me.activated.core.plugin.AquaCoreAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 08:52 p. m.
 **/
public class ScoreProvider {



    public void updateBoard(FastBoard board) {

        ScoreTitlePayload titlePayload = new ScoreTitlePayload();

        board.updateTitle(titlePayload.sendTitle());
        Player player = board.getPlayer();

        String rankLine = Util.translate("&7| &cRank: " + AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getColor().toString() + AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getPrefix());
        String onlineLine = Util.translate("&7| &cGlobal: &7%bungee_total% / 2024");
        String kitmap = Util.translate("&7| &cKitMap: &7%bungee_kitmap% / 500");
        String hcf = Util.translate("&7| &cHCF: &7%bungee_hcf% / 500");

        ScoreFooterPayload scorePayload = new ScoreFooterPayload();
        rankLine = PlaceholderAPI.setPlaceholders(player, rankLine);
        onlineLine = PlaceholderAPI.setPlaceholders(player, onlineLine);
        kitmap = PlaceholderAPI.setPlaceholders(player, kitmap);
        hcf = PlaceholderAPI.setPlaceholders(player, hcf);

        board.updateLines(
                "",
                Util.truncateLine(rankLine),
                "",
                Util.truncateLine(onlineLine),
                Util.truncateLine(hcf),
                Util.truncateLine(kitmap),
                "",
                Util.translate("&7atlas.live")
        );
    }

}
