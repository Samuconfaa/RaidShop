package it.samuconfaa.raidShop.commands;

import it.samuconfaa.raidShop.RaidShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final RaidShop plugin;

    public ReloadCommand(RaidShop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                sender.sendMessage(plugin.getConfigManager().getUsageErrorReload());
            } else {
                sender.sendMessage(plugin.getConfigManager().getUsageErrorReload());
            }
            return true;
        }

        if (sender.hasPermission("raidshop.reload")) {
            // Ricarica la configurazione
            plugin.getConfigManager().reloadConfig();

            sender.sendMessage(plugin.getConfigManager().getConfigReloadedMessage());
            plugin.getLogger().info("Configurazione ricaricata da " + sender.getName());
            return true;
        } else {
            sender.sendMessage(plugin.getConfigManager().getNoPerm());
            return true;
        }
    }
}