package fr.zom.technicia.blocks;

import net.minecraft.world.level.material.Material;

public class OreBlock extends BaseBlock{
    public OreBlock(float hardness, float resistance) {
        super(Material.STONE, hardness, resistance);
    }
}
