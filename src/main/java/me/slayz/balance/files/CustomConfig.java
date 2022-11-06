package me.slayz.balance.files;

import me.slayz.balance.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;
    
    public static void setup(){
        file = new File(Main.getInstance().getDataFolder(),"balance.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(ChatColor.RED+"Couldn't generate file");

            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }


    public static FileConfiguration get(){
        return customFile;
    }
    
    public static void save(){
        try {
            customFile.save(file);
            reload();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
