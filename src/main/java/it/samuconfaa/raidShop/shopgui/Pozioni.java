package it.samuconfaa.raidShop.shopgui;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.managers.EconomyManager;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collections;

public class Pozioni implements Listener {
    private final RaidShop plugin;
    private final EconomyManager econManager;
    private Shop shop;

    public Pozioni(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void openPozioni(Player p) {
        Inventory pozioni = Bukkit.createInventory(p, 54, plugin.getConfigManager().getPozioniName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            pozioni.setItem(slot, border);
        }

        // Decorazioni laterali magenta
        ItemStack magentaGlass = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1);
        ItemMeta magentaMeta = magentaGlass.getItemMeta();
        magentaMeta.setDisplayName(" ");
        magentaGlass.setItemMeta(magentaMeta);
        pozioni.setItem(18, magentaGlass);
        pozioni.setItem(26, magentaGlass);
        pozioni.setItem(27, magentaGlass);
        pozioni.setItem(35, magentaGlass);

        // === POZIONI ORIGINALI ===

        // Pozione di Forza
        ItemStack pozioneForza = creaPozione(Material.POTION, PotionEffectType.STRENGTH, 3600, 0,
                ChatColor.RED + "" + ChatColor.BOLD + "Pozione di Forza",
                Arrays.asList(
                        ChatColor.GRAY + "Aumenta il danno inflitto",
                        ChatColor.GRAY + "nei combattimenti",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1400"
                )
        );
        pozioni.setItem(10, pozioneForza);

        // Pozione di Velocità
        ItemStack pozioneVelocita = creaPozione(Material.POTION, PotionEffectType.SPEED, 3600, 0,
                ChatColor.BLUE + "" + ChatColor.BOLD + "Pozione di Velocità",
                Arrays.asList(
                        ChatColor.GRAY + "Aumenta la velocità di",
                        ChatColor.GRAY + "movimento del giocatore",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1200"
                )
        );
        pozioni.setItem(11, pozioneVelocita);

        // Pozione di Salto in Alto
        ItemStack pozioneSalto = creaPozione(Material.POTION, PotionEffectType.JUMP_BOOST, 3600, 0,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Pozione di Salto in Alto",
                Arrays.asList(
                        ChatColor.GRAY + "Permette di saltare",
                        ChatColor.GRAY + "molto più in alto",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1000"
                )
        );
        pozioni.setItem(12, pozioneSalto);

        // Pozione di Resistenza
        ItemStack pozioneResistenza = creaPozione(Material.POTION, PotionEffectType.RESISTANCE, 3600, 0,
                ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Pozione di Resistenza",
                Arrays.asList(
                        ChatColor.GRAY + "Riduce tutti i danni",
                        ChatColor.GRAY + "subiti dal giocatore",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1800"
                )
        );
        pozioni.setItem(13, pozioneResistenza);

        // Pozione di Cura Istantanea
        ItemStack pozioneCura = creaPozione(Material.POTION, PotionEffectType.INSTANT_HEALTH, 1, 0,
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pozione di Cura Istantanea",
                Arrays.asList(
                        ChatColor.GRAY + "Ripristina istantaneamente",
                        ChatColor.GRAY + "una parte della salute",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1600"
                )
        );
        pozioni.setItem(14, pozioneCura);

        // === POZIONI DIFENSIVE (NUOVE) ===

        // Pozione di Resistenza al Fuoco
        ItemStack pozioneResistenzaFuoco = creaPozione(Material.POTION, PotionEffectType.FIRE_RESISTANCE, 3600, 0,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Pozione di Resistenza al Fuoco",
                Arrays.asList(
                        ChatColor.GRAY + "Immunità completa",
                        ChatColor.GRAY + "al fuoco e alla lava",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1500"
                )
        );
        pozioni.setItem(15, pozioneResistenzaFuoco);

        // Pozione di Assorbimento
        ItemStack pozioneAssorbimento = creaPozione(Material.POTION, PotionEffectType.ABSORPTION, 2400, 0,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Pozione di Assorbimento",
                Arrays.asList(
                        ChatColor.GRAY + "Aggiunge cuori temporanei",
                        ChatColor.GRAY + "per maggiore sopravvivenza",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1700"
                )
        );
        pozioni.setItem(16, pozioneAssorbimento);

        // Pozione di Respirazione Acquatica
        ItemStack pozioneRespirazioneAcqua = creaPozione(Material.POTION, PotionEffectType.WATER_BREATHING, 3600, 0,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pozione di Respirazione Acquatica",
                Arrays.asList(
                        ChatColor.GRAY + "Permette di respirare",
                        ChatColor.GRAY + "sott'acqua senza problemi",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1300"
                )
        );
        pozioni.setItem(19, pozioneRespirazioneAcqua);

        // Pozione di Caduta Lenta (NUOVA)
        ItemStack pozioneCadutaLenta = creaPozione(Material.POTION, PotionEffectType.SLOW_FALLING, 1800, 0,
                ChatColor.WHITE + "" + ChatColor.BOLD + "Pozione di Caduta Lenta",
                Arrays.asList(
                        ChatColor.GRAY + "Riduce la velocità di caduta",
                        ChatColor.GRAY + "e previene danni da caduta",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1100"
                )
        );
        pozioni.setItem(20, pozioneCadutaLenta);

        // === POZIONI SPLASH (NUOVE) ===

        // Pozione Splash di Cura Istantanea
        ItemStack splashCura = creaPozione(Material.SPLASH_POTION, PotionEffectType.INSTANT_HEALTH, 1, 0,
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pozione Splash di Cura",
                Arrays.asList(
                        ChatColor.GRAY + "Cura istantanea ad area",
                        ChatColor.GRAY + "per te e i tuoi alleati",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€2000"
                )
        );
        pozioni.setItem(21, splashCura);

        // Pozione Splash di Forza
        ItemStack splashForza = creaPozione(Material.SPLASH_POTION, PotionEffectType.STRENGTH, 2700, 0,
                ChatColor.RED + "" + ChatColor.BOLD + "Pozione Splash di Forza",
                Arrays.asList(
                        ChatColor.GRAY + "Fornisce forza ad area",
                        ChatColor.GRAY + "per combattimenti di gruppo",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1800"
                )
        );
        pozioni.setItem(22, splashForza);

        // Pozione Splash di Velocità
        ItemStack splashVelocita = creaPozione(Material.SPLASH_POTION, PotionEffectType.SPEED, 2700, 0,
                ChatColor.BLUE + "" + ChatColor.BOLD + "Pozione Splash di Velocità",
                Arrays.asList(
                        ChatColor.GRAY + "Aumenta la velocità",
                        ChatColor.GRAY + "di tutto il gruppo",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1600"
                )
        );
        pozioni.setItem(23, splashVelocita);

        // === POZIONI NEGATIVE (NUOVE) ===

        // Pozione di Debolezza
        ItemStack pozioneDebolezza = creaPozione(Material.POTION, PotionEffectType.WEAKNESS, 1800, 0,
                ChatColor.GRAY + "" + ChatColor.BOLD + "Pozione di Debolezza",
                Arrays.asList(
                        ChatColor.GRAY + "Riduce il danno inflitto",
                        ChatColor.GRAY + "dai nemici colpiti",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€800"
                )
        );
        pozioni.setItem(28, pozioneDebolezza);

        // Pozione Splash di Debolezza
        ItemStack splashDebolezza = creaPozione(Material.SPLASH_POTION, PotionEffectType.WEAKNESS, 1350, 0,
                ChatColor.GRAY + "" + ChatColor.BOLD + "Pozione Splash di Debolezza",
                Arrays.asList(
                        ChatColor.GRAY + "Indebolisce i nemici",
                        ChatColor.GRAY + "in un'area",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1200"
                )
        );
        pozioni.setItem(29, splashDebolezza);

        // Pozione di Lentezza
        ItemStack pozioneLentezza = creaPozione(Material.POTION, PotionEffectType.SLOWNESS, 1800, 0,
                ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Pozione di Lentezza",
                Arrays.asList(
                        ChatColor.GRAY + "Rallenta drasticamente",
                        ChatColor.GRAY + "i movimenti del bersaglio",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€900"
                )
        );
        pozioni.setItem(30, pozioneLentezza);

        // Pozione Splash di Lentezza
        ItemStack splashLentezza = creaPozione(Material.SPLASH_POTION, PotionEffectType.SLOWNESS, 1350, 0,
                ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Pozione Splash di Lentezza",
                Arrays.asList(
                        ChatColor.GRAY + "Rallenta i nemici",
                        ChatColor.GRAY + "in un'area",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1300"
                )
        );
        pozioni.setItem(31, splashLentezza);

        // Bottone per tornare indietro
        ItemStack tornIndietro = new ItemStack(Material.ARROW);
        ItemMeta metaTorna = tornIndietro.getItemMeta();
        metaTorna.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "← Torna al Menu Principale");
        metaTorna.setLore(Collections.singletonList(ChatColor.GRAY + "Clicca per tornare al negozio principale"));
        tornIndietro.setItemMeta(metaTorna);
        pozioni.setItem(49, tornIndietro);

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaWallet = wallet.getItemMeta();
        metaWallet.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        metaWallet.setLore(Arrays.asList(
                ChatColor.GRAY + "Saldo attuale:",
                ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(p))
        ));
        wallet.setItemMeta(metaWallet);
        pozioni.setItem(4, wallet);

        p.openInventory(pozioni);
    }

    private ItemStack creaPozione(Material tipo, PotionEffectType effectType, int duration, int amplifier, String displayName, java.util.List<String> lore) {
        ItemStack pozione = new ItemStack(tipo);
        PotionMeta meta = (PotionMeta) pozione.getItemMeta();
        meta.addCustomEffect(new PotionEffect(effectType, duration, amplifier), true);
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        pozione.setItemMeta(meta);
        return pozione;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getPozioniName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                case 10: // Pozione di Forza
                    if (econManager.checkMoney(p) >= 1400) {
                        ItemStack pozioneForza = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneForza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.STRENGTH, 3600, 0), true);
                        pozioneForza.setItemMeta(meta);
                        p.getInventory().addItem(pozioneForza);
                        econManager.removeMoney(p, 1400);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Forza per €1400!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1400");
                    }
                    break;

                case 11: // Pozione di Velocità
                    if (econManager.checkMoney(p) >= 1200) {
                        ItemStack pozioneVelocita = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneVelocita.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 3600, 0), true);
                        pozioneVelocita.setItemMeta(meta);
                        p.getInventory().addItem(pozioneVelocita);
                        econManager.removeMoney(p, 1200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Velocità per €1200!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1200");
                    }
                    break;

                case 12: // Pozione di Salto in Alto
                    if (econManager.checkMoney(p) >= 1000) {
                        ItemStack pozioneSalto = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneSalto.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 3600, 0), true);
                        pozioneSalto.setItemMeta(meta);
                        p.getInventory().addItem(pozioneSalto);
                        econManager.removeMoney(p, 1000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Salto in Alto per €1000!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1000");
                    }
                    break;

                case 13: // Pozione di Resistenza
                    if (econManager.checkMoney(p) >= 1800) {
                        ItemStack pozioneResistenza = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneResistenza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.RESISTANCE, 3600, 0), true);
                        pozioneResistenza.setItemMeta(meta);
                        p.getInventory().addItem(pozioneResistenza);
                        econManager.removeMoney(p, 1800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Resistenza per €1800!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1800");
                    }
                    break;

                case 14: // Pozione di Cura Istantanea
                    if (econManager.checkMoney(p) >= 1600) {
                        ItemStack pozioneCura = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneCura.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 0), true);
                        pozioneCura.setItemMeta(meta);
                        p.getInventory().addItem(pozioneCura);
                        econManager.removeMoney(p, 1600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Cura Istantanea per €1600!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1600");
                    }
                    break;

                case 15: // Pozione di Resistenza al Fuoco (NUOVA)
                    if (econManager.checkMoney(p) >= 1500) {
                        ItemStack pozioneResistenzaFuoco = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneResistenzaFuoco.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 0), true);
                        pozioneResistenzaFuoco.setItemMeta(meta);
                        p.getInventory().addItem(pozioneResistenzaFuoco);
                        econManager.removeMoney(p, 1500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Resistenza al Fuoco per €1500!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1500");
                    }
                    break;

                case 16: // Pozione di Assorbimento (NUOVA)
                    if (econManager.checkMoney(p) >= 1700) {
                        ItemStack pozioneAssorbimento = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneAssorbimento.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 0), true);
                        pozioneAssorbimento.setItemMeta(meta);
                        p.getInventory().addItem(pozioneAssorbimento);
                        econManager.removeMoney(p, 1700);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Assorbimento per €1700!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1700");
                    }
                    break;

                case 19: // Pozione di Respirazione Acquatica (NUOVA)
                    if (econManager.checkMoney(p) >= 1300) {
                        ItemStack pozioneRespirazioneAcqua = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneRespirazioneAcqua.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 3600, 0), true);
                        pozioneRespirazioneAcqua.setItemMeta(meta);
                        p.getInventory().addItem(pozioneRespirazioneAcqua);
                        econManager.removeMoney(p, 1300);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Respirazione Acquatica per €1300!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1300");
                    }
                    break;

                case 20: // Pozione di Caduta Lenta (NUOVA)
                    if (econManager.checkMoney(p) >= 1100) {
                        ItemStack pozioneCadutaLenta = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneCadutaLenta.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1800, 0), true);
                        pozioneCadutaLenta.setItemMeta(meta);
                        p.getInventory().addItem(pozioneCadutaLenta);
                        econManager.removeMoney(p, 1100);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Caduta Lenta per €1100!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1100");
                    }
                    break;

                case 21: // Pozione Splash di Cura (NUOVA)
                    if (econManager.checkMoney(p) >= 2000) {
                        ItemStack splashCura = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta meta = (PotionMeta) splashCura.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH, 1, 0), true);
                        splashCura.setItemMeta(meta);
                        p.getInventory().addItem(splashCura);
                        econManager.removeMoney(p, 2000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione Splash di Cura per €2000!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €2000");
                    }
                    break;

                case 22: // Pozione Splash di Forza (NUOVA)
                    if (econManager.checkMoney(p) >= 1800) {
                        ItemStack splashForza = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta meta = (PotionMeta) splashForza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.STRENGTH, 2700, 0), true);
                        splashForza.setItemMeta(meta);
                        p.getInventory().addItem(splashForza);
                        econManager.removeMoney(p, 1800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione Splash di Forza per €1800!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1800");
                    }
                    break;

                case 23: // Pozione Splash di Velocità (NUOVA)
                    if (econManager.checkMoney(p) >= 1600) {
                        ItemStack splashVelocita = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta meta = (PotionMeta) splashVelocita.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 2700, 0), true);
                        splashVelocita.setItemMeta(meta);
                        p.getInventory().addItem(splashVelocita);
                        econManager.removeMoney(p, 1600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione Splash di Velocità per €1600!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1600");
                    }
                    break;

                case 28: // Pozione di Debolezza (NUOVA)
                    if (econManager.checkMoney(p) >= 800) {
                        ItemStack pozioneDebolezza = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneDebolezza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1800, 0), true);
                        pozioneDebolezza.setItemMeta(meta);
                        p.getInventory().addItem(pozioneDebolezza);
                        econManager.removeMoney(p, 800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Debolezza per €800!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €800");
                    }
                    break;

                case 29: // Pozione Splash di Debolezza (NUOVA)
                    if (econManager.checkMoney(p) >= 1200) {
                        ItemStack splashDebolezza = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta meta = (PotionMeta) splashDebolezza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1350, 0), true);
                        splashDebolezza.setItemMeta(meta);
                        p.getInventory().addItem(splashDebolezza);
                        econManager.removeMoney(p, 1200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione Splash di Debolezza per €1200!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1200");
                    }
                    break;

                case 30: // Pozione di Lentezza (NUOVA)
                    if (econManager.checkMoney(p) >= 900) {
                        ItemStack pozioneLentezza = new ItemStack(Material.POTION);
                        PotionMeta meta = (PotionMeta) pozioneLentezza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1800, 0), true);
                        pozioneLentezza.setItemMeta(meta);
                        p.getInventory().addItem(pozioneLentezza);
                        econManager.removeMoney(p, 900);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Lentezza per €900!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €900");
                    }
                    break;

                case 31: // Pozione Splash di Lentezza (NUOVA)
                    if (econManager.checkMoney(p) >= 1300) {
                        ItemStack splashLentezza = new ItemStack(Material.SPLASH_POTION);
                        PotionMeta meta = (PotionMeta) splashLentezza.getItemMeta();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1350, 0), true);
                        splashLentezza.setItemMeta(meta);
                        p.getInventory().addItem(splashLentezza);
                        econManager.removeMoney(p, 1300);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione Splash di Lentezza per €1300!");
                        openPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1300");
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}