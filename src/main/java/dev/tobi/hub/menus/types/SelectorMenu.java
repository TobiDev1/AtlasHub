package dev.tobi.hub.menus.types;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.menus.MenuCreator;
import dev.tobi.hub.utility.ItemBuilder;
import dev.tobi.hub.utility.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;
import java.util.Collections;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 12:19 a. m.
 **/
public class SelectorMenu extends MenuCreator {

    public SelectorMenu(int size, String title) {
        super(size, title);
    }

    @Override
    public void createMenu(Inventory inventory, Player player) {
        super.createMenu(inventory, player);

        inventory.setItem(3, new ItemBuilder(Material.DIAMOND_SWORD)
                .name(Util.translate("&c&lHCF"))
                .setLore(Collections.singletonList(Util.translate("&7Right click to go HCF")))
                .build());

        inventory.setItem(3, new ItemBuilder(Material.IRON_SWORD)
                .name(Util.translate("&c&lKitMap"))
                .setLore(Collections.singletonList(Util.translate("&7Right click to go KitMap")))
                .build());

        onInventoryPlayer(player);

    }

    public void onInventoryPlayer(Player player) {
        player.getInventory().setItem(20, HotbarHandler.hub);
        player.getInventory().setItem(22, HotbarHandler.hub2);
        player.updateInventory();
    }
}
