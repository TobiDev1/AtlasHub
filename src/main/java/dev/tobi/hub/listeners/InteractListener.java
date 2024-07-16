package dev.tobi.hub.listeners;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.menus.types.SelectorMenu;
import dev.tobi.hub.utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 12:15 a. m.
 **/
public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().equals(HotbarHandler.selector)) {
                SelectorMenu selectorMenu = new SelectorMenu(9, Util.translate("&cSelector Menu"));
                selectorMenu.createMenu(selectorMenu.getInventory(), player); // Create Inventory

                player.openInventory(selectorMenu.getInventory()); // Open Inventory

                player.getInventory().setItem(20, HotbarHandler.hub);
                player.getInventory().setItem(22, HotbarHandler.hub2);

                player.updateInventory();
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
            } else if (event.getItem().equals(HotbarHandler.viewPlayer)) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(onlinePlayer);
                }
                player.getInventory().setItemInHand(HotbarHandler.offPlayer);
                player.updateInventory();
            } else if (event.getItem().equals(HotbarHandler.offPlayer)) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(onlinePlayer);
                }
                player.getInventory().setItemInHand(HotbarHandler.viewPlayer);
                player.updateInventory();
            } else if (event.getItem().equals(HotbarHandler.enderpearl)) {
                player.setVelocity(player.getLocation().getDirection().multiply(1.5F));
                event.setCancelled(true);
                player.getInventory().setItem(3, HotbarHandler.enderpearl);
                player.updateInventory();
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }
        }
    }
}
