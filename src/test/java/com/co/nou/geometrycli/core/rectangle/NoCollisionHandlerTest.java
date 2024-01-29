package com.co.nou.geometrycli.core.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NoCollisionHandlerTest extends RectangleHandlerTest {

    public NoCollisionHandlerTest() {
        rectangleHandler = new NoCollisionHandler();
    }

    @BeforeEach
    void init() {

    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,3 3 4 4",
            "1 3 6 6,7 5 10 8",
            "5 5 6 6,6 7 7 7"
    })
    void handleRequest_whenIsPositive_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(0, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,1 1 2 2",
            "1 1 2 2,2 2 3 3",
    })
    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        super.handleRequest_whenIsNegative_thenThrowInvalidScenario(input);
    }

}