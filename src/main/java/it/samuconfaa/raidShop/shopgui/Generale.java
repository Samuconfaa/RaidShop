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

        // === OGGETTI IN VENDITA ===

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
        generale.setItem(12, melaDOro);

        // Frecce
        ItemStack frecce = new ItemStack(Material.ARROW, 1);
        ItemMeta metaFrecce = frecce.getItemMeta();
        metaFrecce.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Freccia");
        metaFrecce.setLore(Arrays.asList(
                ChatColor.GRAY + "Freccia affilata per il tuo arco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€300"
        ));
        frecce.setItemMeta(metaFrecce);
        generale.setItem(13, frecce);

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
        generale.setItem(14, arco);

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
        generale.setItem(16, diamante);

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
                        openGenerale(p); // Ricarica l'inventario per aggiornare il saldo
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

                case 12: // Mela d'Oro
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

                case 13: // Frecce
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

                case 14: // Arco
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

                case 16: // Diamante
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

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}