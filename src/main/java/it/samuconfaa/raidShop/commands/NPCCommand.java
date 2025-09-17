package it.samuconfaa.raidShop.commands;

import it.samuconfaa.raidShop.NPC.ShopNPC;
import it.samuconfaa.raidShop.RaidShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class NPCCommand implements CommandExecutor {

    private final RaidShop plugin;
    private final ShopNPC shopNPC;

    public NPCCommand(RaidShop plugin, ShopNPC shopNPC) {
        this.plugin = plugin;
        this.shopNPC = shopNPC;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Solo i giocatori possono fare questo comando");
            return true;
        }
        Player player = (Player) sender;
        if(player.hasPermission("raidshop.setnpc")) {
            if (args.length == 0 || args.length == 1) {
                if(args.length == 0){
                    shopNPC.createNPC(player);
                    return true;
                }else{
                    String nick = args[0];
                    shopNPC.createNPC(player, nick);
                    return true;
                }
            } else {
                player.sendMessage(plugin.getConfigManager().getUsageErrorNpcp());
                return true;
            }
        }else{
            player.sendMessage(plugin.getConfigManager().getNoPerm());
            return true;
        }
    }
}
