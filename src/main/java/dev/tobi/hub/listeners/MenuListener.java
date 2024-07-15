package dev.tobi.hub.listeners;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.menus.types.SelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 12:59 a. m.
 **/
public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Inventory inventory = event.getInventory();
        if (inventory == null) return;

        ItemStack click = event.getCurrentItem();
        if (click == null || click.getType() == Material.AIR) return;

        Material itemType = click.getType();
        if (itemType.equals(Material.DIAMOND_SWORD)) {
            event.getWhoClicked().closeInventory();
        } else if (itemType.equals(Material.IRON_SWORD)) {
            event.getWhoClicked().closeInventory();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();
        if (inventory.getHolder() instanceof SelectorMenu) {
            player.getInventory().clear();
            HotbarHandler.onGiveItems(player);
            player.updateInventory();
        }
    }

}
