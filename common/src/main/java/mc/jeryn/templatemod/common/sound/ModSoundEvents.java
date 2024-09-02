package mc.jeryn.templatemod.common.sound;

import mc.jeryn.templatemod.TemplateMod;
import mc.jeryn.templatemod.registry.DeferredRegistry;
import mc.jeryn.templatemod.registry.RegistrySupplier;
import mc.jeryn.templatemod.registry.RegistrySupplierHolder;
import mc.jeryn.templatemod.util.ModResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {
    public static final DeferredRegistry<SoundEvent> SOUND_EVENTS = DeferredRegistry.create(TemplateMod.MOD_ID, Registries.SOUND_EVENT);

    public static final RegistrySupplierHolder<SoundEvent, SoundEvent> TEMPLATE_SOUND_EVENT = SOUND_EVENTS.registerForHolder(
            "template_sound_event", () -> SoundEvent.createVariableRangeEvent(ModResources.TEMPLATE_SOUND));

}
