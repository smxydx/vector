package com.smxydx.vector.handler;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public interface HandlerHolder {

    void addLast(String key, Handler<?> handler);

    void addFirst(String key, Handler<?> handler);

    void addAfter(String beforeKey, String key, Handler<?> handler);

    void addBefore(String afterKey, String key, Handler<?> handler);

    void remove(String key);

    void concurrentThis();
}
