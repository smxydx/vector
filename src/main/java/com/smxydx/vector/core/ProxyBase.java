package com.smxydx.vector.core;

import com.smxydx.vector.handler.Handler;
import com.smxydx.vector.handler.HandlerHolder;

import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public interface ProxyBase {

    void init();

    void setProxyPort(int port);

    void start();

    List<? extends Handler<?>> getHandlerList();

    void setHandlerHolder(HandlerHolder handlerHolder);
}
