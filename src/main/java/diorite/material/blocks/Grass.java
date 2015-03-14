package diorite.material.blocks;

import java.util.Map;

import diorite.material.BlockMaterialData;
import diorite.utils.collections.SimpleStringHashMap;
import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Grass extends BlockMaterialData
{
    public static final Grass GRASS = new Grass();

    private static final Map<String, Grass>    byName = new SimpleStringHashMap<>(1, .1f);
    @SuppressWarnings("MagicNumber")
    private static final TByteObjectMap<Grass> byID   = new TByteObjectHashMap<>(1, .1f);

    protected Grass()
    {
        super("GRASS", 2, "GRASS", (byte) 0x00);
    }

    public Grass(final String enumName, final int type)
    {
        super(GRASS.name(), GRASS.getId(), enumName, (byte) type);
    }

    public Grass(final int maxStack, final int durability, final String typeName, final byte type)
    {
        super(GRASS.name(), GRASS.getId(), maxStack, durability, typeName, type);
    }

    @Override
    public BlockMaterialData getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BlockMaterialData getType(final int id)
    {
        return getByID(id);
    }

    public static Grass getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Grass getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Grass element)
    {
        byID.put((byte) element.getId(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Grass.register(GRASS);
    }
}