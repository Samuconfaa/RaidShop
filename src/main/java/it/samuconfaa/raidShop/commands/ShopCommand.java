package it.samuconfaa.raidShop.commands;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.shopgui.Shop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {

    private final RaidShop plugin;
    private Shop shop;

    public ShopCommand(RaidShop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Solo i giocatori possono aprire lo shop");
            return true;
        }
        Player p = (Player) sender;

        if(args.length != 0){
            p.sendMessage(plugin.getConfigManager().getUsageErrorShop());
            return true;
        }

        if(p.hasPermission("raidshop.openshop")){
            shop.openShop(p);
            return true;
        }else{
            p.sendMessage(plugin.getConfigManager().getNoPerm());
            return true;
        }
    }
}
