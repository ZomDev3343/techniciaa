package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.items.BaseItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Technicia.MODID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", BaseItem::new);
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", BaseItem::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", BaseItem::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", BaseItem::new);
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", BaseItem::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", BaseItem::new);
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", BaseItem::new);


}
