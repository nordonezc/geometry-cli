package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class NoCollisionHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {

    @Override
    public boolean canHandle(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();
        boolean isNoCollision = a.getX2y2().x() < b.getX1y1().x() ||
                a.getX2y2().y() < b.getX1y1().y();
        return isNoCollision && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        request.setIsContained(false);
    }
}