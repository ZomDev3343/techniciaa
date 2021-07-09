package fr.zom.technicia.data.models;

import com.google.common.collect.Sets;
import fr.zom.technicia.Technicia;
import fr.zom.technicia.blocks.OreBlock;
import fr.zom.technicia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.Collections;

public class BlockstateGenerator extends BlockStateProvider {

    public BlockstateGenerator(DataGenerator gen) {
        super(gen, Technicia.MODID, new ExistingFileHelper(Collections.emptyList(), Sets.newConcurrentHashSet(), false));
    }

    @Override
    protected void registerStatesAndModels() {

        for(RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries())
        {

            Block b = block.get();
            String name = b.getRegistryName().getPath();

            if(b instanceof OreBlock)
            {
                simpleBlock(b);
            }

        }

    }
}
