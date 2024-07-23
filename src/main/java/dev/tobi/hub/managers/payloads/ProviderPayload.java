package dev.tobi.hub.managers.payloads;

import dev.tobi.hub.AtlasHub;
import dev.tobi.hub.providers.Adapter;
import dev.tobi.hub.providers.TabProvider;
import dev.tobi.hub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
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

        ScoreboardAnimated.init();
        Assemble assemble = new Assemble(atlasHub, new Adapter());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);

    }
}
