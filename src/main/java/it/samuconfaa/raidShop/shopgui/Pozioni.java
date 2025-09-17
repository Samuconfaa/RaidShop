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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

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
        ItemStack border = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1, (short) 6); // Rosa
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            pozioni.setItem(slot, border);
        }

        // Decorazioni laterali magenta
        ItemStack magentaGlass = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE, 1, (short) 2); // Magenta
        ItemMeta magentaMeta = magentaGlass.getItemMeta();
        magentaMeta.setDisplayName(" ");
        magentaGlass.setItemMeta(magentaMeta);
        pozioni.setItem(18, magentaGlass);
        pozioni.setItem(26, magentaGlass);
        pozioni.setItem(27, magentaGlass);
        pozioni.setItem(35, magentaGlass);

        // === POZIONI ===

        // Pozione di Forza
        ItemStack pozioneForza = creaPozioneModerna(PotionType.STRENGTH, false, false,
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
        ItemStack pozioneVelocita = creaPozioneModerna(PotionType.SWIFTNESS, false, false,
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
        ItemStack pozioneSalto = creaPozioneModerna(PotionType.LEAPING, false, false,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Pozione di Salto in Alto",
                Arrays.asList(
                        ChatColor.GRAY + "Permette di saltare",
                        ChatColor.GRAY + "molto più in alto",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1000"
                )
        );
        pozioni.setItem(12, pozioneSalto);

        // Pozione di Resistenza (usando Turtle Master che da resistenza)
        ItemStack pozioneResistenza = creaPozioneModerna(PotionType.TURTLE_MASTER, false, false,
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
        ItemStack pozioneCura = creaPozioneModerna(PotionType.HEALING, false, false,
                ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pozione di Cura Istantanea",
                Arrays.asList(
                        ChatColor.GRAY + "Ripristina istantaneamente",
                        ChatColor.GRAY + "una parte della salute",
                        "",
                        ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1600"
                )
        );
        pozioni.setItem(14, pozioneCura);

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

    private ItemStack creaPozione(Material material, short data, String displayName, java.util.List<String> lore) {
        ItemStack pozione = new ItemStack(material, 1, data);
        ItemMeta meta = pozione.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        pozione.setItemMeta(meta);
        return pozione;
    }

    private ItemStack creaPozioneModerna(PotionType type, boolean extended, boolean upgraded, String displayName, java.util.List<String> lore) {
        Potion potion = new Potion(type);
        if (extended) potion.extend();

        ItemStack pozioneItem = potion.toItemStack(1);
        ItemMeta meta = pozioneItem.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        pozioneItem.setItemMeta(meta);
        return pozioneItem;
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
                        Potion potion = new Potion(PotionType.STRENGTH);
                        ItemStack pozioneForza = potion.toItemStack(1);
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
                        Potion potion = new Potion(PotionType.SWIFTNESS);
                        ItemStack pozioneVelocita = potion.toItemStack(1);
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
                        Potion potion = new Potion(PotionType.LEAPING);
                        ItemStack pozioneSalto = potion.toItemStack(1);
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
                        Potion potion = new Potion(PotionType.TURTLE_MASTER);
                        ItemStack pozioneResistenza = potion.toItemStack(1);
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
                        Potion potion = new Potion(PotionType.HEALING);
                        ItemStack pozioneCura = potion.toItemStack(1);
                        p.getInventory().addItem(pozioneCura);
                        econManager.removeMoney(p, 1600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Pozione di Cura Istantanea per €1600!");
                        openPozioni(p);
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