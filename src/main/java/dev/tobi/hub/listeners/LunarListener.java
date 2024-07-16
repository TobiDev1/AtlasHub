package dev.tobi.hub.listeners;

import com.lunarclient.bukkitapi.LunarClientAPI;
import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.utility.Util;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 01:05 p. m.
 **/
public class LunarListener implements Listener {

    public void updateNameTag( Player player) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            Player player2 = onlinePlayer.getPlayer();
            scheduler.scheduleSyncRepeatingTask((Plugin) AtlasHub.getInstance(), () -> LunarClientAPI.getInstance().overrideNametag(player2, (List)this.resetNameTag(player2), player), 0L, 20L);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        this.updateNameTag(player);
    }

    public  List<String> resetNameTag(Player player) {
        List<String> tag = new ArrayList<>();
        tag.add(Util.translate(AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getColor().toString() + AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getPrefix()));
        tag.add(Util.translate(player.getName()));

        return tag;
    }


}
