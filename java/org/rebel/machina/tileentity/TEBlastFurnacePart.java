package org.rebel.machina.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import org.rebel.machina.MachinaItems;
import org.rebel.machina.blocks.BlockBlastFurnacePart;
import org.rebel.machina.gui.GuiBlastFurnace;
import org.rebel.machina.gui.container.ContainerBlastFurnace;
import org.rebel.machina.multiblock.IMultiblockGuiHandler;
import org.rebel.machina.multiblock.MultiblockBlastFurnace;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.multiblock.helper.MultiblockValidationException;
import org.rebel.machina.multiblock.helper.rectangular.RectangularMultiblockTileEntityBase;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class TEBlastFurnacePart extends RectangularMultiblockTileEntityBase implements IMultiblockGuiHandler, IInventory {

    // 0 -- fuel
    // 1 -- carbon
    // 2 - 10 -- iron
    // 11 -- output
    public ItemStack[] inventory;

    // The number of ticks that the furnace will keep burning
    public int furnaceBurnTime;
    // How long a new operation will take
    public int currentItemBurnTime;
    // How many ticks the current operation is at
    public int furnaceCookTime;

    public TEBlastFurnacePart() {
        inventory = new ItemStack[12];
    }

    public static int getItemBurnTime(ItemStack stack) {
        if (stack == null) {
            return 0;
        } else {
            Item item = stack.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab) {
                    return 150;
                }
                if (block.getMaterial() == Material.wood) {
                    return 300;
                }
                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }
            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) {
                return 200;
            }
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) {
                return 200;
            }
            if (item == Items.stick) {
                return 100;
            }
            if (item == Items.coal) {
                return 1600;
            }
            if (item == Items.lava_bucket) {
                return 20000;
            }
            if (item == Item.getItemFromBlock(Blocks.sapling)) {
                return 100;
            }
            if (item == Items.blaze_rod) {
                return 2400;
            }
            return GameRegistry.getFuelValue(stack);
        }
    }

    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {
        super.onMachineAssembled(multiblockControllerBase);
        if (multiblockControllerBase == null) {
            throw new IllegalArgumentException("NULL CONTROLLER!  PANIC PANIC PANIC");
        }
    }

    public MultiblockBlastFurnace getBlastFurnaceController() {
        return (MultiblockBlastFurnace) this.getMultiblockController();
    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException {
    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException {
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            throw new MultiblockValidationException("Blast Controller isn't proper for the frame!");
        }
    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException {
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (metadata == 0) {
            throw new MultiblockValidationException("Blast Controller isn't proper for the frame!");
        }
    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException {
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (metadata == 0) {
            throw new MultiblockValidationException("Blast Controller isn't proper for the frame!");
        }
    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException {
        throw new MultiblockValidationException("Interior has to be empty!");
    }

    @Override
    public void onMachineBroken() {
        super.onMachineBroken();
    }

    @Override
    public void onMachineActivated() {
    }

    @Override
    public void onMachineDeactivated() {
    }

    @Override
    public MultiblockControllerBase createNewMultiblock() {
        return new MultiblockBlastFurnace(this.worldObj);
    }

    @Override
    public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
        return MultiblockBlastFurnace.class;
    }

    @Override
    public Object getContainer(InventoryPlayer inventoryPlayer) {
        if (!this.isConnected() || !this.getMultiblockController().isAssembled()) {
            return null;
        }
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            return new ContainerBlastFurnace(this, inventoryPlayer.player);
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getGuiElement(InventoryPlayer inventoryPlayer) {
        if (!this.isConnected() || !this.getMultiblockController().isAssembled()) {
            return null;
        }
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            return new GuiBlastFurnace(new ContainerBlastFurnace(this, inventoryPlayer.player), this);
        }
        return null;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack var2) {
        if (slot == 0 || slot == 1) {
            if (var2.getItem() == Items.coal) {
                return true;
            }
        }
        return false;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    private boolean canSmelt() {
        if (this.areInputsEmpty()) {
            return false;
        } else {
            ItemStack stack = new ItemStack(MachinaItems.itemIngot, 0, ironInInputs());
            if (stack == null) {
                return false;
            }
            if (inventory[11] == null) {
                return true;
            }
            if (!inventory[11].isItemEqual(stack)) {
                return false;
            }
            int result = inventory[11].stackSize + stack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.inventory[11].getMaxStackSize();
        }
    }

    public void smeltItems() {
        if (this.canSmelt()) {
            ItemStack stack = new ItemStack(MachinaItems.itemIngot, 0, ironInInputs());
            if (this.inventory[11] == null) {
                this.inventory[11] = stack.copy();
            } else if (this.inventory[11].getItem() == stack.getItem()) {
                this.inventory[11].stackSize += stack.stackSize;
            }
            for (int i = 2; i < 11; i++) {
                --this.inventory[i].stackSize;
                if (this.inventory[i].stackSize <= 0) {
                    this.inventory[i] = null;
                }
            }
        }
    }

    public boolean isItemFuel(ItemStack stack) {
        return getItemBurnTime(stack) > 0;
    }

    private int ironInInputs() {
        int total = 0;
        for (int i = 2; i < 11; i++) {
            if (inventory[0] != null) {
                total++;
            }
        }
        return total;
    }

    private boolean areInputsEmpty() {
        for (int i = 2; i < 11; i++) {
            if (inventory[0] != null) {
                return false;
            }
        }
        return true;
    }

}
