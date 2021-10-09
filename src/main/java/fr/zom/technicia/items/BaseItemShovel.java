package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class BaseItemShovel extends ShovelItem {

    public BaseItemShovel(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 1.5f, -3.0f, new Properties().tab(group));
    }

    public BaseItemShovel(Tier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
