package de.kilobyte22.advcomponents.api.values;

import net.minecraft.nbt.NBTTagCompound;

public abstract class BaseValue {
    public abstract String toString();

    public abstract String asString();
    public abstract int asInt();
    public abstract long asLong();

    public abstract ValueType getType();

    public abstract NBTTagCompound toTag();

    public static NBTTagCompound toTag(BaseValue value) {
        NBTTagCompound ret = value.toTag();
        ret.setByte("type", (byte) value.getType().ordinal());
        return ret;
    }
}
