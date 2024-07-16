package dev.tobi.hub.managers.payloads;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.cmd.BuildCMD;
import dev.tobi.hub.cmd.DevCMD;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:01 p. m.
 **/
public class CMDPayload {

    private final AtlasHub atlasHub;

    public CMDPayload(AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerCMD() {
        atlasHub.getCommand("build").setExecutor(new BuildCMD());
        atlasHub.getCommand("dev").setExecutor(new DevCMD());
    }

}
