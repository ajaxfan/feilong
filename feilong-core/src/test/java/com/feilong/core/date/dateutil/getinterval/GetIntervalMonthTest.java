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
package com.feilong.core.date.dateutil.getinterval;

import static com.feilong.core.DatePattern.COMMON_DATE;
import static com.feilong.core.date.DateUtil.getIntervalMonth;
import static com.feilong.core.date.DateUtil.toDate;

import org.junit.Test;

public class GetIntervalMonthTest{

    @Test(expected = NullPointerException.class)
    public void testGetIntervalNull(){
        getIntervalMonth(null, toDate("2008-9-29", COMMON_DATE));
    }

    @Test(expected = NullPointerException.class)
    public void testGetIntervalNull1(){
        getIntervalMonth(toDate("2008-12-1", COMMON_DATE), null);
    }
}