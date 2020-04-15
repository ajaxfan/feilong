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
package com.feilong.io;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class SpecialFolderTest.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class SpecialFolderTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecialFolderTest.class);

    /**
     * Test get desktop.
     */
    @Test
    public void testGetDesktop(){
        LOGGER.debug("桌面地址:" + SpecialFolder.getDesktop());
    }

    /**
     * Test get my documents.
     */
    @Test
    public void testGetMyDocuments(){
        LOGGER.debug("我的文档:" + SpecialFolder.getMyDocuments());
    }

    /**
     * Test get temp.
     */
    @Test
    public void testGetTemp(){
        LOGGER.debug("临时文件夹:" + SpecialFolder.getTemp());
    }
}
