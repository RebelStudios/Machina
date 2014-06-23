package org.rebel.machina.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.rebel.machina.blocks.BlockBlastFurnacePart;
import org.rebel.machina.multiblock.helper.IMultiblockPart;
import org.rebel.machina.multiblock.helper.MultiblockControllerBase;
import org.rebel.machina.multiblock.helper.MultiblockTileEntityBase;
import org.rebel.machina.multiblock.helper.MultiblockValidationException;
import org.rebel.machina.multiblock.helper.rectangular.RectangularMultiblockControllerBase;
import org.rebel.machina.tileentity.TEBlastFurnacePart;
import org.rebel.machina.util.MachinaLog;
import org.rebel.machina.util.MachinaUtil;

import java.util.Set;

/**
 * Created by XVicarious on 6/22/2014.
 */
public class MultiblockBlastFurnace extends RectangularMultiblockControllerBase {

    protected static int nextOrdinal = 0;
    public int ordinal;
    private Set<MultiblockTileEntityBase> attachedControllers;

    public MultiblockBlastFurnace(World world) {
        super(world);
        if(world.isRemote) {
            ordinal = -1;
        }
        else {
            ordinal = nextOrdinal++;
        }
    }

    @Override
    public void onAttachedPartWithMultiblockData(IMultiblockPart part, NBTTagCompound data) {

    }

    @Override
    protected void onBlockAdded(IMultiblockPart newPart) {
        if (newPart instanceof TEBlastFurnacePart) {
            TEBlastFurnacePart teb = (TEBlastFurnacePart)newPart;
            if (BlockBlastFurnacePart.isController(teb.getBlockMetadata())) {
                attachedControllers.add(teb);
            }
        }
    }

    @Override
    protected void onBlockRemoved(IMultiblockPart oldPart) {

    }

    @Override
    protected void onMachineAssembled() {
        MachinaLog.mbInfo("Assembled!");
    }

    @Override
    protected void onMachineRestored() {

    }

    @Override
    protected void onMachinePaused() {

    }

    @Override
    protected void onMachineDisassembled() {

    }

    @Override
    protected int getMinimumNumberOfBlocksForAssembledMachine() {
        return 0;
    }

    @Override
    protected int getMaximumXSize() {
        return 0;
    }

    @Override
    protected int getMaximumZSize() {
        return 0;
    }

    @Override
    protected int getMaximumYSize() {
        return 0;
    }

    @Override
    protected void onAssimilate(MultiblockControllerBase assimilated) {

    }

    @Override
    protected void onAssimilated(MultiblockControllerBase assimilator) {

    }

    @Override
    protected boolean updateServer() {
        return false;
    }

    @Override
    protected void updateClient() {

    }

    @Override
    public void writeToNBT(NBTTagCompound data) {

    }

    @Override
    public void readFromNBT(NBTTagCompound data) {

    }

    @Override
    public void formatDescriptionPacket(NBTTagCompound data) {

    }

    @Override
    public void decodeDescriptionPacket(NBTTagCompound data) {

    }

    @Override
    protected void isBlockGoodForInterior(World world, int x, int y, int z) throws MultiblockValidationException {
        if (!MachinaUtil.isBlockAir(world, x, y, z)) {
            throw new MultiblockValidationException("Interior must be empty!");
        }
    }
}
