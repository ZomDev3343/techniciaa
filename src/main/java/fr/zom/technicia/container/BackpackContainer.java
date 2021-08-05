package fr.zom.technicia.container;

import fr.zom.technicia.init.ModContainers;
import fr.zom.technicia.items.ItemBackpack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public class BackpackContainer extends Container {

	private final PlayerInventory pInv;
	private ItemStack stack;
	private NonNullList<ItemStack> inventory;

	public BackpackContainer(int id, PlayerInventory pInv, PacketBuffer buf) {
		this(id, pInv, buf.readItem(), buf.readNbt());
	}

	public BackpackContainer(int id, PlayerInventory pInv, ItemStack stack, CompoundNBT items) {
		super(ModContainers.BACKPACK_CONTAINER.get(), id);
		this.pInv = pInv;
		this.stack = stack;
		this.inventory = NonNullList.create();
		ItemStackHelper.loadAllItems(items, this.inventory);

	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return inventory;
	}

	@Override
	public boolean stillValid(PlayerEntity player) {
		return player.getItemInHand(Hand.MAIN_HAND).getItem() instanceof ItemBackpack;
	}
}
