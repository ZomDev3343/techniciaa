package fr.zom.technicia.data.models;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.blocks.OreBlock;
import fr.zom.technicia.data.DataGen;
import fr.zom.technicia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.fml.RegistryObject;

public class BlockstateGenerator extends BlockStateProvider {

    public BlockstateGenerator(DataGenerator gen) {
        super(gen, Technicia.MODID,  DataGen.DISABLED_FH);
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
