package mc.jeryn.regenerated.client;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.NativeImage;
import mc.jeryn.regenerated.common.data.player.RegeneratedEntityData;
import mc.jeryn.regenerated.common.data.skin.RegeneratedSkinEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class ClientPlayerSkins {

    private static HashMap<UUID, PlayerSkin> SKINS = new HashMap<>();

    public static void putSkin(UUID uuid, PlayerSkin playerSkin) {
        SKINS.put(uuid, playerSkin);
    }

    public static void removeSkin(UUID uuid) {
        SKINS.remove(uuid);
    }

    public static void removeAll() {
        SKINS.clear();
    }

    public static boolean hasSkin(UUID uuid) {
        return SKINS.containsKey(uuid);
    }

    public static PlayerSkin getSkin(UUID uuid) {
        return SKINS.get(uuid);
    }

    public static PlayerSkin newPlayerSkin(ResourceLocation skinTexture, PlayerSkin.Model model) {
        return new PlayerSkin(skinTexture, null, null, null, model, false);
    }

    public static PlayerSkin newPlayerSkin(byte[] skinTexture, PlayerSkin.Model model) {
        return new PlayerSkin(loadImage(genSkinNative(skinTexture)), null, null, null, model, false);
    }

    public static ResourceLocation loadImage(NativeImage nativeImage) {
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        return textureManager.register("player_", new DynamicTexture(nativeImage));
    }

    public static NativeImage genSkinNative(byte[] skinArray) {
        try {
            return TextureFixer.processLegacySkin(NativeImage.read(new ByteArrayInputStream(skinArray)), "@");
        } catch (IOException e) {
            return null;
        }
    }


    public static void replaceSkinIfReplaceSkinNecessary(GameProfile profile, CallbackInfoReturnable<PlayerSkin> cir) {
        Optional.ofNullable(Minecraft.getInstance().level.getPlayerByUUID(profile.getId()))
                .flatMap(RegeneratedEntityData::get)
                .ifPresent(regeneratedEntityData -> {
                    if (regeneratedEntityData.shouldRenderCustomSkin()) {
                        regeneratedEntityData.setSkinData(new RegeneratedSkinEntry());
                        regeneratedEntityData.getSkinData().ifPresent(skinData -> {
                            if (hasSkin(profile.getId())) {
                                cir.setReturnValue(getSkin(profile.getId()));
                            } else {
                                // Update to load the image from the specified path
                                String skinPath = "C:\\Users\\Craig\\IdeaProjects\\Regenerated\\fabric\\run\\regenerated\\skins\\slim\\server\\xr2904c.png";
                                System.out.println("Loading skin from: " + skinPath);
                                putSkin(profile.getId(), newPlayerSkin(fileToBytes(new File(skinPath)), skinData.isAlex() ? PlayerSkin.Model.SLIM : PlayerSkin.Model.WIDE));
                                cir.setReturnValue(getSkin(profile.getId()));
                            }
                        });
                    } else {
                        removeSkin(profile.getId());
                    }
                });
    }


    public static byte[] fileToBytes(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }



}
