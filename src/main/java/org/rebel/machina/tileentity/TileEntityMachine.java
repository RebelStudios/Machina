package org.rebel.machina.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.energy.IConductor;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.energy.IEnergyNetwork;

import java.util.Set;

/**
 * Created by XVicarious on 7/2/2014.
 */
public class TileEntityMachine extends TileEntity implements IEnergyContainer, IEnergyInterface, IEnergyNetwork {
    @Override
    public void setEnergy(ForgeDirection from, long energy) {

    }

    @Override
    public long getEnergy(ForgeDirection from) {
        return 0;
    }

    @Override
    public long getEnergyCapacity(ForgeDirection from) {
        return 0;
    }

    @Override
    public long onReceiveEnergy(ForgeDirection from, long receive, boolean doReceive) {
        return 0;
    }

    @Override
    public long onExtractEnergy(ForgeDirection from, long extract, boolean doExtract) {
        return 0;
    }

    @Override
    public boolean canConnect(ForgeDirection from, Object source) {
        return false;
    }

    @Override
    public long produce(IConductor conductor, ForgeDirection from, long amount, boolean doProduce) {
        return 0;
    }

    @Override
    public long getBuffer() {
        return 0;
    }

    @Override
    public long getLastBuffer() {
        return 0;
    }

    @Override
    public long getRequest() {
        return 0;
    }

    @Override
    public float getResistance() {
        return 0;
    }

    @Override
    public long getBufferOf(IConductor conductor) {
        return 0;
    }

    @Override
    public void setBufferFor(IConductor conductor, long buffer) {

    }

    @Override
    public void setBuffer(long newBuffer) {

    }

    @Override
    public Set<Object> getNodes() {
        return null;
    }

    @Override
    public void addConnector(IConductor connector) {

    }

    @Override
    public void removeConnector(IConductor connector) {

    }

    @Override
    public Set<IConductor> getConnectors() {
        return null;
    }

    @Override
    public void reconstruct() {

    }

    @Override
    public IEnergyNetwork merge(IEnergyNetwork network) {
        return null;
    }

    @Override
    public void split(IConductor connection) {

    }

    @Override
    public void split(IConductor connectorA, IConductor connectorB) {

    }

    @Override
    public void update() {

    }

    @Override
    public boolean continueUpdate() {
        return false;
    }
}
