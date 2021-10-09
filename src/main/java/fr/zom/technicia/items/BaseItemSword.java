package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class BaseItemSword extends SwordItem {

    public BaseItemSword(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 3, -2.4f, new Item.Properties().tab(group));
    }

    public BaseItemSword(Tier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
