package com.smxydx.vector.core;

import com.smxydx.vector.handler.Handler;
import com.smxydx.vector.handler.HandlerHolder;

import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public abstract class AbstractProxyBase implements ProxyBase {

    protected volatile int port = 8888;

    protected HandlerHolder<?> handlerHolder;

    @Override
    public void setProxyPort(int port) {
        this.port = port;
    }

    @Override
    public List<? extends Handler<?>> getHandlerList() {
        return handlerHolder.getHandlerList();
    }

    @Override
    public void setHandlerHolder(HandlerHolder handlerHolder) {
        this.handlerHolder = handlerHolder;
    }
}
