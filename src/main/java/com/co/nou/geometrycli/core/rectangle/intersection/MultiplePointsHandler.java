package com.co.nou.geometrycli.core.rectangle.intersection;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

import java.util.HashSet;
import java.util.Set;

public class MultiplePointsHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {
    Set<PointsEnum> pointShared = new HashSet<>();

    @Override
    public boolean canHandle(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();
        var c = request.getC();

        if (c.getX1y1().y().equals(a.getX1y1().y()) ||
                c.getX1y1().x().equals(a.getX1y1().x())) {
            pointShared.add(PointsEnum.X1Y1);
        }
        if (c.getX1y2().y().equals(a.getX1y2().y()) ||
                c.getX1y2().x().equals(a.getX1y2().x())) {
            pointShared.add(PointsEnum.X1Y2);
        }
        if (c.getX2y1().y().equals(b.getX2y1().y()) ||
                c.getX2y1().x().equals(b.getX2y1().x())) {
            pointShared.add(PointsEnum.X2Y1);
        }
        if (c.getX2y2().y().equals(b.getX1y2().y()) ||
                c.getX2y2().x().equals(b.getX1y2().x())) {
            pointShared.add(PointsEnum.X2Y2);
        }

        return !pointShared.isEmpty() && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        var c = request.getC();
        request.setIsContained(false);
        addIntersectionPoints(request, c);
        addIntersectionSides(request, c);

    }

    private void addIntersectionSides(RectangleComparator request, Rectangle c) {
        var a = request.getA();
        var b = request.getB();
        if (a.getX1y1().y().equals(b.getX1y1().y())) {
            request.addLineInCommon(c.getX1y1(), c.getX2y1());
        }
        if (a.getX1y1().x().equals(b.getX1y1().x())) {
            request.addLineInCommon(c.getX1y1(), c.getX1y2());
        }
        if (a.getX2y2().y().equals(b.getX2y2().y())) {
            request.addLineInCommon(c.getX1y2(), c.getX2y2());
        }
        if (a.getX2y2().x().equals(b.getX2y2().x())) {
            request.addLineInCommon(c.getX2y1(), c.getX2y2());
        }
    }

    private void addIntersectionPoints(RectangleComparator request, Rectangle c) {
        pointShared.forEach(pointsEnum -> {
            switch (pointsEnum) {
                case X1Y1 -> request.addIntersectionPoints(c.getX1y1());
                case X1Y2 -> request.addIntersectionPoints(c.getX1y2());
                case X2Y1 -> request.addIntersectionPoints(c.getX2y1());
                default -> request.addIntersectionPoints(c.getX2y2());
            }
        });
    }

    private enum PointsEnum {
        X1Y1, X1Y2, X2Y2, X2Y1
    }
}