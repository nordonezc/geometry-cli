package com.co.nou.geometrycli.core;

import com.co.nou.geometrycli.core.common.BaseHandler;
import com.co.nou.geometrycli.model.common.IFigure;
import com.co.nou.geometrycli.model.comparator.IFigureComparator;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public abstract class FigureComparatorHandler<F extends IFigure, FC extends IFigureComparator<F>>
        extends BaseHandler<FC> {

    @Override
    public boolean canHandle(FC request) {
        return Optional.ofNullable(request).isPresent() &&
                Optional.ofNullable(request.getIsContained()).isEmpty();
    }
}