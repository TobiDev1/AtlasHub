package dev.tobi.hub.task.payload;

import dev.tobi.hub.utility.Util;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 01:23 p. m.
 **/
public class ScoreFooterPayload extends BukkitRunnable {
    public static String footer = "";

    private int left;

    public ScoreFooterPayload() {
        this.left = 3;
    }

    @Deprecated
    public void run() {
        --this.left;
        if (this.left < 0) {
            this.left = 3;
            this.sendFooter();
        }
        if (Bukkit.getOnlinePlayers().size() < 0) {
            this.cancel();
        }

    }

    public String sendFooter() {
        String message = footer;
        if (this.left <= 3) {
            if (this.left < 4) {// LINE 1
                message = Util.translate("&7discord.gg/AtlasMC");
            }
            if (this.left < 3) { // LINE 2
                message = Util.translate("&7twitter.com/AtlasMC");
            }
            if (this.left < 2) { // LINE 3
                message = Util.translate("&7ts.atlas.live");
            }
            if (this.left < 1) { // LINE 4
                message = Util.translate("&7store.atlas.live");
            }
        }
        return message;
    }
}

