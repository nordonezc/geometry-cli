package com.co.nou.geometrycli.model.comparator;

import com.co.nou.geometrycli.model.common.IFigure;
import com.co.nou.geometrycli.model.common.Line;
import com.co.nou.geometrycli.model.common.Point;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public abstract class IFigureComparator<F extends IFigure> {

    F a, b;
    private final Set<Point> intersectionPoints;
    private Boolean isContained;
    private final List<Line> sharedSides;

    protected IFigureComparator(F a, F b) {
        this.a = a;
        this.b = b;
        this.intersectionPoints = new HashSet<>();
        this.sharedSides = new ArrayList<>();
    }
}