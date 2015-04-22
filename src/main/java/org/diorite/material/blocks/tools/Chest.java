package org.diorite.material.blocks.tools;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.ContainerBlock;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "Chest" and all its subtypes.
 */
public class Chest extends BlockMaterialData implements ContainerBlock
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
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__CHEST__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__CHEST__HARDNESS;

    public static final Chest CHEST = new Chest();

    private static final Map<String, Chest>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Chest> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Chest()
    {
        super("CHEST", 54, "minecraft:chest", "CHEST", (byte) 0x00);
    }

    public Chest(final String enumName, final int type)
    {
        super(CHEST.name(), CHEST.getId(), CHEST.getMinecraftId(), enumName, (byte) type);
    }

    public Chest(final int maxStack, final String typeName, final byte type)
    {
        super(CHEST.name(), CHEST.getId(), CHEST.getMinecraftId(), maxStack, typeName, type);
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
    public Chest getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Chest getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of Chest sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of Chest or null
     */
    public static Chest getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of Chest sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of Chest or null
     */
    public static Chest getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final Chest element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Chest.register(CHEST);
    }
}