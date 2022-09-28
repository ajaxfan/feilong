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
package com.feilong.core.bean.convertutil;

import static com.feilong.core.bean.ConvertUtil.toBigDecimal;
import static com.feilong.core.bean.ConvertUtil.toList;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.feilong.test.Abstract2ParamsAndResultParameterizedTest;

public class ToBigDecimalDefaultValueParameterizedTest extends Abstract2ParamsAndResultParameterizedTest<Object, BigDecimal, BigDecimal>{

    @Parameters(name = "index:{index}: ConvertUtil.toBigDecimal({0},{1})={2}")
    public static Iterable<Object[]> data(){
        Object[][] objects = new Object[][] { //
                                              { null, null, null },
                                              { null, BigDecimal.valueOf(1), BigDecimal.valueOf(1) },
                                              { "aaaa", null, null },
                                              { "aaaa", BigDecimal.valueOf(1), BigDecimal.valueOf(1) },

                                              { "1%", null, null },

                                              { "1", null, BigDecimal.valueOf(1) },
                                              { 8, null, BigDecimal.valueOf(8) },
                                              { "8", null, BigDecimal.valueOf(8) },
                                              { new BigDecimal("8"), null, BigDecimal.valueOf(8) },

                                              { new String[] { "1", "2", "3" }, null, BigDecimal.valueOf(1) },
                                              { new String[] { "1", null, "2", "3" }, null, BigDecimal.valueOf(1) },

                                              { toList("1", "2"), null, BigDecimal.valueOf(1) },
                                              { 0.1, null, BigDecimal.valueOf(0.1) },

                                              { "1,2,3", null, null },

                //
        };
        return toList(objects);
    }

    @Test
    public void testToBigDecimal(){
        assertEquals(expectedValue, toBigDecimal(input1, input2));
    }
}
