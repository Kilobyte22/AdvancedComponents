package de.kilobyte22.advcomponents.helpers

import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer

object EntityHelper {

  private val eggedPlayers = Set("rhj91")

  def isEgged(entity: Entity) =
    entity match {
      case e: EntityPlayer => eggedPlayers.contains(e.getCommandSenderName)
      case _ => false
    }
}
