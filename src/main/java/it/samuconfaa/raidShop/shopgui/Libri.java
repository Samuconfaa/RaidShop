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
        ItemStack border = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            libri.setItem(slot, border);
        }

        // Decorazioni laterali viola
        ItemStack purpleGlass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1, (short) 10);
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
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getProtectionBookPrice())
        ));
        protezione.setItemMeta(metaProtezione);
        libri.setItem(10, protezione);

        // Sharpness I
        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaSharpness = sharpness.getItemMeta();
        metaSharpness.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Libro di Affilatezza I");
        metaSharpness.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta il danno inflitto",
                ChatColor.GRAY + "dalle armi corpo a corpo",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getSharpnessBookPrice())
        ));
        sharpness.setItemMeta(metaSharpness);
        libri.setItem(11, sharpness);

        // Indistruttibilità I
        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaUnbreaking = unbreaking.getItemMeta();
        metaUnbreaking.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Libro di Indistruttibilità I");
        metaUnbreaking.setLore(Arrays.asList(
                ChatColor.GRAY + "Riduce la perdita di",
                ChatColor.GRAY + "durabilità degli oggetti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getUnbreakingBookPrice())
        ));
        unbreaking.setItemMeta(metaUnbreaking);
        libri.setItem(12, unbreaking);

        // Potenza I
        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaPower = power.getItemMeta();
        metaPower.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Libro di Potenza I");
        metaPower.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta il danno inflitto",
                ChatColor.GRAY + "dalle frecce dell'arco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getPowerBookPrice())
        ));
        power.setItemMeta(metaPower);
        libri.setItem(13, power);

        // Sweeping Edge I
        ItemStack sweepingEdge = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaSweepingEdge = sweepingEdge.getItemMeta();
        metaSweepingEdge.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Libro di Lama Falciante I");
        metaSweepingEdge.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta i danni degli",
                ChatColor.GRAY + "attacchi ad area delle spade",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getSweepingEdgeBookPrice())
        ));
        sweepingEdge.setItemMeta(metaSweepingEdge);
        libri.setItem(14, sweepingEdge);

        // Aqua Affinity I
        ItemStack aquaAffinity = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaAquaAffinity = aquaAffinity.getItemMeta();
        metaAquaAffinity.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Libro di Affinità Acquatica I");
        metaAquaAffinity.setLore(Arrays.asList(
                ChatColor.GRAY + "Permette di scavare alla",
                ChatColor.GRAY + "stessa velocità sott'acqua",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getAquaAffinityBookPrice())
        ));
        aquaAffinity.setItemMeta(metaAquaAffinity);
        libri.setItem(15, aquaAffinity);

        // Respiration I
        ItemStack respiration = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaRespiration = respiration.getItemMeta();
        metaRespiration.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Libro di Respirazione I");
        metaRespiration.setLore(Arrays.asList(
                ChatColor.GRAY + "Prolunga il tempo di",
                ChatColor.GRAY + "respirazione sott'acqua",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getRespirationBookPrice())
        ));
        respiration.setItemMeta(metaRespiration);
        libri.setItem(16, respiration);

        // Punch I
        ItemStack punch = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaPunch = punch.getItemMeta();
        metaPunch.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Libro di Spinta I");
        metaPunch.setLore(Arrays.asList(
                ChatColor.GRAY + "Le frecce respingono",
                ChatColor.GRAY + "i nemici colpiti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getPunchBookPrice())
        ));
        punch.setItemMeta(metaPunch);
        libri.setItem(19, punch);

        // Flame I
        ItemStack flame = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaFlame = flame.getItemMeta();
        metaFlame.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Libro di Fiamma I");
        metaFlame.setLore(Arrays.asList(
                ChatColor.GRAY + "Le frecce incendiano",
                ChatColor.GRAY + "i nemici colpiti",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€" + String.format("%.0f", plugin.getConfigManager().getFlameBookPrice())
        ));
        flame.setItemMeta(metaFlame);
        libri.setItem(20, flame);

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
                case 10: // Protezione I
                    double protectionPrice = plugin.getConfigManager().getProtectionBookPrice();
                    if (econManager.checkMoney(p) >= protectionPrice) {
                        ItemStack protezione = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) protezione.getItemMeta();
                        meta.addStoredEnchant(Enchantment.PROTECTION, 1, true);
                        protezione.setItemMeta(meta);
                        p.getInventory().addItem(protezione);
                        econManager.removeMoney(p, protectionPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Protezione I per €" + String.format("%.0f", protectionPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", protectionPrice));
                    }
                    break;

                case 11: // Sharpness I
                    double sharpnessPrice = plugin.getConfigManager().getSharpnessBookPrice();
                    if (econManager.checkMoney(p) >= sharpnessPrice) {
                        ItemStack sharpness = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sharpness.getItemMeta();
                        meta.addStoredEnchant(Enchantment.SHARPNESS, 1, true);
                        sharpness.setItemMeta(meta);
                        p.getInventory().addItem(sharpness);
                        econManager.removeMoney(p, sharpnessPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Affilatezza I per €" + String.format("%.0f", sharpnessPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", sharpnessPrice));
                    }
                    break;

                case 12: // Indistruttibilità I
                    double unbreakingPrice = plugin.getConfigManager().getUnbreakingBookPrice();
                    if (econManager.checkMoney(p) >= unbreakingPrice) {
                        ItemStack unbreaking = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) unbreaking.getItemMeta();
                        meta.addStoredEnchant(Enchantment.UNBREAKING, 1, true);
                        unbreaking.setItemMeta(meta);
                        p.getInventory().addItem(unbreaking);
                        econManager.removeMoney(p, unbreakingPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Indistruttibilità I per €" + String.format("%.0f", unbreakingPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", unbreakingPrice));
                    }
                    break;

                case 13: // Potenza I
                    double powerPrice = plugin.getConfigManager().getPowerBookPrice();
                    if (econManager.checkMoney(p) >= powerPrice) {
                        ItemStack power = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) power.getItemMeta();
                        meta.addStoredEnchant(Enchantment.POWER, 1, true);
                        power.setItemMeta(meta);
                        p.getInventory().addItem(power);
                        econManager.removeMoney(p, powerPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Potenza I per €" + String.format("%.0f", powerPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", powerPrice));
                    }
                    break;

                case 14: // Sweeping Edge I
                    double sweepingEdgePrice = plugin.getConfigManager().getSweepingEdgeBookPrice();
                    if (econManager.checkMoney(p) >= sweepingEdgePrice) {
                        ItemStack sweepingEdge = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sweepingEdge.getItemMeta();
                        meta.addStoredEnchant(Enchantment.SWEEPING_EDGE, 1, true);
                        sweepingEdge.setItemMeta(meta);
                        p.getInventory().addItem(sweepingEdge);
                        econManager.removeMoney(p, sweepingEdgePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Lama Falciante I per €" + String.format("%.0f", sweepingEdgePrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", sweepingEdgePrice));
                    }
                    break;

                case 15: // Aqua Affinity I
                    double aquaAffinityPrice = plugin.getConfigManager().getAquaAffinityBookPrice();
                    if (econManager.checkMoney(p) >= aquaAffinityPrice) {
                        ItemStack aquaAffinity = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) aquaAffinity.getItemMeta();
                        meta.addStoredEnchant(Enchantment.AQUA_AFFINITY, 1, true);
                        aquaAffinity.setItemMeta(meta);
                        p.getInventory().addItem(aquaAffinity);
                        econManager.removeMoney(p, aquaAffinityPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Affinità Acquatica I per €" + String.format("%.0f", aquaAffinityPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", aquaAffinityPrice));
                    }
                    break;

                case 16: // Respiration I
                    double respirationPrice = plugin.getConfigManager().getRespirationBookPrice();
                    if (econManager.checkMoney(p) >= respirationPrice) {
                        ItemStack respiration = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) respiration.getItemMeta();
                        meta.addStoredEnchant(Enchantment.RESPIRATION, 1, true);
                        respiration.setItemMeta(meta);
                        p.getInventory().addItem(respiration);
                        econManager.removeMoney(p, respirationPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Respirazione I per €" + String.format("%.0f", respirationPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", respirationPrice));
                    }
                    break;

                case 19: // Punch I
                    double punchPrice = plugin.getConfigManager().getPunchBookPrice();
                    if (econManager.checkMoney(p) >= punchPrice) {
                        ItemStack punch = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) punch.getItemMeta();
                        meta.addStoredEnchant(Enchantment.PUNCH, 1, true);
                        punch.setItemMeta(meta);
                        p.getInventory().addItem(punch);
                        econManager.removeMoney(p, punchPrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Spinta I per €" + String.format("%.0f", punchPrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", punchPrice));
                    }
                    break;

                case 20: // Flame I
                    double flamePrice = plugin.getConfigManager().getFlameBookPrice();
                    if (econManager.checkMoney(p) >= flamePrice) {
                        ItemStack flame = new ItemStack(Material.ENCHANTED_BOOK);
                        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) flame.getItemMeta();
                        meta.addStoredEnchant(Enchantment.FLAME, 1, true);
                        flame.setItemMeta(meta);
                        p.getInventory().addItem(flame);
                        econManager.removeMoney(p, flamePrice);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Libro di Fiamma I per €" + String.format("%.0f", flamePrice) + "!");
                        openLibri(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €" + String.format("%.0f", flamePrice));
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}