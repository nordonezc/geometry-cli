package com.co.nou.geometrycli.model.comparator;

import com.co.nou.geometrycli.model.Rectangle;
import com.co.nou.geometrycli.model.common.Line;
import com.co.nou.geometrycli.model.common.Point;
import lombok.Getter;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Getter
public class RectangleComparator extends IFigureComparator<Rectangle> {
    private Rectangle c;

    public RectangleComparator(final Rectangle one, final Rectangle two) {
        super(one, two);
        initRectangles(one, two);
    }

    private void initRectangles(final Rectangle one, final Rectangle two) {
        if (one.getX1y1().x() < two.getX1y1().x()) {
            this.a = one;
            this.b = two;
        } else {
            if (one.getX1y1().y() < two.getX1y1().y()) {
                this.a = one;
                this.b = two;
            } else {
                this.a = two;
                this.b = one;
            }
        }
        this.c = intersectedRectangle();
    }

    private Rectangle intersectedRectangle() {
        var intersection1x = max(a.getX1y1().x(), b.getX1y1().x());
        var intersection1y = max(a.getX1y1().y(), b.getX1y1().y());
        var intersection2x = min(a.getX2y2().x(), b.getX2y2().x());
        var intersection2y = min(a.getX2y2().y(), b.getX2y2().y());

        return new Rectangle(intersection1x, intersection1y, intersection2x, intersection2y);
    }

    public void addLineInCommon(Point p1, Point p2) {
        if (!p1.equals(p2)) {
            Line sharedLine = new Line(p1, p2);
            this.getSharedSides().add(sharedLine);
        }
        addIntersectionPoints(p1, p2);
    }

    public void addIntersectionPoints(Point... p1) {
        this.getIntersectionPoints().addAll(Arrays.asList(p1));
    }

}