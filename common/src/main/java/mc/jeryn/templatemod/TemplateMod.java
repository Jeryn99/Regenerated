package mc.jeryn.templatemod;

import mc.jeryn.templatemod.common.block.ModBlocks;
import mc.jeryn.templatemod.common.tab.ModCreativeModeTabs;
import mc.jeryn.templatemod.common.item.ModItems;
import mc.jeryn.templatemod.common.sound.ModSoundEvents;
import mc.jeryn.templatemod.config.ModConfiguration;
import mc.jeryn.templatemod.util.ModResources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TemplateMod {

    public static final String MOD_ID = "templatemod";
    public static final String MAPPINGS_MESSAGE = "Something has went severely wrong with mappings...";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static ModConfiguration config;

    public static void init() {
        ModCreativeModeTabs.TABS.register();
        ModBlocks.BLOCKS.register();
        ModItems.ITEMS.register();
        ModSoundEvents.SOUND_EVENTS.register();
    }
}