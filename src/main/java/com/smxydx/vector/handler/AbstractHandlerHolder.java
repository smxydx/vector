package com.smxydx.vector.handler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author shaomingxing
 * @since 16/8/12
 */
public abstract class AbstractHandlerHolder implements HandlerHolder {
    protected List<Handler<?>> handlerList;

    @Override
    public void concurrentThis() {
        synchronized (this) {
            if (!(handlerList instanceof CopyOnWriteArrayList)) {
                handlerList = new CopyOnWriteArrayList<>(handlerList);
            }
        }
    }
}
