package com.co.nou.geometrycli.cli;

import com.co.nou.geometrycli.cli.subcommands.RectangleCLI;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(
        name = "figure",
        description = "figure comparator cli",
        mixinStandardHelpOptions = true,
        subcommands = {
                RectangleCLI.class,
        })
public class FigureCLI {
}