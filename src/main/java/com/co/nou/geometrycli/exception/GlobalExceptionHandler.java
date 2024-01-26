package com.co.nou.geometrycli.exception;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
public class GlobalExceptionHandler implements CommandLine.IExecutionExceptionHandler {

    @Override
    public int handleExecutionException(Exception e, CommandLine commandLine, CommandLine.ParseResult parseResult) throws Exception {
        if (e instanceof NoCoordinatesException) {
            log.error(e.getMessage());
        } else {
            log.error("Unexpected exception");
            log.error(e.getMessage());
        }
        return 0;
    }
}