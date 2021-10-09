package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;

public class BaseItemAxe extends AxeItem {

    public BaseItemAxe(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 5f, -3.2f, new Properties().tab(group));
    }

    public BaseItemAxe(Tier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
