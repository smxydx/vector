package com.smxydx.vector.handler;

import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public interface HandlerHolder<T> {

    void addLast(String key, Handler<T> handler);

    void addFirst(String key, Handler<T> handler);

    void addAfter(String beforeKey, String key, Handler<T> handler);

    void addBefore(String afterKey, String key, Handler<T> handler);

    void remove(String key);

    List<Handler<T>> getHandlerList();

}
