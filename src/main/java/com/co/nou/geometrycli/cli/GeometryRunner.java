package com.co.nou.geometrycli.cli;

import com.co.nou.geometrycli.exception.GlobalExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@RequiredArgsConstructor
public class GeometryRunner implements CommandLineRunner {

    private final FigureCLI figureCLI;
    private final CommandLine.IFactory factory;

    @Override
    public void run(String... args) {
        new CommandLine(figureCLI, factory)
                .setExecutionExceptionHandler(new GlobalExceptionHandler())
                .execute(args);

    }
}