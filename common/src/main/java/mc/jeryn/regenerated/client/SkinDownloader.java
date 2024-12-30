package mc.jeryn.regenerated.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.imageio.ImageIO;

public class SkinDownloader {
    private static final String API_URL = "https://api.jeryn.dev/mc/skins/random";
    private static final String SKIN_FOLDER = "regenerated/skins/";
    private static final String ALEX_SKIN_MODEL = "slim";
    private static final String DEFAULT_SKIN_MODEL = "default";

    public void downloadSkins() throws IOException {
        // Create the skin folder if it doesn't exist
        File skinFolder = new File(SKIN_FOLDER);
        skinFolder.mkdirs();

        // Get the skin data from the API
        String jsonData = getUrlContent(API_URL);
        List<SkinData> skinDataList = new Gson().fromJson(jsonData, new TypeToken<List<SkinData>>(){}.getType());

        // Create lists to store the alex and default skins
        List<SkinDownload> alexSkins = new ArrayList<>();
        List<SkinDownload> defaultSkins = new ArrayList<>();

        // Loop through the skin data and sort them into alex and default skins
        for (SkinData skinData : skinDataList) {
            String skinName = skinData.getName();
            String skinLink = skinData.getLink();
            boolean isAlexSkin = isAlexSkin(skinLink);

            SkinDownload skin = new SkinDownload(skinName, skinLink, isAlexSkin ? ALEX_SKIN_MODEL : DEFAULT_SKIN_MODEL);
            if (isAlexSkin) {
                alexSkins.add(skin);
            } else {
                defaultSkins.add(skin);
            }
        }

        // Download and save the skins
        downloadAndSaveSkins(alexSkins, ALEX_SKIN_MODEL);
        downloadAndSaveSkins(defaultSkins, DEFAULT_SKIN_MODEL);
    }

    private void downloadAndSaveSkins(List<SkinDownload> skins, String model) throws IOException {
        for (SkinDownload skin : skins) {
            String skinFolderName = SKIN_FOLDER + model + "/server/";
            File skinFolderFile = new File(skinFolderName);

            if (!skinFolderFile.exists()) {
                skinFolderFile.mkdirs();
            }

            String skinFilePath = skinFolderName + skin.getName() + ".png";
            File skinFile = new File(skinFilePath);

            if (!skinFile.exists()) {
                skinFile.createNewFile();
            }

            URL skinUrl = new URL(skin.getLink());
            Path skinPath = skinFile.toPath();

            Files.copy(skinUrl.openStream(), skinPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Downloaded and saved skin: " + skin.getName());
        }
    }

    private boolean isAlexSkin(String skinLink) throws IOException {
        // Download the skin image
        URL skinUrl = new URL(skinLink);
        BufferedImage skinImage = ImageIO.read(skinUrl);

        // Check the pixels on the skin's arms
        for (int x = 50; x < 54; x++) {
            for (int y = 16; y < 18; y++) {
                int pixel = skinImage.getRGB(x, y);
                if ((pixel & 0xFF000000) != 0) {
                    // If the pixel is not transparent, return false
                    return false;
                }
            }
        }

        // If all pixels are transparent, return true
        return true;
    }

    private String getUrlContent(String url) throws IOException {
        URL apiUrl = new URL(url);
        return new String(apiUrl.openStream().readAllBytes());
    }

    private class SkinDownload {
        private String name;
        private String link;
        private String model;

        public SkinDownload(String name, String link, String model) {
            this.name = name;
            this.link = link;
            this.model = model;
        }

        public String getName() {
            return name;
        }

        public String getLink() {
            return link;
        }

        public String getModel() {
            return model;
        }
    }

    private static class SkinData {
        private String _id;
        private String name;
        private String link;
        private String key;

        public String getName() {
            return name;
        }

        public String getLink() {
            return link;
        }
    }
}