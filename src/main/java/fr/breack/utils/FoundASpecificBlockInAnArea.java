package fr.breack.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FoundASpecificBlockInAnArea {

    public FoundASpecificBlockInAnArea(Player player, Material material,int radius){
        boolean ore = false;

        Location location = player.getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        World w = location.getWorld();
        Location loc = new Location(w, x + radius, y + radius, z + radius);

        Location location2 = player.getLocation();
        int x2 = location2.getBlockX();
        int y2 = location2.getBlockY();
        int z2 = location2.getBlockZ();
        World w2 = location2.getWorld();
        Location loc2 = new Location(w2, x2 - radius, y2 - radius, z2 - radius);

        ArrayList<Location> locationOfOre = new ArrayList<>();

        Iterator<Block> cuboid = new Cuboid(loc, loc2).blockList();

        while(cuboid.hasNext()) {

            if (!cuboid.next().getBlockData().getMaterial().equals(material))
                continue;

            ore = true;

            if(material.equals(Material.COAL_ORE))
                locationOfOre.add(cuboid.next().getLocation());
            else if (material.equals(Material.LAPIS_ORE))
                locationOfOre.add(cuboid.next().getLocation());
            else if (material.equals(Material.IRON_ORE))
                locationOfOre.add(cuboid.next().getLocation());
            else if (material.equals(Material.GOLD_ORE))
                locationOfOre.add(cuboid.next().getLocation());
            else if (material.equals(Material.DIAMOND_ORE))
                locationOfOre.add(cuboid.next().getLocation());
            else if (material.equals(Material.EMERALD_ORE))
                locationOfOre.add(cuboid.next().getLocation());
        }

        if(ore){

            player.sendMessage("Minerai trouvé ^^ ");

            TreeMap<Integer, Location> allDistancesOfPlayerAndOre = new TreeMap<>();

            for(Location myAllLocationOfOre : locationOfOre.stream().toList()){
                allDistancesOfPlayerAndOre.put((int) player.getLocation().distance(myAllLocationOfOre), myAllLocationOfOre);
            }



            player.setCompassTarget(allDistancesOfPlayerAndOre.firstEntry().getValue());
        }else
            player.sendMessage("Minerai non trouvé ... ;c ");


    }
}
