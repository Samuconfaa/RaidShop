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

public class IngredientiPozioni implements Listener {
    private final RaidShop plugin;
    private final EconomyManager econManager;
    private Shop shop;

    public IngredientiPozioni(RaidShop plugin, EconomyManager econManager) {
        this.plugin = plugin;
        this.econManager = econManager;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void openIngredientiPozioni(Player p) {
        Inventory ingredienti = Bukkit.createInventory(p, 54, plugin.getConfigManager().getIngredientiName());

        // Decorazioni - Vetri colorati per i bordi
        ItemStack border = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        // Riempi i bordi
        int[] borderSlots = {0,1,7,8,9,17,36,44,45,46,52,53};
        for (int slot : borderSlots) {
            ingredienti.setItem(slot, border);
        }

        // Decorazioni laterali ciano
        ItemStack cyanGlass = new ItemStack(Material.CYAN_STAINED_GLASS_PANE, 1);
        ItemMeta cyanMeta = cyanGlass.getItemMeta();
        cyanMeta.setDisplayName(" ");
        cyanGlass.setItemMeta(cyanMeta);
        ingredienti.setItem(18, cyanGlass);
        ingredienti.setItem(26, cyanGlass);
        ingredienti.setItem(27, cyanGlass);
        ingredienti.setItem(35, cyanGlass);

        // === INGREDIENTI BASE ===

        // Boccetta d'acqua
        ItemStack boccettaAcqua = new ItemStack(Material.POTION);
        ItemMeta metaBoccetta = boccettaAcqua.getItemMeta();
        metaBoccetta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Boccetta d'Acqua");
        metaBoccetta.setLore(Arrays.asList(
                ChatColor.GRAY + "Base per tutte le pozioni",
                ChatColor.GRAY + "da preparare all'alambicco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€200"
        ));
        boccettaAcqua.setItemMeta(metaBoccetta);
        ingredienti.setItem(2, boccettaAcqua);

        // Polvere di Blaze
        ItemStack polverBlaze = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta metaPolverBlaze = polverBlaze.getItemMeta();
        metaPolverBlaze.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Polvere di Blaze");
        metaPolverBlaze.setLore(Arrays.asList(
                ChatColor.GRAY + "Combustibile per l'alambicco",
                ChatColor.GRAY + "e ingrediente per pozioni",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€400"
        ));
        polverBlaze.setItemMeta(metaPolverBlaze);
        ingredienti.setItem(3, polverBlaze);

        // Verruca del Nether
        ItemStack verrucaNether = new ItemStack(Material.NETHER_WART);
        ItemMeta metaVerruca = verrucaNether.getItemMeta();
        metaVerruca.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Verruca del Nether");
        metaVerruca.setLore(Arrays.asList(
                ChatColor.GRAY + "Base principale per pozioni",
                ChatColor.GRAY + "complesse e avanzate",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€500"
        ));
        verrucaNether.setItemMeta(metaVerruca);
        ingredienti.setItem(5, verrucaNether);

        // === RIGA SUPERIORE - INGREDIENTI COMUNI ===

        // Occhio di Ragno
        ItemStack occhioRagno = new ItemStack(Material.SPIDER_EYE);
        ItemMeta metaOcchioRagno = occhioRagno.getItemMeta();
        metaOcchioRagno.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Occhio di Ragno");
        metaOcchioRagno.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di veleno e debolezza",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€350"
        ));
        occhioRagno.setItemMeta(metaOcchioRagno);
        ingredienti.setItem(10, occhioRagno);

        // Occhio di Ragno Fermentato
        ItemStack occhioRagnoFermentato = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta metaOcchioFermentato = occhioRagnoFermentato.getItemMeta();
        metaOcchioFermentato.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Occhio di Ragno Fermentato");
        metaOcchioFermentato.setLore(Arrays.asList(
                ChatColor.GRAY + "Inverte gli effetti delle",
                ChatColor.GRAY + "pozioni positive in negative",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€600"
        ));
        occhioRagnoFermentato.setItemMeta(metaOcchioFermentato);
        ingredienti.setItem(11, occhioRagnoFermentato);

        // Zucchero
        ItemStack zucchero = new ItemStack(Material.SUGAR);
        ItemMeta metaZucchero = zucchero.getItemMeta();
        metaZucchero.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Zucchero");
        metaZucchero.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di velocità",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€250"
        ));
        zucchero.setItemMeta(metaZucchero);
        ingredienti.setItem(12, zucchero);

        // Melone Scintillante
        ItemStack meloneScintillante = new ItemStack(Material.GLISTERING_MELON_SLICE);
        ItemMeta metaMelone = meloneScintillante.getItemMeta();
        metaMelone.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Melone Scintillante");
        metaMelone.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di cura istantanea",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€800"
        ));
        meloneScintillante.setItemMeta(metaMelone);
        ingredienti.setItem(13, meloneScintillante);

        // Carota Dorata
        ItemStack carotaDorata = new ItemStack(Material.GOLDEN_CARROT);
        ItemMeta metaCarota = carotaDorata.getItemMeta();
        metaCarota.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Carota Dorata");
        metaCarota.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di visione notturna",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€700"
        ));
        carotaDorata.setItemMeta(metaCarota);
        ingredienti.setItem(14, carotaDorata);

        // Pesce Palla
        ItemStack pescePalla = new ItemStack(Material.PUFFERFISH);
        ItemMeta metaPesce = pescePalla.getItemMeta();
        metaPesce.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Pesce Palla");
        metaPesce.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di respirazione acquatica",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€650"
        ));
        pescePalla.setItemMeta(metaPesce);
        ingredienti.setItem(15, pescePalla);

        // Crema di Magma
        ItemStack cremaMagma = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta metaCrema = cremaMagma.getItemMeta();
        metaCrema.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Crema di Magma");
        metaCrema.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di resistenza al fuoco",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€900"
        ));
        cremaMagma.setItemMeta(metaCrema);
        ingredienti.setItem(16, cremaMagma);

        // === RIGA CENTRALE - INGREDIENTI AVANZATI ===

        // Lacrima di Ghast
        ItemStack lacrimaGhast = new ItemStack(Material.GHAST_TEAR);
        ItemMeta metaLacrima = lacrimaGhast.getItemMeta();
        metaLacrima.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Lacrima di Ghast");
        metaLacrima.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di rigenerazione",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1500"
        ));
        lacrimaGhast.setItemMeta(metaLacrima);
        ingredienti.setItem(19, lacrimaGhast);

        // Pietra Rossa
        ItemStack pietraRossa = new ItemStack(Material.REDSTONE);
        ItemMeta metaPietraRossa = pietraRossa.getItemMeta();
        metaPietraRossa.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Pietra Rossa");
        metaPietraRossa.setLore(Arrays.asList(
                ChatColor.GRAY + "Prolunga la durata",
                ChatColor.GRAY + "delle pozioni",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€300"
        ));
        pietraRossa.setItemMeta(metaPietraRossa);
        ingredienti.setItem(20, pietraRossa);

        // Polvere da Sparo
        ItemStack polvereSparo = new ItemStack(Material.GUNPOWDER);
        ItemMeta metaPolvereSparo = polvereSparo.getItemMeta();
        metaPolvereSparo.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Polvere da Sparo");
        metaPolvereSparo.setLore(Arrays.asList(
                ChatColor.GRAY + "Trasforma le pozioni",
                ChatColor.GRAY + "in pozioni splash",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€450"
        ));
        polvereSparo.setItemMeta(metaPolvereSparo);
        ingredienti.setItem(21, polvereSparo);

        // Pietrisco Luminoso
        ItemStack pietrisco = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta metaPietrisco = pietrisco.getItemMeta();
        metaPietrisco.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Pietrisco Luminoso");
        metaPietrisco.setLore(Arrays.asList(
                ChatColor.GRAY + "Aumenta la potenza",
                ChatColor.GRAY + "delle pozioni",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€550"
        ));
        pietrisco.setItemMeta(metaPietrisco);
        ingredienti.setItem(22, pietrisco);

        // Perla di Ender
        ItemStack perlaEnder = new ItemStack(Material.ENDER_PEARL);
        ItemMeta metaPerla = perlaEnder.getItemMeta();
        metaPerla.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Perla di Ender");
        metaPerla.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente raro per",
                ChatColor.GRAY + "pozioni speciali",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1200"
        ));
        perlaEnder.setItemMeta(metaPerla);
        ingredienti.setItem(23, perlaEnder);

        // Conchiglia di Nautilo
        ItemStack concheliaNautilo = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta metaConchiglia = concheliaNautilo.getItemMeta();
        metaConchiglia.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Conchiglia di Nautilo");
        metaConchiglia.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "tramite comandi speciali",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€1000"
        ));
        concheliaNautilo.setItemMeta(metaConchiglia);
        ingredienti.setItem(24, concheliaNautilo);

        // Membrana di Phantom
        ItemStack membranaPhantom = new ItemStack(Material.PHANTOM_MEMBRANE);
        ItemMeta metaMembrana = membranaPhantom.getItemMeta();
        metaMembrana.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Membrana di Phantom");
        metaMembrana.setLore(Arrays.asList(
                ChatColor.GRAY + "Ingrediente per pozioni",
                ChatColor.GRAY + "di caduta lenta",
                "",
                ChatColor.GOLD + "Prezzo: " + ChatColor.GREEN + "€800"
        ));
        membranaPhantom.setItemMeta(metaMembrana);
        ingredienti.setItem(25, membranaPhantom);

        // Bottone per tornare indietro
        ItemStack tornIndietro = new ItemStack(Material.ARROW);
        ItemMeta metaTorna = tornIndietro.getItemMeta();
        metaTorna.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "← Torna al Menu Principale");
        metaTorna.setLore(Collections.singletonList(ChatColor.GRAY + "Clicca per tornare al negozio principale"));
        tornIndietro.setItemMeta(metaTorna);
        ingredienti.setItem(49, tornIndietro);

        // Info wallet del giocatore
        ItemStack wallet = new ItemStack(Material.GOLD_INGOT);
        ItemMeta metaWallet = wallet.getItemMeta();
        metaWallet.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Il Tuo Portafoglio");
        metaWallet.setLore(Arrays.asList(
                ChatColor.GRAY + "Saldo attuale:",
                ChatColor.GREEN + "€" + String.format("%.2f", econManager.checkMoney(p))
        ));
        wallet.setItemMeta(metaWallet);
        ingredienti.setItem(6, wallet);

        p.openInventory(ingredienti);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != null && e.getView().getTitle().equals(plugin.getConfigManager().getIngredientiName())) {
            e.setCancelled(true);

            Player p = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();

            switch (slot) {
                case 2: // Boccetta d'Acqua
                    if (econManager.checkMoney(p) >= 200) {
                        p.getInventory().addItem(new ItemStack(Material.POTION));
                        econManager.removeMoney(p, 200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Boccetta d'Acqua per €200!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €200");
                    }
                    break;

                case 3: // Polvere di Blaze
                    if (econManager.checkMoney(p) >= 400) {
                        p.getInventory().addItem(new ItemStack(Material.BLAZE_POWDER));
                        econManager.removeMoney(p, 400);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Polvere di Blaze per €400!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €400");
                    }
                    break;

                case 5: // Verruca del Nether
                    if (econManager.checkMoney(p) >= 500) {
                        p.getInventory().addItem(new ItemStack(Material.NETHER_WART));
                        econManager.removeMoney(p, 500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Verruca del Nether per €500!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €500");
                    }
                    break;

                case 10: // Occhio di Ragno
                    if (econManager.checkMoney(p) >= 350) {
                        p.getInventory().addItem(new ItemStack(Material.SPIDER_EYE));
                        econManager.removeMoney(p, 350);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Occhio di Ragno per €350!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €350");
                    }
                    break;

                case 11: // Occhio di Ragno Fermentato
                    if (econManager.checkMoney(p) >= 600) {
                        p.getInventory().addItem(new ItemStack(Material.FERMENTED_SPIDER_EYE));
                        econManager.removeMoney(p, 600);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Occhio di Ragno Fermentato per €600!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €600");
                    }
                    break;

                case 12: // Zucchero
                    if (econManager.checkMoney(p) >= 250) {
                        p.getInventory().addItem(new ItemStack(Material.SUGAR));
                        econManager.removeMoney(p, 250);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Zucchero per €250!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €250");
                    }
                    break;

                case 13: // Melone Scintillante
                    if (econManager.checkMoney(p) >= 800) {
                        p.getInventory().addItem(new ItemStack(Material.GLISTERING_MELON_SLICE));
                        econManager.removeMoney(p, 800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Melone Scintillante per €800!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €800");
                    }
                    break;

                case 14: // Carota Dorata
                    if (econManager.checkMoney(p) >= 700) {
                        p.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT));
                        econManager.removeMoney(p, 700);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Carota Dorata per €700!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €700");
                    }
                    break;

                case 15: // Pesce Palla
                    if (econManager.checkMoney(p) >= 650) {
                        p.getInventory().addItem(new ItemStack(Material.PUFFERFISH));
                        econManager.removeMoney(p, 650);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato un Pesce Palla per €650!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €650");
                    }
                    break;

                case 16: // Crema di Magma
                    if (econManager.checkMoney(p) >= 900) {
                        p.getInventory().addItem(new ItemStack(Material.MAGMA_CREAM));
                        econManager.removeMoney(p, 900);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Crema di Magma per €900!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €900");
                    }
                    break;

                case 19: // Lacrima di Ghast
                    if (econManager.checkMoney(p) >= 1500) {
                        p.getInventory().addItem(new ItemStack(Material.GHAST_TEAR));
                        econManager.removeMoney(p, 1500);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Lacrima di Ghast per €1500!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1500");
                    }
                    break;

                case 20: // Pietra Rossa
                    if (econManager.checkMoney(p) >= 300) {
                        p.getInventory().addItem(new ItemStack(Material.REDSTONE));
                        econManager.removeMoney(p, 300);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Pietra Rossa per €300!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €300");
                    }
                    break;

                case 21: // Polvere da Sparo
                    if (econManager.checkMoney(p) >= 450) {
                        p.getInventory().addItem(new ItemStack(Material.GUNPOWDER));
                        econManager.removeMoney(p, 450);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Polvere da Sparo per €450!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €450");
                    }
                    break;

                case 22: // Pietrisco Luminoso
                    if (econManager.checkMoney(p) >= 550) {
                        p.getInventory().addItem(new ItemStack(Material.GLOWSTONE_DUST));
                        econManager.removeMoney(p, 550);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato Pietrisco Luminoso per €550!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €550");
                    }
                    break;

                case 23: // Perla di Ender
                    if (econManager.checkMoney(p) >= 1200) {
                        p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                        econManager.removeMoney(p, 1200);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Perla di Ender per €1200!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1200");
                    }
                    break;

                case 24: // Conchiglia di Nautilo
                    if (econManager.checkMoney(p) >= 1000) {
                        p.getInventory().addItem(new ItemStack(Material.NAUTILUS_SHELL));
                        econManager.removeMoney(p, 1000);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Conchiglia di Nautilo per €1000!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €1000");
                    }
                    break;

                case 25: // Membrana di Phantom
                    if (econManager.checkMoney(p) >= 800) {
                        p.getInventory().addItem(new ItemStack(Material.PHANTOM_MEMBRANE));
                        econManager.removeMoney(p, 800);
                        p.sendMessage(ChatColor.GREEN + "Hai acquistato una Membrana di Phantom per €800!");
                        openIngredientiPozioni(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "Fondi insufficienti! Servono €800");
                    }
                    break;

                case 49: // Torna indietro
                    shop.openShop(p);
                    break;
            }
        }
    }
}