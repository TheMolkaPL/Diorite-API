package org.diorite.material.blocks.stony.ore;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class RedstoneOreGlowing extends Ore
{	
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 1;	
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__REDSTONE_ORE_GLOWING__BLAST_RESISTANCE;	
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__REDSTONE_ORE_GLOWING__HARDNESS;

    public static final RedstoneOreGlowing REDSTONE_ORE_GLOWING = new RedstoneOreGlowing();

    private static final Map<String, RedstoneOreGlowing>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<RedstoneOreGlowing> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected RedstoneOreGlowing()
    {
        super("REDSTONE_ORE_GLOWING", 74, "minecraft:lit_redstone_ore", "REDSTONE_ORE_GLOWING", (byte) 0x00);
    }

    public RedstoneOreGlowing(final String enumName, final int type)
    {
        super(REDSTONE_ORE_GLOWING.name(), REDSTONE_ORE_GLOWING.getId(), REDSTONE_ORE_GLOWING.getMinecraftId(), enumName, (byte) type);
    }

    public RedstoneOreGlowing(final int maxStack, final String typeName, final byte type)
    {
        super(REDSTONE_ORE_GLOWING.name(), REDSTONE_ORE_GLOWING.getId(), REDSTONE_ORE_GLOWING.getMinecraftId(), maxStack, typeName, type);
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
    public RedstoneOreGlowing getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public RedstoneOreGlowing getType(final int id)
    {
        return getByID(id);
    }

    public static RedstoneOreGlowing getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static RedstoneOreGlowing getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final RedstoneOreGlowing element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        RedstoneOreGlowing.register(REDSTONE_ORE_GLOWING);
    }
}
