package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.items.ItemOmniTool;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Technicia.MODID);

    public static final RegistryObject<Item> OMNI_TOOL = ITEMS.register("omni_tool", ItemOmniTool::new);

}
