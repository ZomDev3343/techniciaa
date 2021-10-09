package fr.zom.technicia.data.other.tags;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.DataGen;
import fr.zom.technicia.init.ModBlocks;
import fr.zom.technicia.init.ModItems;
import fr.zom.technicia.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class ItemTagGenerator extends ItemTagsProvider {

    private final Tag.Named<Item> PICKAXE = ItemTags.bind("minecraft:mineable/pickaxe");
    private final Tag.Named<Item> AXE = ItemTags.bind("minecraft:mineable/axe");
    private final Tag.Named<Item> SHOVEL = ItemTags.bind("minecraft:mineable/shovel");
    private final Tag.Named<Item> HOE = ItemTags.bind("minecraft:mineable/hoe");

    private final Tag.Named<Item> WOOD_LEVEL = ItemTags.bind("forge:needs_wood_tool");
    private final Tag.Named<Item> GOLD_LEVEL = ItemTags.bind("forge:needs_gold_tool");
    private final Tag.Named<Item> STONE_LEVEL = ItemTags.bind("minecraft:needs_stone_tool");
    private final Tag.Named<Item> IRON_LEVEL = ItemTags.bind("minecraft:needs_iron_tool");
    private final Tag.Named<Item> DIAMOND_LEVEL = ItemTags.bind("minecraft:needs_diamond_tool");
    private final Tag.Named<Item> NETHERITE_LEVEL = ItemTags.bind("forge:needs_netherite_tool");

    public enum ItemTier
    {
        WOOD, GOLD, STONE, IRON, DIAMOND, NETHERITE;
    }

    public ItemTagGenerator(DataGenerator gen, BlockTagsProvider blockTagProvider) {
        super(gen, blockTagProvider, Technicia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {

        tag(ModTags.STICKS).add(Items.STICK);
        tag(ModTags.COPPER_INGOTS).add(ModItems.COPPER_INGOT.get());
        tag(ModTags.OSMIUM_INGOTS).add(ModItems.OSMIUM_INGOT.get());
        tag(ModTags.SILVER_INGOTS).add(ModItems.SILVER_INGOT.get());
        tag(ModTags.LEAD_INGOTS).add(ModItems.LEAD_INGOT.get());
        tag(ModTags.TUNGSTEN_INGOTS).add(ModItems.TUNGSTEN_INGOT.get());
        tag(ModTags.PLATINUM_INGOTS).add(ModItems.PLATINUM_INGOT.get());
        tag(ModTags.NIOBIUM_INGOTS).add(ModItems.NIOBIUM_INGOT.get());


        // HARVEST LEVEL
        pickaxeTool(ModBlocks.COPPER_ORE.get(), ItemTier.STONE);
        pickaxeTool(ModBlocks.OSMIUM_ORE.get(), ItemTier.STONE);
        pickaxeTool(ModBlocks.SILVER_ORE.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.LEAD_ORE.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.TUNGSTEN_ORE.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.PLATINUM_ORE.get(), ItemTier.DIAMOND);
        pickaxeTool(ModBlocks.NIOBIUM_ORE.get(), ItemTier.DIAMOND);

        pickaxeTool(ModBlocks.COPPER_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.OSMIUM_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.SILVER_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.LEAD_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.TUNGSTEN_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.PLATINUM_BLOCK.get(), ItemTier.IRON);
        pickaxeTool(ModBlocks.NIOBIUM_BLOCK.get(), ItemTier.IRON);

    }

    private void pickaxeTool(Block block, ItemTier tier)
    {
        tag(PICKAXE).add(block.asItem());
        setTier(block, tier);
    }

    private void axeTool(Block block, ItemTier tier)
    {
        tag(AXE).add(block.asItem());
        setTier(block, tier);
    }

    private void shovelTool(Block block, ItemTier tier)
    {
        tag(SHOVEL).add(block.asItem());
        setTier(block, tier);
    }

    private void hoeTool(Block block, ItemTier tier)
    {
        tag(HOE).add(block.asItem());
        setTier(block, tier);
    }

    private void setTier(Block block, ItemTier tier)
    {
        switch (tier)
        {
            case WOOD -> tag(WOOD_LEVEL).add(block.asItem());
            case GOLD -> tag(GOLD_LEVEL).add(block.asItem());
            case STONE -> tag(STONE_LEVEL).add(block.asItem());
            case IRON -> tag(IRON_LEVEL).add(block.asItem());
            case DIAMOND -> tag(DIAMOND_LEVEL).add(block.asItem());
            case NETHERITE -> tag(NETHERITE_LEVEL).add(block.asItem());
        }
    }
}
