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
package com.feilong.io.entity;

/**
 * 文件写入的方式.
 * 
 * <ul>
 * <li>{@link #COVER} 覆盖</li>
 * <li>{@link #APPEND} 追加</li>
 * </ul>
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.7.1
 */
public enum FileWriteMode{

    /** 覆盖. */
    COVER,

    /**
     * 追加 then bytes will be written to the end of the file rather than the beginning.
     * 
     * @see java.io.FileOutputStream#FileOutputStream(java.io.File, boolean)
     */
    APPEND
}