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
package com.feilong;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.feilong.core.CoreTests;
import com.feilong.core.bean.BeanSuiteTests;
import com.feilong.core.date.DateSuiteTests;
import com.feilong.core.lang.LangSuiteTests;
import com.feilong.core.net.NetSuiteTests;
import com.feilong.core.text.TextSuiteTests;
import com.feilong.core.util.UtilSuiteTests;
import com.feilong.tools.log.LogHelperAutoTest;
import com.feilong.tools.slf4j.Slf4jUtilSuiteTests;

@RunWith(Suite.class)
@SuiteClasses({
                CoreTests.class,

                Slf4jUtilSuiteTests.class,
                LogHelperAutoTest.class,

                BeanSuiteTests.class,
                DateSuiteTests.class,
                LangSuiteTests.class,
                TextSuiteTests.class,
                NetSuiteTests.class,
                UtilSuiteTests.class
//
})
public class SuiteTests{

}
