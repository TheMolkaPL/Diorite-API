package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "BrownMushroomBlock" and all its subtypes.
 */
public class BrownMushroomBlockMat extends MushroomBlockMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 13;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__BROWN_MUSHROOM_BLOCK__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__BROWN_MUSHROOM_BLOCK__HARDNESS;

    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_PORES_FULL     = new BrownMushroomBlockMat();
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_NORTH_WEST = new BrownMushroomBlockMat(Type.CAP_NORTH_WEST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_NORTH      = new BrownMushroomBlockMat(Type.CAP_NORTH);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_NORTH_EAST = new BrownMushroomBlockMat(Type.CAP_NORTH_EAST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_WEST       = new BrownMushroomBlockMat(Type.CAP_WEST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP            = new BrownMushroomBlockMat(Type.CAP);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_EAST       = new BrownMushroomBlockMat(Type.CAP_EAST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_SOUTH_WEST = new BrownMushroomBlockMat(Type.CAP_SOUTH_WEST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_SOUTH      = new BrownMushroomBlockMat(Type.CAP_SOUTH);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_SOUTH_EAST = new BrownMushroomBlockMat(Type.CAP_SOUTH_EAST);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_STEAM          = new BrownMushroomBlockMat(Type.STEAM);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_CAP_FULL       = new BrownMushroomBlockMat(Type.CAP_FULL);
    public static final BrownMushroomBlockMat BROWN_MUSHROOM_BLOCK_STEAM_FULL     = new BrownMushroomBlockMat(Type.STEAM_FULL);

    private static final Map<String, BrownMushroomBlockMat>    byName = new CaseInsensitiveMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<BrownMushroomBlockMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected BrownMushroomBlockMat()
    {
        super("BROWN_MUSHROOM_BLOCK", 99, "minecraft:brown_mushroom_block", Type.PORES_FULL);
    }

    protected BrownMushroomBlockMat(final Type type)
    {
        super(BROWN_MUSHROOM_BLOCK_PORES_FULL.name(), BROWN_MUSHROOM_BLOCK_PORES_FULL.ordinal(), BROWN_MUSHROOM_BLOCK_PORES_FULL.getMinecraftId(), type);
    }

    protected BrownMushroomBlockMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type, final Type mushroomType)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type, mushroomType);
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
    public BrownMushroomBlockMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BrownMushroomBlockMat getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public BrownMushroomBlockMat getMushroomType(final Type mushroomType)
    {
        return getByID(mushroomType.getFlag());
    }

    /**
     * Returns one of BrownMushroomBlock sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of BrownMushroomBlock or null
     */
    public static BrownMushroomBlockMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of BrownMushroomBlock sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of BrownMushroomBlock or null
     */
    public static BrownMushroomBlockMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Returns one of BrownMushroomBlock sub-type based on {@link Type}.
     * It will never return null;
     *
     * @param type type of mushroom texture/block.
     *
     * @return sub-type of BrownMushroomBlock
     */
    public static BrownMushroomBlockMat getBrownMushroomBlock(final Type type)
    {
        return getByID(type.getFlag());
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final BrownMushroomBlockMat element)
    {
        byID.put((byte) element.getType(), element);
        byName.put(element.name(), element);
    }

    @Override
    public BrownMushroomBlockMat[] types()
    {
        return BrownMushroomBlockMat.brownMushroomBlockTypes();
    }

    /**
     * @return array that contains all sub-types of this block.
     */
    public static BrownMushroomBlockMat[] brownMushroomBlockTypes()
    {
        return byID.values(new BrownMushroomBlockMat[byID.size()]);
    }

    static
    {
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_PORES_FULL);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH_WEST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH_EAST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_WEST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_EAST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH_WEST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH_EAST);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_STEAM);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_CAP_FULL);
        BrownMushroomBlockMat.register(BROWN_MUSHROOM_BLOCK_STEAM_FULL);
    }
}
