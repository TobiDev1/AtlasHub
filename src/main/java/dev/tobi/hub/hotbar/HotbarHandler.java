package dev.tobi.hub.hotbar;

import dev.tobi.hub.utility.ItemBuilder;
import dev.tobi.hub.utility.Util;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import java.util.Collections;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:50 p. m.
 **/
public class HotbarHandler {

    public static void onGiveItems(Player player) {
        player.getInventory().setItem(3, enderpearl);
        player.getInventory().setItem(4, selector);
        player.getInventory().setItem(5, viewPlayer);
    }


    public static ItemStack enderpearl = new ItemBuilder(Material.ENDER_PEARL)
            .name(Util.translate("&c&lEnderpearl"))
            .setQuantity(64)
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack selector = new ItemBuilder(Material.NETHER_STAR)
            .name(Util.translate("&c&lServer Selector"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack viewPlayer = new ItemBuilder(Material.getMaterial(351), 1, (short) 10)
            .name(Util.translate("&a&lPlayers Visible"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to hide players")))
            .build();

    public static ItemStack offPlayer = new ItemBuilder(Material.getMaterial(351), 1, (short) 8)
            .name(Util.translate("&c&lPlayers Hidden"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to show players")))
            .build();

    public static ItemStack hub = new ItemBuilder(Material.BEACON)
            .name(Util.translate("&c&lHub-1"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack hub2 = new ItemBuilder(Material.BEACON)
            .name(Util.translate("&c&lHub-2"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();




}
