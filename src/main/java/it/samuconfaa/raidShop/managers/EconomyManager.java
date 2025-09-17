package it.samuconfaa.raidShop.managers;

import it.samuconfaa.raidShop.RaidShop;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getServer;

public class EconomyManager {
    private final RaidShop plugin;
    private static Economy econ = null;

    public EconomyManager(RaidShop plugin) {
        this.plugin = plugin;
    }

    public static void setEconomy(Economy economy) {
        econ = economy;
    }

    public void removeMoney(Player player, double amount) {
        if (econ != null) {
            econ.withdrawPlayer(player, amount);
        }
    }

    public double checkMoney(Player player) {
        if (econ != null) {
            return econ.getBalance(player);
        }
        return 0;
    }

    public void giveMoney(Player player, double amount) {
        if (econ != null) {
            econ.depositPlayer(player, amount);
        }
    }
}
