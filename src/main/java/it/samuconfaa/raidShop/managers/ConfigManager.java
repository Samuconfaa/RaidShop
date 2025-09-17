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
        NOMI DELLE GUI
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

    /*
        NPC
     */

    public String getNpcName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("NPC.shop-name"));
    }



}
