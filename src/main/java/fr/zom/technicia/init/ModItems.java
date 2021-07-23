package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.items.*;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
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

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new BaseItemSword(ModItemTiers.COPPER));
    public static final RegistryObject<Item> OSMIUM_SWORD = ITEMS.register("osmium_sword", () -> new BaseItemSword(ModItemTiers.OSMIUM));
    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword", () -> new BaseItemSword(ModItemTiers.SILVER));
    public static final RegistryObject<Item> LEAD_SWORD = ITEMS.register("lead_sword", () -> new BaseItemSword(ModItemTiers.LEAD));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new BaseItemSword(ModItemTiers.TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_SWORD = ITEMS.register("platinum_sword", () -> new BaseItemSword(ModItemTiers.PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_SWORD = ITEMS.register("niobium_sword", () -> new BaseItemSword(ModItemTiers.NIOBIUM));

    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.COPPER));
    public static final RegistryObject<Item> OSMIUM_PICKAXE = ITEMS.register("osmium_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.OSMIUM));
    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.SILVER));
    public static final RegistryObject<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.LEAD));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_PICKAXE = ITEMS.register("niobium_pickaxe", () -> new BaseItemPickaxe(ModItemTiers.NIOBIUM));

    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new BaseItemAxe(ModItemTiers.COPPER));
    public static final RegistryObject<Item> OSMIUM_AXE = ITEMS.register("osmium_axe", () -> new BaseItemAxe(ModItemTiers.OSMIUM));
    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () -> new BaseItemAxe(ModItemTiers.SILVER));
    public static final RegistryObject<Item> LEAD_AXE = ITEMS.register("lead_axe", () -> new BaseItemAxe(ModItemTiers.LEAD));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new BaseItemAxe(ModItemTiers.TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new BaseItemAxe(ModItemTiers.PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_AXE = ITEMS.register("niobium_axe", () -> new BaseItemAxe(ModItemTiers.NIOBIUM));

    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new BaseItemShovel(ModItemTiers.COPPER));
    public static final RegistryObject<Item> OSMIUM_SHOVEL = ITEMS.register("osmium_shovel", () -> new BaseItemShovel(ModItemTiers.OSMIUM));
    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () -> new BaseItemShovel(ModItemTiers.SILVER));
    public static final RegistryObject<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel", () -> new BaseItemShovel(ModItemTiers.LEAD));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel", () -> new BaseItemShovel(ModItemTiers.TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_SHOVEL = ITEMS.register("platinum_shovel", () -> new BaseItemShovel(ModItemTiers.PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_SHOVEL = ITEMS.register("niobium_shovel", () -> new BaseItemShovel(ModItemTiers.NIOBIUM));

    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new BaseItemHoe(ModItemTiers.COPPER));
    public static final RegistryObject<Item> OSMIUM_HOE = ITEMS.register("osmium_hoe", () -> new BaseItemHoe(ModItemTiers.OSMIUM));
    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () -> new BaseItemHoe(ModItemTiers.SILVER));
    public static final RegistryObject<Item> LEAD_HOE = ITEMS.register("lead_hoe", () -> new BaseItemHoe(ModItemTiers.LEAD));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new BaseItemHoe(ModItemTiers.TUNGSTEN));
    public static final RegistryObject<Item> PLATINUM_HOE = ITEMS.register("platinum_hoe", () -> new BaseItemHoe(ModItemTiers.PLATINUM));
    public static final RegistryObject<Item> NIOBIUM_HOE = ITEMS.register("niobium_hoe", () -> new BaseItemHoe(ModItemTiers.NIOBIUM));


    public enum ModItemTiers implements IItemTier {

//        WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
//            return Ingredient.of(ItemTags.PLANKS);
//        }),
//        STONE(1, 131, 4.0F, 1.0F, 5, () -> {
//            return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);
//        }),
//        IRON(2, 250, 6.0F, 2.0F, 14, () -> {
//            return Ingredient.of(Items.IRON_INGOT);
//        }),
//        DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
//            return Ingredient.of(Items.DIAMOND);
//        }),
//        GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//            return Ingredient.of(Items.GOLD_INGOT);
//        }),
//        NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
//            return Ingredient.of(Items.NETHERITE_INGOT);
//        });

        COPPER(1, 160, 4.5f, 1.5f, 6, Ingredient.of(ModItems.COPPER_INGOT.get())),
        OSMIUM(1, 220, 5f, 1.8f, 10, Ingredient.of(ModItems.OSMIUM_INGOT.get())),
        SILVER(2, 550, 8f, 2f, 15, Ingredient.of(ModItems.SILVER_INGOT.get())),
        LEAD(2, 1400, 6f, 2.5f, 4, Ingredient.of(ModItems.LEAD_INGOT.get())),
        TUNGSTEN(3, 2000, 7f, 3.5f, 5, Ingredient.of(ModItems.TUNGSTEN_INGOT.get())),
        PLATINUM(3, 1400, 12f, 3f, 20, Ingredient.of(ModItems.PLATINUM_INGOT.get())),
        NIOBIUM(3, 5000, 10f, 4.5f, 12, Ingredient.of(ModItems.NIOBIUM_INGOT.get()));


        private int uses;
        private float speed;
        private float attackBonus;
        private int harvestLevel;
        private int enchantValue;
        private Ingredient repairIngredient;

        ModItemTiers(int harvestLevel, int uses, float speed, float attackBonus, int enchantValue, Ingredient repairIngredient) {
            this.uses = uses;
            this.speed = speed;
            this.attackBonus = attackBonus;
            this.harvestLevel = harvestLevel;
            this.enchantValue = enchantValue;
            this.repairIngredient = repairIngredient;
        }

        @Override
        public int getUses() {
            return this.uses;
        }

        @Override
        public float getSpeed() {
            return this.speed;
        }

        @Override
        public float getAttackDamageBonus() {
            return this.attackBonus;
        }

        @Override
        public int getLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantValue;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairIngredient;
        }
    }


}
