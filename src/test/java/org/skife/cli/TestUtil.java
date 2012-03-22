package org.skife.cli;

public class TestUtil
{
    public static <T> Cli<T> singleCommandParser(Class<T> commandClass)
    {
         return Cli.buildCli("parser", commandClass)
                .withCommand(commandClass)
                .build();
    }
}
