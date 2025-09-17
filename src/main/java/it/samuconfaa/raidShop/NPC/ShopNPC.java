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
import net.citizensnpcs.trait.SkinTrait;

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

    public void setSkin(NPC npc, String nick) {
        if (npc.isSpawned()) {
            SkinTrait skinTrait = npc.getTrait(SkinTrait.class);
            if (skinTrait == null) {
                skinTrait = new SkinTrait();
                npc.addTrait(skinTrait);
            }
            skinTrait.setSkinName(nick);
        }
    }

    public static void setRandomSkin(NPC npc) {
        UUID uuid = UUID.randomUUID();
        npc.data().set("player-skin", uuid.toString());
    }
}