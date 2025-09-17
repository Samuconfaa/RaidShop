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

import java.util.Arrays;
import java.util.Collections;

public class Armor implements Listener {
    private final RaidShop plugin;
    private final EconomyManager econManager;
    private Shop shop;

    public Armor(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void openArmor(Player p) {
        Inventory armor = Bukkit.createInventory(p, 54, plugin.getConfigManager().getArmorName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1, (short) 8); // Grigio scuro
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            armor.setItem(slot, border);
        }

        // Decorazioni laterali arancioni
        ItemStack orangeGlass = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1, (short) 1); // Arancione
        ItemMeta orangeMeta = orangeGlass.getItemMeta();
        orangeMeta.setDisplayName(" ");
        orangeGlass.setItemMeta(orangeMeta);
        armor.setItem(18, orangeGlass);
        armor.setItem(26, orangeGlass);
        armor.setItem(27, orangeGlass);
        armor.setItem(35, orangeGlass);

        // === ARMOR SET FERRO - SINISTRA ===

        // Titolo Set Ferro
        ItemStack titleFerro = new ItemStack(Material.IRON_INGOT);
        ItemMeta metaTitleFerro = titleFerro.getItemMeta();
        metaTitleFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "SET ARMATURA DI FERRO");
        metaTitleFerro.setLore(Collections.singletonList(ChatColor.GRAY + "Protezione solida e affidabile"));
        titleFerro.setItemMeta(metaTitleFerro);
        armor.setItem(2, titleFerro);

        // Elmo di Ferro
        ItemStack elmoFerro = new ItemStack(Material.IRON_HELMET);
        ItemMeta metaElmoFerro = elmoFerro.getItemMeta();
        metaElmoFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Elmo di Ferro");
        metaElmoFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Protegge la testa dai",
                ChatColor.GRAY + "colpi nemici",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€800"
        ));
        elmoFerro.setItemMeta(metaElmoFerro);
        armor.setItem(10, elmoFerro);

        // Corazza di Ferro
        ItemStack corazzaFerro = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta metaCorazzaFerro = corazzaFerro.getItemMeta();
        metaCorazzaFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Corazza di Ferro");
        metaCorazzaFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Protegge il torace con",
                ChatColor.GRAY + "piastre resistenti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1200"
        ));
        corazzaFerro.setItemMeta(metaCorazzaFerro);
        armor.setItem(19, corazzaFerro);

        // Gambali di Ferro
        ItemStack gambaliFerro = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta metaGambaliFerro = gambaliFerro.getItemMeta();
        metaGambaliFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Gambali di Ferro");
        metaGambaliFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Protegge le gambe durante",
                ChatColor.GRAY + "i combattimenti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1000"
        ));
        gambaliFerro.setItemMeta(metaGambaliFerro);
        armor.setItem(28, gambaliFerro);

        // Stivali di Ferro
        ItemStack stivaliFerro = new ItemStack(Material.IRON_BOOTS);
        ItemMeta metaStivaliFerro = stivaliFerro.getItemMeta();
        metaStivaliFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Stivali di Ferro");
        metaStivaliFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Proteggono i piedi e",
                ChatColor.GRAY + "migliorano la stabilità",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€600"
        ));
        stivaliFerro.setItemMeta(metaStivaliFerro);
        armor.setItem(37, stivaliFerro);

        // Set Completo Ferro
        ItemStack setFerro = new ItemStack(Material.IRON_INGOT);
        ItemMeta metaSetFerro = setFerro.getItemMeta();
        metaSetFerro.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "SET COMPLETO DI FERRO");
        metaSetFerro.setLore(Arrays.asList(
                ChatColor.GRAY + "Include tutti i pezzi",
                ChatColor.GRAY + "dell'armatura di ferro",
                "",
                ChatColor.GOLD + "Prezzo originale: " + ChatColor.RED + "€3600",
                ChatColor.GOLD + "Prezzo scontato: " + ChatColor.GREEN + "€3000",
                ChatColor.YELLOW + "Risparmio: €600!"
        ));
        setFerro.setItemMeta(metaSetFerro);
        armor.setItem(20, setFerro);

        // === ARMOR SET DIAMANTE - DESTRA ===

        // Titolo Set Diamante
        ItemStack titleDiamante = new ItemStack(Material.DIAMOND);
        ItemMeta metaTitleDiamante = titleDiamante.getItemMeta();
        metaTitleDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "SET ARMATURA DI DIAMANTE");
        metaTitleDiamante.setLore(Collections.singletonList(ChatColor.GRAY + "La massima protezione disponibile"));
        titleDiamante.setItemMeta(metaTitleDiamante);
        armor.setItem(6, titleDiamante);

        // Elmo di Diamante
        ItemStack elmoDiamante = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta metaElmoDiamante = elmoDiamante.getItemMeta();
        metaElmoDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Elmo di Diamante");
        metaElmoDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Protezione superiore per",
                ChatColor.GRAY + "la testa del guerriero",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€2400"
        ));
        elmoDiamante.setItemMeta(metaElmoDiamante);
        armor.setItem(16, elmoDiamante);

        // Corazza di Diamante
        ItemStack corazzaDiamante = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta metaCorazzaDiamante = corazzaDiamante.getItemMeta();
        metaCorazzaDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Corazza di Diamante");
        metaCorazzaDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Massima protezione del",
                ChatColor.GRAY + "torace con diamanti puri",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€3600"
        ));
        corazzaDiamante.setItemMeta(metaCorazzaDiamante);
        armor.setItem(25, corazzaDiamante);

        // Gambali di Diamante
        ItemStack gambaliDiamante = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta metaGambaliDiamante = gambaliDiamante.getItemMeta();
        metaGambaliDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Gambali di Diamante");
        metaGambaliDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Protezione delle gambe",
                ChatColor.GRAY + "con la forza del diamante",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€3000"
        ));
        gambaliDiamante.setItemMeta(metaGambaliDiamante);
        armor.setItem(34, gambaliDiamante);

        // Stivali di Diamante
        ItemStack stivaliDiamante = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta metaStivaliDiamante = stivaliDiamante.getItemMeta();
        metaStivaliDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Stivali di Diamante");
        metaStivaliDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "I migliori stivali per",
                ChatColor.GRAY + "ogni tipo di terreno",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1800"
        ));
        stivaliDiamante.setItemMeta(metaStivaliDiamante);
        armor.setItem(43, stivaliDiamante);

        // Set Completo Diamante
        ItemStack setDiamante = new ItemStack(Material.DIAMOND);
        ItemMeta metaSetDiamante = setDiamante.getItemMeta();
        metaSetDiamante.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "SET COMPLETO DI DIAMANTE");
        metaSetDiamante.setLore(Arrays.asList(
                ChatColor.GRAY + "Include tutti i pezzi",
                ChatColor.GRAY + "dell'armatura di diamante",
                "",
                ChatColor.GOLD + "Prezzo originale: " + ChatColor.RED + "€10800",
                ChatColor.GOLD + "Prezzo scontato: " + ChatColor.GREEN + "€9000",
                ChatColor.YELLOW + "Risparmio: €1800!"
        ));
        setDiamante.setItemMeta(metaSetDiamante);
        armor.setItem(24, setDiamante);

        // Bottone per tornare indietro
        ItemStack tornIndietro = new ItemStack(Material.ARROW);
        ItemMeta metaTorna = tornIndietro.getItemMeta();
        metaTorna.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "← Torna al Menu Principale");
        metaTorna.setLore(Collections.singletonList(ChatColor.GRAY + "Clicca per tornare al negozio principale"));
        tornIndietro.setItemMeta(metaTorna);
        armor.setItem(49, tornIndietro);

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaWallet = wallet.getItemMeta();
        metaWallet.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        metaWallet.setLore(Arrays.asList(
                ChatColor.GRAY + "Saldo attuale:",
                ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(p))
        ));
        wallet.setItemMeta(metaWallet);
        armor.setItem(4, wallet);

        p.openInventory(armor);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getArmorName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                // FERRO
                case 10: // Elmo di Ferro
                    if (econManager.checkMoney(p) >= 800) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
                        econManager.removeMoney(p, 800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Elmo di Ferro per €800!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €800");
                    }
                    break;

                case 19: // Corazza di Ferro
                    if (econManager.checkMoney(p) >= 1200) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
                        econManager.removeMoney(p, 1200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Corazza di Ferro per €1200!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1200");
                    }
                    break;

                case 28: // Gambali di Ferro
                    if (econManager.checkMoney(p) >= 1000) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
                        econManager.removeMoney(p, 1000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato dei Gambali di Ferro per €1000!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1000");
                    }
                    break;

                case 37: // Stivali di Ferro
                    if (econManager.checkMoney(p) >= 600) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
                        econManager.removeMoney(p, 600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato degli Stivali di Ferro per €600!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €600");
                    }
                    break;

                case 20: // Set Completo Ferro
                    if (econManager.checkMoney(p) >= 3000) {
                        p.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
                        p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
                        p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
                        p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
                        econManager.removeMoney(p, 3000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato il Set Completo di Ferro per €3000!");
                        p.sendMessage(ChatColor.YELLOW + "Hai risparmiato €600!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €3000");
                    }
                    break;

                // DIAMANTE
                case 16: // Elmo di Diamante
                    if (econManager.checkMoney(p) >= 2400) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
                        econManager.removeMoney(p, 2400);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Elmo di Diamante per €2400!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €2400");
                    }
                    break;

                case 25: // Corazza di Diamante
                    if (econManager.checkMoney(p) >= 3600) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        econManager.removeMoney(p, 3600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Corazza di Diamante per €3600!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €3600");
                    }
                    break;

                case 34: // Gambali di Diamante
                    if (econManager.checkMoney(p) >= 3000) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
                        econManager.removeMoney(p, 3000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato dei Gambali di Diamante per €3000!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €3000");
                    }
                    break;

                case 43: // Stivali di Diamante
                    if (econManager.checkMoney(p) >= 1800) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
                        econManager.removeMoney(p, 1800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato degli Stivali di Diamante per €1800!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1800");
                    }
                    break;

                case 24: // Set Completo Diamante
                    if (econManager.checkMoney(p) >= 9000) {
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET));
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS));
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS));
                        econManager.removeMoney(p, 9000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato il Set Completo di Diamante per €9000!");
                        p.sendMessage(ChatColor.YELLOW + "Hai risparmiato €1800!");
                        openArmor(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €9000");
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}