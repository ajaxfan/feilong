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
package com.feilong.net.http.callback;

import java.util.Date;

import com.feilong.lib.org.apache.http.HttpResponse;
import com.feilong.lib.org.apache.http.client.methods.HttpUriRequest;
import com.feilong.net.http.ConnectionConfig;
import com.feilong.net.http.HttpRequest;

/**
 * A callback interface,用来执行httpclient之后,渲染拿到的结果.
 * 
 * <p>
 * 是feilong httpclient 底层接口,目前有的实现有:
 * </p>
 * 
 * <ol>
 * <li>{@link HttpResponseResultCallback}:用来构造全的返回数据,包含字符串,状态码,时间等等</li>
 * <li>{@link ResponseBodyAsStringResultCallback}:用来获得接口的返回字符串(常用)</li>
 * <li>{@link StatusCodeResultCallback}:用来只需要获得状态码</li>
 * </ol>
 * <p>
 * 设计思想,类似于 org.springframework.data.redis.core.RedisCallback
 * </p>
 *
 * @param <T>
 *            the generic type
 * @see com.feilong.net.http.builder.HttpRequestExecuter#execute(HttpRequest, ConnectionConfig, ResultCallback)
 * @see HttpResponseResultCallback
 * @see ResponseBodyAsStringResultCallback
 * @see StatusCodeResultCallback
 */
@FunctionalInterface // 该注解加不加,对于接口是不是函数式接口没有影响;只是提醒编译器去检查该接口是否仅包含一个抽象方法
public interface ResultCallback<T> {

    /**
     * On.
     * 
     * <p>
     * 注意:每个参数都不会为null
     * </p>
     *
     * @param httpRequest
     *            the http request
     * @param httpUriRequest
     *            the http uri request
     * @param httpResponse
     *            the http response
     * @param useConnectionConfig
     *            the use connection config
     * @param beginDate
     *            http调用开始时间
     * @return the t
     */
    T on(
                    HttpRequest httpRequest,
                    HttpUriRequest httpUriRequest,
                    HttpResponse httpResponse,
                    ConnectionConfig useConnectionConfig,
                    Date beginDate);
}