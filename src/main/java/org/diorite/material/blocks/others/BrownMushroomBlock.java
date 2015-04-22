package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "BrownMushroomBlock" and all its subtypes.
 */
public class BrownMushroomBlock extends MushroomBlock
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

    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_PORES_FULL     = new BrownMushroomBlock();
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_NORTH_WEST = new BrownMushroomBlock(Type.CAP_NORTH_WEST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_NORTH      = new BrownMushroomBlock(Type.CAP_NORTH);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_NORTH_EAST = new BrownMushroomBlock(Type.CAP_NORTH_EAST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_WEST       = new BrownMushroomBlock(Type.CAP_WEST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP            = new BrownMushroomBlock(Type.CAP);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_EAST       = new BrownMushroomBlock(Type.CAP_EAST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_SOUTH_WEST = new BrownMushroomBlock(Type.CAP_SOUTH_WEST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_SOUTH      = new BrownMushroomBlock(Type.CAP_SOUTH);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_SOUTH_EAST = new BrownMushroomBlock(Type.CAP_SOUTH_EAST);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_STEAM          = new BrownMushroomBlock(Type.STEAM);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_CAP_FULL       = new BrownMushroomBlock(Type.CAP_FULL);
    public static final BrownMushroomBlock BROWN_MUSHROOM_BLOCK_STEAM_FULL     = new BrownMushroomBlock(Type.STEAM_FULL);

    private static final Map<String, BrownMushroomBlock>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<BrownMushroomBlock> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected BrownMushroomBlock()
    {
        super("BROWN_MUSHROOM_BLOCK", 99, "minecraft:brown_mushroom_block", Type.PORES_FULL);
    }

    public BrownMushroomBlock(final Type type)
    {
        super(BROWN_MUSHROOM_BLOCK_PORES_FULL.name(), BROWN_MUSHROOM_BLOCK_PORES_FULL.getId(), BROWN_MUSHROOM_BLOCK_PORES_FULL.getMinecraftId(), type);
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
    public BrownMushroomBlock getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BrownMushroomBlock getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public BrownMushroomBlock getMushroomType(final Type mushroomType)
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
    public static BrownMushroomBlock getByID(final int id)
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
    public static BrownMushroomBlock getByEnumName(final String name)
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
    public static BrownMushroomBlock getBrownMushroomBlock(final Type type)
    {
        return getByID(type.getFlag());
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final BrownMushroomBlock element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_PORES_FULL);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH_WEST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_NORTH_EAST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_WEST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_EAST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH_WEST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_SOUTH_EAST);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_STEAM);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_CAP_FULL);
        BrownMushroomBlock.register(BROWN_MUSHROOM_BLOCK_STEAM_FULL);
    }
}