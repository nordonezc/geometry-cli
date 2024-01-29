package com.co.nou.geometrycli.core.rectangle;

import com.co.nou.geometrycli.core.FigureComparatorHandler;
import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.comparator.RectangleComparator;

public class ContainedHandler extends FigureComparatorHandler<Rectangle, RectangleComparator> {

    @Override
    public boolean canHandle(RectangleComparator request) {
        var a = request.getA();
        var b = request.getB();
        var c = request.getC();

        boolean isContained = c.equals(a) || c.equals(b);
        return isContained && super.canHandle(request);
    }

    @Override
    protected void process(RectangleComparator request) {
        request.setIsContained(true);
        var a = request.getA();
        var b = request.getB();
        var c = request.getC();

        boolean isSharedBotXAxisSide = a.getX1y1().y().equals(b.getX1y1().y());
        boolean isSharedTopXAxisSide = a.getX2y2().y().equals(b.getX2y2().y());
        boolean isSharedLeftYAxisSide = a.getX1y1().x().equals(b.getX1y1().x());
        boolean isSharedRightYAxisSide = a.getX2y2().x().equals(b.getX2y2().x());

        if (isSharedBotXAxisSide) {
            request.addLineInCommon(c.getX1y1(), c.getX2y1());
        }
        if (isSharedTopXAxisSide) {
            request.addLineInCommon(c.getX1y2(), c.getX2y2());
        }
        if (isSharedRightYAxisSide) {
            request.addLineInCommon(c.getX2y1(), c.getX2y2());
        }
        if (isSharedLeftYAxisSide) {
            request.addLineInCommon(c.getX1y1(), c.getX1y2());
        }

    }
}