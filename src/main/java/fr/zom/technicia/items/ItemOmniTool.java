package fr.zom.technicia.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class ItemOmniTool extends Item {

    // TODO Modèle dynamique en fonction du tier
    // TODO -> en fonction de l'état aussi
    // TODO Modèle 3D
    // TODO Modèle JSON
    /* TODO
        Textures
        - WEAK
        - BASIC
        - STRONG
        - ADVANCED
        - ULTIMATE
     */
    // TODO Ajouter une description avec les stats
    // TODO Modifier le nom pour chaque tier
    // TODO Corriger le bug des dégats
    // TODO Vérifier la durabilité

    public ItemOmniTool() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant().setNoRepair());
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        boolean damageable = stack.getDamageValue() != 1;

        if (!damageable) {
            CompoundTag tag = stack.getOrCreateTag();
            tag.putBoolean("broken", true);
        }

        return damageable;
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        CompoundTag tag = pStack.getOrCreateTag();
        if(tag.getBoolean("broken"))
            return 0f;
        return isCorrectTier(pStack, pState) ? tag.getFloat("mineSpd") : 1f;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {

        /*
         * Structure NBT
         * - mineSpd : float
         * - atkDmg : float
         * - tier : int
         * - durability : int
         * - broken : boolean
         * - owner : UUID
         */

        return isCorrectTier(stack, state);
    }

    private static boolean isCorrectTier(ItemStack stack, BlockState state) {
        CompoundTag tag = stack.getOrCreateTag();

        int tier = tag.getInt("tier");
        int blockTier = -1;

        if(state.is(BlockTags.NEEDS_STONE_TOOL)) blockTier = 0;
        if(state.is(BlockTags.NEEDS_IRON_TOOL)) blockTier = 1;
        if(state.is(BlockTags.NEEDS_DIAMOND_TOOL)) blockTier = 2;
        if(state.is(Tags.Blocks.NEEDS_NETHERITE_TOOL)) blockTier = 3;

        return switch (tier) {
            case 0, 1 -> blockTier < 1;
            case 2 -> blockTier < 2;
            case 3 -> blockTier < 3;
            case 4, 5 -> true;
            default -> false;
        };
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        return tag.contains("durability") ? tag.getInt("durability") : 10;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (pIsSelected) {
            if (!pLevel.isClientSide && pEntity instanceof Player player) {

                CompoundTag tag = pStack.getOrCreateTag();

                if (!tag.hasUUID("owner"))
                    tag.putUUID("owner", player.getUUID());

                if (!tag.contains("mineSpd"))
                    initTier(pStack);

            }
        }

    }

    //DEBUG


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide)
        {
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);
            nextTier(stack);
            return InteractionResultHolder.success(stack);
        }

        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    private void nextTier(ItemStack stack)
    {
        CompoundTag tag = stack.getOrCreateTag();
        int currentTier = tag.getInt("tier");
        if(currentTier == 5)
            currentTier = 0;
        else ++currentTier;
        changeTier(stack, OmniToolTier.getTier(currentTier));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {

        CompoundTag tag = stack.getOrCreateTag();

        float atkDmg = tag.getBoolean("broken") ? tag.getFloat("atkDmg") : 0f;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", atkDmg, AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND ? builder.build() : ImmutableMultimap.of();
    }

    public static void changeTier(ItemStack stack, OmniToolTier tier) {
        CompoundTag tag = stack.getOrCreateTag();

        tag.putFloat("mineSpd", tier.getMiningSpeed());
        tag.putFloat("atkDmg", tier.getAttackDamage());
        tag.putInt("tier", tier.getTier());

        System.out.println("Changement de tier !");
    }

    private static void initTier(ItemStack stack) {
        changeTier(stack, OmniToolTier.WEAK);
        stack.getOrCreateTag().putBoolean("broken", false);
    }

    public enum OmniToolTier {

        WEAK(3f, 1f, 250, 0),
        BASIC(5f, 2f, 500, 1),
        STRONG(7f, 4f, 1024, 2),
        ADVANCED(9f, 5f, 2048, 3),
        ENHANCED(11f, 7f, 4096, 4),
        ULTIMATE(13f, 9f, 8192, 5);

        private final float miningSpeed;
        private final float attackDamage;
        private final int maxDurability;
        private final int tier;

        OmniToolTier(float miningSpeed, float attackDamage, int maxDurability, int tier) {
            this.miningSpeed = miningSpeed;
            this.attackDamage = attackDamage;
            this.maxDurability = maxDurability;
            this.tier = tier;
        }

        public float getAttackDamage() {
            return attackDamage;
        }

        public float getMiningSpeed() {
            return miningSpeed;
        }

        public int getMaxDurability() {
            return maxDurability;
        }

        public int getTier() {
            return tier;
        }


        public static OmniToolTier getTier(int id) {
            return OmniToolTier.values()[id];
        }
    }
}
