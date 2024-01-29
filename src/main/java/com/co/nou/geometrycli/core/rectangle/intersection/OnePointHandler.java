package com.co.nou.geometrycli.core.rectangle.intersection;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class OnePointHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {


    @Override
    public boolean canHandle(RectangleComparator request) {
        var c = request.getC();
        return c.getArea() == 0 && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        var c = request.getC();
        request.setIsContained(false);
        request.getIntersectionPoints().add(c.getX1y1());
    }
}