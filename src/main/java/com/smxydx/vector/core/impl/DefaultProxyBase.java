package com.smxydx.vector.core.impl;

import com.smxydx.vector.core.AbstractProxyBase;
import com.smxydx.vector.core.HttpProxyFilterBase;
import com.smxydx.vector.core.ProxyBase;
import com.smxydx.vector.core.ProxyFilter;
import com.smxydx.vector.model.HttpMessageModel;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public class DefaultProxyBase extends AbstractProxyBase {
    private static final Logger logger = LoggerFactory.getLogger(DefaultProxyBase.class);


    @Override
    public void start() {
        HttpProxyFilterBase httpProxyFilterBase = (HttpProxyFilterBase) getProxyFilter();
        DefaultHttpProxyServer.bootstrap()
                .withPort(port).withFiltersSource(new HttpFiltersSourceAdapter() {
            @Override
            public HttpFilters filterRequest(HttpRequest originalRequest) {
                return new HttpFiltersAdapter(originalRequest) {
                    @Override
                    public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                        httpProxyFilterBase.getClient2ProxyFilters().values().forEach(func ->
                                func.apply(httpObject));
                        return null;
                    }
                };
            }
        }).start();
    }

    public static void main(String[] args) {
        /*ProxyFilter<HttpObject, HttpMessageModel> proxyFilter = new DefaultHttpProxyFilterBase();
        proxyFilter.addClient2ProxyFilter("",null);
        DefaultProxyBase proxyBase = new DefaultProxyBase();
        proxyBase.start(proxyFilter);*/

        ProxyBase proxyBase = new DefaultProxyBase();
        DefaultHttpProxyFilterBase filter = new DefaultHttpProxyFilterBase();
        filter.addDefault();
        proxyBase.setProxyFilter(filter);
        proxyBase.start();

    }
}
