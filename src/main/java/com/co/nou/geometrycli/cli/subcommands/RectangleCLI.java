package com.co.nou.geometrycli.cli.subcommands;

import com.co.nou.geometrycli.core.rectangle.AdjacentRectangleHandler;
import com.co.nou.geometrycli.core.rectangle.ContainedRectangleHandler;
import com.co.nou.geometrycli.core.rectangle.IntersectedRectangleHandler;
import com.co.nou.geometrycli.core.rectangle.NoCollisionRectangleHandler;
import com.co.nou.geometrycli.core.rectangle.SameRectangleHandler;
import com.co.nou.geometrycli.exception.NoCoordinatesException;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@Slf4j
@Component
@CommandLine.Command(
        name = "rectangle",
        description = "Rectangle Comparator")
public class RectangleCLI implements Callable<Integer> {

    @CommandLine.Option(
            names = {"-r1", "--rectangle-one"},
            description = "Coordinates of the first rectangle in form: x1 y1 x2 y2.",
            split = ",",
            arity = "4")
    private ArrayList<Double> r1;

    @CommandLine.Option(
            names = {"-r2", "--rectangle-two"},
            description = "Coordinates of the second rectangle in form: x1 y1 x2 y2",
            split = ",",
            arity = "4")
    private ArrayList<Double> r2;


    @Override
    public Integer call() throws Exception {
        var r1 = new Rectangle(this.r1);
        var r2 = new Rectangle(this.r2);
        validateInput(r1, r2);

        var rComp = new RectangleComparator(r1, r2);
        var figureComparatorHandler = new NoCollisionRectangleHandler();
        figureComparatorHandler.andThen(new SameRectangleHandler())
                .andThen(new AdjacentRectangleHandler())
                .andThen(new ContainedRectangleHandler())
                .andThen(new IntersectedRectangleHandler());
        figureComparatorHandler.handleRequest(rComp);

        log.info("Intersection points: " + rComp.getIntersectionPoints());
        log.info("Contained: " + rComp.getIsContained());
        log.info("Shared sides: " + rComp.getSharedSides());
        log.info("Intersected rectangle: " + rComp.getC());
        return 0;
    }

    private static void validateInput(Rectangle r1, Rectangle r2) throws NoCoordinatesException {
        if (r1.getArea() == 0) {
            throw new NoCoordinatesException("Rectangle one has area zero and it is not a valid rectangle");
        }

        if (r2.getArea() == 0) {
            throw new NoCoordinatesException("Rectangle two has area zero and it is not a valid rectangle");
        }
    }
}