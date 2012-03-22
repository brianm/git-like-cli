package org.skife.cli;

import org.skife.cli.model.CommandGroupMetadata;
import org.skife.cli.model.CommandMetadata;
import org.skife.cli.model.OptionMetadata;

import javax.inject.Inject;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.transform;

public class GroupSuggester
    implements Suggester
{
    @Inject
    public CommandGroupMetadata group;

    @Override
    public Iterable<String> suggest()
    {
        return concat(transform(group.getCommands(), CommandMetadata.primaryNameGetter()),
                      concat(transform(group.getOptions(), OptionMetadata.optionsGetter())));
    }
}
