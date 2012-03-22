package org.skife.cli;

import org.skife.cli.model.CommandGroupMetadata;
import org.skife.cli.model.CommandMetadata;
import org.skife.cli.model.GlobalMetadata;
import org.skife.cli.model.OptionMetadata;

import javax.inject.Inject;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.transform;

public class GlobalSuggester
    implements Suggester
{
    @Inject
    public GlobalMetadata metadata;

    @Override
    public Iterable<String> suggest()
    {
        return concat(
                transform(metadata.getCommandGroups(), CommandGroupMetadata.nameGetter()),
                transform(metadata.getDefaultGroupCommands(), CommandMetadata.primaryNameGetter()),
                concat(transform(metadata.getOptions(), OptionMetadata.optionsGetter()))
        );
    }
}
