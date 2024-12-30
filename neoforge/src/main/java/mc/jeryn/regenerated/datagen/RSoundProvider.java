package mc.jeryn.regenerated.datagen;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.common.data.player.Regen;
import mc.jeryn.regenerated.common.sound.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class RSoundProvider extends SoundDefinitionsProvider {

    protected RSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, Regenerated.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.REGENERATION_RANDOM, SoundDefinition.definition().with(
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_short"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_heartbeat"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_long"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_powerful"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_teacup"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regeneration_turbulence"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regen_0"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regen_4"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regen_troughton"), SoundDefinition.SoundType.SOUND),
                SoundDefinition.Sound.sound(Regenerated.resourceLocation("regen_watcher"), SoundDefinition.SoundType.SOUND)
        ));
    }
}
