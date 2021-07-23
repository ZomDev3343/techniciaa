package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class BaseItemSword extends SwordItem {

    public BaseItemSword(IItemTier itemTier, ItemGroup group) {
        super(itemTier, 3, -2.4f, new Item.Properties().tab(group));
    }

    public BaseItemSword(IItemTier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
