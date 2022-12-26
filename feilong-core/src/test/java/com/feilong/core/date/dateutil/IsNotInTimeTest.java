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
package com.feilong.core.date.dateutil;

import static com.feilong.core.DatePattern.COMMON_DATE;
import static com.feilong.core.DatePattern.COMMON_DATE_AND_TIME;
import static com.feilong.core.date.DateUtil.toDate;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.feilong.core.date.DateUtil;

public class IsNotInTimeTest{

    @Test
    public void testIsInTime(){
        assertSame(
                        false,
                        DateUtil.isNotInTime(
                                        toDate("2016-06-12", COMMON_DATE),
                                        toDate("2016-06-11 22:59:00", COMMON_DATE_AND_TIME),
                                        toDate("2016-06-16 22:59:00", COMMON_DATE_AND_TIME)));

        //        assertSame(
        //                        false,
        //                        DateUtil.isNotInTime(
        //                                        toDate("2016-06-12", COMMON_DATE),
        //                                        toDate("2016-06-12 00:00:00", COMMON_DATE_AND_TIME),
        //                                        toDate("2016-06-16 22:59:00", COMMON_DATE_AND_TIME)));
    }

    //---------------------------------------------------------------

    /**
     * Test is in time null date.
     */
    @Test(expected = NullPointerException.class)
    public void testIsInTimeNullDate(){
        DateUtil.isNotInTime(
                        null,
                        toDate("2016-06-12 00:00:00", COMMON_DATE_AND_TIME),
                        toDate("2016-06-16 22:59:00", COMMON_DATE_AND_TIME));
    }

    /**
     * Test is in time null begin date.
     */
    @Test(expected = NullPointerException.class)
    public void testIsInTimeNullBeginDate(){
        DateUtil.isNotInTime(toDate("2016-06-12", COMMON_DATE), null, toDate("2016-06-16 22:59:00", COMMON_DATE_AND_TIME));
    }

    /**
     * Test is in time null end date.
     */
    @Test(expected = NullPointerException.class)
    public void testIsInTimeNullEndDate(){
        DateUtil.isNotInTime(toDate("2016-06-12", COMMON_DATE), toDate("2016-06-12 00:00:00", COMMON_DATE_AND_TIME), null);
    }

}