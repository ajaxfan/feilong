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
package com.feilong.excel.销售数据;

import java.util.List;

import org.junit.Test;

public class WriteTest extends AbstractSalesDataWriteTest{

    @Test
    public void test(){
        String templateFileName = "销售数据/export-template-sales.xlsx";
        String configurations = "excel/销售数据/sheets-definition.xml";

        String sheetName = "salesDataExport";

        //---------------------------------------------------------------
        List<SalesData> list = buildList();
        build(templateFileName, configurations, sheetName, "salesDataList", list);
    }

}
