package com.smxydx.vector.handler;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public interface Handler<M> {

    M client2Proxy(M message);

    M proxy2Server(M message);

    M server2Proxy(M message);

    M proxy2Client(M message);
}
