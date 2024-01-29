package com.co.nou.geometrycli.core.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainedHandlerTest extends RectangleHandlerTest {

    public ContainedHandlerTest() {
        rectangleHandler = new ContainedHandler();
    }

    @BeforeEach
    void init() {

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 5 5,2 2 3 3"
    })
    void handleRequest_whenIsNoSides_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(0, comparator.getIntersectionPoints().size());
        assertTrue(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 5 5,2 1 3 2",
            "1 1 5 5,1 3 3 2",
            "1 1 5 5,2 2 4 5",
            "1 1 5 5,2 2 5 4",
    })
    void handleRequest_whenIsOneSide_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(1, comparator.getSharedSides().size());
        assertEquals(2, comparator.getIntersectionPoints().size());
        assertTrue(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 5 5,1 1 3 3",
            "1 1 5 5,1 3 3 5",
            "1 1 5 5,2 2 5 5",
            "1 1 5 5,2 1 5 3",
    })
    void handleRequest_whenIsTwoSide_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(2, comparator.getSharedSides().size());
        assertEquals(3, comparator.getIntersectionPoints().size());
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