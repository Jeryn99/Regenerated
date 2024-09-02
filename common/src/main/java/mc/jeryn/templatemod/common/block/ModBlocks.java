package mc.jeryn.templatemod.common.block;

import mc.jeryn.templatemod.common.item.ModItems;
import mc.jeryn.templatemod.registry.DeferredRegistry;
import mc.jeryn.templatemod.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static mc.jeryn.templatemod.TemplateMod.MOD_ID;

public class ModBlocks {
    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> TEMPLATE_BLOCK = registerBlock("template_block", () -> new Block(BlockBehaviour.Properties.of()), true, null);

    public static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block, boolean registerItem, @Nullable Item.Properties properties) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        if (registerItem) {
            registerBlockItem(name, toReturn, properties == null ? new Item.Properties() : properties);
        }
        return toReturn;
    }

    private static <T extends Block> RegistrySupplier<Item> registerBlockItem(String name, RegistrySupplier<T> block, Item.Properties properties) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
}
