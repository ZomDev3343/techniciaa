package fr.zom.technicia;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technicia.MODID)
public class Technicia {

    public static final String MODID = "technicia";

    public Technicia() {


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();




        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);


    }

    public void setup(final FMLCommonSetupEvent e)
    {

    }

    public void clientSetup(final FMLClientSetupEvent e)
    {

    }

}
