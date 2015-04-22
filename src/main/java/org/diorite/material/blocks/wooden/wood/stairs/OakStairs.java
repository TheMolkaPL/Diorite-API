package org.diorite.material.blocks.wooden.wood.stairs;

import java.util.Map;

import org.diorite.BlockFace;
import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Stairs;
import org.diorite.material.blocks.wooden.WoodType;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "OakStairs" and all its subtypes.
 */
public class OakStairs extends WoodenStairs
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
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__OAK_STAIRS__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__OAK_STAIRS__HARDNESS;

    public static final OakStairs OAK_STAIRS = new OakStairs();

    private static final Map<String, OakStairs>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<OakStairs> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected OakStairs()
    {
        super("OAK_STAIRS", 53, "minecraft:oak_stairs", "OAK_STAIRS", WoodType.OAK);
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
    public OakStairs getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public OakStairs getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public boolean isUpsideDown()
    {
        return false; // TODO: implement
    }

    @Override
    public Stairs getUpsideDown(final boolean upsideDown)
    {
        return null; // TODO: implement
    }

    @Override
    public BlockFace getBlockFacing()
    {
        return null; // TODO: implement
    }

    @Override
    public BlockMaterialData getBlockFacing(final BlockFace face)
    {
        return null; // TODO: implement
    }

    /**
     * Returns one of OakStairs sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of OakStairs or null
     */
    public static OakStairs getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of OakStairs sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of OakStairs or null
     */
    public static OakStairs getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final OakStairs element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        OakStairs.register(OAK_STAIRS);
    }
}