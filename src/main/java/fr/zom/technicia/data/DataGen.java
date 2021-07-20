package fr.zom.technicia.data;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.models.BlockstateGenerator;
import fr.zom.technicia.data.models.ItemModelGen;
import fr.zom.technicia.data.other.LangGenerator;
import fr.zom.technicia.data.recipes.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Technicia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void dataGen(final GatherDataEvent e)
    {

        DataGenerator gen = e.getGenerator();

        if(e.includeServer())
        {
            gen.addProvider(new RecipeGenerator(gen));
        }

        if(e.includeClient())
        {
            gen.addProvider(new ItemModelGen(gen));
            gen.addProvider(new LangGenerator(gen));
            gen.addProvider(new BlockstateGenerator(gen));
        }
    }
}
