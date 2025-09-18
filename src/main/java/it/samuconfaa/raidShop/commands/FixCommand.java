package it.samuconfaa.raidShop.commands;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.fixGUI.FixGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FixCommand implements CommandExecutor {

    private final RaidShop plugin;
    private final FixGui fixGui;

    public FixCommand(RaidShop plugin, FixGui fixGui) {
        this.plugin = plugin;
        this.fixGui = fixGui;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i giocatori possono usare questo comando");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 0) {
            player.sendMessage(plugin.getConfigManager().getUsageErrorFix());
            return true;
        }

        if (player.hasPermission("raidshop.fix")) {
            fixGui.openGUI(player);
            return true;
        } else {
            player.sendMessage(plugin.getConfigManager().getNoPerm());
            return true;
        }
    }
}