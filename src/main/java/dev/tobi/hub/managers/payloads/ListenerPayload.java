package dev.tobi.hub.managers.payloads;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.listeners.EnderButtListener;
import dev.tobi.hub.listeners.JoinListener;
import dev.tobi.hub.listeners.MenuListener;
import dev.tobi.hub.listeners.ProtectionListener;

import dev.tobi.hub.listeners.score.ScoreCreateListener;
import dev.tobi.hub.listeners.score.ScoreDeleteListener;
import dev.tobi.hub.menus.MenuCreator;
import dev.tobi.hub.menus.types.SelectorMenu;
import org.bukkit.plugin.PluginManager;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:01 p. m.
 **/
public class ListenerPayload {

    private final AtlasHub atlasHub;

    public ListenerPayload(AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void register() {
        PluginManager pm = atlasHub.getServer().getPluginManager();

        pm.registerEvents(new JoinListener(), atlasHub);
        pm.registerEvents(new ProtectionListener(), atlasHub);
        pm.registerEvents(new EnderButtListener(), atlasHub);
        pm.registerEvents(new ScoreCreateListener(), atlasHub);
        pm.registerEvents(new ScoreDeleteListener(), atlasHub);
        pm.registerEvents(new MenuListener(), atlasHub);

    }
}
