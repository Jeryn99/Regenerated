package mc.jeryn.regenerated.common.sound;

import mc.jeryn.regenerated.Regenerated;
import mc.jeryn.regenerated.registry.DeferredRegistry;
import mc.jeryn.regenerated.registry.RegistrySupplierHolder;
import mc.jeryn.regenerated.util.ModResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {
    public static final DeferredRegistry<SoundEvent> SOUND_EVENTS = DeferredRegistry.create(Regenerated.MOD_ID, Registries.SOUND_EVENT);

    public static final RegistrySupplierHolder<SoundEvent, SoundEvent> REGENERATION_RANDOM = SOUND_EVENTS.registerForHolder(
            "regeneration_random", () -> SoundEvent.createVariableRangeEvent(ModResources.TEMPLATE_SOUND));

}
