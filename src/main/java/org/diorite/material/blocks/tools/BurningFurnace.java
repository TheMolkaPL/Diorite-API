package org.diorite.material.blocks.tools;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "BurningFurnace" and all its subtypes.
 */
public class BurningFurnace extends BlockMaterialData
{
    // TODO: auto-generated class, implement other types (sub-ids).	
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 1;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__BURNING_FURNACE__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__BURNING_FURNACE__HARDNESS;

    public static final BurningFurnace BURNING_FURNACE = new BurningFurnace();

    private static final Map<String, BurningFurnace>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<BurningFurnace> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected BurningFurnace()
    {
        super("BURNING_FURNACE", 62, "minecraft:lit_furnace", "BURNING_FURNACE", (byte) 0x00);
    }

    public BurningFurnace(final String enumName, final int type)
    {
        super(BURNING_FURNACE.name(), BURNING_FURNACE.getId(), BURNING_FURNACE.getMinecraftId(), enumName, (byte) type);
    }

    public BurningFurnace(final int maxStack, final String typeName, final byte type)
    {
        super(BURNING_FURNACE.name(), BURNING_FURNACE.getId(), BURNING_FURNACE.getMinecraftId(), maxStack, typeName, type);
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
    public BurningFurnace getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BurningFurnace getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of BurningFurnace sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of BurningFurnace or null
     */
    public static BurningFurnace getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of BurningFurnace sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of BurningFurnace or null
     */
    public static BurningFurnace getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final BurningFurnace element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        BurningFurnace.register(BURNING_FURNACE);
    }
}