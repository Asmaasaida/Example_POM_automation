
package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExcelReader {

    public static Object[][] getTestData(String sheetName) throws IOException {
        InputStream inputStream = null;
        Workbook workbook = null;
        try {
            // Use ClassLoader to get the resource from the classpath
            inputStream = ExcelReader.class.getClassLoader().getResourceAsStream("Signupdata.xlsx");
            if (inputStream == null) {
                throw new FileNotFoundException("Signupdata.xlsx not found in classpath");
            }
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rowCount][columnCount];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = getCellValue(cell);
                }
            }
            return data;
        } catch (FileNotFoundException e) {
            System.err.println("Error: Excel file not found: " + e.getMessage());
            throw e;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
}