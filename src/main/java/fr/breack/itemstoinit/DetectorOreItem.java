package fr.breack.itemstoinit;

import fr.breack.main.Main;
import fr.breack.utils.CreateCustomItemUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DetectorOreItem {

    public DetectorOreItem(){

        Main.getInstance().getMyDetectorOreItem().setNameItem("Ore Detector");

        Main.getInstance().getMyDetectorOreItem().setPermissionItem("detector.give");

        List<String> loreItem = new ArrayList<>();

        loreItem.add("Une super détecteur pour tricher");
        loreItem.add("amusez-vous bien ^^/");

        Main.getInstance().getMyDetectorOreItem().setLoreItem(loreItem);

        Main.getInstance().getMyDetectorOreItem().setItemStackItem(new CreateCustomItemUtil().CreateCustomItem(Material.COMPASS, "§l§b-= Détecteur de minerai =-", loreItem));
    }
}
