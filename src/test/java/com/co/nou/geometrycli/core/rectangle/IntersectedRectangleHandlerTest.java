package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.rectangle.intersection.MultiplePointsHandler;
import com.co.nou.geometrycli.core.rectangle.intersection.OnePointHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class IntersectedRectangleHandlerTest extends RectangleHandlerTest {

    public IntersectedRectangleHandlerTest() {
        rectangleHandler = new OnePointHandler();
        rectangleHandler.andThen(new MultiplePointsHandler());
    }

    @BeforeEach
    void init() {

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 2 2,2 2 3 3",
            "1 5 5 10,5 2 10 5"
    })
    void handleRequest_whenOneIntersections_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(1, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 1 5 5,2 4 4 8",
            "1 1 5 5,4 2 8 4",
            "1 1 8 5,2 2 6 8",
            "3 3 8 5,1 1 6 4"
    })
    void handleRequest_whenTwoIntersections_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(0, comparator.getSharedSides().size());
        assertEquals(2, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 3 8 6,5 3 10 4",
            "2 3 8 6,5 5 10 6",
            "2 3 8 6,5 5 8 8",
            "2 3 8 6,5 1 8 5",
            "-5 -0.8 5 2.8,-5 2 2 7.2",
            "0.5 0.5 4.2 10.8,0.5 2.2 14.2 17"
    })
    void handleRequest_whenThreeIntersections_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(1, comparator.getSharedSides().size());
        assertEquals(3, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "-5 -5 8 8,0 -10 8 8",
            "-5 -5 8 8,0 -5 8 12"
            //"1 1 8 8,1 1 10 6"
    })
    void handleRequest_whenFourPoints_thenOk(String input) {
        super.handleRequest_whenIsPositive_thenOk(input);
        assertEquals(2, comparator.getSharedSides().size());
        assertEquals(4, comparator.getIntersectionPoints().size());
        assertFalse(comparator.getIsContained());
    }

    @Override
    @ParameterizedTest
    @NullSource
    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        super.handleRequest_whenIsNegative_thenThrowInvalidScenario(input);
    }

}