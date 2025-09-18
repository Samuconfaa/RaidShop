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

public class Shop implements Listener {
    private final RaidShop plugin;
    private final Libri libri;
    private final Generale generale;
    private final Pozioni pozioni;
    private final Armor armor;
    private final IngredientiPozioni ingredientiPozioni;
    private final EconomyManager econManager;

    public Shop(RaidShop plugin, Generale generale, Pozioni pozioni, Libri libri, Armor armor, IngredientiPozioni ingredientiPozioni, EconomyManager econManager) {
        this.plugin = plugin;
        this.generale = generale;
        this.pozioni = pozioni;
        this.libri = libri;
        this.armor = armor;
        this.ingredientiPozioni = ingredientiPozioni;
        this.econManager = econManager;
    }

    public void openShop(Player p) {
        Inventory shop = Bukkit.createInventory(p, 54, plugin.getConfigManager().getShopName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, (short) 4); // Giallo
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,2,6,7,8,9,17,36,44,45,46,47,51,52,53};
        for (int slot : borderSlots) {
            shop.setItem(slot, border);
        }

        // Decorazioni laterali oro
        ItemStack goldGlass = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1, (short) 1); // Arancione/oro
        ItemMeta goldMeta = goldGlass.getItemMeta();
        goldMeta.setDisplayName(" ");
        goldGlass.setItemMeta(goldMeta);
        shop.setItem(18, goldGlass);
        shop.setItem(26, goldGlass);
        shop.setItem(27, goldGlass);
        shop.setItem(35, goldGlass);

        // === SEZIONI DEL NEGOZIO ===

        // Sezione Generale
        ItemStack generale = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaGenerale = generale.getItemMeta();
        metaGenerale.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "SEZIONE GENERALE");
        metaGenerale.setLore(Arrays.asList(
                ChatColor.GRAY + "Armi, strumenti e oggetti",
                ChatColor.GRAY + "essenziali per l'avventura",
                "",
                ChatColor.YELLOW + "Clicca per aprire!"
        ));
        generale.setItemMeta(metaGenerale);
        shop.setItem(19, generale);

        // Sezione Pozioni
        ItemStack pozioni = new ItemStack(Material.POTION, 1, (short) 8197);
        ItemMeta metaPozioni = pozioni.getItemMeta();
        metaPozioni.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "SEZIONE POZIONI");
        metaPozioni.setLore(Arrays.asList(
                ChatColor.GRAY + "Elisir magici per potenziare",
                ChatColor.GRAY + "le tue abilità in battaglia",
                "",
                ChatColor.YELLOW + "Clicca per aprire!"
        ));
        pozioni.setItemMeta(metaPozioni);
        shop.setItem(21, pozioni);

        // Sezione Libri Incantati
        ItemStack libri = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta metaLibri = libri.getItemMeta();
        metaLibri.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "SEZIONE INCANTESIMI");
        metaLibri.setLore(Arrays.asList(
                ChatColor.GRAY + "Libri magici per incantare",
                ChatColor.GRAY + "le tue armi e armature",
                "",
                ChatColor.YELLOW + "Clicca per aprire!"
        ));
        libri.setItemMeta(metaLibri);
        shop.setItem(23, libri);

        // Sezione Armature
        ItemStack armature = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta metaArmature = armature.getItemMeta();
        metaArmature.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "SEZIONE ARMATURE");
        metaArmature.setLore(Arrays.asList(
                ChatColor.GRAY + "Set completi di armature",
                ChatColor.GRAY + "in ferro e diamante",
                "",
                ChatColor.YELLOW + "Clicca per aprire!"
        ));
        armature.setItemMeta(metaArmature);
        shop.setItem(25, armature);

        // Sezione Ingredienti Pozioni (NUOVA!)
        ItemStack ingredienti = new ItemStack(Material.BREWING_STAND);
        ItemMeta metaIngredienti = ingredienti.getItemMeta();
        metaIngredienti.setDisplayName(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "INGREDIENTI POZIONI");
        metaIngredienti.setLore(Arrays.asList(
                ChatColor.GRAY + "Tutto ciò che serve per",
                ChatColor.GRAY + "preparare pozioni all'alambicco",
                "",
                ChatColor.YELLOW + "Clicca per aprire!"
        ));
        ingredienti.setItemMeta(metaIngredienti);
        shop.setItem(31, ingredienti);

        // Info centrale - Logo del negozio
        ItemStack logo = new ItemStack(Material.EMERALD);
        ItemMeta metaLogo = logo.getItemMeta();
        metaLogo.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "⭐ RAID SHOP ⭐");
        metaLogo.setLore(Arrays.asList(
                ChatColor.GRAY + "Benvenuto nel negozio principale!",
                ChatColor.GRAY + "Scegli una sezione per iniziare",
                "",
                ChatColor.GREEN + "Il tuo saldo: €" + String.format("%.2f", econManager.checkMoney(p))
        ));
        logo.setItemMeta(metaLogo);
        shop.setItem(13, logo);

        // Informazioni sulle sezioni
        ItemStack info = new ItemStack(Material.BOOK);
        ItemMeta metaInfo = info.getItemMeta();
        metaInfo.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "ℹ INFORMAZIONI");
        metaInfo.setLore(Arrays.asList(
                ChatColor.GRAY + "Questo negozio offre:",
                "",
                ChatColor.GREEN + "• " + ChatColor.WHITE + "Generale: " + ChatColor.GRAY + "Armi e strumenti",
                ChatColor.LIGHT_PURPLE + "• " + ChatColor.WHITE + "Pozioni: " + ChatColor.GRAY + "Elisir magici",
                ChatColor.BLUE + "• " + ChatColor.WHITE + "Incantesimi: " + ChatColor.GRAY + "Libri incantati",
                ChatColor.AQUA + "• " + ChatColor.WHITE + "Armature: " + ChatColor.GRAY + "Set di protezione",
                ChatColor.DARK_AQUA + "• " + ChatColor.WHITE + "Ingredienti: " + ChatColor.GRAY + "Per l'alambicco",
                "",
                ChatColor.GOLD + "Buona spesa!"
        ));
        info.setItemMeta(metaInfo);
        shop.setItem(49, info);

        p.openInventory(shop);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();

        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getShopName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                case 19: // Sezione Generale
                    generale.openGenerale(p);
                    break;

                case 21: // Sezione Pozioni
                    pozioni.openPozioni(p);
                    break;

                case 23: // Sezione Libri
                    libri.openLibri(p);
                    break;

                case 25: // Sezione Armature
                    armor.openArmor(p);
                    break;

                case 31: // Sezione Ingredienti Pozioni (NUOVA!)
                    ingredientiPozioni.openIngredientiPozioni(p);
                    break;
            }
        }
    }
}