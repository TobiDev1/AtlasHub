package dev.tobi.hub.cmd;

import dev.tobi.hub.utility.Util;
import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 11:26 p. m.
 **/

public class BuildCMD implements CommandExecutor {
    @Getter
    private static final HashMap<UUID, Player> players = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("hub.build")) {
                if (args.length == 0) {
                    if (!players.containsKey(player.getUniqueId())) {
                        players.put(player.getUniqueId(), player);
                        player.sendMessage(Util.translate("&aBuild Mode has been enabled"));
                    }
                } else if (args.length == 1 && args[0].equalsIgnoreCase("disable")) {
                    if (players.containsKey(player.getUniqueId())) {
                        players.remove(player.getUniqueId());
                        player.sendMessage(Util.translate("&cBuild Mode has been disabled"));
                    }
                } else {
                    player.sendMessage(Util.translate("&cUsage: /build [disable]"));
                }
            } else {
                player.sendMessage(Util.translate("&cYou do not have permission to use this command"));
            }
        }
        return true;
    }
}
