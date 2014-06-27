package de.kilobyte22.advcomponents

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import de.kilobyte22.advcomponents.block.Zapper
import de.kilobyte22.advcomponents.tileentity.{Zapper => TileEntityZapper}
import li.cil.oc.api.CreativeTab

@Mod(modid = "advcomponents", name = "Advanced Components", modLanguage = "scala", version = "0.1")
object AdvancedComponents {

  val zapper = new Zapper()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    zapper.setCreativeTab(CreativeTab.instance)
  }

  @EventHandler
  def init(event: FMLInitializationEvent) {
    GameRegistry.registerTileEntity(classOf[TileEntityZapper], "zapper")

    GameRegistry.registerBlock(zapper, "zapper")
  }

  @EventHandler
  def postInit(event: FMLPostInitializationEvent) {

  }

}
