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
package com.feilong.spring.web.multipart;

import org.springframework.web.multipart.MultipartFile;

/**
 * {@link MultipartFile} 解析器.
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.5.4
 */
public interface MultipartFileResolver{

    /**
     * 将<code>MultipartFile</code>上传到指定目录<code>directoryName</code>下面重命名指定的文件名称<code>fileName</code>.
     * 
     * <p>
     * 如果{@link MultipartFile#isEmpty()},那么log warn并跳过
     * </p>
     *
     * @param multipartFile
     *            the multipart file
     * @param directoryName
     *            指定目录
     * @param fileName
     *            the file name
     */
    void upload(MultipartFile multipartFile,String directoryName,String fileName);

    /**
     * 将一组<code>multipartFiles</code>上传到指定目录<code>directoryName</code>下面,依次重命名指定的文件名称<code>fileNames</code>.
     * 
     * <p>
     * 如果{@link MultipartFile#isEmpty()},那么log warn并跳过
     * </p>
     * 
     * @param multipartFiles
     *            the multipart files
     * @param directoryName
     *            指定目录
     * @param fileNames
     *            the file names
     */
    void upload(MultipartFile[] multipartFiles,String directoryName,String[] fileNames);
}
