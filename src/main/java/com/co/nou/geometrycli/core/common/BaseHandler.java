package com.co.nou.geometrycli.core.common;

import com.co.nou.geometrycli.exception.InvalidScenarioException;

import java.util.Optional;

public abstract class BaseHandler<T> implements Handler<T> {

    Handler<T> nextHandler;

    protected BaseHandler() {

    }

    protected BaseHandler(Handler<T> nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(T request) throws InvalidScenarioException {
        if (canHandle(request)) {
            process(request);
        } else {
            if (Optional.ofNullable(nextHandler).isPresent()) {
                nextHandler.handleRequest(request);
            } else {
                throw new InvalidScenarioException("No scenario was able to be matched. Please contact with the administrator.");
            }
        }
    }

    public abstract boolean canHandle(T request);

    protected abstract void process(T request);

    public BaseHandler<T> andThen(BaseHandler<T> nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
}