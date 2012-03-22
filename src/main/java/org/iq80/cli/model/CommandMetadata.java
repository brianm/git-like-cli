package org.iq80.cli.model;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import org.iq80.cli.Accessor;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.getFirst;

public class CommandMetadata
{
    private final Set<String> names;
    private final String               description;
    private final List<OptionMetadata> globalOptions;
    private final List<OptionMetadata> groupOptions;
    private final List<OptionMetadata> commandOptions;
    private final ArgumentsMetadata    arguments;
    private final List<Accessor>       metadataInjections;
    private final Class<?>             type;

    public CommandMetadata(String[] name,
                           String description,
                           Iterable<OptionMetadata> globalOptions,
                           Iterable<OptionMetadata> groupOptions,
                           Iterable<OptionMetadata> commandOptions,
                           ArgumentsMetadata arguments,
                           Iterable<Accessor> metadataInjections,
                           Class<?> type)
    {
        this.names =  Sets.newLinkedHashSet(Arrays.asList(name));
        this.description = description;
        this.globalOptions = ImmutableList.copyOf(globalOptions);
        this.groupOptions = ImmutableList.copyOf(groupOptions);
        this.commandOptions = ImmutableList.copyOf(commandOptions);
        this.arguments = arguments;
        this.metadataInjections = ImmutableList.copyOf(metadataInjections);
        this.type = type;
    }

    public Set<String> getNames()
    {
        return names;
    }

    public String getPrimaryName()
    {
        return getFirst(names, null);
    }

    public String getDescription()
    {
        return description;
    }

    public List<OptionMetadata> getAllOptions()
    {
        return ImmutableList.<OptionMetadata>builder()
                            .addAll(globalOptions)
                            .addAll(groupOptions)
                            .addAll(commandOptions)
                            .build();

    }

    public List<OptionMetadata> getGlobalOptions()
    {
        return globalOptions;
    }

    public List<OptionMetadata> getGroupOptions()
    {
        return groupOptions;
    }

    public List<OptionMetadata> getCommandOptions()
    {
        return commandOptions;
    }

    public ArgumentsMetadata getArguments()
    {
        return arguments;
    }

    public List<Accessor> getMetadataInjections()
    {
        return metadataInjections;
    }

    public Class<?> getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("CommandMetadata");
        sb.append("{name='").append(names).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", globalOptions=").append(globalOptions);
        sb.append(", groupOptions=").append(groupOptions);
        sb.append(", commandOptions=").append(commandOptions);
        sb.append(", arguments=").append(arguments);
        sb.append(", metadataInjections=").append(metadataInjections);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    public static Function<CommandMetadata, String> primaryNameGetter()
    {
        return new Function<CommandMetadata, String>()
        {
            public String apply(CommandMetadata input)
            {
                return input.getPrimaryName();
            }
        };
    }

}
