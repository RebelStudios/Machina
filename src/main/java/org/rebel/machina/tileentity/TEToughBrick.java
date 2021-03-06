package org.rebel.machina.tileentity;

import org.rebel.machina.multiblock.MultiblockBlastFurnace;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.multiblock.helper.MultiblockTileEntityBase;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class TEToughBrick extends MultiblockTileEntityBase {

    @Override
    public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {

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
        return null;
    }
}
