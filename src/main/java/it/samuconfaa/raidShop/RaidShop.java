package it.samuconfaa.raidShop;

import it.samuconfaa.raidShop.commands.NPCCommand;
import it.samuconfaa.raidShop.commands.ShopCommand;
import it.samuconfaa.raidShop.managers.ConfigManager;
import it.samuconfaa.raidShop.managers.EconomyManager;
import it.samuconfaa.raidShop.NPC.ShopNPC;
import it.samuconfaa.raidShop.shopgui.Generale;
import it.samuconfaa.raidShop.shopgui.Libri;
import it.samuconfaa.raidShop.shopgui.Pozioni;
import it.samuconfaa.raidShop.shopgui.Shop;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;

public final class RaidShop extends JavaPlugin {

    private ConfigManager configManager;
    private EconomyManager econManager;
    private Shop shop;
    private Generale generale;
    private Pozioni pozioni;
    private Libri libri;
    private ShopNPC shopNPC;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);

        if (!setupEconomy()) {
            getLogger().severe("Vault non è installato o nessun plugin economico è trovato!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.econManager = new EconomyManager(this);
        this.generale = new Generale(this, econManager);
        this.pozioni = new Pozioni(this, econManager);
        this.libri = new Libri(this, econManager);

        this.shop = new Shop(this, generale, pozioni, libri);
        this.shopNPC = new ShopNPC(this, shop);

        getCommand("shopraid").setExecutor(new ShopCommand(this, shop)); // Passa 'shop'
        getCommand("setnpcshop").setExecutor(new NPCCommand(this, shopNPC)); // Passa 'shopNPC'

        Bukkit.getPluginManager().registerEvents(generale, this);
        Bukkit.getPluginManager().registerEvents(pozioni, this);
        Bukkit.getPluginManager().registerEvents(libri, this);
        Bukkit.getPluginManager().registerEvents(shop, this);
        Bukkit.getPluginManager().registerEvents(shopNPC, this);

    }

    @Override
    public void onDisable() {
        // Disabilita il plugin
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        Economy econ = rsp.getProvider();
        EconomyManager.setEconomy(econ);
        return true;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}