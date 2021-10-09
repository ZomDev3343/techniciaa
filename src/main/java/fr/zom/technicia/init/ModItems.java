package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.items.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Technicia.MODID);

    private static final ForgeTier COPPER = new ForgeTier(1, 160, 4.5f, 1.5f,
            6, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.COPPER_INGOT.get()));

    private static final ForgeTier OSMIUM = new ForgeTier(1, 220, 5f, 1.8f,
            10, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.OSMIUM_INGOT.get()));

    private static final ForgeTier SILVER = new ForgeTier(2, 550, 8f, 2f,
            15, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.SILVER_INGOT.get()));

    private static final ForgeTier LEAD = new ForgeTier(2, 1400, 6f, 2.5f,
            4, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.LEAD_INGOT.get()));


    private static final ForgeTier TUNGSTEN = new ForgeTier(3, 2000, 7f, 3.5f,
            5, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get()));


    private static final ForgeTier PLATINUM = new ForgeTier(3, 1400, 12f, 3f,
            200, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.PLATINUM_INGOT.get()));

    private static final ForgeTier NIOBIUM = new ForgeTier(3, 5000, 10f, 4.5f,
            12, BlockTags.MINEABLE_WITH_PICKAXE,
            () -> Ingredient.of(ModItems.NIOBIUM_INGOT.get()));


    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", BaseItem::new);
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", BaseItem::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", BaseItem::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", BaseItem::new);
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", BaseItem::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", BaseItem::new);
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", BaseItem::new);

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new BaseItemSword(COPPER));
    public static final RegistryObject<Item> OSMIUM_SWORD = ITEMS.register("osmium_sword", () -> new BaseItemSword(OSMIUM));
    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () -> new BaseItemSword(SILVER));
    public static final RegistryObject<Item> LEAD_SWORD = ITEMS.register("lead_sword", () -> new BaseItemSword(LEAD));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new BaseItemSword(TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new BaseItemSword(PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_SWORD = ITEMS.register("niobium_sword", () -> new BaseItemSword(NIOBIUM));

    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new BaseItemPickaxe(COPPER));
    public static final RegistryObject<Item> OSMIUM_PICKAXE = ITEMS.register("osmium_pickaxe", () -> new BaseItemPickaxe(OSMIUM));
    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new BaseItemPickaxe(SILVER));
    public static final RegistryObject<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe", () -> new BaseItemPickaxe(LEAD));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new BaseItemPickaxe(TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new BaseItemPickaxe(PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_PICKAXE = ITEMS.register("niobium_pickaxe", () -> new BaseItemPickaxe(NIOBIUM));

    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new BaseItemAxe(COPPER));
    public static final RegistryObject<Item> OSMIUM_AXE = ITEMS.register("osmium_axe", () -> new BaseItemAxe(OSMIUM));
    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () -> new BaseItemAxe(SILVER));
    public static final RegistryObject<Item> LEAD_AXE = ITEMS.register("lead_axe", () -> new BaseItemAxe(LEAD));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new BaseItemAxe(TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new BaseItemAxe(PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_AXE = ITEMS.register("niobium_axe", () -> new BaseItemAxe(NIOBIUM));

    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new BaseItemShovel(COPPER));
    public static final RegistryObject<Item> OSMIUM_SHOVEL = ITEMS.register("osmium_shovel", () -> new BaseItemShovel(OSMIUM));
    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () -> new BaseItemShovel(SILVER));
    public static final RegistryObject<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel", () -> new BaseItemShovel(LEAD));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel", () -> new BaseItemShovel(TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new BaseItemShovel(PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_SHOVEL = ITEMS.register("niobium_shovel", () -> new BaseItemShovel(NIOBIUM));

    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new BaseItemHoe(COPPER));
    public static final RegistryObject<Item> OSMIUM_HOE = ITEMS.register("osmium_hoe", () -> new BaseItemHoe(OSMIUM));
    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () -> new BaseItemHoe(SILVER));
    public static final RegistryObject<Item> LEAD_HOE = ITEMS.register("lead_hoe", () -> new BaseItemHoe(LEAD));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new BaseItemHoe(TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new BaseItemHoe(PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_HOE = ITEMS.register("niobium_hoe", () -> new BaseItemHoe(NIOBIUM));

    public static final RegistryObject<Item> ORE_BAG = ITEMS.register("ore_bag", ItemOreBag::new);

}
