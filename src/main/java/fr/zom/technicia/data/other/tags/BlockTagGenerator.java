package fr.zom.technicia.data.other.tags;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.DataGen;
import fr.zom.technicia.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class BlockTagGenerator extends BlockTagsProvider {

    private final Tag.Named<Block> WOOD_LEVEL = BlockTags.bind("forge:needs_wood_tool");
    private final Tag.Named<Block> GOLD_LEVEL = BlockTags.bind("forge:needs_gold_tool");
    private final Tag.Named<Block> STONE_LEVEL = BlockTags.bind("minecraft:needs_stone_tool");
    private final Tag.Named<Block> IRON_LEVEL = BlockTags.bind("minecraft:needs_iron_tool");
    private final Tag.Named<Block> DIAMOND_LEVEL = BlockTags.bind("minecraft:needs_diamond_tool");
    private final Tag.Named<Block> NETHERITE_LEVEL = BlockTags.bind("forge:needs_netherite_tool");

    public enum ItemTier {
        WOOD, GOLD, STONE, IRON, DIAMOND, NETHERITE;
    }

    public BlockTagGenerator(DataGenerator gen) {
        super(gen, Technicia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {
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

    private void pickaxeTool(Block block, ItemTier tier) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        setTier(block, tier);
    }

    private void axeTool(Block block, ItemTier tier) {
        tag(BlockTags.MINEABLE_WITH_AXE).add(block);
        setTier(block, tier);
    }

    private void shovelTool(Block block, ItemTier tier) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
        setTier(block, tier);
    }

    private void hoeTool(Block block, ItemTier tier) {
        tag(BlockTags.MINEABLE_WITH_HOE).add(block);
        setTier(block, tier);
    }

    private void setTier(Block block, ItemTier tier) {
        switch (tier) {
            case WOOD -> tag(WOOD_LEVEL).add(block);
            case GOLD -> tag(GOLD_LEVEL).add(block);
            case STONE -> tag(STONE_LEVEL).add(block);
            case IRON -> tag(IRON_LEVEL).add(block);
            case DIAMOND -> tag(DIAMOND_LEVEL).add(block);
            case NETHERITE -> tag(NETHERITE_LEVEL).add(block);
        }
    }
}
