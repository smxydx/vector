package com.smxydx.vector.handler.impl;

import com.smxydx.vector.handler.AbstractHandlerHolder;
import com.smxydx.vector.handler.Handler;
import io.netty.handler.codec.http.HttpObject;

/**
 * @author shaomingxing
 * @since 16/8/26
 */
public class HttpHandlerHolder extends AbstractHandlerHolder<HttpObject> {

    @Override
    public synchronized void addLast(String key, Handler<HttpObject> handler) {
        handlerLocal.put(key, handler);
    }

    @Override
    public synchronized void addFirst(String key, Handler<HttpObject> handler) {
        handlerLocal.put(0, key, handler);
    }

    @Override
    public synchronized void addAfter(String beforeKey, String key, Handler<HttpObject> handler) {
        int beforeIndex = handlerLocal.indexOf(beforeKey);
        if (beforeIndex >= 0) {
            handlerLocal.put(beforeIndex + 1, key, handler);
        }
    }

    @Override
    public synchronized void addBefore(String afterKey, String key, Handler<HttpObject> handler) {
        int afterIndex = handlerLocal.indexOf(afterKey);
        if (afterIndex >= 0) {
            handlerLocal.put(afterIndex, key, handler);
        }
    }

    @Override
    public synchronized void remove(String key) {
        handlerLocal.remove(key);
    }

}
