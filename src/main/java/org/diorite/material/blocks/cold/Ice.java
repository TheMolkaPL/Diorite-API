package org.diorite.material.blocks.cold;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Ice extends BlockMaterialData
{
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__ICE__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__ICE__HARDNESS;

    public static final Ice ICE = new Ice();

    private static final Map<String, Ice>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Ice> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Ice()
    {
        super("ICE", 79, "minecraft:ice", "ICE", (byte) 0x00);
    }

    public Ice(final String enumName, final int type)
    {
        super(ICE.name(), ICE.getId(), ICE.getMinecraftId(), enumName, (byte) type);
    }

    public Ice(final int maxStack, final String typeName, final byte type)
    {
        super(ICE.name(), ICE.getId(), ICE.getMinecraftId(), maxStack, typeName, type);
    }

    @Override
    public float getBlastResistance()
    {
        return BLAST_RESISTANCE;
    }

    @Override
    public float getHardness()
    {
        return HARDNESS;
    }

    @Override
    public Ice getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Ice getType(final int id)
    {
        return getByID(id);
    }

    public static Ice getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Ice getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Ice element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Ice.register(ICE);
    }
}