package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class AdjacentRectangleHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {

    @Override
    public boolean canHandle(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();

        boolean isAdjacentXAxisSide = a.getX2y2().x() < b.getX1y1().x() ?
                a.getX1y1().y().equals(b.getX2y2().y()) :
                a.getX2y2().y().equals(b.getX1y1().y());
        boolean isAdjacentYAxisSide = a.getX2y2().y() >= b.getX1y1().y() &&
                a.getX2y2().x().equals(b.getX1y1().x());

        boolean isAdjacent = isAdjacentYAxisSide || isAdjacentXAxisSide;

        return isAdjacent && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        var c = request.getC();
        request.setIsContained(false);
        request.addLineInCommon(c.getX1y1(), c.getX2y2());
    }
}