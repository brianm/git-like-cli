package org.skife.cli.args;

import org.skife.cli.Command;
import org.skife.cli.Option;

@Command(name="Arity1")
public class Arity1
{
    @Option(arity = 1, name = "-inspect", description = "", required = false)
    public boolean inspect;
}
