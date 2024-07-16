package dev.tobi.hub.utility.animation;

import dev.tobi.hub.utility.Tasks;
import dev.tobi.hub.utility.Util;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreboardAnimated {

    @Getter
    private static String title;
    @Getter
    private static String footer;

    private static final List<String> TITLES = Arrays.asList("&5A", "&5At", "&5Atl", "&5Atla", "&5Atlas", "&5AtlasM", "&5AtlasMC");
    private static final List<String> FOOTERS = Arrays.asList("&7discord.gg/AtlasMC", "&7twitter.com/AtlasMC", "&7ts.atlas.live", "&7store.atlas.live");
    private static final boolean TITLE_ANIMATED_ENABLED = true;
    private static final boolean FOOTER_ANIMATED_ENABLED = true;

    public static void init() {
        title = Util.translate(TITLES.get(0));
        footer = Util.translate(FOOTERS.get(0));

        if (TITLE_ANIMATED_ENABLED) {
            AtomicInteger atomicInteger = new AtomicInteger();

            Tasks.runTimerAsync(() -> {
                if (atomicInteger.get() == TITLES.size()) atomicInteger.set(0);
                title = TITLES.get(atomicInteger.getAndIncrement());
            }, 0L, (long) (2.0 * 20L));
        }

        if (FOOTER_ANIMATED_ENABLED) {
            AtomicInteger atomicInteger = new AtomicInteger();

            Tasks.runTimerAsync(() -> {
                if (atomicInteger.get() == FOOTERS.size()) atomicInteger.set(0);
                footer = FOOTERS.get(atomicInteger.getAndIncrement());
            }, 0L, (long) (2.0 * 20L));
        }
    }
}

