package mc.jeryn.regenerated.mixin;

import mc.jeryn.regenerated.common.data.player.RegenState;
import mc.jeryn.regenerated.common.data.player.RegeneratedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", at = @At("HEAD"), cancellable = true)
    public void hurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.getHealth() - amount <= 0) {
            RegeneratedEntityData.get(entity).ifPresent(regenData -> {
                if (regenData.remainingRegenerations() > 0) {
                    regenData.setRegenState(RegenState.REGENERATING);
                    regenData.removeRegeneration();
                    entity.setHealth(entity.getMaxHealth());
                    cir.setReturnValue(false);
                }
            });
        }
    }


}
