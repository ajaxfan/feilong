/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.net.http.packer;

import static com.feilong.core.Validator.isNotNullOrEmpty;
import static com.feilong.core.Validator.isNullOrEmpty;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.lib.org.apache.http.HttpHeaders;
import com.feilong.lib.org.apache.http.client.methods.HttpUriRequest;
import com.feilong.net.http.ConnectionConfig;
import com.feilong.net.http.HttpRequest;
import com.feilong.security.Base64Util;

/**
 * 专门用来封装请求头 {@link com.feilong.lib.org.apache.http.HttpMessage#setHeader(String, String)}.
 * 
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * @since 1.10.6
 * @since 1.11.0 rename from HeadersPacker
 */
public final class HttpRequestHeadersPacker{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestHeadersPacker.class);

    //---------------------------------------------------------------

    /** Don't let anyone instantiate this class. */
    private HttpRequestHeadersPacker(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------

    /**
     * 设置 headers.
     *
     * @param httpUriRequest
     *            the http uri request
     * @param headerMap
     *            请求header map, 如果 <code>headerMap</code> 是null或者empty,什么都不做<br>
     * @param connectionConfig
     *            the connection config
     */
    public static void setHeaders(HttpUriRequest httpUriRequest,Map<String, String> headerMap,ConnectionConfig connectionConfig){
        setDefaultHeader(httpUriRequest);

        setBasicAuthenticationHeader(httpUriRequest, connectionConfig);

        //---------------------------------------------------------------
        setHeaderMap(httpUriRequest, headerMap);
    }

    //---------------------------------------------------------------

    /**
     * 设置 header map.
     *
     * @param httpUriRequest
     *            the http uri request
     * @param headerMap
     *            the header map
     * @since 1.11.0
     */
    private static void setHeaderMap(HttpUriRequest httpUriRequest,Map<String, String> headerMap){
        if (isNullOrEmpty(headerMap)){
            LOGGER.trace("input [headerMap] is null or empty ,skip!");
            return;
        }

        //-------------set header------------------------------------------
        for (Map.Entry<String, String> entry : headerMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            httpUriRequest.setHeader(key, value);

            if (LOGGER.isTraceEnabled()){
                LOGGER.trace("httpUriRequest.setHeader({}, {})", key, value);
            }
        }
    }

    //---------------------------------------------------------------

    /**
     * 设置 basic authentication header.
     *
     * @param httpUriRequest
     *            the http uri request
     * @param connectionConfig
     *            the connection config
     * @since 1.11.0
     */
    private static void setBasicAuthenticationHeader(HttpUriRequest httpUriRequest,ConnectionConfig connectionConfig){
        String userName = connectionConfig.getUserName();
        String password = connectionConfig.getPassword();

        if (isNotNullOrEmpty(userName) && isNotNullOrEmpty(password)){
            String authString = userName + ":" + password;

            String authHeader = "Basic " + Base64Util.encodeBase64(authString, StandardCharsets.US_ASCII);

            httpUriRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        }
    }

    //---------------------------------------------------------------

    /**
     * 设置默认头.
     *
     * @param httpUriRequest
     *            the new default header
     */
    private static void setDefaultHeader(HttpUriRequest httpUriRequest){
        httpUriRequest.setHeader(HttpHeaders.USER_AGENT, HttpRequest.DEFAULT_USER_AGENT);
        //httpUriRequest.setHeader("Connection", "keep-alive");
    }
}