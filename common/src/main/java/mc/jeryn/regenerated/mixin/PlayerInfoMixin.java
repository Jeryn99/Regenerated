package mc.jeryn.regenerated.mixin;

import com.mojang.authlib.GameProfile;
import mc.jeryn.regenerated.client.ClientPlayerSkins;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.PlayerSkin;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInfo.class)
public class PlayerInfoMixin {

    @Shadow @Final private GameProfile profile;

    @Inject(method = "getSkin()Lnet/minecraft/client/resources/PlayerSkin;", at = @At("HEAD"), cancellable = true)
    public void getSkin(CallbackInfoReturnable<PlayerSkin> cir) {
       ClientPlayerSkins.replaceSkinIfReplaceSkinNecessary(profile, cir);
    }

}
