package com.co.nou.geometrycli.core.common;

import com.co.nou.geometrycli.exception.InvalidScenarioException;

@FunctionalInterface
public interface Handler<T> {
    void handleRequest(T request) throws InvalidScenarioException;
}