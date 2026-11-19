package com.itm.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
public class ExcelUtil {
    public static Object[][] getLoginData()
            throws Exception {
        FileInputStream fis =
                new FileInputStream(
                        "testdata/TestData.xlsx");
        Workbook workbook =
                WorkbookFactory.create(fis);
        Sheet sheet =
                workbook.getSheet("login");
        int rows =
                sheet.getPhysicalNumberOfRows();
        Object[][] data =
                new Object[rows - 1][2];
        for(int i = 1; i < rows; i++) {
            data[i - 1][0] =
                    sheet.getRow(i)
                            .getCell(0)
                            .toString();
            data[i - 1][1] =
                    sheet.getRow(i)
                            .getCell(1)
                            .toString();
        }
        workbook.close();
        return data;
    }
}
