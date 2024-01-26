package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class IntersectedRectangleHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {

    @Override
    protected void process(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();
        var c = request.getC();

        request.setIsContained(false);

        boolean isIntersectedY = a.getX2y2().x() > b.getX2y2().x();
        boolean isIntersectedX = a.getX2y2().y() < b.getX2y2().y();
        boolean isSharingY = a.getX2y2().x().equals(b.getX2y2().x());
        boolean isIntersectedXBot = a.getX1y1().y() > b.getX1y1().y();

        if (isIntersectedY) {
            if (isIntersectedX) {
                request.getIntersectionPoints().add(c.getX1y2());
                request.getIntersectionPoints().add(c.getX2y2());
            }
            if (isIntersectedXBot) {
                request.getIntersectionPoints().add(c.getX1y1());
                request.getIntersectionPoints().add(c.getX2y1());
            }
        } else {
            request.getIntersectionPoints().add(c.getX2y1());
            request.getIntersectionPoints().add(isIntersectedX ? c.getX1y2() : c.getX2y2());
            if (isSharingY) {
                request.getIntersectionPoints().add(c.getX2y2());
            }

        }

    }
}