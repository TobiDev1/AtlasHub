package dev.tobi.hub;

import dev.tobi.hub.managers.ManagerLoader;
import dev.tobi.hub.providers.ScoreProvider;
import dev.tobi.hub.task.TaskManager;
import dev.tobi.hub.utility.Util;
import fr.mrmicky.fastboard.FastBoard;
import lombok.Getter;
import me.lucanius.edge.Edge;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AtlasHub extends JavaPlugin {



    @Getter private static AtlasHub instance;
    @Getter private TaskManager taskManager;
    @Getter private final Map<UUID, FastBoard> boards = new HashMap<>();
    private ManagerLoader loader;


    @Override
    public void onEnable() {
        instance = this;

        this.loader = new ManagerLoader(this);
        this.loader.enable();

        ScoreProvider scoreProvider = new ScoreProvider();

        this.getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.getBoards().values()) {
                scoreProvider.updateBoard(board);
            }
        }, 0L, 20);

        Util.log("&4AtlasHub has been enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;
        this.loader.disable();
    }
}
