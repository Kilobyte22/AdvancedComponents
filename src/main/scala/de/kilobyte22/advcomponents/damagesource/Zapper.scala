package de.kilobyte22.advcomponents.damagesource

import net.minecraft.util._
import net.minecraft.entity.EntityLivingBase

class Zapper private (comment: String) extends DamageSource("zapper") {
  override def func_151519_b(entity : EntityLivingBase): IChatComponent = {
    // todo: localization
    val name = entity.getCommandSenderName
    if (comment == null)
      new ChatComponentText(s"$name was zapped")
    else
      new ChatComponentText(s"$name was zapped ($comment)")
  }
}

object Zapper {
  def make(comment: String) =
    new Zapper(comment).setDamageIsAbsolute().setDamageBypassesArmor()
}