package fr.zom.technicia.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import fr.zom.technicia.Technicia;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Set;
import java.util.function.Consumer;

public class ItemOmniTool extends Item {

    // TODO Modèle dynamique en fonction du tier
    // TODO -> en fonction de l'état (cassé) aussi
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
    // TODO Vérifier la durabilité
    // TODO Nettoyer et optimiser le code
    // TODO Afficher quand l'outil est cassé

    public static final Set<ToolAction> ALWAYS_SUPPORTED_ACTIONS = Set.of(ToolActions.AXE_DIG, ToolActions.SHOVEL_DIG, ToolActions.PICKAXE_DIG,
            ToolActions.SWORD_DIG);

    public ItemOmniTool() {
        super(new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant().setNoRepair().durability(10));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ALWAYS_SUPPORTED_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity) {

        if(pStack.getOrCreateTag().getBoolean("broken"))
            return false;

        if (!pLevel.isClientSide && pState.getDestroySpeed(pLevel, pPos) != 0.0F) {

            pStack.hurtAndBreak(1, pMiningEntity, (p_40992_) -> {
                p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });

        }
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        if(pStack.getOrCreateTag().getBoolean("broken"))
            return false;

        pStack.hurtAndBreak(2, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        CompoundTag tag = pStack.getOrCreateTag();
        boolean isBroken = tag.getBoolean("broken");
        if (isBroken)
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
        int blockTier = 0;

        if (state.is(BlockTags.NEEDS_IRON_TOOL)) blockTier = 1;
        if (state.is(BlockTags.NEEDS_DIAMOND_TOOL)) blockTier = 2;
        if (state.is(Tags.Blocks.NEEDS_NETHERITE_TOOL)) blockTier = 3;

        Technicia.LOGGER.debug("Block : {}, Tier : {}", state.getBlock().getRegistryName(), blockTier);

        return switch (tier) {
            case 0, 1 -> blockTier < 1;
            case 2 -> blockTier < 2;
            case 3 -> blockTier < 3;
            case 4, 5 -> true;
            default -> false;
        };
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {

        boolean broken = true;
        if(stack.getDamageValue() + amount == stack.getMaxDamage())
        {
            stack.getOrCreateTag().putBoolean("broken", true);
            stack.setDamageValue(0);
        }else
        {
            broken = false;
        }

        return broken ? 0 : amount;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();

        int durability = tag.getInt("durability");

        return durability;
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
        if (!pLevel.isClientSide) {
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);
            nextTier(stack);
            return InteractionResultHolder.success(stack);
        }

        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    private void nextTier(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        int currentTier = tag.getInt("tier");
        if (currentTier == 5)
            currentTier = 0;
        else ++currentTier;
        changeTier(stack, OmniToolTier.getTier(currentTier));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {

        CompoundTag tag = stack.getOrCreateTag();
        boolean broken = tag.getBoolean("broken");

        if (!broken) {
            float atkDmg = tag.getFloat("atkDmg");

            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", atkDmg, AttributeModifier.Operation.ADDITION));
            return slot == EquipmentSlot.MAINHAND ? builder.build() : ImmutableMultimap.of();
        }

        return ImmutableMultimap.of();
    }

    public static void changeTier(ItemStack stack, OmniToolTier tier) {
        CompoundTag tag = stack.getOrCreateTag();

        tag.putFloat("mineSpd", tier.getMiningSpeed());
        tag.putFloat("atkDmg", tier.getAttackDamage());
        tag.putInt("tier", tier.getTier());
        tag.putInt("durability", tier.getMaxDurability());
        if(stack.getDamageValue() < tier.getMaxDurability())
            stack.getOrCreateTag().putBoolean("broken", false);
        else
            stack.getOrCreateTag().putBoolean("broken", true);

        Technicia.LOGGER.debug("Changement de tier Omni Tool {}", tier.getTier());
    }

    private static void initTier(ItemStack stack) {
        changeTier(stack, OmniToolTier.WEAK);
        stack.getOrCreateTag().putBoolean("broken", false);
    }

    public enum OmniToolTier {

        WEAK(3f, 1f, 5, 0),
        BASIC(5f, 2f, 500, 1),
        STRONG(7f, 4f, 1024, 2),
        ADVANCED(9f, 5f, 2048, 3),
        ENHANCED(13f, 7f, 4096, 4),
        ULTIMATE(99f, 9f, 8192, 5);

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
