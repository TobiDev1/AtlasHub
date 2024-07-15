package dev.tobi.hub.providers;

import dev.tobi.hub.managers.payloads.ProviderPayload;
import dev.tobi.hub.utility.SkinUtil;
import dev.tobi.hub.utility.Util;
import me.clip.placeholderapi.PlaceholderAPI;
import me.lucanius.edge.adapter.TabAdapter;
import me.lucanius.edge.column.TabColumn;
import me.lucanius.edge.entry.TabData;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 08:52 p. m.
 **/
public class TabProvider implements TabAdapter {


    @Override
    public List<String> getHeader(Player player) {
        return Arrays.asList(" ", Util.translate( "&4&lAtlas"), " ");
    }

    @Override
    public List<String> getFooter(Player player) {
        return Arrays.asList(" ", PlaceholderAPI.setPlaceholders(player, Util.translate( "&7You're playing &catlasmc.live &7with &c0 &7players")), " ");
    }

    @Override
    public Set<TabData> getEntries(Player player) {
        Set<TabData> entries = new HashSet<>();

        entries.add(new TabData(TabColumn.LEFT, 7, Util.translate( "&c&lHCF"), SkinUtil.SHIELD));
        entries.add(new TabData(TabColumn.LEFT, 8, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cOnline: &7%bungee_hcf% / 500"))));
        entries.add(new TabData(TabColumn.LEFT, 9, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cStatus: &7%pinger_isonline_localhost:25567%\n"))));
        entries.add(new TabData(TabColumn.LEFT, 12, Util.translate( "&c&lStore"), SkinUtil.MONEY));
        entries.add(new TabData(TabColumn.LEFT, 13, Util.translate( "&7store.atlasmc.live")));

        entries.add(new TabData(TabColumn.MIDDLE, 1, Util.translate( "&c&lOnline"), SkinUtil.ONLINE));
        entries.add(new TabData(TabColumn.MIDDLE, 2, PlaceholderAPI.setPlaceholders(player, Util.translate( "&7%bungee_total% online"))));
        entries.add(new TabData(TabColumn.MIDDLE, 4, Util.translate( "&c&lModalities"),SkinUtil.SWORD));
        entries.add(new TabData(TabColumn.MIDDLE, 7, Util.translate( "&c&lKitMap"), SkinUtil.SHIELD));
        entries.add(new TabData(TabColumn.MIDDLE, 8, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cOnline: &7%bungee_kitmap% / 500"))));
        entries.add(new TabData(TabColumn.MIDDLE, 9, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cStatus: &7%pinger_isonline_localhost:25566%\n"))));
        entries.add(new TabData(TabColumn.MIDDLE, 12, Util.translate( "&c&lDiscord"), SkinUtil.DISCORD));
        entries.add(new TabData(TabColumn.MIDDLE, 13, Util.translate( "&7discord.atlasmc.live")));

        entries.add(new TabData(TabColumn.RIGHT, 7, Util.translate( "&c&lPractice"), SkinUtil.SHIELD));
        entries.add(new TabData(TabColumn.RIGHT, 8, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cOnline: &7%bungee_practice% / 500"))));
        entries.add(new TabData(TabColumn.RIGHT, 9, PlaceholderAPI.setPlaceholders(player, Util.translate( "&cStatus: &7%pinger_isonline_localhost:25568%\n"))));
        entries.add(new TabData(TabColumn.RIGHT, 12, Util.translate( "&c&lTwitter"), SkinUtil.TWITTER));
        entries.add(new TabData(TabColumn.RIGHT, 13, Util.translate( "&7twitter.atlasmc.live")));

        entries.add(new TabData(TabColumn.FAR_RIGHT, 4, Util.translate( "&c&lYou"), ProviderPayload.getInstance().getTabHandler().getSkin(player.getUniqueId())));
        entries.add(new TabData(TabColumn.FAR_RIGHT, 5, PlaceholderAPI.setPlaceholders(player, Util.translate( "&7%player_name%"))));
        entries.add(new TabData(TabColumn.FAR_RIGHT, 7, PlaceholderAPI.setPlaceholders(player, Util.translate( "&c&lRank")), SkinUtil.RANK));
        entries.add (new TabData(TabColumn.FAR_RIGHT, 8, PlaceholderAPI.setPlaceholders(player, Util.translate( "&7%luckperms_primary_group_name%"))));

        return entries;
    }
}

