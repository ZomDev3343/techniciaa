package fr.zom.technicia.data.other.tags;

import fr.zom.technicia.data.DataGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;

public class BlockTagGenerator extends ForgeBlockTagsProvider {

    public BlockTagGenerator(DataGenerator gen) {
        super(gen, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {

    }
}
