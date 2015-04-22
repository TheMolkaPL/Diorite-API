package org.diorite.material.blocks.plants;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "CarrotsBlock" and all its subtypes.
 */
public class CarrotsBlock extends Plant
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
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__CARROTS_BLOCK__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__CARROTS_BLOCK__HARDNESS;

    public static final CarrotsBlock CARROTS_BLOCK = new CarrotsBlock();

    private static final Map<String, CarrotsBlock>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<CarrotsBlock> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected CarrotsBlock()
    {
        super("CARROTS_BLOCK", 141, "minecraft:carrots", "CARROTS_BLOCK", (byte) 0x00);
    }

    public CarrotsBlock(final String enumName, final int type)
    {
        super(CARROTS_BLOCK.name(), CARROTS_BLOCK.getId(), CARROTS_BLOCK.getMinecraftId(), enumName, (byte) type);
    }

    public CarrotsBlock(final int maxStack, final String typeName, final byte type)
    {
        super(CARROTS_BLOCK.name(), CARROTS_BLOCK.getId(), CARROTS_BLOCK.getMinecraftId(), maxStack, typeName, type);
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
    public CarrotsBlock getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public CarrotsBlock getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of CarrotsBlock sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of CarrotsBlock or null
     */
    public static CarrotsBlock getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of CarrotsBlock sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of CarrotsBlock or null
     */
    public static CarrotsBlock getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final CarrotsBlock element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        CarrotsBlock.register(CARROTS_BLOCK);
    }
}