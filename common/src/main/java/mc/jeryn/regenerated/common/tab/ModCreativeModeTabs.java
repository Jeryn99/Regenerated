package mc.jeryn.regenerated.common.tab;

import dev.architectury.injectables.annotations.ExpectPlatform;
import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.item.RItems;
import mc.jeryn.regenerated.registry.DeferredRegistry;
import mc.jeryn.regenerated.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(Regenerated.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN = TABS.register("main", () -> createTab("main"));

    public static ItemStack makeIcon() {
        return new ItemStack(RItems.POCKET_WATCH.get());
    }

    @ExpectPlatform
    public static CreativeModeTab createTab(String title){
        throw new RuntimeException(Regenerated.MAPPINGS_MESSAGE);
    }
}
