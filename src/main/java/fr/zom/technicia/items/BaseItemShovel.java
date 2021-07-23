package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;

public class BaseItemShovel extends ShovelItem {

    public BaseItemShovel(IItemTier itemTier, ItemGroup group) {
        super(itemTier, 1.5f, -3.0f, new Properties().tab(group));
    }

    public BaseItemShovel(IItemTier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
