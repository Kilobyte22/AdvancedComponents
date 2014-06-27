package de.kilobyte22.advcomponents.block

import net.minecraft.block.BlockContainer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

import de.kilobyte22.advcomponents.tileentity.{Zapper => TileEntityZapper}
import net.minecraft.block.material.Material

class Zapper extends BlockContainer(Material.piston) {
  /**
   * Returns a new instance of a block's tile entity class. Called on placing the block.
   */
  def createNewTileEntity(var1: World, var2: Int): TileEntity =
    new TileEntityZapper

}
