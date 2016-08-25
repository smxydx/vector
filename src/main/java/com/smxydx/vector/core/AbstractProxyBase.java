package com.smxydx.vector.core;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public abstract class AbstractProxyBase implements ProxyBase {

    protected volatile int port = 8888;

    protected ProxyFilter<?, ?> proxyFilter;

    @Override
    public void setProxyPort(int port) {
        this.port = port;
    }

    @Override
    public ProxyFilter<?, ?> getProxyFilter() {
        return proxyFilter;
    }

    @Override
    public void setProxyFilter(ProxyFilter<?, ?> proxyFilter) {
        this.proxyFilter = proxyFilter;
    }
}
