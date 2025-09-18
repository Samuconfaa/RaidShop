package it.samuconfaa.raidShop.fixGUI;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.managers.EconomyManager;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FixGui implements Listener {

    private final RaidShop plugin;
    private final EconomyManager econManager;

    public FixGui(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, plugin.getConfigManager().getFixGUISize(),
                plugin.getConfigManager().getFixGUIName());

        // Incudine per riparare
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.setDisplayName(plugin.getConfigManager().getFixAnvilName());
        List<String> lore = new ArrayList<>();
        lore.add(plugin.getConfigManager().getFixLore1());
        lore.add(plugin.getConfigManager().getFixLore2());
        lore.add(plugin.getConfigManager().getFixLore3() + plugin.getConfigManager().getFixPrice());
        anvilMeta.setLore(lore);
        anvil.setItemMeta(anvilMeta);
        gui.setItem(plugin.getConfigManager().getFixAnvilPos(), anvil);

        // Vetri decorativi
        ItemStack glass = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1,
                (short) plugin.getConfigManager().getFixGlassColor());
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(plugin.getConfigManager().getFixGlassName());
        glass.setItemMeta(glassMeta);

        // Riempimento con vetri
        for (int i = 0; i < plugin.getConfigManager().getFixGUISize(); i++) {
            if (i != plugin.getConfigManager().getFixAnvilPos()) {
                gui.setItem(i, glass);
            }
        }

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta walletMeta = wallet.getItemMeta();
        walletMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        List<String> walletLore = new ArrayList<>();
        walletLore.add(ChatColor.GRAY + "Saldo attuale:");
        walletLore.add(ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(player)));
        walletMeta.setLore(walletLore);
        wallet.setItemMeta(walletMeta);
        gui.setItem(plugin.getConfigManager().getFixWalletPos(), wallet);

        player.openInventory(gui);
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem().getItemStack();

        // Previene il pickup di incudini nel mondo se configurato
        if (item.getType() == Material.ANVIL && plugin.getConfigManager().isPreventAnvilPickup()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        if (inv != null && inv.getHolder() == null &&
                plugin.getConfigManager().getFixGUIName().equals(e.getView().getTitle())) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            if (slot == plugin.getConfigManager().getFixAnvilPos()) {
                double price = plugin.getConfigManager().getFixPrice();

                if (econManager.checkMoney(player) >= price) {
                    repairAllItems(player);
                    player.sendMessage(plugin.getConfigManager().getFixSuccessMessage());

                    // Suono di successo
                    if (plugin.getConfigManager().isFixSoundEnabled()) {
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
                    }

                    // Riaggiorna la GUI per mostrare il nuovo saldo
                    openGUI(player);

                } else {
                    player.sendMessage(plugin.getConfigManager().getFixNoMoneyMessage());

                    // Suono di errore
                    if (plugin.getConfigManager().isFixSoundEnabled()) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                    }
                }
            }
        }
    }

    private void repairAllItems(Player player) {
        boolean itemsRepaired = false;

        // Ripara tutti gli oggetti nell'inventario del giocatore
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR && item.getDurability() > 0) {
                item.setDurability((short) 0);
                itemsRepaired = true;
            }
        }

        // Ripara anche gli oggetti nell'armatura
        for (ItemStack armorItem : player.getInventory().getArmorContents()) {
            if (armorItem != null && armorItem.getType() != Material.AIR && armorItem.getDurability() > 0) {
                armorItem.setDurability((short) 0);
                itemsRepaired = true;
            }
        }

        // Ripara l'oggetto nella mano secondaria (offhand) se presente
        ItemStack offhand = player.getInventory().getItemInOffHand();
        if (offhand != null && offhand.getType() != Material.AIR && offhand.getDurability() > 0) {
            offhand.setDurability((short) 0);
            itemsRepaired = true;
        }

        // Togli i soldi solo se almeno un oggetto è stato riparato
        if (itemsRepaired) {
            econManager.removeMoney(player, plugin.getConfigManager().getFixPrice());
        }
    }
}