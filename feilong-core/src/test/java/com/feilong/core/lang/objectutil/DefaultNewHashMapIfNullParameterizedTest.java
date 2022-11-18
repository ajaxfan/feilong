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
package com.feilong.core.lang.objectutil;

import static com.feilong.core.bean.ConvertUtil.toList;
import static com.feilong.core.bean.ConvertUtil.toMap;
import static com.feilong.core.util.MapUtil.newHashMap;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.feilong.core.lang.ObjectUtil;
import com.feilong.test.Abstract1ParamAndResultParameterizedTest;

public class DefaultNewHashMapIfNullParameterizedTest<K, V> extends Abstract1ParamAndResultParameterizedTest<Map<K, V>, Map<K, V>>{

    @Parameters(name = "index:{index}: ObjectUtil.defaultNewHashMapIfNull({0})={1}")
    public static Iterable<Object[]> data(){
        Object[][] objects = build();

        return toList(objects);
    }

    private static Object[][] build(){
        return new Object[][] {
                                new Object[] { null, newHashMap() },
                                new Object[] { toMap(1, 2), toMap(1, 2) },
                                new Object[] { toMap("name", "zhangfei"), toMap("name", "zhangfei") },
                                new Object[] { new HashMap<>(), new HashMap<>() },

        };
    }

    @Test
    public void test(){
        assertEquals(expectedValue, ObjectUtil.defaultNewHashMapIfNull(input1));
    }

}