package com.smxydx.vector.handler;

import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/12
 */
public abstract class AbstractHandlerHolder<T> implements HandlerHolder<T> {

    protected ListOrderedMap<String, Handler<T>> handlerLocal = new ListOrderedMap<>();

    @Override
    public List<Handler<T>> getHandlerList() {
        return handlerLocal.valueList();
    }

}
