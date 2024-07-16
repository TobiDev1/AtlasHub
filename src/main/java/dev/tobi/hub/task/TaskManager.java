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

    public TaskManager(AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerTask() {
        actionTask = new ActionPayload().runTaskTimer(atlasHub, 0L, 60L);
    }

    public void unregisterTask() {
        if (actionTask != null) {
            actionTask.cancel();
            actionTask = null; // Limpia la referencia después de la cancelación xde
        }
    }
}
