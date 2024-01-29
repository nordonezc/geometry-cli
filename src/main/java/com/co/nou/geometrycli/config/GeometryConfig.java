package com.co.nou.geometrycli.config;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.core.rectangle.AdjacentHandler;
import com.co.nou.geometrycli.core.rectangle.ContainedHandler;
import com.co.nou.geometrycli.core.rectangle.NoCollisionHandler;
import com.co.nou.geometrycli.core.rectangle.SameHandler;
import com.co.nou.geometrycli.core.rectangle.intersection.MultiplePointsHandler;
import com.co.nou.geometrycli.core.rectangle.intersection.OnePointHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeometryConfig {

    @Bean("rectangleHandler")
    public FigureComparatorHandler<Rectangle, RectangleComparator> getRectangleHandler(
            FigureComparatorHandler<Rectangle, RectangleComparator> intersectionHandler
    ) {
        var figureComparatorHandler = new NoCollisionHandler();
        figureComparatorHandler.andThen(new SameHandler())
                .andThen(new AdjacentHandler())
                .andThen(new ContainedHandler())
                .andThen(intersectionHandler);
        return figureComparatorHandler;
    }

    @Bean("intersectionHandler")
    public FigureComparatorHandler<Rectangle, RectangleComparator> getIntersectedHandler() {
        var intersectionHandler = new OnePointHandler();
        intersectionHandler.andThen(new MultiplePointsHandler());
        return intersectionHandler;
    }

}