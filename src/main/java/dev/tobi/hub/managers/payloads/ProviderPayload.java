package dev.tobi.hub.managers.payloads;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.providers.TabProvider;
import lombok.Getter;
import me.lucanius.edge.Edge;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:01 p. m.
 **/
public class ProviderPayload {

    @Getter private static ProviderPayload instance;
    private final AtlasHub atlasHub;

    @Getter private Edge tabHandler;


    public ProviderPayload(AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerProviders() {
        tabHandler = new Edge(atlasHub, new TabProvider());


    }
}
