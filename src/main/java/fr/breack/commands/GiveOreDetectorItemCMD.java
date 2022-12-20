package fr.breack.commands;

import fr.breack.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveOreDetectorItemCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player))
            return true;

        if(!(commandSender.hasPermission(Main.getInstance().getMyDetectorOreItem().getPermissionItem())))
            return true;

        Player player = (Player) commandSender;

        player.sendMessage("Vous venez de vous donner un super item pour tricher !");

        player.getInventory().addItem(Main.getInstance().getMyDetectorOreItem().getItemStackItem());
        return false;

    }
}
