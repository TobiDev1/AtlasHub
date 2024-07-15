package dev.tobi.hub.task;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.task.payload.ActionPayload;
import org.bukkit.scheduler.BukkitTask;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:43 p. m.
 **/
public class TaskManager {

    private final AtlasHub atlasHub;
    private BukkitTask actionTask;

    public TaskManager(final AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerTask() {
        this.actionTask = new ActionPayload().runTaskTimer(atlasHub, 0L, 20L);
    }

    public void unregisterTask() {
        if (this.actionTask != null) {
            this.actionTask.cancel();
        }
    }

}
