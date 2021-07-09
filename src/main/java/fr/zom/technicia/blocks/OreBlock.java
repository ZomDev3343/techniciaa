package fr.zom.technicia.blocks;

import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreBlock extends BaseBlock{
    public OreBlock(float hardness, float resistance, int harvestLevel) {
        super(Material.STONE, hardness, resistance, ToolType.PICKAXE, harvestLevel);
    }
}
