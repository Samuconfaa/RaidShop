package it.samuconfaa.raidShop.shopgui;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.managers.EconomyManager;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;

import java.util.Arrays;
import java.util.Collections;

public class Libri implements Listener {
    private final RaidShop plugin;
    private final EconomyManager econManager;
    private Shop shop;

    public Libri(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void openLibri(Player p) {
        Inventory libri = Bukkit.createInventory(p, 54, plugin.getConfigManager().getEnchantName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1, (short) 11); // Blu
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            libri.setItem(slot, border);
        }

        // Decorazioni laterali viola
        ItemStack purpleGlass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1, (short) 10); // Viola
        ItemMeta purpleMeta = purpleGlass.getItemMeta();
        purpleMeta.setDisplayName(" ");
        purpleGlass.setItemMeta(purpleMeta);
        libri.setItem(18, purpleGlass);
        libri.setItem(26, purpleGlass);
        libri.setItem(27, purpleGlass);
        libri.setItem(35, purpleGlass);

        // === LIBRI INCANTATI ===

        // Protezione I
        ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaProtezione = protezione.getItemMeta();
        metaProtezione.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Libro di Protezione I");
        metaProtezione.setLore(Arrays.asList(
                ChatColor.GRAY + "Riduce i danni subiti",
                ChatColor.GRAY + "da attacchi fisici",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1800"
        ));
        protezione.setItemMeta(metaProtezione);
        libri.setItem(11, protezione);

        // Sharpness I
        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaSharpness = sharpness.getItemMeta();
        metaSharpness.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Libro di Affilatezza I");
        metaSharpness.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta il danno inflitto",
                ChatColor.GRAY + "dalle armi corpo a corpo",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1500"
        ));
        sharpness.setItemMeta(metaSharpness);
        libri.setItem(12, sharpness);

        // Indistruttibilità I
        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaUnbreaking = unbreaking.getItemMeta();
        metaUnbreaking.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Libro di Indistruttibilità I");
        metaUnbreaking.setLore(Arrays.asList(
                ChatColor.GRAY + "Riduce la perdita di",
                ChatColor.GRAY + "durabilità degli oggetti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€2200"
        ));
        unbreaking.setItemMeta(metaUnbreaking);
        libri.setItem(13, unbreaking);

        // Potenza I
        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaPower = power.getItemMeta();
        metaPower.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Libro di Potenza I");
        metaPower.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta il danno inflitto",
                ChatColor.GRAY + "dalle frecce dell'arco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1600"
        ));
        power.setItemMeta(metaPower);
        libri.setItem(15, power);

        // Bottone per tornare indietro
        ItemStack tornIndietro = new ItemStack(Material.ARROW);
        ItemMeta metaTorna = tornIndietro.getItemMeta();
        metaTorna.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "← Torna al Menu Principale");
        metaTorna.setLore(Collections.singletonList(ChatColor.GRAY + "Clicca per tornare al negozio principale"));
        tornIndietro.setItemMeta(metaTorna);
        libri.setItem(49, tornIndietro);

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaWallet = wallet.getItemMeta();
        metaWallet.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        metaWallet.setLore(Arrays.asList(
                ChatColor.GRAY + "Saldo attuale:",
                ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(p))
        ));
        wallet.setItemMeta(metaWallet);
        libri.setItem(4, wallet);

        p.openInventory(libri);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getEnchantName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                case 11: // Protezione I
                    if (econManager.checkMoney(p) >= 1800) {
                        ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protezione.getItemMeta();
                        meta.addStoredEnchant(Enchantment.PROTECTION, 1, true);
                        protezione.setItemMeta(meta);
                        p.getInventory().addItem(protezione);
                        econManager.removeMoney(p, 1800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Protezione I per €1800!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1800");
                    }
                    break;

                case 12: // Sharpness I
                    if (econManager.checkMoney(p) >= 1500) {
                        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sharpness.getItemMeta();
                        meta.addStoredEnchant(Enchantment.SHARPNESS, 1, true);
                        sharpness.setItemMeta(meta);
                        p.getInventory().addItem(sharpness);
                        econManager.removeMoney(p, 1500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Affilatezza I per €1500!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1500");
                    }
                    break;

                case 13: // Indistruttibilità I
                    if (econManager.checkMoney(p) >= 2200) {
                        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) unbreaking.getItemMeta();
                        meta.addStoredEnchant(Enchantment.UNBREAKING, 1, true);
                        unbreaking.setItemMeta(meta);
                        p.getInventory().addItem(unbreaking);
                        econManager.removeMoney(p, 2200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Indistruttibilità I per €2200!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €2200");
                    }
                    break;

                case 15: // Potenza I
                    if (econManager.checkMoney(p) >= 1600) {
                        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) power.getItemMeta();
                        meta.addStoredEnchant(Enchantment.POWER, 1, true);
                        power.setItemMeta(meta);
                        p.getInventory().addItem(power);
                        econManager.removeMoney(p, 1600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Potenza I per €1600!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1600");
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}