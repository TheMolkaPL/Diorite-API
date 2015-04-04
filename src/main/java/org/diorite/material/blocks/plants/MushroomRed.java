package org.diorite.material.blocks.plants;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class MushroomRed extends Mushroom
{
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__RED_MUSHROOM__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__RED_MUSHROOM__HARDNESS;

    public static final MushroomRed RED_MUSHROOM = new MushroomRed();

    private static final Map<String, MushroomRed>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<MushroomRed> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected MushroomRed()
    {
        super("RED_MUSHROOM", 40, "minecraft:red_mushroom", "RED_MUSHROOM", (byte) 0x00);
    }

    public MushroomRed(final String enumName, final int type)
    {
        super(RED_MUSHROOM.name(), RED_MUSHROOM.getId(), RED_MUSHROOM.getMinecraftId(), enumName, (byte) type);
    }

    public MushroomRed(final int maxStack, final String typeName, final byte type)
    {
        super(RED_MUSHROOM.name(), RED_MUSHROOM.getId(), RED_MUSHROOM.getMinecraftId(), maxStack, typeName, type);
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
    public MushroomRed getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public MushroomRed getType(final int id)
    {
        return getByID(id);
    }

    public static MushroomRed getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static MushroomRed getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final MushroomRed element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        MushroomRed.register(RED_MUSHROOM);
    }
}