package com.smxydx.vector.core;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public interface ProxyBase {

    int port = 7777;

    ProxyFilter<?, ?> proxyFilter = null;

    void setProxyPort(int port);

    void start();

    ProxyFilter<?, ?> getProxyFilter();

    void setProxyFilter(ProxyFilter<?, ?> proxyFilter);
}
