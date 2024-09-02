package mc.jeryn.templatemod.common.item;

import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.registry.DeferredRegistry;
import mc.jeryn.templatemod.registry.RegistrySupplier;
import mc.jeryn.templatemod.util.ModResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ModItems {
    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(TemplateMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> TEMPLATE_ITEM = ITEMS.register("template_item", () -> new Item(new Item.Properties()
            .stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ModResources.TEMPLATE_JUKEBOX_SONG)));
}
