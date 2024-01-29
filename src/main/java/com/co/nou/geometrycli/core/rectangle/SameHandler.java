package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class SameHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {

    @Override
    public boolean canHandle(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();
        boolean isSame = a.equals(b);
        return isSame && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        var c = request.getC();
        request.setIsContained(true);
        request.addLineInCommon(c.getX1y1(), c.getX1y2());
        request.addLineInCommon(c.getX1y1(), c.getX2y1());
        request.addLineInCommon(c.getX1y2(), c.getX2y2());
        request.addLineInCommon(c.getX2y1(), c.getX2y2());
    }
}