package me.slayz.balance.commands;

import me.slayz.balance.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Balance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(args.length == 0) {

                if (Utilities.playerExists(p)) {
                    p.sendMessage(ChatColor.YELLOW+"You have "+Utilities.getMoney(p)+" balance.");
                } else {
                    p.sendMessage(ChatColor.RED + "Something went wrong with the database");
                }
            }
            else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null && Utilities.playerExists(target)){
                    p.sendMessage(ChatColor.YELLOW+target.getName()+" has "+Utilities.getMoney(target)+" balance.");
                }else{
                    p.sendMessage(ChatColor.RED+"Player doesn't exists in the databse");
                }
            }
            else{
                p.sendMessage(ChatColor.RED+"Usage: /bal [target]");
            }
        }

        return true;
    }
}
