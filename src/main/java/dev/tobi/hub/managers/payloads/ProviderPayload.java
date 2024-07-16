package dev.tobi.hub.managers.payloads;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.providers.ScoreProvider;
import dev.tobi.hub.providers.TabProvider;
import fr.mrmicky.fastboard.FastBoard;
import lombok.Getter;
import me.lucanius.edge.Edge;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * DevTobi has Created For Project AtlasHub 14/07/2024 09:01 p. m.
 **/
public class ProviderPayload {

    @Getter private static ProviderPayload instance;
    private final AtlasHub atlasHub;

    @Getter private final Map<UUID, FastBoard> boards = new HashMap<>();

    @Getter private Edge tabHandler;


    public ProviderPayload(AtlasHub atlasHub) {
        this.atlasHub = atlasHub;
    }

    public void registerProviders() {
        tabHandler = new Edge(atlasHub, new TabProvider());


    }
}
