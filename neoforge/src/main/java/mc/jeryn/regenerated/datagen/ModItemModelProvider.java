package mc.jeryn.regenerated.datagen;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.item.RItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper efh) {
        super(output, Regenerated.MOD_ID, efh);
    }

    @Override
    protected void registerModels() {
        basicItem(RItems.INTERDIMENSIONAL_STORAGE.get());
    }
}
