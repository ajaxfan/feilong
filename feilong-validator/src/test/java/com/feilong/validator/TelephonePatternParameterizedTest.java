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
package com.feilong.validator;

import static com.feilong.validator.RegexPattern.TELEPHONE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.feilong.core.util.RegexUtil;
import com.feilong.test.AbstractBooleanParameterizedTest;
import com.feilong.test.TestUtil;

/**
 * The Class TelephonePatternTest.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * @since 1.5.3
 */
public class TelephonePatternParameterizedTest extends AbstractBooleanParameterizedTest<String, Boolean>{

    /**
     * Data.
     *
     * @return the collection
     */
    //@Parameters(name = "index:{index}: matches({0})={1}")
    @Parameters(name = "RegexUtil.matches(RegexPattern.TELEPHONE, {0})={1}")
    public static Iterable<Object[]> data(){
        String[] valids = { "86771588", "021-86771588", "021-867715", "86771588-888", "021-86771588-888" };
        String[] invalids = {
                              "",
                              "   ",
                              "02021-86771588-888", //区号3-4位 太长了
                              "020-86771588888", //电话号码6-8位 太长了
                              "021-86775", };
        return TestUtil.toDataList(valids, invalids);
    }

    /**
     * Matches.
     */
    @Test
    public void matches(){
        assertEquals(expectedValue, RegexUtil.matches(TELEPHONE, input));
    }
}