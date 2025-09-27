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

    public void reloadConfig() {
        loadConfig();
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
        PREZZI OGGETTI - SEZIONE GENERALE
    */
    public double getDiamondSwordPrice() { return config.getDouble("prices.generale.diamond_sword", 1500.0); }
    public double getIronSwordPrice() { return config.getDouble("prices.generale.iron_sword", 800.0); }
    public double getDiamondAxePrice() { return config.getDouble("prices.generale.diamond_axe", 1400.0); }
    public double getIronAxePrice() { return config.getDouble("prices.generale.iron_axe", 700.0); }
    public double getCrossbowPrice() { return config.getDouble("prices.generale.crossbow", 900.0); }
    public double getTridentPrice() { return config.getDouble("prices.generale.trident", 2500.0); }
    public double getBowPrice() { return config.getDouble("prices.generale.bow", 600.0); }
    public double getCookedBeefPrice() { return config.getDouble("prices.generale.cooked_beef", 150.0); }
    public double getBreadPrice() { return config.getDouble("prices.generale.bread", 80.0); }
    public double getGoldenApplePrice() { return config.getDouble("prices.generale.golden_apple", 1200.0); }
    public double getArrowPrice() { return config.getDouble("prices.generale.arrow", 300.0); }
    public double getSpectralArrowPrice() { return config.getDouble("prices.generale.spectral_arrow", 500.0); }
    public double getFireworkRocketPrice() { return config.getDouble("prices.generale.firework_rocket", 400.0); }
    public double getDiamondPrice() { return config.getDouble("prices.generale.diamond", 2000.0); }
    public double getExperienceBottlePrice() { return config.getDouble("prices.generale.experience_bottle", 600.0); }

    /*
        PREZZI OGGETTI - SEZIONE POZIONI
    */
    public double getStrengthPotionPrice() { return config.getDouble("prices.pozioni.strength", 1400.0); }
    public double getSpeedPotionPrice() { return config.getDouble("prices.pozioni.speed", 1200.0); }
    public double getJumpBoostPotionPrice() { return config.getDouble("prices.pozioni.jump_boost", 1000.0); }
    public double getResistancePotionPrice() { return config.getDouble("prices.pozioni.resistance", 1800.0); }
    public double getInstantHealthPotionPrice() { return config.getDouble("prices.pozioni.instant_health", 1600.0); }
    public double getFireResistancePotionPrice() { return config.getDouble("prices.pozioni.fire_resistance", 1500.0); }
    public double getAbsorptionPotionPrice() { return config.getDouble("prices.pozioni.absorption", 1700.0); }
    public double getWaterBreathingPotionPrice() { return config.getDouble("prices.pozioni.water_breathing", 1300.0); }
    public double getSlowFallingPotionPrice() { return config.getDouble("prices.pozioni.slow_falling", 1100.0); }
    public double getSplashInstantHealthPotionPrice() { return config.getDouble("prices.pozioni.splash_instant_health", 2000.0); }
    public double getSplashStrengthPotionPrice() { return config.getDouble("prices.pozioni.splash_strength", 1800.0); }
    public double getSplashSpeedPotionPrice() { return config.getDouble("prices.pozioni.splash_speed", 1600.0); }
    public double getWeaknessPotionPrice() { return config.getDouble("prices.pozioni.weakness", 800.0); }
    public double getSplashWeaknessPotionPrice() { return config.getDouble("prices.pozioni.splash_weakness", 1200.0); }
    public double getSlownessPotionPrice() { return config.getDouble("prices.pozioni.slowness", 900.0); }
    public double getSplashSlownessPotionPrice() { return config.getDouble("prices.pozioni.splash_slowness", 1300.0); }

    /*
        PREZZI OGGETTI - SEZIONE LIBRI - CORRETTI SECONDO IL CONFIG REALE
    */
    public double getProtectionBookPrice() { return config.getDouble("libri.protection", 1800.0); }
    public double getSharpnessBookPrice() { return config.getDouble("libri.sharpness", 1500.0); }
    public double getUnbreakingBookPrice() { return config.getDouble("libri.unbreaking", 2200.0); }
    public double getPowerBookPrice() { return config.getDouble("libri.power", 1600.0); }
    public double getSweepingEdgeBookPrice() { return config.getDouble("libri.sweeping_edge", 1700.0); }
    public double getAquaAffinityBookPrice() { return config.getDouble("libri.aqua_affinity", 1400.0); }
    public double getRespirationBookPrice() { return config.getDouble("libri.respiration", 1300.0); }
    public double getPunchBookPrice() { return config.getDouble("libri.punch", 1500.0); }
    public double getFlameBookPrice() { return config.getDouble("libri.flame", 1800.0); }

    /*
        PREZZI OGGETTI - SEZIONE ARMATURE - CORRETTI SECONDO IL CONFIG REALE
    */
    // Armature di Ferro
    public double getIronHelmetPrice() { return config.getDouble("armor.iron.iron_helmet", 800.0); }
    public double getIronChestplatePrice() { return config.getDouble("armor.iron.iron_chestplate", 1200.0); }
    public double getIronLeggingsPrice() { return config.getDouble("armor.iron.iron_leggings", 1000.0); }
    public double getIronBootsPrice() { return config.getDouble("armor.iron.iron_boots", 600.0); }
    public double getIronSetPrice() { return config.getDouble("armor.iron.iron_set", 3000.0); }

    // Armature di Diamante
    public double getDiamondHelmetPrice() { return config.getDouble("armor.diamond.diamond_helmet", 2400.0); }
    public double getDiamondChestplatePrice() { return config.getDouble("armor.diamond.diamond_chestplate", 3600.0); }
    public double getDiamondLeggingsPrice() { return config.getDouble("armor.diamond.diamond_leggings", 3000.0); }
    public double getDiamondBootsPrice() { return config.getDouble("armor.diamond.diamond_boots", 1800.0); }
    public double getDiamondSetPrice() { return config.getDouble("armor.diamond.diamond_set", 9000.0); }

    /*
        PREZZI OGGETTI - SEZIONE INGREDIENTI - CORRETTI SECONDO IL CONFIG REALE
    */
    public double getPotionPrice() { return config.getDouble("ingredienti.potion", 200.0); }
    public double getBlazePowderPrice() { return config.getDouble("ingredienti.blaze_powder", 400.0); }
    public double getNetherWartPrice() { return config.getDouble("ingredienti.nether_wart", 500.0); }
    public double getSpiderEyePrice() { return config.getDouble("ingredienti.spider_eye", 350.0); }
    public double getFermentedSpiderEyePrice() { return config.getDouble("ingredienti.fermented_spider_eye", 600.0); }
    public double getSugarPrice() { return config.getDouble("ingredienti.sugar", 250.0); }
    public double getGlisteringMelonSlicePrice() { return config.getDouble("ingredienti.glistering_melon_slice", 800.0); }
    public double getGoldenCarrotPrice() { return config.getDouble("ingredienti.golden_carrot", 700.0); }
    public double getPufferfishPrice() { return config.getDouble("ingredienti.pufferfish", 650.0); }
    public double getMagmaCreamPrice() { return config.getDouble("ingredienti.magma_cream", 900.0); }
    public double getGhastTearPrice() { return config.getDouble("ingredienti.ghast_tear", 1500.0); }
    public double getRedstonePrice() { return config.getDouble("ingredienti.redstone", 300.0); }
    public double getGunpowderPrice() { return config.getDouble("ingredienti.gunpowder", 450.0); }
    public double getGlowstoneDustPrice() { return config.getDouble("ingredienti.glowstone_dust", 550.0); }
    public double getEnderPearlPrice() { return config.getDouble("ingredienti.ender_pearl", 1200.0); }
    public double getNautilusShellPrice() { return config.getDouble("ingredienti.nautilus_shell", 1000.0); }
    public double getPhantomMembranePrice() { return config.getDouble("ingredienti.phantom_membrane", 800.0); }

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

    public String getUsageErrorReload(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.usage-reload"));
    }

    public String getConfigReloadedMessage(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("messages.config-reloaded"));
    }

    /*
        NPC
     */

    public String getNpcName(){
        return ChatColor.translateAlternateColorCodes('&', config.getString("NPC.shop-name"));
    }
}