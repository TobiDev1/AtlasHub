package dev.tobi.hub;

import dev.tobi.hub.managers.ManagerLoader;
import dev.tobi.hub.utility.Util;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class AtlasHub extends JavaPlugin {

    @Getter
    private static AtlasHub instance;

    private ManagerLoader loader;


    @Override
    public void onEnable() {
        instance = this;

        this.loader = new ManagerLoader(this);
        this.loader.enable();

        Util.log("&4AtlasHub has been enabled!");
    }

    @Override
    public void onDisable() {
        this.loader.disable();
    }
}
