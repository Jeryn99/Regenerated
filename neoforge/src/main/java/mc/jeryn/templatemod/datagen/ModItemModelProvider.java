package mc.jeryn.templatemod.datagen;

import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.common.item.ModItems;
import mc.jeryn.templatemod.util.ModResources;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, TemplateMod.MOD_ID, efh);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TEMPLATE_ITEM.get());
    }
}
