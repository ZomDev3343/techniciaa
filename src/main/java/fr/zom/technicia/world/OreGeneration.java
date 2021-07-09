package fr.zom.technicia.world;

import fr.zom.technicia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OreGeneration {

    public static final TagMatchRuleTest END_STONE = new TagMatchRuleTest(Tags.Blocks.END_STONES);

    @SubscribeEvent
    public static void oreGen(BiomeLoadingEvent e) {

        if(e.getCategory() != Biome.Category.NETHER && e.getCategory() != Biome.Category.THEEND)
        {
            
        }else if(e.getCategory() == Biome.Category.NETHER)
        {

        }else if(e.getCategory() == Biome.Category.THEEND)
        {

        }

    }

    private static void generateOverworldOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ore, veinSize, count, maxY);
    }


    private static void generateNetherOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, OreFeatureConfig.FillerBlockType.NETHERRACK, ore, veinSize, count, maxY);
    }


    private static void generateEndOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, END_STONE, ore, veinSize, count, maxY);
    }

    private static void generateOre(BiomeLoadingEvent e, RuleTest fillerBlock, Block ore, int veinSize, int count, int maxY) {
        e.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                .configured(new OreFeatureConfig(fillerBlock, ore.defaultBlockState(), veinSize))
                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, maxY)))
                .squared()
                .count(count));
    }

}
