package fr.zom.technicia.data.models;

import com.google.common.collect.Sets;
import fr.zom.technicia.Technicia;
import fr.zom.technicia.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.Collections;

public class ItemModelGen extends ItemModelProvider {

    public ItemModelGen(DataGenerator generator) {
        super(generator, Technicia.MODID, new ExistingFileHelper(Collections.emptyList(), Sets.newHashSet(), false));
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> itemObject : ModItems.ITEMS.getEntries()) {
            if (itemObject.get() instanceof BlockItem) {
                blockItem(itemObject.get());
            }
            else if(itemObject.get() instanceof TieredItem)
            {
                handheld(itemObject.get());
            }
            else
            {
                generated(itemObject.get());
            }
        }
    }


    private void blockItem(Item item) {
        withExistingParent(item.getRegistryName().getPath(), modLoc("block/" + item.getRegistryName().getPath()));
    }

    private void generated(Item item) {
        String itemName = item.getRegistryName().getPath();
        withExistingParent(itemName, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + itemName));
    }

    private void handheld(Item item) {
        String itemName = item.getRegistryName().getPath();
        withExistingParent(itemName, mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + itemName));
    }
}
