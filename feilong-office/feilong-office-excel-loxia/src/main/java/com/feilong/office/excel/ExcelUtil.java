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
package com.feilong.office.excel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

/**
 * The Class ExcelUtil.
 */
public class ExcelUtil{

    /** Don't let anyone instantiate this class. */
    private ExcelUtil(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------

    /** The Constant DYNAMIC_CELL_PATTREN. */
    private static final Pattern DYNAMIC_CELL_PATTREN = Pattern.compile("[A-Z][A-Z]?\\d+");

    /**
     * Gets the cell index.
     *
     * @param row
     *            the row
     * @param col
     *            the col
     * @return the cell index
     */
    public static String getCellIndex(int row,int col){
        CellReference cell = new CellReference(row, col);
        return cell.formatAsString().replaceAll("\\$", "");
    }

    //---------------------------------------------------------------

    /**
     * Gets the cell position.
     *
     * @param cellIndex
     *            the cell index
     * @return the cell position
     */
    public static int[] getCellPosition(String cellIndex){
        CellReference cellReference = new CellReference(cellIndex);
        return new int[] { cellReference.getRow(), cellReference.getCol() };
    }

    /**
     * Offset cell index.
     *
     * @param cellIndex
     *            the cell index
     * @param rowOffset
     *            the row offset
     * @param colOffset
     *            the col offset
     * @return the string
     */
    static String offsetCellIndex(String cellIndex,int rowOffset,int colOffset){
        CellReference cellReference = new CellReference(cellIndex);
        CellReference newCell = new CellReference(cellReference.getRow() + rowOffset, cellReference.getCol() + colOffset);
        return newCell.formatAsString().replaceAll("\\$", "");
    }

    //---------------------------------------------------------------

    /**
     * Offset formula.
     *
     * @param formula
     *            the formula
     * @param rowOffset
     *            the row offset
     * @param colOffset
     *            the col offset
     * @return the string
     */
    static String offsetFormula(String formula,int rowOffset,int colOffset){
        StringBuffer sb = new StringBuffer();
        Matcher matcher = DYNAMIC_CELL_PATTREN.matcher(formula);
        int head = 0, start = 0, end = -1;
        while (matcher.find()){
            start = matcher.start();
            end = matcher.end();
            sb.append(formula.substring(head, start));
            sb.append(offsetCellIndex(formula.substring(start, end), rowOffset, colOffset));
            head = end;
        }
        sb.append(formula.substring(head));
        return sb.toString();
    }

    //---------------------------------------------------------------

    /**
     * Copy sheet.
     *
     * @param sheet
     *            the sheet
     * @param newSheet
     *            the new sheet
     */
    static void copySheet(Sheet sheet,Sheet newSheet){
        int maxCol = 0;
        for (int row = 0; row <= sheet.getLastRowNum(); row++){
            Row oldRow = sheet.getRow(row);
            if (oldRow == null){
                continue;
            }
            Row newRow = newSheet.getRow(row);
            if (newRow == null){
                newRow = newSheet.createRow(row);
            }
            if (oldRow.getHeight() >= 0){
                newRow.setHeight(oldRow.getHeight());
            }
            maxCol = (maxCol >= oldRow.getLastCellNum() - 1 ? maxCol : oldRow.getLastCellNum() - 1);
            for (int col = 0; col < oldRow.getLastCellNum(); col++){
                Cell oldCell = oldRow.getCell(col);
                if (oldCell == null){
                    continue;
                }
                Cell newCell = newRow.getCell(col);
                if (newCell == null){
                    newCell = newRow.createCell(col);
                }
                CellCoper.copy(oldCell, newCell);
            }
        }
        for (int col = 0; col <= maxCol; col++){
            if (sheet.getColumnWidth(col) >= 0){
                newSheet.setColumnWidth(col, sheet.getColumnWidth(col));
            }
        }
        for (int i = 0; i < sheet.getNumMergedRegions(); i++){
            CellRangeAddress cra = sheet.getMergedRegion(i);
            newSheet.addMergedRegion(cra);
        }
    }

    //---------------------------------------------------------------

}
