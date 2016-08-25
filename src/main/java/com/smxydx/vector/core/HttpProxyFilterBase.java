package com.smxydx.vector.core;

import com.smxydx.vector.model.HttpMessageModel;
import io.netty.handler.codec.http.HttpObject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public abstract class HttpProxyFilterBase implements ProxyFilter<HttpObject, HttpMessageModel> {
    protected static AtomicReference<ConcurrentHashMap<String, Function<HttpObject, HttpMessageModel>>> c2pMapRef = new AtomicReference<>(new ConcurrentHashMap<>());
    protected static AtomicReference<ConcurrentHashMap<String, Function<HttpObject, HttpMessageModel>>> p2sMapRef = new AtomicReference<>(new ConcurrentHashMap<>());
    protected static AtomicReference<ConcurrentHashMap<String, Function<HttpObject, HttpMessageModel>>> s2pMapRef = new AtomicReference<>(new ConcurrentHashMap<>());
    protected static AtomicReference<ConcurrentHashMap<String, Function<HttpObject, HttpMessageModel>>> p2cMapRef = new AtomicReference<>(new ConcurrentHashMap<>());

}
