package fr.zom.technicia.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {

    public BaseBlock(Properties properties) {
        super(properties);
    }

    public BaseBlock(Material mat, float hardness, float resistance) {
        super(Properties.of(mat).strength(hardness, resistance).requiresCorrectToolForDrops());
    }
}
