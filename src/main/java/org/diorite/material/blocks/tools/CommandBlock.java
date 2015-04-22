package org.diorite.material.blocks.tools;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "CommandBlock" and all its subtypes.
 */
public class CommandBlock extends BlockMaterialData
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
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__COMMAND_BLOCK__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__COMMAND_BLOCK__HARDNESS;

    public static final CommandBlock COMMAND_BLOCK = new CommandBlock();

    private static final Map<String, CommandBlock>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<CommandBlock> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected CommandBlock()
    {
        super("COMMAND_BLOCK", 137, "minecraft:command_block", "COMMAND_BLOCK", (byte) 0x00);
    }

    public CommandBlock(final String enumName, final int type)
    {
        super(COMMAND_BLOCK.name(), COMMAND_BLOCK.getId(), COMMAND_BLOCK.getMinecraftId(), enumName, (byte) type);
    }

    public CommandBlock(final int maxStack, final String typeName, final byte type)
    {
        super(COMMAND_BLOCK.name(), COMMAND_BLOCK.getId(), COMMAND_BLOCK.getMinecraftId(), maxStack, typeName, type);
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
    public CommandBlock getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public CommandBlock getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of CommandBlock sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of CommandBlock or null
     */
    public static CommandBlock getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of CommandBlock sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of CommandBlock or null
     */
    public static CommandBlock getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final CommandBlock element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        CommandBlock.register(COMMAND_BLOCK);
    }
}