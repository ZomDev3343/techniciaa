package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BaseItemPickaxe extends PickaxeItem {

    public BaseItemPickaxe(Tier itemTier, CreativeModeTab group) {
        super(itemTier, 1, -2.8f, new Properties().tab(group));
    }

    public BaseItemPickaxe(Tier itemTier) {
        this(itemTier, Technicia.ITEMS);
    }
}
