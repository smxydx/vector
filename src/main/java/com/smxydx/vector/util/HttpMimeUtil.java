package com.smxydx.vector.util;

import com.smxydx.vector.model.HttpHeaderModel;
import io.netty.handler.codec.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaomingxing
 * @since 16/8/11
 */
public class HttpMimeUtil {

    private HttpMimeUtil() {
    }

    public static List<HttpHeaderModel> tranforms(HttpHeaders httpHeaders) {
        List<HttpHeaderModel> headerModels = new ArrayList<>(httpHeaders.size());
        httpHeaders.forEach(nHeader -> headerModels.add(new HttpHeaderModel(nHeader.getKey(), nHeader.getValue())));
        return headerModels;
    }
}
