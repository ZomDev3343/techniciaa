package fr.zom.technicia.data.other.tags;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.data.DataGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;

public class BlockTagGenerator extends BlockTagsProvider {

    public BlockTagGenerator(DataGenerator gen) {
        super(gen, Technicia.MODID, DataGen.DISABLED_FH);
    }

    @Override
    public void addTags() {

    }
}
