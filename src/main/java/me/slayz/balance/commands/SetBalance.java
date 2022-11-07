package me.slayz.balance.commands;

import me.slayz.balance.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetBalance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(p.isOp()){
                if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    int amount ;
                    if(target == null || !Utilities.playerExists(target)){
                        p.sendMessage(Utilities.database);
                        return true;
                    }

                    try{
                        amount = Integer.parseInt(args[1]);
                    }catch(Exception e){
                        p.sendMessage(ChatColor.RED+"Insert numbers only in the amount argument");
                        return true;
                    }

                    if(amount < 0){
                        p.sendMessage(ChatColor.RED+"Amount must be positive or 0");
                        return true;
                    }

                    Utilities.setMoney(target,amount);
                    p.sendMessage(ChatColor.YELLOW+"New "+target.getName()+" balance is: "+amount);



                }else{
                    p.sendMessage(ChatColor.RED+"Usage: /setbal [target] [amount]");
                }
            }else{
                p.sendMessage(ChatColor.RED+"You must be an operator to use this command");
            }
        }

        return true;
    }
}
