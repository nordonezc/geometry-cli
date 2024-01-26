package com.co.nou.geometrycli.model;

import com.co.nou.geometrycli.model.common.IFigure;
import com.co.nou.geometrycli.model.common.Point;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Getter
@ToString
@EqualsAndHashCode
public class Rectangle implements IFigure {

    private final Point x1y1;
    private final Point x2y2;
    private final Point x1y2;
    private final Point x2y1;

    public Rectangle(Double x1, Double y1, Double x2, Double y2) {
        this.x1y1 = new Point(min(x1, x2), min(y1, y2));
        this.x2y2 = new Point(max(x1, x2), max(y1, y2));
        this.x1y2 = new Point(x1y1.x(), x2y2.y());
        this.x2y1 = new Point(x2y2.x(), x1y1.y());
    }

    public Rectangle(List<Double> coordinates) {
        this(coordinates.get(0),
                coordinates.get(1),
                coordinates.get(2),
                coordinates.get(3));
    }

    @Override
    public Double getPerimeter() {
        return Math.abs(x2y2.x() - x1y1.x() +
                x2y2.y() - x1y1.y()) * 2;
    }

    @Override
    public Double getArea() {
        return Math.abs((x2y2.x() - x1y1.x()) *
                (x2y2.y() - x1y1.y()));
    }

}