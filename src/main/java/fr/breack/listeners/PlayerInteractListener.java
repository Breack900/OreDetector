package fr.breack.listeners;

import fr.breack.gui.OreDetectorGUI;
import fr.breack.main.Main;
import fr.breack.utils.Cuboid;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collections;
import java.util.Iterator;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent playerInteractEvent){

        Player player = playerInteractEvent.getPlayer();

        if(!playerInteractEvent.hasItem())
            return;
        if(!playerInteractEvent.getItem().hasItemMeta())
            return;

        if(playerInteractEvent.getItem().getItemMeta().equals(Main.getInstance().getMyDetectorOreItem().getItemStackItem().getItemMeta())){
            playerInteractEvent.setCancelled(true);

            player.sendMessage("Vous venez d'utiliser votre détecteur de minerai !");

            OreDetectorGUI.INVENTORY.open(player);
        }
    }
}
