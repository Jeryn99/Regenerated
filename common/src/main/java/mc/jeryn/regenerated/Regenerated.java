package mc.jeryn.regenerated;

import mc.jeryn.regenerated.common.block.ModBlocks;
import mc.jeryn.regenerated.common.tab.ModCreativeModeTabs;
import mc.jeryn.regenerated.common.item.RItems;
import mc.jeryn.regenerated.common.sound.ModSoundEvents;
import mc.jeryn.regenerated.config.ModConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Regenerated {

    public static final String MOD_ID = "regenerated";
    public static final String MAPPINGS_MESSAGE = "Something has went severely wrong with mappings...";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static ModConfiguration config;

    public static void init() {
        ModCreativeModeTabs.TABS.register();
        ModBlocks.BLOCKS.register();
        RItems.ITEMS.register();
        ModSoundEvents.SOUND_EVENTS.register();
    }
}