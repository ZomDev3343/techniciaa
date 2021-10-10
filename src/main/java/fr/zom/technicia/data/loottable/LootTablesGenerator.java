package fr.zom.technicia.data.loottable;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTablesGenerator extends LootTableProvider {

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> subProviders = ImmutableList.of(
            Pair.of(ModBlockLootTable::new, LootContextParamSets.BLOCK));
            //Pair.of(FishingLoot::new, LootContextParamSets.FISHING),
            //Pair.of(ChestLoot::new, LootContextParamSets.CHEST),
            //Pair.of(EntityLoot::new, LootContextParamSets.ENTITY),
            //Pair.of(PiglinBarterLoot::new, LootContextParamSets.PIGLIN_BARTER),
//            Pair.of(GiftLoot::new, LootContextParamSets.GIFT));

    public LootTablesGenerator(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return subProviders;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {

    }
}
