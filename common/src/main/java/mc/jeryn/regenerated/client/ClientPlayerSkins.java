package mc.jeryn.regenerated.client;

import com.mojang.authlib.GameProfile;
import mc.jeryn.regenerated.Regenerated;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.UUID;

/**
 * A utility class for managing client-side player skins.
 */
public class ClientPlayerSkins {

    /**
     * A hashmap to store player skins, keyed by player UUID.
     */
    private static HashMap<UUID, PlayerSkin> SKINS = new HashMap<>();

    /**
     * Adds a player skin to the cache.
     *
     * @param uuid the UUID of the player
     * @param playerSkin the player skin to add
     */
    public static void putSkin(UUID uuid, PlayerSkin playerSkin) {
        SKINS.put(uuid, playerSkin);
    }

    /**
     * Removes a player skin from the cache.
     *
     * @param uuid the UUID of the player
     */
    public static void removeSkin(UUID uuid) {
        SKINS.remove(uuid);
    }

    /**
     * Removes all player skins from the cache.
     */
    public static void removeAll() {
        SKINS.clear();
    }

    /**
     * Checks if a player skin is present in the cache for the given UUID.
     *
     * @param uuid the UUID of the player
     * @return true if the player skin is present, false otherwise
     */
    public static boolean hasSkin(UUID uuid) {
        return SKINS.containsKey(uuid);
    }

    /**
     * Returns the player skin associated with the given UUID, or null if not present.
     *
     * @param uuid the UUID of the player
     * @return the player skin, or null if not present
     */
    public static PlayerSkin getSkin(UUID uuid) {
        return SKINS.get(uuid);
    }

    /**
     * Creates a new player skin with the specified texture and model.
     *
     * @param skinTexture the resource location of the skin texture
     * @param model the player skin model
     * @return a new player skin
     */
    public static PlayerSkin newPlayerSkin(ResourceLocation skinTexture, PlayerSkin.Model model){
        return new PlayerSkin(skinTexture, null, null, null, model, false);
    }

    public static void getSkin(GameProfile profile, CallbackInfoReturnable<PlayerSkin> cir) {
        Player localPlayer = Minecraft.getInstance().level.getPlayerByUUID(profile.getId());

        // Null check - sometimes a player may not be fully loaded on the client or exist yet
        if(localPlayer == null) return;

        // === Test Code ====
        if(localPlayer.isCrouching()){
            ClientPlayerSkins.putSkin(profile.getId(), ClientPlayerSkins.newPlayerSkin(ResourceLocation.parse(Regenerated.MOD_ID + ":textures/entity/player/test_skin.png"), PlayerSkin.Model.SLIM));
        } else {
            ClientPlayerSkins.removeSkin(profile.getId());
        }
        // === Test Code End ====

        if(ClientPlayerSkins.hasSkin(profile.getId())){
            PlayerSkin skin = ClientPlayerSkins.getSkin(profile.getId());
            cir.setReturnValue(skin);
        }
    }
}