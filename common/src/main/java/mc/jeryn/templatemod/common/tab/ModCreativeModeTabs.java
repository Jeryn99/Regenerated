package mc.jeryn.templatemod.common.tab;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.common.item.ModItems;
import mc.jeryn.templatemod.registry.DeferredRegistry;
import mc.jeryn.templatemod.registry.RegistrySupplier;
import mc.jeryn.templatemod.util.ModResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(TemplateMod.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> TEMPLATE_MOD = TABS.register("template_mod", () -> createTab("template_mod"));
    public static ItemStack makeIcon() {
        return new ItemStack(ModItems.TEMPLATE_ITEM.get());
    }

    @ExpectPlatform
    public static CreativeModeTab createTab(String title){
        throw new RuntimeException(TemplateMod.MAPPINGS_MESSAGE);
    }
}
