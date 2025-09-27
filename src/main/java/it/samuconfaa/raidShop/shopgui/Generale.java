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
        ItemStack border = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            generale.setItem(slot, border);
        }

        // Decorazioni laterali verdi
        ItemStack greenGlass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, (short) 5);
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getDiamondSwordPrice())
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getIronSwordPrice())
        ));
        spadaFerro.setItemMeta(metaSpadaFerro);
        generale.setItem(11, spadaFerro);

        // Ascia di Diamante
        ItemStack asciaDiamante = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta metaAsciaDiamante = asciaDiamante.getItemMeta();
        metaAsciaDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Ascia di Diamante");
        metaAsciaDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Ascia potente per tagliare",
                ChatColor.GRAY + "legno e combattere",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getDiamondAxePrice())
        ));
        asciaDiamante.setItemMeta(metaAsciaDiamante);
        generale.setItem(12, asciaDiamante);

        // Ascia di Ferro
        ItemStack asciaFerro = new ItemStack(Material.IRON_AXE);
        ItemMeta metaAsciaFerro = asciaFerro.getItemMeta();
        metaAsciaFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Ascia di Ferro");
        metaAsciaFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Ascia affidabile per",
                ChatColor.GRAY + "ogni necessità",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getIronAxePrice())
        ));
        asciaFerro.setItemMeta(metaAsciaFerro);
        generale.setItem(13, asciaFerro);

        // Balestra
        ItemStack balestra = new ItemStack(Material.CROSSBOW);
        ItemMeta metaBalestra = balestra.getItemMeta();
        metaBalestra.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Balestra");
        metaBalestra.setLore(Arrays.asList(
                ChatColor.GRAY + "Arma da lancio potente",
                ChatColor.GRAY + "per attacchi precisi",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getCrossbowPrice())
        ));
        balestra.setItemMeta(metaBalestra);
        generale.setItem(14, balestra);

        // Tridente
        ItemStack tridente = new ItemStack(Material.TRIDENT);
        ItemMeta metaTridente = tridente.getItemMeta();
        metaTridente.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Tridente");
        metaTridente.setLore(Arrays.asList(
                ChatColor.GRAY + "Arma leggendaria del mare",
                ChatColor.GRAY + "per veri esploratori",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getTridentPrice())
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getBowPrice())
        ));
        arco.setItemMeta(metaArco);
        generale.setItem(16, arco);

        // === CIBO ===

        // Steak
        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
        ItemMeta metaSteak = steak.getItemMeta();
        metaSteak.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Bistecca Cotta");
        metaSteak.setLore(Arrays.asList(
                ChatColor.GRAY + "Cibo nutriente che ripristina",
                ChatColor.GRAY + "molta fame e salute",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getCookedBeefPrice())
        ));
        steak.setItemMeta(metaSteak);
        generale.setItem(19, steak);

        // Pane
        ItemStack pane = new ItemStack(Material.BREAD);
        ItemMeta metaPane = pane.getItemMeta();
        metaPane.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Pane");
        metaPane.setLore(Arrays.asList(
                ChatColor.GRAY + "Alimento base economico",
                ChatColor.GRAY + "per lunghe avventure",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getBreadPrice())
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getGoldenApplePrice())
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getArrowPrice())
        ));
        frecce.setItemMeta(metaFrecce);
        generale.setItem(28, frecce);

        // Freccia Spectral
        ItemStack frecciaSpectral = new ItemStack(Material.SPECTRAL_ARROW, 1);
        ItemMeta metaFrecciaSpectral = frecciaSpectral.getItemMeta();
        metaFrecciaSpectral.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Freccia Spectral");
        metaFrecciaSpectral.setLore(Arrays.asList(
                ChatColor.GRAY + "Freccia magica che rivela",
                ChatColor.GRAY + "i nemici colpiti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getSpectralArrowPrice())
        ));
        frecciaSpectral.setItemMeta(metaFrecciaSpectral);
        generale.setItem(29, frecciaSpectral);

        // Firework Rocket
        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, 1);
        ItemMeta metaFirework = firework.getItemMeta();
        metaFirework.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Razzo Pirotecnico");
        metaFirework.setLore(Arrays.asList(
                ChatColor.GRAY + "Munizione esplosiva per",
                ChatColor.GRAY + "balestre e volo con elytra",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getFireworkRocketPrice())
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getDiamondPrice())
        ));
        diamante.setItemMeta(metaDiamante);
        generale.setItem(25, diamante);

        // Bottiglia di Esperienza
        ItemStack bottigliaExp = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
        ItemMeta metaBottigliaExp = bottigliaExp.getItemMeta();
        metaBottigliaExp.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Bottiglia di Esperienza");
        metaBottigliaExp.setLore(Arrays.asList(
                ChatColor.GRAY + "Contiene esperienza pura",
                ChatColor.GRAY + "per aumentare i tuoi livelli",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getExperienceBottlePrice())
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
                    double spadaDiamantePrice = plugin.getConfigManager().getDiamondSwordPrice();
                    if (econManager.checkMoney(p) >= spadaDiamantePrice) {
                        ItemStack spadaDiamante = new ItemStack(Material.DIAMOND_SWORD);
                        p.getInventory().addItem(spadaDiamante);
                        econManager.removeMoney(p, spadaDiamantePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Spada di Diamante per €" + String.format("%.0f", spadaDiamantePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", spadaDiamantePrice));
                    }
                    break;

                case 11: // Spada di Ferro
                    double spadaFerroPrice = plugin.getConfigManager().getIronSwordPrice();
                    if (econManager.checkMoney(p) >= spadaFerroPrice) {
                        ItemStack spadaFerro = new ItemStack(Material.IRON_SWORD);
                        p.getInventory().addItem(spadaFerro);
                        econManager.removeMoney(p, spadaFerroPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Spada di Ferro per €" + String.format("%.0f", spadaFerroPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", spadaFerroPrice));
                    }
                    break;

                case 12: // Ascia di Diamante
                    double asciaDiamantePrice = plugin.getConfigManager().getDiamondAxePrice();
                    if (econManager.checkMoney(p) >= asciaDiamantePrice) {
                        ItemStack asciaDiamante = new ItemStack(Material.DIAMOND_AXE);
                        p.getInventory().addItem(asciaDiamante);
                        econManager.removeMoney(p, asciaDiamantePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un'Ascia di Diamante per €" + String.format("%.0f", asciaDiamantePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", asciaDiamantePrice));
                    }
                    break;

                case 13: // Ascia di Ferro
                    double asciaFerroPrice = plugin.getConfigManager().getIronAxePrice();
                    if (econManager.checkMoney(p) >= asciaFerroPrice) {
                        ItemStack asciaFerro = new ItemStack(Material.IRON_AXE);
                        p.getInventory().addItem(asciaFerro);
                        econManager.removeMoney(p, asciaFerroPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un'Ascia di Ferro per €" + String.format("%.0f", asciaFerroPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", asciaFerroPrice));
                    }
                    break;

                case 14: // Balestra
                    double balestraPrice = plugin.getConfigManager().getCrossbowPrice();
                    if (econManager.checkMoney(p) >= balestraPrice) {
                        ItemStack balestra = new ItemStack(Material.CROSSBOW);
                        p.getInventory().addItem(balestra);
                        econManager.removeMoney(p, balestraPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Balestra per €" + String.format("%.0f", balestraPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", balestraPrice));
                    }
                    break;

                case 15: // Tridente
                    double tridentePrice = plugin.getConfigManager().getTridentPrice();
                    if (econManager.checkMoney(p) >= tridentePrice) {
                        ItemStack tridente = new ItemStack(Material.TRIDENT);
                        p.getInventory().addItem(tridente);
                        econManager.removeMoney(p, tridentePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Tridente per €" + String.format("%.0f", tridentePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", tridentePrice));
                    }
                    break;

                case 16: // Arco
                    double arcoPrice = plugin.getConfigManager().getBowPrice();
                    if (econManager.checkMoney(p) >= arcoPrice) {
                        ItemStack arco = new ItemStack(Material.BOW);
                        p.getInventory().addItem(arco);
                        econManager.removeMoney(p, arcoPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Arco per €" + String.format("%.0f", arcoPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", arcoPrice));
                    }
                    break;

                case 19: // Steak
                    double steakPrice = plugin.getConfigManager().getCookedBeefPrice();
                    if (econManager.checkMoney(p) >= steakPrice) {
                        ItemStack steak = new ItemStack(Material.COOKED_BEEF);
                        p.getInventory().addItem(steak);
                        econManager.removeMoney(p, steakPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Bistecca Cotta per €" + String.format("%.0f", steakPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", steakPrice));
                    }
                    break;

                case 20: // Pane
                    double panePrice = plugin.getConfigManager().getBreadPrice();
                    if (econManager.checkMoney(p) >= panePrice) {
                        ItemStack pane = new ItemStack(Material.BREAD);
                        p.getInventory().addItem(pane);
                        econManager.removeMoney(p, panePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato del Pane per €" + String.format("%.0f", panePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", panePrice));
                    }
                    break;

                case 21: // Mela d'Oro
                    double melaDOroPrice = plugin.getConfigManager().getGoldenApplePrice();
                    if (econManager.checkMoney(p) >= melaDOroPrice) {
                        ItemStack melaDOro = new ItemStack(Material.GOLDEN_APPLE);
                        p.getInventory().addItem(melaDOro);
                        econManager.removeMoney(p, melaDOroPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Mela d'Oro per €" + String.format("%.0f", melaDOroPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", melaDOroPrice));
                    }
                    break;

                case 28: // Frecce
                    double freccePrice = plugin.getConfigManager().getArrowPrice();
                    if (econManager.checkMoney(p) >= freccePrice) {
                        ItemStack frecce = new ItemStack(Material.ARROW, 1);
                        p.getInventory().addItem(frecce);
                        econManager.removeMoney(p, freccePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una freccia per €" + String.format("%.0f", freccePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", freccePrice));
                    }
                    break;

                case 29: // Freccia Spectral
                    double frecciaSpectralPrice = plugin.getConfigManager().getSpectralArrowPrice();
                    if (econManager.checkMoney(p) >= frecciaSpectralPrice) {
                        ItemStack frecciaSpectral = new ItemStack(Material.SPECTRAL_ARROW, 1);
                        p.getInventory().addItem(frecciaSpectral);
                        econManager.removeMoney(p, frecciaSpectralPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Freccia Spectral per €" + String.format("%.0f", frecciaSpectralPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", frecciaSpectralPrice));
                    }
                    break;

                case 30: // Firework Rocket
                    double fireworkPrice = plugin.getConfigManager().getFireworkRocketPrice();
                    if (econManager.checkMoney(p) >= fireworkPrice) {
                        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET, 1);
                        p.getInventory().addItem(firework);
                        econManager.removeMoney(p, fireworkPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Razzo Pirotecnico per €" + String.format("%.0f", fireworkPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", fireworkPrice));
                    }
                    break;

                case 25: // Diamante
                    double diamantePrice = plugin.getConfigManager().getDiamondPrice();
                    if (econManager.checkMoney(p) >= diamantePrice) {
                        ItemStack diamante = new ItemStack(Material.DIAMOND);
                        p.getInventory().addItem(diamante);
                        econManager.removeMoney(p, diamantePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Diamante per €" + String.format("%.0f", diamantePrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", diamantePrice));
                    }
                    break;

                case 34: // Bottiglia di Esperienza
                    double bottigliaExpPrice = plugin.getConfigManager().getExperienceBottlePrice();
                    if (econManager.checkMoney(p) >= bottigliaExpPrice) {
                        ItemStack bottigliaExp = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                        p.getInventory().addItem(bottigliaExp);
                        econManager.removeMoney(p, bottigliaExpPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Bottiglia di Esperienza per €" + String.format("%.0f", bottigliaExpPrice) + "!");
                        openGenerale(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", bottigliaExpPrice));
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}