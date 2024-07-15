package dev.tobi.hub.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 10:48 p. m.
 **/
public abstract class MenuCreator{

    private final int size;
    private final String title;

    public MenuCreator(int size, String title) {
        this.size = size;
        this.title = title;

    }

    public void createMenu(Inventory inventory, Player player) {
        inventory = Bukkit.getServer().createInventory(null, size, title);
    }

}
