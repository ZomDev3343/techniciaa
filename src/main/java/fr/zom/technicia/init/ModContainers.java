package fr.zom.technicia.init;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.container.BackpackContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Technicia.MODID);

    public static final RegistryObject<ContainerType<BackpackContainer>> BACKPACK_CONTAINER = CONTAINERS.register("backpack", () -> IForgeContainerType.create(BackpackContainer::new));

}
