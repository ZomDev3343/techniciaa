package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;

public class BaseItemHoe extends HoeItem {

    public BaseItemHoe(IItemTier itemTier, ItemGroup group) {
        super(itemTier, 0, -3.0f, new Properties().tab(group));
    }

    public BaseItemHoe(IItemTier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
