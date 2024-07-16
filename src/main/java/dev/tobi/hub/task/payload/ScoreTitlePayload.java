package dev.tobi.hub.task.payload;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.utility.Util;
import fr.mrmicky.fastboard.FastBoard;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 01:15 p. m.
 **/
public class ScoreTitlePayload extends BukkitRunnable {

    @Getter
    private String title = ""; // Añade un getter para obtener el título actual
    private int left;

    public ScoreTitlePayload() {
        this.left = 8;
    }

    @Override
    public void run() {
        --this.left;
        if (this.left < 0) {
            this.left = 8;
            sendTitle(); // Llama a updateTitle() cuando el contador llega a cero
        }
        if (Bukkit.getOnlinePlayers().size() < 0) {
            this.cancel();
        }
    }

    public void updateTitle() {
        this.title = sendTitle();

        AtlasHub atlasHub = AtlasHub.getInstance();
        if (atlasHub == null) {
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            FastBoard playerBoard = atlasHub.getBoards().get(player.getUniqueId());
            if (playerBoard != null) {
                playerBoard.updateTitle(Util.translate(this.title));
            }
        }
    }

    public String sendTitle() {
        String message = "";
        if (this.left <= 8) {
            if (this.left < 7) {
                message = "&5A"; // LINE 1
            }
            if (this.left < 6) {
                message = "&5At"; // LINE 2
            }
            if (this.left < 5) { // LINE 3
                message = "&5Atl";
            }
            if (this.left < 4) { // LINE 4
                message = "&5Atla";
            }
            if (this.left < 3) { // LINE 5
                message = "&5Atlas";
            }
            if (this.left < 2) { // LINE 6
                message = "&5AtlasM";
            }
            if (this.left < 1) { // LINE 7
                message = "&5AtlasMC";
            }
        }
        return message;
    }


}
