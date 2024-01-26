package com.co.nou.geometrycli.core.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SameRectangleHandlerTest extends RectangleHandlerTest {

    public SameRectangleHandlerTest() {
        rectangleHandler = new SameRectangleHandler();
    }

    @BeforeEach
    void init() {

    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,1 1 2 2",
            "5 5 -6 -6,-6 -6 5 5",
            "-9 -8 1 2,-9 2 1 -8"
    })
    void handleRequest_whenIsPositive_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(4, comparator.getSharedSides().size());
        assertEquals(4, comparator.getIntersectionPoints().size());
        assertTrue(comparator.getIsContained());
    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,3 3 5 5",
            "1 5 3 9,2.5 9 20.3 12",
    })
    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        super.handleRequest_whenIsNegative_thenThrowInvalidScenario(input);
    }

}