package fr.zom.technicia.world;

import fr.zom.technicia.init.ModBlocks;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OreGeneration {

    public static final TagMatchTest END_STONE = new TagMatchTest(Tags.Blocks.END_STONES);

    @SubscribeEvent
    public static void oreGen(BiomeLoadingEvent e) {

        if(e.getCategory() != Biome.BiomeCategory.NETHER && e.getCategory() != Biome.BiomeCategory.THEEND)
        {

            generateOverworldOre(e, ModBlocks.COPPER_ORE.get(), 16, 25, 80);
            generateOverworldOre(e, ModBlocks.OSMIUM_ORE.get(), 10, 25, 70);
            generateOverworldOre(e, ModBlocks.SILVER_ORE.get(), 6, 17, 55);
            generateOverworldOre(e, ModBlocks.LEAD_ORE.get(), 5, 17, 35);
            generateOverworldOre(e, ModBlocks.TUNGSTEN_ORE.get(), 6, 15, 35);
            generateOverworldOre(e, ModBlocks.PLATINUM_ORE.get(), 4, 15, 20);
            generateOverworldOre(e, ModBlocks.NIOBIUM_ORE.get(), 2, 15, 14);

        }else if(e.getCategory() == Biome.BiomeCategory.NETHER)
        {
            generateNetherOre(e, ModBlocks.TUNGSTEN_ORE.get(), 5, 20, 60);
            generateNetherOre(e, ModBlocks.NIOBIUM_ORE.get(), 4, 20, 60);
        }else if(e.getCategory() == Biome.BiomeCategory.THEEND)
        {
            generateEndOre(e, ModBlocks.PLATINUM_ORE.get(), 6, 15, 80);

        }

    }

    private static void generateOverworldOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, OreConfiguration.Predicates.NATURAL_STONE, ore, veinSize, count, maxY);
    }


    private static void generateNetherOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, OreConfiguration.Predicates.NETHERRACK, ore, veinSize, count, maxY);
    }


    private static void generateEndOre(BiomeLoadingEvent e, Block ore, int veinSize, int count, int maxY)
    {
        generateOre(e, END_STONE, ore, veinSize, count, maxY);
    }

    private static void generateOre(BiomeLoadingEvent e, RuleTest fillerBlock, Block ore, int veinSize, int count, int maxY) {
        e.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Feature.ORE
                .configured(new OreConfiguration(fillerBlock, ore.defaultBlockState(), veinSize))
                .rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(maxY))
                .squared()
                .count(count));
    }

}
