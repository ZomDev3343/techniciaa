package fr.zom.technicia;

import fr.zom.technicia.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Technicia.MODID)
public class Technicia {

    public static final String MODID = "technicia";

    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public Technicia() {



        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerAll(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

    }

    public void setup(final FMLCommonSetupEvent e)
    {
        LOGGER.info("SETUP START");
        IEventBus eventBus = MinecraftForge.EVENT_BUS;
        LOGGER.info("SETUP COMPLETE");
    }

    public void clientSetup(final FMLClientSetupEvent e)
    {
        LOGGER.info("CLIENT SETUP START");
        LOGGER.info("CLIENT SETUP COMPLETE");

    }

    private void registerAll(IEventBus bus)
    {
        LOGGER.info("REGISTRIES...");
        ModItems.ITEMS.register(bus);
        LOGGER.info("REGISTRIES DONE");
    }

}
