package de.kilobyte22.advcomponents.value

import de.kilobyte22.advcomponents.api.values.{ValueType, BaseValue}
import net.minecraft.nbt.NBTTagCompound

class StringValue(value: String) extends BaseValue {

  override def toString = value
  override def asString = value

  override def asInt = throw new ClassCastException
  override def asLong = throw new ClassCastException

  override def getType = ValueType.STRING

  override def toTag = {
    val ret = new NBTTagCompound
    ret.setString("value", value)
    ret
  }

}
