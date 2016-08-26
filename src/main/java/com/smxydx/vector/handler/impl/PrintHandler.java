package com.smxydx.vector.handler.impl;

import com.smxydx.vector.model.HttpRequestModel;
import com.smxydx.vector.util.HttpMimeUtil;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @author shaomingxing
 * @since 16/8/27
 */
public class PrintHandler extends HandlerAdapter<HttpObject> {

    @Override
    public HttpObject client2Proxy(HttpObject message) {
        if (message instanceof HttpRequest) {
            HttpRequest nRequest = (HttpRequest) message;
            HttpRequestModel request = new HttpRequestModel();
            request.setMethod(nRequest.method().name());
            request.setProtocol(nRequest.protocolVersion().protocolName());
            request.setVersion(nRequest.protocolVersion().majorVersion() + "." + nRequest.protocolVersion().minorVersion());
            request.setUri(nRequest.uri());
            request.setHttpHeaderModels(HttpMimeUtil.tranforms(nRequest.headers()));
            System.out.println(request.text());
        }
        
        return message;
    }

}
