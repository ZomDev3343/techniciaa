package fr.zom.technicia;

import net.minecraftforge.common.MinecraftForge;
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

        registerAll(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

    }

    public void setup(final FMLCommonSetupEvent e)
    {
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
    }

    public void clientSetup(final FMLClientSetupEvent e)
    {

    }

    private void registerAll(IEventBus bus)
    {

    }

}
