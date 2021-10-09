package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {

    public BaseItem(Properties properties) {
        super(properties);
    }

    public BaseItem(CreativeModeTab group, int maxStackSize, int maxDamage) {
        this(new Properties().tab(group).stacksTo(maxStackSize).defaultDurability(maxDamage));
    }

    public BaseItem(CreativeModeTab group, int maxStackSize) {
        this(new Properties().tab(group).stacksTo(maxStackSize));
    }

    public BaseItem(CreativeModeTab group) {
        this(new Properties().tab(group));
    }

    public BaseItem() {
        this(Technicia.ITEMS);
    }
}
