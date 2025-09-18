package it.samuconfaa.raidShop;

import it.samuconfaa.raidShop.commands.FixCommand;
import it.samuconfaa.raidShop.commands.NPCCommand;
import it.samuconfaa.raidShop.commands.ShopCommand;
import it.samuconfaa.raidShop.fixGUI.FixGui;
import it.samuconfaa.raidShop.managers.ConfigManager;
import it.samuconfaa.raidShop.managers.EconomyManager;
import it.samuconfaa.raidShop.NPC.ShopNPC;
import it.samuconfaa.raidShop.shopgui.Generale;
import it.samuconfaa.raidShop.shopgui.Libri;
import it.samuconfaa.raidShop.shopgui.Pozioni;
import it.samuconfaa.raidShop.shopgui.Armor;
import it.samuconfaa.raidShop.shopgui.IngredientiPozioni;
import it.samuconfaa.raidShop.shopgui.Shop;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;

public final class RaidShop extends JavaPlugin {

    private ConfigManager configManager;
    private EconomyManager econManager;
    private Shop shop;
    private Generale generale;
    private Pozioni pozioni;
    private Libri libri;
    private Armor armor;
    private IngredientiPozioni ingredientiPozioni;
    private ShopNPC shopNPC;
    private FixGui fixGui;

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
        this.armor = new Armor(this, econManager);
        this.ingredientiPozioni = new IngredientiPozioni(this, econManager);
        this.fixGui = new FixGui(this, econManager);

        this.shop = new Shop(this, generale, pozioni, libri, armor, ingredientiPozioni, econManager);
        this.shopNPC = new ShopNPC(this, shop);

        // Imposta i riferimenti circolari
        this.generale.setShop(this.shop);
        this.pozioni.setShop(this.shop);
        this.libri.setShop(this.shop);
        this.armor.setShop(this.shop);
        this.ingredientiPozioni.setShop(this.shop);

        // Registra i comandi
        getCommand("shopraid").setExecutor(new ShopCommand(this, shop));
        getCommand("setnpcshop").setExecutor(new NPCCommand(this, shopNPC));
        getCommand("fix").setExecutor(new FixCommand(this, fixGui));

        // Registra gli event listeners
        Bukkit.getPluginManager().registerEvents(generale, this);
        Bukkit.getPluginManager().registerEvents(pozioni, this);
        Bukkit.getPluginManager().registerEvents(libri, this);
        Bukkit.getPluginManager().registerEvents(armor, this);
        Bukkit.getPluginManager().registerEvents(ingredientiPozioni, this);
        Bukkit.getPluginManager().registerEvents(shop, this);
        Bukkit.getPluginManager().registerEvents(shopNPC, this);
        Bukkit.getPluginManager().registerEvents(fixGui, this);

        getLogger().info("RaidShop è stato abilitato con successo!");
        getLogger().info("Sezioni disponibili: Generale, Pozioni, Incantesimi, Armature, Ingredienti Pozioni");
        getLogger().info("Fix GUI abilitata! Usa /fix per riparare gli oggetti");
    }

    @Override
    public void onDisable() {
        getLogger().info("RaidShop è stato disabilitato!");
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

    public FixGui getFixGui() {
        return fixGui;
    }
}