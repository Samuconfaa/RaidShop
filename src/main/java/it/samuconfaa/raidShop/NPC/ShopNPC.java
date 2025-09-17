package it.samuconfaa.raidShop.NPC;

import it.samuconfaa.raidShop.RaidShop;
import it.samuconfaa.raidShop.shopgui.Shop;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.Trait;
import net.citizensnpcs.api.trait.TraitInfo;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class ShopNPC implements Listener {
    private final RaidShop plugin;
    public final Shop shop;

    public ShopNPC(RaidShop plugin, Shop shop) {
        this.plugin = plugin;
        this.shop = shop;
    }

    public void createNPC(Player p, String name){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, plugin.getConfigManager().getNpcName());
        npc.spawn(p.getLocation());
        setSkin(npc, name);
    }

    public void createNPC(Player p){
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, plugin.getConfigManager().getNpcName());
        npc.spawn(p.getLocation());
        setRandomSkin(npc);
    }

    @EventHandler
    public void onNPCRightClick(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();
        if (npc.getName().equals(plugin.getConfigManager().getNpcName())){
            String command = "shopraid";
            player.performCommand(command);
        }
    }

    public void setSkin(NPC npc, String nick) {
        if (npc.isSpawned()) {
            try {
                // Riflessione per accedere a metodi e classi private
                Class<?> playerNPCTraitClass = Class.forName("net.citizensnpcs.api.npc.trait.PlayerSkinTrait");
                Object playerNPCTrait = npc.getTrait(playerNPCTraitClass.asSubclass(net.citizensnpcs.api.trait.Trait.class));

                // Invoca il metodo setSkinName sul trait
                playerNPCTraitClass.getMethod("setSkinName", String.class).invoke(playerNPCTrait, nick);

                // Imposta il nome dell'NPC separatamente
                npc.setName(plugin.getConfigManager().getNpcName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setRandomSkin(NPC npc) {
        UUID uuid = UUID.randomUUID();
        npc.data().set("player-skin", uuid.toString());
    }
}
