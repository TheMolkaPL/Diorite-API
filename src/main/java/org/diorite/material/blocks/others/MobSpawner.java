package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "MobSpawner" and all its subtypes.
 */
public class MobSpawner extends BlockMaterialData
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
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__MOB_SPAWNER__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__MOB_SPAWNER__HARDNESS;

    public static final MobSpawner MOB_SPAWNER = new MobSpawner();

    private static final Map<String, MobSpawner>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<MobSpawner> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected MobSpawner()
    {
        super("MOB_SPAWNER", 52, "minecraft:mob_spawner", "MOB_SPAWNER", (byte) 0x00);
    }

    public MobSpawner(final String enumName, final int type)
    {
        super(MOB_SPAWNER.name(), MOB_SPAWNER.getId(), MOB_SPAWNER.getMinecraftId(), enumName, (byte) type);
    }

    public MobSpawner(final int maxStack, final String typeName, final byte type)
    {
        super(MOB_SPAWNER.name(), MOB_SPAWNER.getId(), MOB_SPAWNER.getMinecraftId(), maxStack, typeName, type);
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
    public MobSpawner getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public MobSpawner getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of MobSpawner sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of MobSpawner or null
     */
    public static MobSpawner getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of MobSpawner sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of MobSpawner or null
     */
    public static MobSpawner getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final MobSpawner element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        MobSpawner.register(MOB_SPAWNER);
    }
}