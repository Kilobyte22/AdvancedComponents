package de.kilobyte22.advcomponents.tileentity

import net.minecraft.tileentity.TileEntity
import li.cil.oc.api.network.{Arguments, Context, Callback, SimpleComponent}
import cpw.mods.fml.common.Optional
import net.minecraft.entity.{EntityLiving, Entity}
import de.kilobyte22.advcomponents.helpers.{EntityHelper, ErrorHelper}
import de.kilobyte22.advcomponents.damagesource.{Zapper => DamageSourceZapper}
import net.minecraft.entity.player.EntityPlayer

class Zapper extends TileEntity with SimpleComponent {

  override def getComponentName = "zapper"
  def range = 10
  def baseEnergyUsage = 10
  def distanceFactor = 1

  @Callback
  @Optional.Method(modid = "OpenComputers")
  def zap(ctx: Context, args: Arguments) = {
    val pattern = args.checkString(0)
    val damage = args.checkInteger(1)
    val relative: Boolean = args.checkAny(2) match {
      case null => false
      case value: java.lang.Boolean => value
      case _ => if (pattern == "Kethtar") // Kethtar is the ingame name of Sangar, our loved OC Dev
        // full quote [26/06/2014 23:08:19] <@Sangar> just throw an exception if you
        // really want to error, or return Array(Unit, "u r doin it wrong")
        throw new Exception("\"u r doin it wrong\" - Sangar, 2014")
      else
        throw new Exception(ErrorHelper.argError(2, "boolean or nil"))
    }
    val message = args.checkAny(3) match {
      case null => null
      case value: String => value
      case _ => ErrorHelper.argError(3, "string or nil")
    }

    val entities: Set[Entity] = resolveEntities(pattern)

    doZap(entities, damage, relative, message)
  }

  def doZap(entities: Set[Entity], damage: Int, relative: Boolean, comment: String) = {
    entities.foreach {
      case p: EntityPlayer => {
        val h = getTargetHealth(damage, relative, p.getHealth)
        if (h == 0) {
          p.setHealth(1)
          p.attackEntityFrom(DamageSourceZapper.make(comment), Float.MaxValue)
        } else
          p.setHealth(h)
      }
      case e: EntityLiving =>
        e.setHealth(getTargetHealth(damage, relative, e.getHealth))
      case entity =>
        entity.setDead()
    }
    Array(true)
  }

  def getTargetHealth(damage: Int, relative: Boolean, health: Float) =
    if (relative)
      math.max(damage, 0).toFloat
    else
      health - math.max(damage.toFloat, health)

  def baseCostForEntityWithoutEasterEggs(entity: Entity) =
    entity.getDistance(xCoord, yCoord, zCoord).toInt * distanceFactor

  def baseCostForEntity(entity: Entity) =
    baseCostForEntityWithoutEasterEggs(entity) * (if (EntityHelper.isEgged(entity)) 0.25 else 1.toFloat)


  def resolveEntities(pattern: String): Set[Entity] =
    Set(worldObj.getPlayerEntityByName(pattern))


}
