package it.samuconfaa.raidShop.managers;

import it.samuconfaa.raidShop.RaidShop;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private final RaidShop plugin;
    public FileConfiguration config;

    public ConfigManager(RaidShop plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig(){
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    /*
        NOMI DELLE GUI - SHOP
    */
    public String getGeneraleName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.generale"));
    }

    public String getEnchantName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.libri"));
    }

    public String getPozioniName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.pozioni"));
    }

    public String getShopName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.shop"));
    }

    public String getArmorName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.armor"));
    }

    public String getIngredientiName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ingredienti"));
    }

    /*
        CONFIGURAZIONI FIX GUI
    */
    public String getFixGUIName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.name"));
    }

    public int getFixGUISize(){
        return config.getInt("FixGUI.size");
    }

    public String getFixAnvilName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.anvil.name"));
    }

    public int getFixAnvilPos(){
        return config.getInt("FixGUI.anvil.position");
    }

    public String getFixLore1(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.anvil.lore.line1"));
    }

    public String getFixLore2(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.anvil.lore.line2"));
    }

    public String getFixLore3(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.anvil.lore.line3"));
    }

    public double getFixPrice(){
        return config.getDouble("FixGUI.price");
    }

    public String getFixGlassName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.glass.name"));
    }

    public int getFixGlassColor(){
        return config.getInt("FixGUI.glass.color");
    }

    public int getFixWalletPos(){
        return config.getInt("FixGUI.wallet.position");
    }

    public boolean isPreventAnvilPickup(){
        return config.getBoolean("FixGUI.prevent-anvil-pickup");
    }

    public boolean isFixSoundEnabled(){
        return config.getBoolean("FixGUI.sounds.enabled");
    }

    public String getFixSuccessMessage(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.messages.success"));
    }

    public String getFixNoMoneyMessage(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("FixGUI.messages.no-money"));
    }

    /*
        MESSAGGI
     */

    public String getNoPerm(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.no-permission"));
    }

    public String getUsageErrorShop(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.usage-shop"));
    }

    public String getUsageErrorNpcp(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.usage-npc"));
    }

    public String getUsageErrorFix(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.usage-fix"));
    }

    /*
        NPC
     */

    public String getNpcName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("NPC.shop-name"));
    }
}