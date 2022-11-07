package me.slayz.balance.utils;

import me.slayz.balance.Main;
import me.slayz.balance.files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utilities {

    public static final String database = ChatColor.RED+"This player doesn't exist in the database";


    public static boolean playerExists(Player p){
        return CustomConfig.get().contains(p.getUniqueId().toString());
    }

    public static void createPlayer(Player p){
        CustomConfig.get().set(p.getUniqueId().toString(),0);
        CustomConfig.save();
    }

    public static int getMoney(Player p){
        return CustomConfig.get().getInt(p.getUniqueId().toString());
    }

    public static void setMoney(Player p, int i){
        CustomConfig.get().set(p.getUniqueId().toString(),i);
        CustomConfig.save();
    }


    public static void transfer(Player who, Player to, int amount){
        if(amount > getMoney(who)){
            who.sendMessage(ChatColor.RED+"You cannot transfer more money than you have");
            return;
        }

        setMoney(to,getMoney(to)+amount);
        setMoney(who,getMoney(who)-amount);

        who.sendMessage(ChatColor.GREEN+"You sent to "+to.getName()+" "+amount+" money");
        to.sendMessage(ChatColor.YELLOW+who.getName()+" sent you "+amount+" money");
    }
}
