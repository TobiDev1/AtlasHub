package dev.tobi.hub.task;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.providers.ScoreProvider;
import dev.tobi.hub.task.payload.ActionPayload;
import dev.tobi.hub.task.payload.ScoreFooterPayload;
import dev.tobi.hub.task.payload.ScoreTitlePayload;
import fr.mrmicky.fastboard.FastBoard;
import javafx.concurrent.Task;
import lombok.Getter;
import org.bukkit.scheduler.BukkitTask;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:43 p. m.
 **/
public class TaskManager {



    private final AtlasHub atlasHub;
    private BukkitTask actionTask;

    private BukkitTask scoreTitlePayload;

    private BukkitTask scoreFooterPayload;

    public TaskManager(final AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerTask() {
        this.actionTask = new ActionPayload().runTaskTimer(atlasHub, 0L, 60L);



        this.scoreTitlePayload =  new ScoreTitlePayload().runTaskTimerAsynchronously(atlasHub, 0L, 20L);
        this.scoreFooterPayload = new ScoreFooterPayload().runTaskTimerAsynchronously(atlasHub, 0L, 20L);
    }

    public void unregisterTask() {
        if (this.actionTask != null) {
            this.actionTask.cancel();
        }
        if (this.scoreTitlePayload != null) {
            this.scoreTitlePayload.cancel();
        }
        if (this.scoreFooterPayload != null) {
            this.scoreFooterPayload.cancel();
        }
    }

}

