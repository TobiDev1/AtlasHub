package dev.tobi.hub.managers;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.managers.payloads.CMDPayload;
import dev.tobi.hub.managers.payloads.ListenerPayload;
import dev.tobi.hub.managers.payloads.ProviderPayload;
import dev.tobi.hub.task.TaskManager;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:00 p. m.
 **/
public class ManagerLoader {

    private final TaskManager taskManager;
    private final ProviderPayload providerPayload;
    private final CMDPayload cmdPayload;
    private final ListenerPayload listenerPayload;

    public ManagerLoader(AtlasHub atlasHub) {
        this.taskManager = new TaskManager(atlasHub);
        this.providerPayload = new ProviderPayload(atlasHub);
        this.cmdPayload = new CMDPayload(atlasHub);
        this.listenerPayload = new ListenerPayload(atlasHub);
    }

    public void enable() {
        load();
    }

    public void load() {
        taskManager.registerTask();
        providerPayload.registerProviders();
        cmdPayload.registerCMD();
        listenerPayload.register();
    }

    public void disable() {
        taskManager.unregisterTask();
        if (providerPayload.getTabHandler() != null && providerPayload.getTabHandler().getService() != null) {
            providerPayload.getTabHandler().getService().destroy();
        }
    }

}
