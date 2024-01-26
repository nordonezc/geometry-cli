package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.exception.InvalidScenarioException;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class RectangleHandlerTest {
    RectangleComparator comparator;
    FigureComparatorHandler<Rectangle, RectangleComparator> rectangleHandler;

    @BeforeEach
    void init() {

    }

    void handleRequest_whenIsPositive_thenOk(String input) {
        var rectangles = readStringInput(input.split(","));
        comparator = new RectangleComparator(rectangles[0], rectangles[1]);
        assertDoesNotThrow(() -> rectangleHandler.handleRequest(comparator));
    }


    void handleRequest_whenIsNegative_thenThrowInvalidScenario(String input) {
        Optional.ofNullable(input).ifPresent(i -> {
            var rectangles = readStringInput(input.split(","));
            comparator = new RectangleComparator(rectangles[0], rectangles[1]);
        });
        assertThrows(InvalidScenarioException.class,
                () -> rectangleHandler.handleRequest(comparator));
    }

    private static Rectangle[] readStringInput(String[] rectangles) {
        Rectangle[] rects = new Rectangle[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            var coordinates = rectangles[i].split(" ");
            rects[i] = new Rectangle(Arrays.stream(coordinates)
                    .map(Double::valueOf)
                    .collect(Collectors.toList()));
        }
        return rects;
    }
}