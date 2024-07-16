package dev.tobi.hub.providers;

import dev.tobi.hub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.activated.core.api.rank.RankData;
import me.activated.core.plugin.AquaCoreAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static dev.tobi.hub.utility.Util.translate;

public class Adapter implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {

        return ScoreboardAnimated.getTitle();
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> scores = new ArrayList<>();
        RankData api = AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId());

        String totalGlobal = PlaceholderAPI.setPlaceholders(player, "%bungee_total%");
        String kitMap = PlaceholderAPI.setPlaceholders(player, "%bungee_kitmap%");
        String hcf = PlaceholderAPI.setPlaceholders(player, "%bungee_hcf%");

        scores.add(translate("&7&l▏&cRank: " + api.getPrefix()));
        scores.add("");
        scores.add(translate("&7&l▏&cGlobal: &7" + totalGlobal + " / 2024"));
        scores.add(translate("&7&l▏&cKitMap: &7" + kitMap + " / 500"));
        scores.add(translate("&7&l▏&cHCF: &7" + hcf + " / 500"));
        scores.add("");
        scores.add(translate(ScoreboardAnimated.getFooter()));

        return scores;
    }
}
