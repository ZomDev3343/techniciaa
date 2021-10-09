package fr.zom.technicia.data.other.tags;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.DataGen;
import fr.zom.technicia.init.ModItems;
import fr.zom.technicia.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;

public class ItemTagGenerator extends ItemTagsProvider {


    public ItemTagGenerator(DataGenerator gen, BlockTagsProvider blockTagProvider) {
        super(gen, blockTagProvider, Technicia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {

        tag(ModTags.STICKS).add(Items.STICK);
        tag(ModTags.COPPER_INGOTS).add(ModItems.COPPER_INGOT.get());
        tag(ModTags.OSMIUM_INGOTS).add(ModItems.OSMIUM_INGOT.get());
        tag(ModTags.SILVER_INGOTS).add(ModItems.SILVER_INGOT.get());
        tag(ModTags.LEAD_INGOTS).add(ModItems.LEAD_INGOT.get());
        tag(ModTags.TUNGSTEN_INGOTS).add(ModItems.TUNGSTEN_INGOT.get());
        tag(ModTags.PLATINUM_INGOTS).add(ModItems.PLATINUM_INGOT.get());
        tag(ModTags.NIOBIUM_INGOTS).add(ModItems.NIOBIUM_INGOT.get());


    }


}
