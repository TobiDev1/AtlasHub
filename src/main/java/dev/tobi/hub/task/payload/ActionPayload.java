package dev.tobi.hub.task.payload;

import dev.tobi.hub.utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:44 p. m.
 **/
public class ActionPayload extends BukkitRunnable {


    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Util.sendActionBar(player, Util.translate("&fThere is currently &5&l25% OFF SALE &fat our store")); // MESSAGE THE ACTION BAR
        }
    }
}
