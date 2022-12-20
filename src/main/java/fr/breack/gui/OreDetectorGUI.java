package fr.breack.gui;

import fr.breack.main.Main;
import fr.breack.utils.FoundASpecificBlockInAnArea;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OreDetectorGUI implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myCustomGuiOreDetector")
            .provider(new OreDetectorGUI())
            .size(3, 9)
            .title(Main.getInstance().getMyDetectorOreItem().getItemStackItem().getItemMeta().getDisplayName())
            .build();
    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        player.sendMessage("Nous vérifions dans un périmètre de 50 blocks ...");

        inventoryContents.set(1, 1, ClickableItem.of(new ItemStack(Material.COAL),
                e -> {new FoundASpecificBlockInAnArea(player, Material.COAL_ORE, 50);player.closeInventory();}));
        inventoryContents.set(1, 2, ClickableItem.of(new ItemStack(Material.LAPIS_ORE),
                e -> {new FoundASpecificBlockInAnArea(player, Material.LAPIS_ORE, 50);player.closeInventory();}));
        inventoryContents.set(1, 3, ClickableItem.of(new ItemStack(Material.IRON_ORE),
                e -> {new FoundASpecificBlockInAnArea(player, Material.IRON_ORE, 50);player.closeInventory();}));
        inventoryContents.set(1, 5, ClickableItem.of(new ItemStack(Material.GOLD_ORE),
                e -> {new FoundASpecificBlockInAnArea(player, Material.GOLD_ORE, 50);player.closeInventory();}));
        inventoryContents.set(1, 6, ClickableItem.of(new ItemStack(Material.DIAMOND_ORE),
                e -> {new FoundASpecificBlockInAnArea(player, Material.DIAMOND_ORE, 50);player.closeInventory();}));
        inventoryContents.set(1, 7, ClickableItem.of(new ItemStack(Material.EMERALD_ORE),
                e -> {new FoundASpecificBlockInAnArea(player, Material.EMERALD_ORE, 50);player.closeInventory();}));

        inventoryContents.set(1, 4, ClickableItem.of(new ItemStack(Material.BARRIER),
                e -> player.closeInventory()));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
