package mc.jeryn.regenerated.datagen.bootstrap;

import mc.jeryn.regenerated.common.sound.ModSoundEvents;
import mc.jeryn.regenerated.registry.RegistrySupplierHolder;
import mc.jeryn.regenerated.util.ModResources;
import net.minecraft.Util;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

public class ModJukeboxSongsProvider {
    private static void register(
            BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, RegistrySupplierHolder<SoundEvent, SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput
    ) {
        context.register(
                key, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())), (float)lengthInSeconds, comparatorOutput)
        );
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, ModResources.TEMPLATE_JUKEBOX_SONG, ModSoundEvents.TEMPLATE_SOUND_EVENT, 156, 11);
    }
}
