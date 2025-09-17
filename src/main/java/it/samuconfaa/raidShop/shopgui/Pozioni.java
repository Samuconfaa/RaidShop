package it.samuconfaa.raidShop.shopgui;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.managers.EconomyManager;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        // Imposta il titolo dell'inventario dal config
        String inventoryTitle = plugin.getConfigManager().getPozioniName();
        Inventory pozioni = Bukkit.createInventory(p, 27, inventoryTitle);

        // Crea le pozioni con i relativi metadati
        pozioni.setItem(11, creaPozione(Material.POTION, (short) 8226, "Pozione di Velocità II", "Prezzo: €2100"));
        pozioni.setItem(12, creaPozione(Material.POTION, (short) 8233, "Pozione di Forza II", "Prezzo: €5000"));
        pozioni.setItem(13, creaPozione(Material.POTION, (short) 8195, "Pozione di Resistenza al Fuoco", "Prezzo: €700"));
        pozioni.setItem(14, creaPozione(Material.POTION, (short) 16394, "Pozione Splash di Lentezza", "Prezzo: €4500"));
        pozioni.setItem(15, creaPozione(Material.POTION, (short) 16388, "Pozione Splash di Avvelenamento", "Prezzo: €4500"));

        // Crea l'elemento per tornare indietro
        ItemStack freccia = new ItemStack(Material.ARROW);
        ItemMeta metaFreccia = freccia.getItemMeta();
        metaFreccia.setDisplayName("Torna Indietro");
        freccia.setItemMeta(metaFreccia);
        pozioni.setItem(26, freccia);

        // Apre l'inventario al giocatore
        p.openInventory(pozioni);
    }

    private ItemStack creaPozione(Material material, short data, String displayName, String lore) {
        ItemStack pozione = new ItemStack(material, 1, data);
        ItemMeta meta = pozione.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Collections.singletonList(lore));
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
            if (slot == 11 && econManager.checkMoney(p) >= 2100) {
                p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 8226));
                econManager.removeMoney(p, 2100);
            } else if (slot == 12 && econManager.checkMoney(p) >= 5000) {
                p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 8233));
                econManager.removeMoney(p, 5000);
            } else if (slot == 13 && econManager.checkMoney(p) >= 700) {
                p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 8195));
                econManager.removeMoney(p, 700);
            } else if (slot == 14 && econManager.checkMoney(p) >= 4500) {
                p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 16394));
                econManager.removeMoney(p, 4500);
            } else if (slot == 15 && econManager.checkMoney(p) >= 4500) {
                p.getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 16388));
                econManager.removeMoney(p, 4500);
            } else if (slot == 26) {
                shop.openShop(p);
            }
        }
    }
}
