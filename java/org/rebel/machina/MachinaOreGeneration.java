package org.rebel.machina;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by XVicarious on 6/17/2014.
 */
public class MachinaOreGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
            case 0:
                generateSurface(world, random, chunkX*16, chunkZ*16);
                break;
        }
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for (int j = 0; j < ModNames.blockOreNames.length; j++) {
            for (int i = 0; i < 30; i++) {
                int randPosX = chunkX + random.nextInt(16);
                int randPosY = random.nextInt(64);
                int randPosZ = chunkZ + random.nextInt(16);
                (new WorldGenMinable(ModBlocks.blockOre, j, 10, Blocks.stone)).generate(world, random, randPosX, randPosY, randPosZ); //ModBlocks.blockOre
            }
        }
    }

}
