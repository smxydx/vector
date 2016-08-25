package com.smxydx.vector.core;

import java.util.Map;
import java.util.function.Function;

/**
 * @author shaomingxing
 * @since 16/8/10
 */
public interface ProxyFilter<S, R> {

    void addClient2ProxyFilter(String funcKey, Function<S, R> function);

    void addProxy2ServerFilter(String funcKey, Function<S, R> function);

    void addServer2ProxyFilter(String funcKey, Function<S, R> function);

    void addProxy2ClientFilter(String funcKey, Function<S, R> function);

    Map<String, Function<S, R>> getClient2ProxyFilters();

    Map<String, Function<S, R>> getProxy2ServerFilters();

    Map<String, Function<S, R>> getServer2ProxyFilter();

    Map<String, Function<S, R>> getProxy2ClientFilter();
}
