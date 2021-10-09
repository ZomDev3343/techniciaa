package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.blocks.OreBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Technicia.MODID);

    public static final RegistryObject<Block> COPPER_ORE = createBlock("copper_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> OSMIUM_ORE = createBlock("osmium_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> SILVER_ORE = createBlock("silver_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> LEAD_ORE = createBlock("lead_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> TUNGSTEN_ORE = createBlock("tungsten_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> PLATINUM_ORE = createBlock("platinum_ore", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> NIOBIUM_ORE = createBlock("niobium_ore", () -> new OreBlock(3f, 10f));

    public static final RegistryObject<Block> COPPER_BLOCK = createBlock("copper_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> OSMIUM_BLOCK = createBlock("osmium_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> SILVER_BLOCK = createBlock("silver_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> LEAD_BLOCK = createBlock("lead_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = createBlock("tungsten_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> PLATINUM_BLOCK = createBlock("platinum_block", () -> new OreBlock(3f, 10f));
    public static final RegistryObject<Block> NIOBIUM_BLOCK = createBlock("niobium_block", () -> new OreBlock(3f, 10f));


    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp, CreativeModeTab group) {
        RegistryObject<Block> block = BLOCKS.register(name, supp);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(group)));
        return block;
    }

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supp) {
        return createBlock(name, supp, Technicia.BLOCKS);
    }
}
