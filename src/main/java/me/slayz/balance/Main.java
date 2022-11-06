package me.slayz.balance;

import me.slayz.balance.commands.Balance;
import me.slayz.balance.commands.Earn;
import me.slayz.balance.commands.Give;
import me.slayz.balance.commands.SetBalance;
import me.slayz.balance.events.Join;
import me.slayz.balance.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {
    private static Main instance;


    @Override
    public void onEnable() {
        setInstance(this);
        CustomConfig.setup();
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        getServer().getPluginManager().registerEvents(new Join(),this);

        registerCommands();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin Balance has enabled");


    }


    void registerCommands(){
        getCommand("bal").setExecutor(new Balance());
        getCommand("setbal").setExecutor(new SetBalance());
        getCommand("givebal").setExecutor(new Give());
        getCommand("earn").setExecutor(new Earn());
    }

    @Override
    public void onDisable() {

    }


    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(Main instance) {
        Main.instance = instance;
    }





}
