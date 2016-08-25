package com.smxydx.vector.model;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public class HttpHeaderModel {
    private String key;
    private String value;

    public HttpHeaderModel() {
    }

    public HttpHeaderModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

}
