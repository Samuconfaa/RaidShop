package it.samuconfaa.raidShop.shopgui;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.managers.EconomyManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class Generale implements Listener {

    private final RaidShop plugin;
    private final EconomyManager econManager;
    private Shop shop;

    public Generale(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void openGenerale(Player p) {
        Inventory generale = Bukkit.createInventory(p, 54, plugin.getConfigManager().getGeneraleName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 7); // Grigio
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            generale.setItem(slot, border);
        }

        // Decorazioni laterali verdi
        ItemStack greenGlass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 5); // Verde
        ItemMeta greenMeta = greenGlass.getItemMeta();
        greenMeta.setDisplayName(" ");
        greenGlass.setItemMeta(greenMeta);
        generale.setItem(18, greenGlass);
        generale.setItem(26, greenGlass);
        generale.setItem(27, greenGlass);
        generale.setItem(35, greenGlass);

        // === ARMI E STRUMENTI ===

        // Spada di Diamante
        ItemStack spadaDiamante = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaSpadaDiamante = spadaDiamante.getItemMeta();
        metaSpadaDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Spada di Diamante");
        metaSpadaDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Una potente spada di diamante",
                ChatColor.GRAY + "per i veri guerrieri!",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1500"
        ));
        spadaDiamante.setItemMeta(metaSpadaDiamante);
        generale.setItem(10, spadaDiamante);

        // Spada di Ferro
        ItemStack spadaFerro = new ItemStack(Material.IRON_SWORD);
        ItemMeta metaSpadaFerro = spadaFerro.getItemMeta();
        metaSpadaFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Spada di Ferro");
        metaSpadaFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Una solida spada di ferro",
                ChatColor.GRAY + "per combattimenti efficaci",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€800"
        ));
        spadaFerro.setItemMeta(metaSpadaFerro);
        generale.setItem(11, spadaFerro);

        // Ascia di Diamante (NUOVO)
        ItemStack asciaDiamante = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta metaAsciaDiamante = asciaDiamante.getItemMeta();
        metaAsciaDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Ascia di Diamante");
        metaAsciaDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Ascia potente per tagliare",
                ChatColor.GRAY + "legno e combattere",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1400"
        ));
        asciaDiamante.setItemMeta(metaAsciaDiamante);
        generale.setItem(12, asciaDiamante);

        // Ascia di Ferro (NUOVO)
        ItemStack asciaFerro = new ItemStack(Material.IRON_AXE);
        ItemMeta metaAsciaFerro = asciaFerro.getItemMeta();
        metaAsciaFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Ascia di Ferro");
        metaAsciaFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Ascia affidabile per",
                ChatColor.GRAY + "ogni necessità",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€700"
        ));
        asciaFerro.setItemMeta(metaAsciaFerro);
        generale.setItem(13, asciaFerro);

        // Balestra (NUOVO)
        ItemStack balestra = new ItemStack(Material.CROSSBOW);
        ItemMeta metaBalestra = balestra.getItemMeta();
        metaBalestra.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Balestra");
        metaBalestra.setLore(Arrays.asList(
                ChatColor.GRAY + "Arma da lancio potente",
                ChatColor.GRAY + "per attacchi precisi",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€900"
        ));
        balestra.setItemMeta(metaBalestra);
        generale.setItem(14, balestra);

        // Tridente (NUOVO)
        ItemStack tridente = new ItemStack(Material.TRIDENT);
        ItemMeta metaTridente = tridente.getItemMeta();
        metaTridente.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tridente");
        metaTridente.setLore(Arrays.asList(
                ChatColor.GRAY + "Arma leggendaria del mare",
                ChatColor.GRAY + "per veri esploratori",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€2500"
        ));
        tridente.setItemMeta(metaTridente);
        generale.setItem(15, tridente);

        // Arco
        ItemStack arco = new ItemStack(Material.BOW);
        ItemMeta metaArco = arco.getItemMeta();
        metaArco.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Arco");
        metaArco.setLore(Arrays.asList(
                ChatColor.GRAY + "Un arco resistente per",
                ChatColor.GRAY + "attacchi a distanza precisi",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€600"
        ));
        arco.setItemMeta(metaArco);
        generale.setItem(16, arco);

        // === CIBO ===

        // Steak (NUOVO)
        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
        ItemMeta metaSteak = steak.getItemMeta();
        metaSteak.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Bistecca Cotta");
        metaSteak.setLore(Arrays.asList(
                ChatColor.GRAY + "Cibo nutriente che ripristina",
                ChatColor.GRAY + "molta fame e salute",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€150"
        ));
        steak.setItemMeta(metaSteak);
        generale.setItem(19, steak);

        // Pane (NUOVO)
        ItemStack pane = new ItemStack(Material.BREAD);
        ItemMeta metaPane = pane.getItemMeta();
        metaPane.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Pane");
        metaPane.setLore(Arrays.asList(
                ChatColor.GRAY + "Alimento base economico",
                ChatColor.GRAY + "per lunghe avventure",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€80"
        ));
        pane.setItemMeta(metaPane);
        generale.setItem(20, pane);

        // Mela d'Oro
        ItemStack melaDOro = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta metaMela = melaDOro.getItemMeta();
        metaMela.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Mela d'Oro");
        metaMela.setLore(Arrays.asList(
                ChatColor.GRAY + "Una prelibatezza che rigenera",
                ChatColor.GRAY + "la salute istantaneamente",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1200"
        ));
        melaDOro.setItemMeta(metaMela);
        generale.setItem(21, melaDOro);

        // === MUNIZIONI ===

        // Frecce normali
        ItemStack frecce = new ItemStack(Material.ARROW, 1);
        ItemMeta metaFrecce = frecce.getItemMeta();
        metaFrecce.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Freccia");
        metaFrecce.setLore(Arrays.asList(
                ChatColor.GRAY + "Freccia affilata per il tuo arco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€300"
        ));
        frecce.setItemMeta(metaFrecce);
        generale.setItem(28, frecce);

        // Freccia Spectral (NUOVO)
        ItemStack frecciaSpectral = new ItemStack(Material.SPECTRAL_ARROW, 1);
        ItemMeta metaFrecciaSpectral = frecciaSpectral.getItemMeta();
        metaFrecciaSpectral.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Freccia Spectral");
        metaFrecciaSpectral.setLore(Arrays.asList(
                ChatColor.GRAY + "Freccia magica che rivela",
                ChatColor.GRAY + "i nemici colpiti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€500"
        ));
        frecciaSpectral.setItemMeta(metaFrecciaSpectral);
        generale.setItem(29, frecciaSpectral);

        // Firework Rocket (NUOVO)
        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, 1);
        ItemMeta metaFirework = firework.getItemMeta();
        metaFirework.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Razzo Pirotecnico");
        metaFirework.setLore(Arrays.asList(
                ChatColor.GRAY + "Munizione esplosiva per",
                ChatColor.GRAY + "balestre e volo con elytra",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€400"
        ));
        firework.setItemMeta(metaFirework);
        generale.setItem(30, firework);

        // === OGGETTI PREZIOSI ===

        // Diamante
        ItemStack diamante = new ItemStack(Material.DIAMOND);
        ItemMeta metaDiamante = diamante.getItemMeta();
        metaDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamante");
        metaDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Un prezioso diamante",
                ChatColor.GRAY + "perfetto per il crafting",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€2000"
        ));
        diamante.setItemMeta(metaDiamante);
        generale.setItem(25, diamante);

        // Bottiglia di Esperienza (NUOVO)
        ItemStack bottigliaExp = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta metaBottigliaExp = bottigliaExp.getItemMeta();
        metaBottigliaExp.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Bottiglia di Esperienza");
        metaBottigliaExp.setLore(Arrays.asList(
                ChatColor.GRAY + "Contiene esperienza pura",
                ChatColor.GRAY + "per aumentare i tuoi livelli",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€600"
        ));
        bottigliaExp.setItemMeta(metaBottigliaExp);
        generale.setItem(34, bottigliaExp);

        // Bottone per tornare indietro
        ItemStack tornIndietro = new ItemStack(Material.ARROW);
        ItemMeta metaTorna = tornIndietro.getItemMeta();
        metaTorna.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "← Torna al Menu Principale");
        metaTorna.setLore(Collections.singletonList(ChatColor.GRAY + "Clicca per tornare al negozio principale"));
        tornIndietro.setItemMeta(metaTorna);
        generale.setItem(49, tornIndietro);

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaWallet = wallet.getItemMeta();
        metaWallet.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        metaWallet.setLore(Arrays.asList(
                ChatColor.GRAY + "Saldo attuale:",
                ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(p))
        ));
        wallet.setItemMeta(metaWallet);
        generale.setItem(4, wallet);

        p.openInventory(generale);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getGeneraleName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                case 10: // Spada di Diamante
                    if (econManager.checkMoney(p) >= 1500) {
                        ItemStack spadaDiamante = new ItemStack(Material.DIAMOND_SWORD);
                        p.getInventory().addItem(spadaDiamante);
                        econManager.removeMoney(p, 1500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Spada di Diamante per €1500!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1500");
                    }
                    break;

                case 11: // Spada di Ferro
                    if (econManager.checkMoney(p) >= 800) {
                        ItemStack spadaFerro = new ItemStack(Material.IRON_SWORD);
                        p.getInventory().addItem(spadaFerro);
                        econManager.removeMoney(p, 800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Spada di Ferro per €800!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €800");
                    }
                    break;

                case 12: // Ascia di Diamante (NUOVO)
                    if (econManager.checkMoney(p) >= 1400) {
                        ItemStack asciaDiamante = new ItemStack(Material.DIAMOND_AXE);
                        p.getInventory().addItem(asciaDiamante);
                        econManager.removeMoney(p, 1400);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un'Ascia di Diamante per €1400!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1400");
                    }
                    break;

                case 13: // Ascia di Ferro (NUOVO)
                    if (econManager.checkMoney(p) >= 700) {
                        ItemStack asciaFerro = new ItemStack(Material.IRON_AXE);
                        p.getInventory().addItem(asciaFerro);
                        econManager.removeMoney(p, 700);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un'Ascia di Ferro per €700!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €700");
                    }
                    break;

                case 14: // Balestra (NUOVO)
                    if (econManager.checkMoney(p) >= 900) {
                        ItemStack balestra = new ItemStack(Material.CROSSBOW);
                        p.getInventory().addItem(balestra);
                        econManager.removeMoney(p, 900);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Balestra per €900!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €900");
                    }
                    break;

                case 15: // Tridente (NUOVO)
                    if (econManager.checkMoney(p) >= 2500) {
                        ItemStack tridente = new ItemStack(Material.TRIDENT);
                        p.getInventory().addItem(tridente);
                        econManager.removeMoney(p, 2500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Tridente per €2500!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €2500");
                    }
                    break;

                case 16: // Arco
                    if (econManager.checkMoney(p) >= 600) {
                        ItemStack arco = new ItemStack(Material.BOW);
                        p.getInventory().addItem(arco);
                        econManager.removeMoney(p, 600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Arco per €600!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €600");
                    }
                    break;

                case 19: // Steak (NUOVO)
                    if (econManager.checkMoney(p) >= 150) {
                        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
                        p.getInventory().addItem(steak);
                        econManager.removeMoney(p, 150);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Bistecca Cotta per €150!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €150");
                    }
                    break;

                case 20: // Pane (NUOVO)
                    if (econManager.checkMoney(p) >= 80) {
                        ItemStack pane = new ItemStack(Material.BREAD);
                        p.getInventory().addItem(pane);
                        econManager.removeMoney(p, 80);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato del Pane per €80!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €80");
                    }
                    break;

                case 21: // Mela d'Oro
                    if (econManager.checkMoney(p) >= 1200) {
                        ItemStack melaDOro = new ItemStack(Material.GOLDEN_APPLE);
                        p.getInventory().addItem(melaDOro);
                        econManager.removeMoney(p, 1200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Mela d'Oro per €1200!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1200");
                    }
                    break;

                case 28: // Frecce
                    if (econManager.checkMoney(p) >= 300) {
                        ItemStack frecce = new ItemStack(Material.ARROW, 1);
                        p.getInventory().addItem(frecce);
                        econManager.removeMoney(p, 300);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una freccia per €300!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €300");
                    }
                    break;

                case 29: // Freccia Spectral (NUOVO)
                    if (econManager.checkMoney(p) >= 500) {
                        ItemStack frecciaSpectral = new ItemStack(Material.SPECTRAL_ARROW, 1);
                        p.getInventory().addItem(frecciaSpectral);
                        econManager.removeMoney(p, 500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Freccia Spectral per €500!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €500");
                    }
                    break;

                case 30: // Firework Rocket (NUOVO)
                    if (econManager.checkMoney(p) >= 400) {
                        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, 1);
                        p.getInventory().addItem(firework);
                        econManager.removeMoney(p, 400);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Razzo Pirotecnico per €400!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €400");
                    }
                    break;

                case 25: // Diamante
                    if (econManager.checkMoney(p) >= 2000) {
                        ItemStack diamante = new ItemStack(Material.DIAMOND);
                        p.getInventory().addItem(diamante);
                        econManager.removeMoney(p, 2000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Diamante per €2000!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €2000");
                    }
                    break;

                case 34: // Bottiglia di Esperienza (NUOVO)
                    if (econManager.checkMoney(p) >= 600) {
                        ItemStack bottigliaExp = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                        p.getInventory().addItem(bottigliaExp);
                        econManager.removeMoney(p, 600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Bottiglia di Esperienza per €600!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €600");
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}