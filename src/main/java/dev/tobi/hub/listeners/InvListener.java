package dev.tobi.hub.listeners;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.menus.types.SelectorMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 05:24 p. m.
 **/
public class InvListener implements Listener {

    private final Map<Player, ItemStack[]> storedInv = new HashMap<>();

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        if (inventory.getType() == InventoryType.PLAYER) {
            player.getInventory().clear();
            player.getInventory().setItem(20, HotbarHandler.hub);
            player.getInventory().setItem(22, HotbarHandler.hub2);
            player.sendMessage("SE QUITARON LOS HUBS");
            player.updateInventory();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        if (inventory.getHolder() instanceof SelectorMenu) {
            player.getInventory().clear();

            ItemStack[] storedItems = storedInv.get(player);
            if (storedItems != null) {
                player.getInventory().setContents(storedItems);
                storedInv.remove(player);
            }

            HotbarHandler.onGiveItems(player);

            player.getInventory().remove(HotbarHandler.hub);
            player.getInventory().remove(HotbarHandler.hub2);
            player.sendMessage("SE QUITARON LOS HUBS");

            player.updateInventory();
        }
    }
}
