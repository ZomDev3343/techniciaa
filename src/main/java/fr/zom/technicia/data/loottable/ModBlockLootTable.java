package fr.zom.technicia.data.loottable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import fr.zom.technicia.init.ModBlocks;
import fr.zom.technicia.init.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ModBlockLootTable extends BlockLoot {

    private final Map<ResourceLocation, LootTable.Builder> map = Maps.newHashMap();
    private final List<Block> KNOWN_BLOCKS = Lists.newArrayList();

    @Override
    protected void addTables() {
        add(ModBlocks.COPPER_ORE.get(), createOreDrop(ModBlocks.COPPER_ORE.get(), ModItems.COPPER_RAW.get()));
        add(ModBlocks.OSMIUM_ORE.get(), createOreDrop(ModBlocks.OSMIUM_ORE.get(), ModItems.OSMIUM_RAW.get()));
        add(ModBlocks.SILVER_ORE.get(), createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.SILVER_RAW.get()));
        add(ModBlocks.LEAD_ORE.get(), createOreDrop(ModBlocks.LEAD_ORE.get(), ModItems.LEAD_RAW.get()));
        add(ModBlocks.TUNGSTEN_ORE.get(), createOreDrop(ModBlocks.TUNGSTEN_ORE.get(), ModItems.TUNGSTEN_RAW.get()));
        add(ModBlocks.PLATINUM_ORE.get(), createOreDrop(ModBlocks.PLATINUM_ORE.get(), ModItems.PLATINUM_RAW.get()));
        add(ModBlocks.NIOBIUM_ORE.get(), createOreDrop(ModBlocks.NIOBIUM_ORE.get(), ModItems.NIOBIUM_RAW.get()));
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        this.addTables();
        map.forEach((consumer::accept));

    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return KNOWN_BLOCKS;
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pLootTableBuilder) {
        this.map.put(pBlock.getLootTable(), pLootTableBuilder);
    }
}
