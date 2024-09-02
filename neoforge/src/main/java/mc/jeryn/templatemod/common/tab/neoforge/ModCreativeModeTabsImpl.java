package mc.jeryn.templatemod.common.tab.neoforge;

import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.common.item.ModItems;
import mc.jeryn.templatemod.common.tab.ModCreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabsImpl {
    public static CreativeModeTab createTab(String title){
        return CreativeModeTab.builder()
                .icon(ModCreativeModeTabs::makeIcon)
                .title(Component.translatable("itemGroup." + TemplateMod.MOD_ID + "." + title))
                .displayItems((itemDisplayParameters, output) -> ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                .build();
    }
}
