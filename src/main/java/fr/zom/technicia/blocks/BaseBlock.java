package fr.zom.technicia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class BaseBlock extends Block {

    public BaseBlock(Properties properties) {
        super(properties);
    }

    public BaseBlock(Material mat, float hardness, float resistance, ToolType toolType, int harvestLevel) {
        super(Properties.of(mat).strength(hardness, resistance).harvestTool(toolType).harvestLevel(harvestLevel).requiresCorrectToolForDrops());
    }
}
