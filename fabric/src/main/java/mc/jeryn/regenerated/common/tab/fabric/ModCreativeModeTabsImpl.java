package mc.jeryn.regenerated.common.tab.fabric;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.tab.ModCreativeModeTabs;
import mc.jeryn.regenerated.common.item.RItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabsImpl {
    public static CreativeModeTab createTab(String title){
        return FabricItemGroup.builder()
                .icon(ModCreativeModeTabs::makeIcon)
                .title(Component.translatable("itemGroup."+ Regenerated.MOD_ID+"."+title))
                .displayItems((itemDisplayParameters, output) -> RItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                .build();
    }
}
