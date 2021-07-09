package fr.zom.technicia.data;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.models.ItemModelGen;
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

        }

        if(e.includeClient())
        {
            gen.addProvider(new ItemModelGen(gen));
        }
    }
}
