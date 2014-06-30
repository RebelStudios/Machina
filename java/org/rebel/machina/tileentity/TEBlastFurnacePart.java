package org.rebel.machina.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import org.rebel.machina.blocks.BlockBlastFurnacePart;
import org.rebel.machina.gui.BlastFurnaceGUI;
import org.rebel.machina.gui.container.BlastFurnaceContainer;
import org.rebel.machina.multiblock.IMultiblockGuiHandler;
import org.rebel.machina.multiblock.MultiblockBlastFurnace;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.multiblock.helper.MultiblockValidationException;
import org.rebel.machina.multiblock.helper.rectangular.RectangularMultiblockTileEntityBase;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class TEBlastFurnacePart extends RectangularMultiblockTileEntityBase implements IMultiblockGuiHandler {

    public TEBlastFurnacePart() {
        super();
    }

    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {

    }

    public MultiblockBlastFurnace getBlastFurnaceController() {
        return (MultiblockBlastFurnace)this.getMultiblockController();
    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException {
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            throw new MultiblockValidationException("Blast Controller isn't proper for the frame!");
        }
    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException {

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
        if (!this.isConnected()) {
            return null;
        }
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            return new BlastFurnaceContainer(this, inventoryPlayer.player);
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getGuiElement(InventoryPlayer inventoryPlayer) {
        if (!this.isConnected()) {
            return null;
        }
        int metadata = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
        if (BlockBlastFurnacePart.isController(metadata)) {
            return new BlastFurnaceGUI(new BlastFurnaceContainer(this, inventoryPlayer.player), this);
        }
        return null;
    }
}
