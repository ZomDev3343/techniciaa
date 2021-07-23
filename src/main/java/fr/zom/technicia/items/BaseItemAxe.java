package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;

public class BaseItemAxe extends AxeItem {

    public BaseItemAxe(IItemTier itemTier, ItemGroup group) {
        super(itemTier, 5f, -3.2f, new Properties().tab(group));
    }

    public BaseItemAxe(IItemTier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
