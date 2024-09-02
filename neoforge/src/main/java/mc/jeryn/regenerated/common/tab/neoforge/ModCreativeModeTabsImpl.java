package mc.jeryn.regenerated.common.tab.neoforge;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.item.RItems;
import mc.jeryn.regenerated.common.tab.ModCreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabsImpl {
    public static CreativeModeTab createTab(String title){
        return CreativeModeTab.builder()
                .icon(ModCreativeModeTabs::makeIcon)
                .title(Component.translatable("itemGroup." + Regenerated.MOD_ID + "." + title))
                .displayItems((itemDisplayParameters, output) -> RItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                .build();
    }
}
