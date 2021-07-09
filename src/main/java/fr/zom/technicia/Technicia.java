package fr.zom.technicia;

import fr.zom.technicia.init.ModBlocks;
import fr.zom.technicia.init.ModContainers;
import fr.zom.technicia.init.ModItems;
import fr.zom.technicia.init.ModTileEntities;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technicia.MODID)
public class Technicia {

    public static final String MODID = "technicia";

    public static final ItemGroup BLOCKS = new ItemGroup("blocks_group") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.COPPER_BLOCK.get());
        }

    };
    public static final ItemGroup ITEMS = new ItemGroup("items_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };

    public Technicia() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerAll(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);

    }

    public void setup(final FMLCommonSetupEvent e)
    {

    }

    public void clientSetup(final FMLClientSetupEvent e)
    {

    }

    private void registerAll(IEventBus bus)
    {
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);
        ModContainers.CONTAINERS.register(bus);
    }

}
