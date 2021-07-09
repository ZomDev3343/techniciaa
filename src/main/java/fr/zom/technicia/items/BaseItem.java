package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BaseItem extends Item {

    public BaseItem(Properties properties) {
        super(properties);
    }

    public BaseItem(ItemGroup group, int maxStackSize, int maxDamage) {
        this(new Properties().tab(group).stacksTo(maxStackSize).defaultDurability(maxDamage));
    }

    public BaseItem(ItemGroup group, int maxStackSize) {
        this(new Properties().tab(group).stacksTo(maxStackSize));
    }

    public BaseItem(ItemGroup group) {
        this(new Properties().tab(group));
    }

    public BaseItem() {
        this(Technicia.ITEMS);
    }
}
