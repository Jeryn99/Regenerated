package mc.jeryn.regenerated.client;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.platform.NativeImage;
import mc.jeryn.regenerated.common.data.player.RegeneratedEntityData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class ClientPlayerSkins {

    private static final HashMap<UUID, PlayerSkin> SKINS = new HashMap<>();

    public static void insertSkin(UUID uuid, PlayerSkin playerSkin) {
        SKINS.put(uuid, playerSkin);
    }

    public static void deleteSkin(UUID uuid) {
        PlayerSkin skin = SKINS.get(uuid);
        Minecraft.getInstance().getTextureManager().release(skin.texture());
        SKINS.remove(uuid);
    }

    public static void removeAll() {
        SKINS.forEach((uuid, playerSkin) -> {
            Minecraft.getInstance().getTextureManager().release(playerSkin.texture());
        });
        SKINS.clear();
    }

    public static boolean hasSkin(UUID uuid) {
        return SKINS.containsKey(uuid);
    }

    public static PlayerSkin retrieveSkinForPlayer(UUID uuid) {
        return SKINS.get(uuid);
    }

    public static PlayerSkin instantiateSkin(UUID playeruuid, ResourceLocation skinTexture, PlayerSkin.Model model) {
        PlayerSkin mojangSkin = retrieveMojangSkin(playeruuid);
        return new PlayerSkin(skinTexture, null, mojangSkin.capeTexture(), mojangSkin.elytraTexture(), model, false);
    }

    public static PlayerSkin instantiateSkin(UUID playeruuid, byte[] skinTexture, PlayerSkin.Model model) {
        PlayerSkin mojangSkin = retrieveMojangSkin(playeruuid);
        return new PlayerSkin(loadImage(genSkinNative(skinTexture)), null, mojangSkin.capeTexture(), mojangSkin.elytraTexture(), model, false);
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
                        regeneratedEntityData.getSkinData().ifPresent(skinData -> {
                            if (hasSkin(profile.getId())) {
                                cir.setReturnValue(retrieveSkinForPlayer(profile.getId()));
                            } else {
                                // Update to load the image from the specified path
                                String skinPath = "C:\\Users\\Craig\\IdeaProjects\\Regenerated\\fabric\\run\\regenerated\\skins\\slim\\server\\xr2904c.png";
                                System.out.println("Loading skin from: " + skinPath);
                                insertSkin(profile.getId(), instantiateSkin(profile.getId(), fileToBytes(new File(skinPath)), skinData.isAlex() ? PlayerSkin.Model.SLIM : PlayerSkin.Model.WIDE));
                                cir.setReturnValue(retrieveSkinForPlayer(profile.getId()));
                            }
                        });
                    } else {
                        deleteSkin(profile.getId());
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

    public static PlayerSkin retrieveMojangSkin(UUID uuid){
        SkinManager skinManager = Minecraft.getInstance().getSkinManager();
        GameProfile gameProfile = new GameProfile(uuid, uuid.toString());
        return skinManager.getInsecureSkin(gameProfile);
    }



}
