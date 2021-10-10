package fr.zom.technicia.data.recipes;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.init.ModBlocks;
import fr.zom.technicia.init.ModItems;
import fr.zom.technicia.init.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ingotsToBlock(consumer, "copper_ingots_to_block", ModItems.COPPER_INGOT.get(), ModBlocks.COPPER_BLOCK.get());
        ingotsToBlock(consumer, "osmium_ingots_to_block", ModItems.OSMIUM_INGOT.get(), ModBlocks.OSMIUM_BLOCK.get());
        ingotsToBlock(consumer, "silver_ingots_to_block", ModItems.SILVER_INGOT.get(), ModBlocks.SILVER_BLOCK.get());
        ingotsToBlock(consumer, "lead_ingots_to_block", ModItems.LEAD_INGOT.get(), ModBlocks.LEAD_BLOCK.get());
        ingotsToBlock(consumer, "tungsten_ingots_to_block", ModItems.TUNGSTEN_INGOT.get(), ModBlocks.TUNGSTEN_BLOCK.get());
        ingotsToBlock(consumer, "platinum_ingots_to_block", ModItems.PLATINUM_INGOT.get(), ModBlocks.PLATINUM_BLOCK.get());
        ingotsToBlock(consumer, "niobium_ingots_to_block", ModItems.NIOBIUM_INGOT.get(), ModBlocks.NIOBIUM_BLOCK.get());

        blockToIngots(consumer, "copper_block_to_ingots", ModItems.COPPER_INGOT.get(), ModBlocks.COPPER_BLOCK.get());
        blockToIngots(consumer, "osmium_block_to_ingots", ModItems.OSMIUM_INGOT.get(), ModBlocks.OSMIUM_BLOCK.get());
        blockToIngots(consumer, "silver_block_to_ingots", ModItems.SILVER_INGOT.get(), ModBlocks.SILVER_BLOCK.get());
        blockToIngots(consumer, "lead_block_to_ingots", ModItems.LEAD_INGOT.get(), ModBlocks.LEAD_BLOCK.get());
        blockToIngots(consumer, "tungsten_block_to_ingots", ModItems.TUNGSTEN_INGOT.get(), ModBlocks.TUNGSTEN_BLOCK.get());
        blockToIngots(consumer, "platinum_block_to_ingots", ModItems.PLATINUM_INGOT.get(), ModBlocks.PLATINUM_BLOCK.get());
        blockToIngots(consumer, "niobium_block_to_ingots", ModItems.NIOBIUM_INGOT.get(), ModBlocks.NIOBIUM_BLOCK.get());

        sword(consumer, "copper_sword", ModTags.COPPER_INGOTS, ModTags.STICKS, ModItems.COPPER_SWORD.get());
        sword(consumer, "osmium_sword", ModTags.OSMIUM_INGOTS, ModTags.STICKS, ModItems.OSMIUM_SWORD.get());
        sword(consumer, "silver_sword", ModTags.SILVER_INGOTS, ModTags.STICKS, ModItems.SILVER_SWORD.get());
        sword(consumer, "lead_sword", ModTags.LEAD_INGOTS, ModTags.STICKS, ModItems.LEAD_SWORD.get());
        sword(consumer, "tungsten_sword", ModTags.TUNGSTEN_INGOTS, ModTags.STICKS, ModItems.TUNGSTEN_SWORD.get());
        sword(consumer, "platinum_sword", ModTags.PLATINUM_INGOTS, ModTags.STICKS, ModItems.PLATINUM_SWORD.get());
        sword(consumer, "niobium_sword", ModTags.NIOBIUM_INGOTS, ModTags.STICKS, ModItems.NIOBIUM_SWORD.get());

        pickaxe(consumer, "copper_pickaxe", ModTags.COPPER_INGOTS, ModTags.STICKS, ModItems.COPPER_PICKAXE.get());
        pickaxe(consumer, "osmium_pickaxe", ModTags.OSMIUM_INGOTS, ModTags.STICKS, ModItems.OSMIUM_PICKAXE.get());
        pickaxe(consumer, "silver_pickaxe", ModTags.SILVER_INGOTS, ModTags.STICKS, ModItems.SILVER_PICKAXE.get());
        pickaxe(consumer, "lead_pickaxe", ModTags.LEAD_INGOTS, ModTags.STICKS, ModItems.LEAD_PICKAXE.get());
        pickaxe(consumer, "tungsten_pickaxe", ModTags.TUNGSTEN_INGOTS, ModTags.STICKS, ModItems.TUNGSTEN_PICKAXE.get());
        pickaxe(consumer, "platinum_pickaxe", ModTags.PLATINUM_INGOTS, ModTags.STICKS, ModItems.PLATINUM_PICKAXE.get());
        pickaxe(consumer, "niobium_pickaxe", ModTags.NIOBIUM_INGOTS, ModTags.STICKS, ModItems.NIOBIUM_PICKAXE.get());

        axe(consumer, "copper_axe", ModTags.COPPER_INGOTS, ModTags.STICKS, ModItems.COPPER_AXE.get());
        axe(consumer, "osmium_axe", ModTags.OSMIUM_INGOTS, ModTags.STICKS, ModItems.OSMIUM_AXE.get());
        axe(consumer, "silver_axe", ModTags.SILVER_INGOTS, ModTags.STICKS, ModItems.SILVER_AXE.get());
        axe(consumer, "lead_axe", ModTags.LEAD_INGOTS, ModTags.STICKS, ModItems.LEAD_AXE.get());
        axe(consumer, "tungsten_axe", ModTags.TUNGSTEN_INGOTS, ModTags.STICKS, ModItems.TUNGSTEN_AXE.get());
        axe(consumer, "platinum_axe", ModTags.PLATINUM_INGOTS, ModTags.STICKS, ModItems.PLATINUM_AXE.get());
        axe(consumer, "niobium_axe", ModTags.NIOBIUM_INGOTS, ModTags.STICKS, ModItems.NIOBIUM_AXE.get());

        shovel(consumer, "copper_shovel", ModTags.COPPER_INGOTS, ModTags.STICKS, ModItems.COPPER_SHOVEL.get());
        shovel(consumer, "osmium_shovel", ModTags.OSMIUM_INGOTS, ModTags.STICKS, ModItems.OSMIUM_SHOVEL.get());
        shovel(consumer, "silver_shovel", ModTags.SILVER_INGOTS, ModTags.STICKS, ModItems.SILVER_SHOVEL.get());
        shovel(consumer, "lead_shovel", ModTags.LEAD_INGOTS, ModTags.STICKS, ModItems.LEAD_SHOVEL.get());
        shovel(consumer, "tungsten_shovel", ModTags.TUNGSTEN_INGOTS, ModTags.STICKS, ModItems.TUNGSTEN_SHOVEL.get());
        shovel(consumer, "platinum_shovel", ModTags.PLATINUM_INGOTS, ModTags.STICKS, ModItems.PLATINUM_SHOVEL.get());
        shovel(consumer, "niobium_shovel", ModTags.NIOBIUM_INGOTS, ModTags.STICKS, ModItems.NIOBIUM_SHOVEL.get());

        hoe(consumer, "copper_hoe", ModTags.COPPER_INGOTS, ModTags.STICKS, ModItems.COPPER_HOE.get());
        hoe(consumer, "osmium_hoe", ModTags.OSMIUM_INGOTS, ModTags.STICKS, ModItems.OSMIUM_HOE.get());
        hoe(consumer, "silver_hoe", ModTags.SILVER_INGOTS, ModTags.STICKS, ModItems.SILVER_HOE.get());
        hoe(consumer, "lead_hoe", ModTags.LEAD_INGOTS, ModTags.STICKS, ModItems.LEAD_HOE.get());
        hoe(consumer, "tungsten_hoe", ModTags.TUNGSTEN_INGOTS, ModTags.STICKS, ModItems.TUNGSTEN_HOE.get());
        hoe(consumer, "platinum_hoe", ModTags.PLATINUM_INGOTS, ModTags.STICKS, ModItems.PLATINUM_HOE.get());
        hoe(consumer, "niobium_hoe", ModTags.NIOBIUM_INGOTS, ModTags.STICKS, ModItems.NIOBIUM_HOE.get());

        oreSmelting(consumer, "copper_raw_to_ingot", ModTags.COPPER_RAW, ModItems.COPPER_INGOT.get());
        oreSmelting(consumer, "osmium_raw_to_ingot", ModTags.OSMIUM_RAW, ModItems.OSMIUM_INGOT.get());
        oreSmelting(consumer, "silver_raw_to_ingot", ModTags.SILVER_RAW, ModItems.SILVER_INGOT.get());
        oreSmelting(consumer, "lead_raw_to_ingot", ModTags.LEAD_RAW, ModItems.LEAD_INGOT.get());
        oreSmelting(consumer, "tungsten_raw_to_ingot", ModTags.TUNGSTEN_RAW, ModItems.TUNGSTEN_INGOT.get());
        oreSmelting(consumer, "platinum_raw_to_ingot", ModTags.PLATINUM_RAW, ModItems.PLATINUM_INGOT.get());
        oreSmelting(consumer, "niobium_raw_to_ingot", ModTags.NIOBIUM_RAW, ModItems.NIOBIUM_INGOT.get());

    }

    private void ingotsToBlock(Consumer<FinishedRecipe> consumer, String name, ItemLike ingots, ItemLike block) {
        ShapedRecipeBuilder.shaped(block)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ingots)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ingots))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void blockToIngots(Consumer<FinishedRecipe> consumer, String name, ItemLike ingots, ItemLike block) {
        ShapelessRecipeBuilder.shapeless(ingots, 9)
                .requires(block)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void sword(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void pickaxe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void axe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void shovel(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void hoe(Consumer<FinishedRecipe> consumer, String name, Tag<Item> material, Tag<Item> stick, ItemLike result) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("AA")
                .pattern(" S")
                .pattern(" S")
                .define('A', material)
                .define('S', stick)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(material).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience, int cookingTime)
    {
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), result, experience, cookingTime)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ore).build()))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result, float experience)
    {
        oreSmelting(consumer, name, ore, result, experience, 200);
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, String name, Tag<Item> ore, ItemLike result)
    {
        oreSmelting(consumer, name, ore, result, 0.1f, 200);
    }

}
