package fr.zom.technicia.items;

import fr.zom.technicia.Technicia;
import fr.zom.technicia.container.BackpackContainer;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class ItemBackpack extends Item {

	private final int slots = 27;


	public ItemBackpack() {
		super(new Item.Properties().tab(Technicia.ITEMS).rarity(Rarity.UNCOMMON).stacksTo(1));
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

		if (!world.isClientSide && hand == Hand.MAIN_HAND) {
			ItemStack stack = player.getItemInHand(Hand.MAIN_HAND);

			ServerPlayerEntity sPlayer = ((ServerPlayerEntity) player);
			NetworkHooks.openGui(sPlayer, new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new StringTextComponent(stack.getDisplayName().getString() + "'s Inventory");
				}

				@Nullable
				@Override
				public Container createMenu(int id, PlayerInventory pInv, PlayerEntity playerEntity) {
					return new BackpackContainer(id, pInv, stack, stack.getOrCreateTag());
				}
			}, buffer -> {
				buffer.writeItem(stack);
				buffer.writeNbt(stack.getOrCreateTag());
			});
		}

		return super.use(world, player, hand);
	}
}
