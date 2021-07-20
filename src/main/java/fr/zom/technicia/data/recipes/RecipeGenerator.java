package fr.zom.technicia.data.recipes;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.init.ModBlocks;
import fr.zom.technicia.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class RecipeGenerator extends ForgeRecipeProvider {

    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

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

    }

    private void ingotsToBlock(Consumer<IFinishedRecipe> consumer, String name, IItemProvider ingots, IItemProvider block)
    {
        ShapedRecipeBuilder.shaped(block)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ingots)
                .unlockedBy("unlock", hasItems(ingots))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private void blockToIngots(Consumer<IFinishedRecipe> consumer, String name, IItemProvider ingots, IItemProvider block)
    {
        ShapelessRecipeBuilder.shapeless(ingots, 9)
                .requires(block)
                .unlockedBy("unlock", hasItems(block))
                .save(consumer, new ResourceLocation(Technicia.MODID, name));
    }

    private InventoryChangeTrigger.Instance hasItems(IItemProvider... items)
    {
        return InventoryChangeTrigger.Instance.hasItems(items);
    }


}
