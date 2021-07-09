package fr.zom.technicia.data.other;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import org.apache.commons.lang3.StringUtils;

public class LangGenerator extends LanguageProvider {

    public LangGenerator(DataGenerator gen) {
        super(gen, Technicia.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.technicia.blocks_group", "Technicia Blocks");
        add("itemGroup.technicia.items_group", "Technicia Items");

        for (RegistryObject<Item> item :
                ModItems.ITEMS.getEntries()) {
            add(item.get(), formatName(item.get().getRegistryName().getPath()));
        }
    }

    private String formatName(String name)
    {
        String a = name.replace('_' , ' ');
        String[] b = a.split("[ ]");
        for(String c : b)
        {
            a = a.replace(c, StringUtils.capitalize(c));
        }
        return a;
    }
}
