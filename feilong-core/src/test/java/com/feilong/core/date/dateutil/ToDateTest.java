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
import static com.feilong.core.DatePattern.COMMON_DATE_AND_TIME_WITHOUT_SECOND;
import static com.feilong.core.DatePattern.TIMESTAMP_WITH_MILLISECOND;
import static com.feilong.core.date.DateUtil.toDate;

import java.util.Date;

import org.junit.Test;

import com.feilong.core.DatePattern;
import com.feilong.core.date.DateUtil;
import com.feilong.lib.lang3.StringUtils;

public class ToDateTest{

    @Test
    public void testToDateTest(){
        Date date = toDate("2020-05-26T01:52:07Z", "yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(DateUtil.toString(date, DatePattern.COMMON_DATE_AND_TIME));//TODO:remove
    }

    @Test
    public void testToDate(){
        toDate("2016-06-28T01:21:12-0800", "yyyy-MM-dd'T'HH:mm:ssZ");
        toDate("2016-06-28T01:21:12+0800", "yyyy-MM-dd'T'HH:mm:ssZ");
        toDate("2016-02-33", COMMON_DATE);

        // 商品上线时间
        toDate("20130102140806000", TIMESTAMP_WITH_MILLISECOND);
    }

    /**
     * Test to date null.
     */
    @Test(expected = NullPointerException.class)
    public void testToDateNull(){
        toDate(null, COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    /**
     * Test to date empty.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmpty(){
        toDate("", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    /**
     * Test to date empty 1.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmpty1(){
        toDate(" ", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    //---------------------------------------------------------------

    @Test(expected = NullPointerException.class)
    public void testToDateNullPattern(){
        toDate("2016-06-30 15:36", (String[]) null);
    }

    /**
     * Test to date empty patterns.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDateEmptyPatterns(){
        toDate("2016-06-30 15:36");
    }

    /**
     * Test to date null pattern element.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDateNullPatternElement(){
        toDate("2016-06-30 15:36", (String) null);
    }

    /**
     * Test to date 1.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDate1(){
        toDate("2016-06-30 15:36 ", COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }

    /**
     * Test to date 2.
     */
    @Test
    public void testToDate2(){
        toDate(StringUtils.trimToEmpty("2016-06-30 15:36 "), COMMON_DATE_AND_TIME_WITHOUT_SECOND);
    }
}