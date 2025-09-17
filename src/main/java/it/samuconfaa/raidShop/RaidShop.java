package it.samuconfaa.raidShop;

import it.samuconfaa.raidShop.commands.NPCCommand;
import it.samuconfaa.raidShop.commands.ShopCommand;
import it.samuconfaa.raidShop.managers.ConfigManager;
import it.samuconfaa.raidShop.managers.EconomyManager;
import it.samuconfaa.raidShop.managers.EconomyManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public final class RaidShop extends JavaPlugin {

    private ConfigManager configManager;
    private Economy econ;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        getCommand("shopraid").setExecutor(new ShopCommand(this));
        getCommand("setnpcshop").setExecutor(new NPCCommand(this));

        if (!setupEconomy()) {
            getLogger().severe("Vault non è installato o nessun plugin economico è trovato!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    @Override
    public void onDisable() {

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }


}
