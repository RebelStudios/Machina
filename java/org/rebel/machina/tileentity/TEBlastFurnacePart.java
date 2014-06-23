package org.rebel.machina.tileentity;

import org.rebel.machina.blocks.BlockBlastFurnacePart;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.multiblock.helper.MultiblockTileEntityBase;
import org.rebel.machina.multiblock.helper.MultiblockValidationException;
import org.rebel.machina.multiblock.helper.rectangular.RectangularMultiblockTileEntityBase;
import org.rebel.machina.util.Util;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class TEBlastFurnacePart extends RectangularMultiblockTileEntityBase {

    public TEBlastFurnacePart() {
        super();
    }

    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {

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
        return null;
    }

    @Override
    public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
        return null;
    }
}
