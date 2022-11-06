package me.slayz.balance.commands;

import me.slayz.balance.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Give implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(Utilities.playerExists(p)) {
                if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    int amount;

                    try{
                        amount = Integer.parseInt(args[1]);
                    }catch(Exception e){
                        p.sendMessage(ChatColor.RED+"Only numbers in amount argument");
                        return true;
                    }

                    if(target == p){
                        p.sendMessage(ChatColor.RED+"You can't transfer to yourself money");
                        return true;
                    }

                    if (target != null && Utilities.playerExists(target)) {
                        Utilities.transfer(p,target,amount);
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Usage: /givemoney [target] [amount]");
                }
            }

        }

        return true;
    }
}
