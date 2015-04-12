package org.diorite.material.blocks.wooden.wood.fence;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.wooden.WoodType;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class JungleFence extends WoodenFence
{	
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 1;	
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__JUNGLE_FENCE__BLAST_RESISTANCE;	
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__JUNGLE_FENCE__HARDNESS;

    public static final JungleFence JUNGLE_FENCE = new JungleFence();

    private static final Map<String, JungleFence>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<JungleFence> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected JungleFence()
    {
        super("JUNGLE_FENCE", 190, "minecraft:jungle_fence", "JUNGLE_FENCE", WoodType.JUNGLE);
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
    public JungleFence getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public JungleFence getType(final int id)
    {
        return getByID(id);
    }

    public static JungleFence getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static JungleFence getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final JungleFence element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        JungleFence.register(JUNGLE_FENCE);
    }
}
