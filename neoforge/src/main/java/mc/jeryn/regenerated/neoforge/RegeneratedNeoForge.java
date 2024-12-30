package mc.jeryn.regenerated.neoforge;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.datagen.ModDataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Regenerated.MOD_ID)
public class RegeneratedNeoForge {
    public static IEventBus modEventBus;
    public RegeneratedNeoForge(IEventBus modEventBusParam) {
        modEventBus = modEventBusParam;
        IEventBus eventBus = NeoForge.EVENT_BUS;

  /*      ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        ModLoadingContext.get().getActiveContainer().registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        Regenerated.config = ConfigHolder.SERVER;*/
        Regenerated.init();

        modEventBus.register(ModDataGenerators.class);
    }
}