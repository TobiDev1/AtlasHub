package dev.tobi.hub.listeners;

import dev.tobi.hub.hotbar.HotbarHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 10:22 p. m.
 **/
public class EnderButtListener implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if ((!event.hasItem() || event.getAction() != Action.RIGHT_CLICK_AIR)
                && (event.getAction() != Action.RIGHT_CLICK_BLOCK
                || !event.getItem().isSimilar(HotbarHandler.enderpearl))) {
            player.setVelocity(player.getLocation().getDirection().multiply(1.5F));
            event.setCancelled(true);
            player.getInventory().setItem(0, HotbarHandler.enderpearl);
            player.updateInventory();
            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
        }


    }



}
