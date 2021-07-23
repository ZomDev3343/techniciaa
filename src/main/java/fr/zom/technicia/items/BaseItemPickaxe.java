package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class BaseItemPickaxe extends PickaxeItem {

    public BaseItemPickaxe(IItemTier itemTier, ItemGroup group) {
        super(itemTier, 1, -2.8f, new Properties().tab(group));
    }

    public BaseItemPickaxe(IItemTier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
