package com.co.nou.geometrycli.core.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IntersectedRectangleHandlerTest extends RectangleHandlerTest {

    public IntersectedRectangleHandlerTest() {
        rectangleHandler = new IntersectedRectangleHandler();
    }

    @BeforeEach
    void init() {

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,2 2 3 3"
    })
    void handleRequest_whenOneIntersections_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(1, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 5 5,2 3 1 4",
            "1 1 5 5,2 4 4 8",
            "1 1 5 5,4 2 8 4"
    })
    void handleRequest_whenTwoIntersections_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(2, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @Override
    @ParameterizedTest
    @NullSource
    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        super.handleRequest_whenIsNegative_thenThrowInvalidScenario(input);
    }

}