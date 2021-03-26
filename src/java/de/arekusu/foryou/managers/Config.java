package de.arekusu.foryou.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.*;

public class Config {
    private static String documentPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();


    public static void generate() {
        try {
            new File(documentPath + "\\ForYou\\").mkdir();
            new File(documentPath + "\\ForYou\\settings.json").createNewFile();
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        File folder = new File(documentPath + "\\ForYou\\");
        File[] files = folder.listFiles();

        if(files != null) {
            for(File f: files) {
                f.delete();
            }
        }
        folder.delete();
    }

    public static void save() {
        try {
            if(!new File(documentPath + "\\ForYou\\").exists()) generate();

            FileWriter writer = new FileWriter(documentPath + "\\ForYou\\settings.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jObject = new JsonObject();

            jObject.addProperty("prevKey", HotKey.INSTANCE.getPreviousKey());
            jObject.addProperty("pauseKey", HotKey.INSTANCE.getPauseKey());
            jObject.addProperty("skipKey", HotKey.INSTANCE.getSkipKey());

            gson.toJson(jObject, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        if(new File(documentPath + "\\ForYou\\settings.json").exists()) {
            try {
                FileReader reader = new FileReader(documentPath + "\\ForYou\\settings.json");
                JsonObject jObject = new Gson().fromJson(reader, JsonObject.class);

                HotKey.INSTANCE.setPreviousKey(jObject.get("prevKey").getAsInt());
                HotKey.INSTANCE.setPauseKey(jObject.get("pauseKey").getAsInt());
                HotKey.INSTANCE.setSkipKey(jObject.get("skipKey").getAsInt());

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
