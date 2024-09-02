package mc.jeryn.regenerated.datagen;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.block.ModBlocks;
import mc.jeryn.regenerated.common.item.RItems;
import mc.jeryn.regenerated.util.ModResources;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static mc.jeryn.regenerated.Regenerated.MOD_ID;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    public void addAdvancement(ResourceLocation advancementLocation, String title, String desc){
        add("advancement."+MOD_ID+":"+advancementLocation.getPath(), title);
        add("advancement."+MOD_ID+":"+advancementLocation.getPath()+".desc", desc);
    }

    public void addGuiMessage(String title, String translation){
        add("gui."+ MOD_ID+"."+title, translation);
    }

    public void addChatMessage(String title, String translation){
        add("chat.message."+ MOD_ID+"."+title, translation);
    }

    public void addDisconnectionReason(String title, String translation){
        add("disconnect."+ MOD_ID+"."+title, translation);
    }

    public void addConfigOption(String title, String tileTranslation, String tipTranslation){
     add(title, tileTranslation);
     add(title+".tooltip", tipTranslation);
    }

    public void addConfigSection(String title, String titleTranslation, String commentTranslation){
        add(MOD_ID + ".configuration."+title, titleTranslation);
        add(MOD_ID + ".configuration."+title+".button", "Edit");
        add(MOD_ID + ".configuration."+title+".tooltip", commentTranslation);
    }

    public void addJukeboxSong(ResourceKey key, String translation){
        add(Util.makeDescriptionId("jukebox_song", key.location()), translation);
    }

    public void addItemGroup(String title, String translation){
        add("itemGroup." + Regenerated.MOD_ID + "." + title, translation);
    }

    public void addSound(String title, String translation){
        add(Regenerated.MOD_ID + ".sound." + title, translation);
    }

    @Override
    protected void addTranslations() {
        addConfigOption("meow", "meow", "meow?");
        addConfigSection("General Settings", "General Settings", "This category holds general values that most people will want to change.");
        addBlock(ModBlocks.TEMPLATE_BLOCK, "Meowing Block");
        addItem(RItems.TEMPLATE_ITEM, "Meowing Disc");
        addJukeboxSong(ModResources.TEMPLATE_JUKEBOX_SONG, "Tanger - Scratch!");

        addSound("fail", "no meow :<");
        addSound("meow", "MEOW!!");
    }
}
