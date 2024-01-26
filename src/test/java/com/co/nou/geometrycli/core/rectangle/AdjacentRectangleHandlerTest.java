package com.co.nou.geometrycli.core.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdjacentRectangleHandlerTest extends RectangleHandlerTest {

    public AdjacentRectangleHandlerTest() {
        rectangleHandler = new AdjacentRectangleHandler();
    }

    @BeforeEach
    void init() {

    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 3,2 2 3 10",
            "1 5 3 9,2.5 9 20.3 12",
            "3.8 8 4.8 2,2.1 2 4.7 1"
    })
    void handleRequest_whenIsPositive_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(1, comparator.getSharedSides().size());
        assertEquals(2, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @Override
    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,3 3 5 5",
            "2 2 5 5,2 3 6 4"
    })
    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        super.handleRequest_whenIsNegative_thenThrowInvalidScenario(input);
    }

}