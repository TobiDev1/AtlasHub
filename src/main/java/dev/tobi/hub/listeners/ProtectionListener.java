package dev.tobi.hub.listeners;

import dev.tobi.hub.cmd.BuildCMD;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 11:15 p. m.
 **/
public class ProtectionListener implements Listener {

    @EventHandler
    public void onBuild(BlockPlaceEvent event) {
        if (BuildCMD.getPlayers().containsKey(event.getPlayer().getUniqueId())
                && event.getPlayer().hasPermission("hub.build")) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVoid(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL
                || event.getCause() == EntityDamageEvent.DamageCause.VOID || event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (BuildCMD.getPlayers().containsKey(event.getPlayer().getUniqueId())
                && event.getPlayer().hasPermission("hub.build")) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        if (BuildCMD.getPlayers().containsKey(event.getPlayer().getUniqueId())
                && event.getPlayer().hasPermission("hub.build")) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent event) {
        event.setCancelled(true);
        event.setFoodLevel(20);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (BuildCMD.getPlayers().containsKey(event.getPlayer().getUniqueId())
                && event.getPlayer().hasPermission("hub.build")) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }


}
