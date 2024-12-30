package mc.jeryn.regenerated.common.data.player.fabric;

import mc.jeryn.regenerated.common.data.player.RegeneratedEntityData;
import mc.jeryn.regenerated.data_attachment.RegeneratedPlayerComponents;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.ladysnake.cca.api.v3.component.ComponentV3;

import java.util.Objects;
import java.util.Optional;

public class RegeneratedEntityDataImpl extends RegeneratedEntityData implements ComponentV3 {

    public RegeneratedEntityDataImpl(Player player) {
        super(player);
    }

    public static Optional<RegeneratedEntityData> get(LivingEntity livingEntity) {
        try {
            return Optional.of(RegeneratedPlayerComponents.REGENERATION_ENTITY_DATA_COMPONENT_KEY.get(livingEntity));
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    @Override
    public void readFromNbt(CompoundTag compoundTag, HolderLookup.Provider provider) {
        deserializeNBT(compoundTag);
    }

    @Override
    public void writeToNbt(CompoundTag compoundTag, HolderLookup.Provider provider) {
        CompoundTag nbt = serializeNBT();
        for (String key : nbt.getAllKeys()) {
            compoundTag.put(key, Objects.requireNonNull(nbt.get(key)));
        }
    }
}