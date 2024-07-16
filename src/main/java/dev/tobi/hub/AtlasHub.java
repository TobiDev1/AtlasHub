package dev.tobi.hub;

import dev.tobi.hub.managers.ManagerLoader;
import dev.tobi.hub.providers.Adapter;
import dev.tobi.hub.task.TaskManager;
import dev.tobi.hub.utility.Util;
import dev.tobi.hub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class AtlasHub extends JavaPlugin {

    @Getter
    private static AtlasHub instance;

    private TaskManager taskManager;
    private ManagerLoader loader;


    @Override
    public void onEnable() {
        instance = this;

        this.loader = new ManagerLoader(this);
        this.loader.enable();

        ScoreboardAnimated.init();
        Assemble assemble = new Assemble(this, new Adapter());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);

        Util.log("&4AtlasHub has been enabled!");
    }

    @Override
    public void onDisable() {
        this.loader.disable();
    }
}
