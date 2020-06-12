/*
 * Copyright (C) 2004 Joe Walnes.
 * Copyright (C) 2006, 2007, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 13. January 2004 by Joe Walnes
 */
package com.feilong.lib.xstream.converters.extended;

import java.io.File;

import com.feilong.lib.xstream.converters.basic.AbstractSingleValueConverter;

/**
 * This converter will take care of storing and retrieving File with either
 * an absolute path OR a relative path depending on how they were created.
 *
 * @author Joe Walnes
 */
public class FileConverter extends AbstractSingleValueConverter{

    @Override
    public boolean canConvert(Class type){
        return type == File.class;
    }

    @Override
    public Object fromString(String str){
        return new File(str);
    }

    @Override
    public String toString(Object obj){
        return ((File) obj).getPath();
    }

}