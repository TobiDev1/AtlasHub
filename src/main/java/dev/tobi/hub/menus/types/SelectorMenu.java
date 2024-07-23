package dev.tobi.hub.menus.types;

import dev.tobi.hub.menus.MenuCreator;
import dev.tobi.hub.utility.ItemBuilder;
import dev.tobi.hub.utility.Util;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

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
                .setLore(Arrays.asList(
                        Util.translate("&7&m                       "),
                        Util.translate("&a&lSOTW &f29/06/2024 &7- 16:00PM EST"),
                        Util.translate("&c&lEOTW &f05/07/2024 &7- 18:00PM EST"),
                        "",
                        Util.translate("&5&lMap Information"),
                        Util.translate("&d* &7Map Kit &fP1 & S1"),
                        Util.translate("&d* &7Factions &f5 Members"),
                        Util.translate("&d* &7Allies &fDisabled"),
                        "",
                        Util.translate("&5&lMap Prizes"),
                        Util.translate("&d* &7Faction Top &f10 GiftCard"),
                        Util.translate("&d* &7Top Kills &f20 GiftCard + Rank (15d)"),
                        "",
                        PlaceholderAPI.setPlaceholders(player, Util.translate("&7Users (&f%bungee_HCF%/200)")),
                        "",
                        Util.translate("&aClick to connect this server!"),
                        Util.translate("&7&m                       ")
                ))
                .build());

        inventory.setItem(4, new ItemBuilder(Material.IRON_SWORD)
                .name(Util.translate("&c&lKitMap"))
                .setLore(Arrays.asList(
                        Util.translate("&7&m                       "),
                        Util.translate("&a&lSOTW &f21/09/2024 &7- 16:00PM EST"),
                        Util.translate("&c&lEOTW &f27/09/2024 &7- 18:00PM EST"),
                        "",
                        Util.translate("&5&lMap Information"),
                        Util.translate("&d* &7Map Kit &fP1 & S1"),
                        Util.translate("&d* &7Factions &f17 Members"),
                        Util.translate("&d* &7Allies &fDisabled"),
                        "",
                        Util.translate("&5&lMap Prizes"),
                        Util.translate("&d* &7Faction Top &f?"),
                        Util.translate("&d* &7Top Kills &f?"),
                        "",
                        PlaceholderAPI.setPlaceholders(player, Util.translate("&7Users (&f%bungee_Kitmap%/200)")),
                        "",
                        Util.translate("&aClick to connect this server!"),
                        Util.translate("&7&m                       ")
                ))
                .build());

        inventory.setItem(5, new ItemBuilder(Material.DIAMOND_AXE)
                .name(Util.translate("&c&lPractice"))
                .setLore(Arrays.asList(
                        Util.translate("&7&m                       "),
                        Util.translate("&5&lPractice Information"),
                        Util.translate("&d* &fRanked & unranked Ladders"),
                        Util.translate("&d* &fParty fights with friends"),
                        Util.translate("&d* &fDaily tournaments"),
                        Util.translate("&d* &fLeaderboards Prizes"),
                        "",
                        PlaceholderAPI.setPlaceholders(player, Util.translate("&7Users (&f%bungee_Practice%/200)")),
                        "",
                        Util.translate("&aClick to connect this server!"),
                        Util.translate("&7&m                       ")
                ))
                .build());

        player.updateInventory();
    }

}
