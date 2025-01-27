/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package com.feilong.lib.org.apache.http.protocol;

import java.io.IOException;

import com.feilong.lib.org.apache.http.HttpException;
import com.feilong.lib.org.apache.http.HttpRequest;
import com.feilong.lib.org.apache.http.HttpRequestInterceptor;
import com.feilong.lib.org.apache.http.annotation.Contract;
import com.feilong.lib.org.apache.http.annotation.ThreadingBehavior;
import com.feilong.lib.org.apache.http.util.Args;

/**
 * RequestUserAgent is responsible for adding {@code User-Agent} header.
 * This interceptor is recommended for client side protocol processors.
 *
 * @since 4.0
 */
@SuppressWarnings("deprecation")
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RequestUserAgent implements HttpRequestInterceptor{

    private final String userAgent;

    public RequestUserAgent(final String userAgent){
        super();
        this.userAgent = userAgent;
    }

    public RequestUserAgent(){
        this(null);
    }

    @Override
    public void process(final HttpRequest request,final HttpContext context) throws HttpException,IOException{
        Args.notNull(request, "HTTP request");
        if (!request.containsHeader(HTTP.USER_AGENT)){
            String s = null;
            //            final HttpParams params = request.getParams();
            //            if (params != null){
            //                s = (String) params.getParameter(CoreProtocolPNames.USER_AGENT);
            //            }
            if (s == null){
                s = this.userAgent;
            }
            if (s != null){
                request.addHeader(HTTP.USER_AGENT, s);
            }
        }
    }

}
