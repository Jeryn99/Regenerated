package mc.jeryn.regenerated.common.item;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.registry.DeferredRegistry;
import mc.jeryn.regenerated.registry.RegistrySupplier;
import mc.jeryn.regenerated.util.ModResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RItems {
    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(Regenerated.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> POCKET_WATCH = ITEMS.register("pocket_watch", () -> new FobWatchItem(new Item.Properties()
            .stacksTo(1).rarity(Rarity.RARE)));
}
