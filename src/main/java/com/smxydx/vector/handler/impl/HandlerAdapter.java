package com.smxydx.vector.handler.impl;

import com.smxydx.vector.handler.Handler;

/**
 * @author shaomingxing
 * @since 16/8/27
 */
public class HandlerAdapter<M> implements Handler<M> {

    @Override
    public M client2Proxy(M message) {
        return null;
    }

    @Override
    public M proxy2Server(M message) {
        return null;
    }

    @Override
    public M server2Proxy(M message) {
        return null;
    }

    @Override
    public M proxy2Client(M message) {
        return null;
    }
}
