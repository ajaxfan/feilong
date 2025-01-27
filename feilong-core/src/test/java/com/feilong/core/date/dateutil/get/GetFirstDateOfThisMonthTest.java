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
package com.feilong.core.date.dateutil.get;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.feilong.core.date.DateUtil.getFirstDateOfThisMonth;
import static com.feilong.core.date.DateUtil.toDate;

import static com.feilong.core.DatePattern.COMMON_DATE_AND_TIME;

/**
 * The Class DateUtilGetFirstDateOfThisMonthTest.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 */
public class GetFirstDateOfThisMonthTest{

    /**
     * Test get first date of this month.
     */
    @Test
    public void testGetFirstDateOfThisMonth(){
        assertEquals(
                        toDate("2016-08-01 00:00:00", COMMON_DATE_AND_TIME),
                        getFirstDateOfThisMonth(toDate("2016-08-22 01:00:00", COMMON_DATE_AND_TIME)));
    }

    /**
     * Test get first date of this month null.
     */
    @Test(expected = NullPointerException.class)
    public void testGetFirstDateOfThisMonthNull(){
        getFirstDateOfThisMonth(null);
    }
}