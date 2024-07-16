package dev.tobi.hub.menus.types;

import dev.tobi.hub.hotbar.HotbarHandler;
import dev.tobi.hub.menus.MenuCreator;
import dev.tobi.hub.utility.ItemBuilder;
import dev.tobi.hub.utility.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Collections;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 10:48 p. m.
 **/
public class SelectorMenu extends MenuCreator {

    public SelectorMenu(int size, String title) {
        super(size, title);
    }

    @Override
    public void createMenu(Inventory inventory, Player player) {
        inventory.setItem(3, new ItemBuilder(Material.DIAMOND_SWORD)
                .name(Util.translate("&c&lHCF"))
                .setLore(Collections.singletonList(Util.translate("&7Right click to go HCF")))
                .build());

        inventory.setItem(4, new ItemBuilder(Material.IRON_SWORD)
                .name(Util.translate("&c&lKitMap"))
                .setLore(Collections.singletonList(Util.translate("&7Right click to go KitMap")))
                .build());

        inventory.setItem(5, new ItemBuilder(Material.DIAMOND_AXE)
                .name(Util.translate("&c&lPractice"))
                .setLore(Collections.singletonList(Util.translate("&7Right click to go Practice")))
                .build());
        player.updateInventory();
    }
}
