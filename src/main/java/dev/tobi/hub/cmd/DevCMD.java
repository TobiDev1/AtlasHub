package dev.tobi.hub.cmd;

import dev.tobi.hub.utility.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * DevTobi has Created For Project AtlasHub 15/07/2024 01:54 a. m.
 **/
public class DevCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(Util.translate("&7&m---------------"));
        player.sendMessage(Util.translate("&4&lAuthor: &9Atlas Development Team"));
        player.sendMessage(Util.translate("&7&m---------------"));

        return true;
    }
}
