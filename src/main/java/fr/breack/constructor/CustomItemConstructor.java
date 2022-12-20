package fr.breack.constructor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class CustomItemConstructor {

    String nameItem;

    String permissionItem;

    List<String> loreItem = new ArrayList<>();

    ItemStack itemStackItem;
}
