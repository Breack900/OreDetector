package fr.breack.main;

import fr.breack.commands.GiveOreDetectorItemCMD;
import fr.breack.itemstoinit.DetectorOreItem;
import fr.breack.constructor.CustomItemConstructor;
import fr.breack.listeners.PlayerInteractListener;
import fr.minuskube.inv.InventoryManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Getter
    public static Main instance;

    @Getter
    CustomItemConstructor myDetectorOreItem = new CustomItemConstructor();

    @Override
    public void onEnable() {
        instance = this;

        new DetectorOreItem();

        getCommand("GiveOreDetector").setExecutor(new GiveOreDetectorItemCMD());

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);


    }

}
