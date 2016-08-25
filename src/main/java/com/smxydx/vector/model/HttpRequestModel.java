package com.smxydx.vector.model;

import com.smxydx.vector.util.StringHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public class HttpRequestModel implements HttpMessageModel {
    private String protocol;// http or https
    private String version;// 1.0 1.1 or 2.0,but 2.0 temporarily does not support
    private List<HttpHeaderModel> httpHeaderModels;//headers
    private String uri;
    private int port;//port is 80 when protocol is http or port is 443 when protocol is https
    private String method;//get post put delete header ..

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<HttpHeaderModel> getHttpHeaderModels() {
        return httpHeaderModels;
    }

    public void setHttpHeaderModels(List<HttpHeaderModel> httpHeaderModels) {
        this.httpHeaderModels = httpHeaderModels;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String text() {
        return method + " " + uri + " " + protocol + "/" + version + StringHelper.LINE_SEPARATOR
                + httpHeaderModels.stream().map(HttpHeaderModel::toString).collect(Collectors.joining(StringHelper.LINE_SEPARATOR))
                + StringHelper.LINE_SEPARATOR;
    }
}
