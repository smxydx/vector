package com.smxydx.vector.core.impl;

import com.smxydx.vector.core.HttpProxyFilterBase;
import com.smxydx.vector.model.HttpMessageModel;
import io.netty.handler.codec.http.HttpObject;

import java.util.Map;
import java.util.function.Function;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public class HttpProxyFilterBaseAdapt extends HttpProxyFilterBase {

    @Override
    public void addClient2ProxyFilter(String funcKey, Function<HttpObject, HttpMessageModel> function) {

    }

    @Override
    public void addProxy2ServerFilter(String funcKey, Function<HttpObject, HttpMessageModel> function) {

    }

    @Override
    public void addServer2ProxyFilter(String funcKey, Function<HttpObject, HttpMessageModel> function) {

    }

    @Override
    public void addProxy2ClientFilter(String funcKey, Function<HttpObject, HttpMessageModel> function) {

    }


    @Override
    public Map<String, Function<HttpObject, HttpMessageModel>> getClient2ProxyFilters() {
        return c2pMapRef.get();
    }

    @Override
    public Map<String, Function<HttpObject, HttpMessageModel>> getProxy2ServerFilters() {
        return p2sMapRef.get();
    }

    @Override
    public Map<String, Function<HttpObject, HttpMessageModel>> getServer2ProxyFilter() {
        return s2pMapRef.get();
    }

    @Override
    public Map<String, Function<HttpObject, HttpMessageModel>> getProxy2ClientFilter() {
        return p2cMapRef.get();
    }
}
