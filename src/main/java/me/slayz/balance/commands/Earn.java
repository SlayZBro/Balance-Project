package me.slayz.balance.commands;

import me.slayz.balance.Main;
import me.slayz.balance.utils.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Earn implements CommandExecutor {

    private List<Player> list = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender instanceof Player){
            Player p = (Player) sender;

            if(!list.contains(p)){

                if(Utilities.playerExists(p)) {

                    list.add(p);
                    Random r = new Random();
                    int amount = r.nextInt(4)+1;
                    Utilities.setMoney(p,Utilities.getMoney(p) + amount);
                    p.sendMessage(ChatColor.GREEN+"You earned "+amount+" money!");

                    new BukkitRunnable(){
                        int i = 60;
                        @Override
                        public void run(){
                            if(i == 0){
                                list.remove(p);
                                this.cancel();
                            }

                            i--;
                        }
                    }.runTaskTimer(Main.getInstance(),0,20);


                }

            }else{
                p.sendMessage(ChatColor.RED+"You still can't use this command");
            }

        }

        return true;
    }
}
