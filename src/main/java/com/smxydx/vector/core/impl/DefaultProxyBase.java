package com.smxydx.vector.core.impl;

import com.smxydx.vector.core.AbstractProxyBase;
import com.smxydx.vector.core.ProxyBase;
import com.smxydx.vector.handler.Handler;
import com.smxydx.vector.handler.HandlerHolder;
import com.smxydx.vector.handler.impl.HttpHandlerHolder;
import com.smxydx.vector.handler.impl.PrintHandler;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public class DefaultProxyBase extends AbstractProxyBase {
    private static final Logger logger = LoggerFactory.getLogger(DefaultProxyBase.class);

    public void init() {
        HandlerHolder<HttpObject> handlerHolder = new HttpHandlerHolder();
        handlerHolder.addLast("print", new PrintHandler());
        setHandlerHolder(handlerHolder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void start() {
        List<Handler<HttpObject>> httpHandlerList = (List<Handler<HttpObject>>) getHandlerList();
        DefaultHttpProxyServer.bootstrap()
                .withPort(port).withFiltersSource(new HttpFiltersSourceAdapter() {
            @Override
            public HttpFilters filterRequest(HttpRequest originalRequest) {
                return new HttpFiltersAdapter(originalRequest) {
                    @Override
                    public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                        httpHandlerList.forEach(httpObjectHandler -> httpObjectHandler.client2Proxy(httpObject));
                        return null;
                    }
                };
            }
        }).start();
    }

    public static void main(String[] args) {
        ProxyBase proxyBase = new DefaultProxyBase();
        proxyBase.init();
        proxyBase.start();

    }
}
