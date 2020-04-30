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
package com.feilong.office.excel.reader;

import com.feilong.office.excel.DataConvertorConfigurator;
import com.feilong.office.excel.ExcelException;
import com.feilong.office.excel.convertor.DataConvertor;
import com.feilong.office.excel.definition.ExcelCell;

class CellValueConverter{

    /** The Constant UNSUPPORTING_DATA_TYPE. */
    private static final int UNSUPPORTING_DATA_TYPE = 2;

    //---------------------------------------------------------------

    /** Don't let anyone instantiate this class. */
    private CellValueConverter(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------
    static Object convert(int sheetNo,String cellIndex,Object value,ExcelCell excelCell,Class<? extends Object> propertyClass){
        //primitive type should be mandatory
        if (propertyClass.isPrimitive()){
            excelCell.setMandatory(true);
        }

        //---------------------------------------------------------------
        DataConvertor<?> dataConvertor = DataConvertorConfigurator.getInstance().getConvertor(propertyClass);
        if (dataConvertor == null){
            throw new ExcelException(UNSUPPORTING_DATA_TYPE, sheetNo, cellIndex, value, excelCell);
        }
        return dataConvertor.convert(value, sheetNo, cellIndex, excelCell);
    }
}