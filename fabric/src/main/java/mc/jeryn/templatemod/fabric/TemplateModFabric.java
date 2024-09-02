package mc.jeryn.templatemod.fabric;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import mc.jeryn.templatemod.util.ModResources;
import net.fabricmc.api.ModInitializer;
import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.config.ConfigHolder;
import net.neoforged.fml.config.ModConfig;

public class TemplateModFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        NeoForgeConfigRegistry.INSTANCE.register(TemplateMod.MOD_ID, ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
        TemplateMod.config = ConfigHolder.SERVER;
        TemplateMod.init();
    }
}