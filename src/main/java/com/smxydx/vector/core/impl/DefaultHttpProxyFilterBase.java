package com.smxydx.vector.core.impl;

import com.smxydx.vector.model.HttpMessageModel;
import com.smxydx.vector.model.HttpRequestModel;
import com.smxydx.vector.util.HttpMimeUtil;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public class DefaultHttpProxyFilterBase extends HttpProxyFilterBaseAdapt {

    @Override
    public void addClient2ProxyFilter(String funcKey, Function<HttpObject, HttpMessageModel> function) {
        ConcurrentHashMap<String, Function<HttpObject, HttpMessageModel>> c2pMap = c2pMapRef.get();
        c2pMap.put(funcKey, function);
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

    public void addDefault() {
        addClient2ProxyFilter("printFilter", httpObject -> {
            if (httpObject instanceof HttpRequest) {
                HttpRequest nRequest = (HttpRequest) httpObject;
                HttpRequestModel request = new HttpRequestModel();
                request.setMethod(nRequest.method().name());
                request.setProtocol(nRequest.protocolVersion().protocolName());
                request.setVersion(nRequest.protocolVersion().majorVersion() + "." + nRequest.protocolVersion().minorVersion());
                request.setUri(nRequest.uri());
                request.setHttpHeaderModels(HttpMimeUtil.tranforms(nRequest.headers()));
                System.out.println(request.text());
                return request;
            } else {
                return null;
            }
        });
    }
}
