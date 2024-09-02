package mc.jeryn.regenerated.fabric;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import mc.jeryn.regenerated.Regenerated;
import net.fabricmc.api.ModInitializer;
import mc.jeryn.regenerated.config.ConfigHolder;
import net.neoforged.fml.config.ModConfig;

public class RegeneratedFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        NeoForgeConfigRegistry.INSTANCE.register(Regenerated.MOD_ID, ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        Regenerated.config = ConfigHolder.SERVER;
        Regenerated.init();
    }
}