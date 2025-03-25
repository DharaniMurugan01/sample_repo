package Excelexample;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DPexcel {

    @DataProvider(name = "exceldata", parallel = true)
    public Object[][] excelProvider() throws IOException {
    	String filePath = System.getProperty("user.dir") + "/src/test/resources/Book1.xlsx";
        String sheetName = "Sheet1";

        Object[][] object = getExcelData(filePath, sheetName);
        
        // Debugging: Print if data is null
        if (object == null) {
            System.out.println("Error: DataProvider returned null.");
        }
        
        return object;
    }

    public String[][] getExcelData(String file, String sheet) throws IOException {
        String[][] data = null;
        
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook wrkBk = new XSSFWorkbook(fis)) {

            XSSFSheet sht = wrkBk.getSheet(sheet);
            if (sht == null) {
                System.out.println("Error: Sheet " + sheet + " not found in file " + file);
                return new String[][]{};
            }

            XSSFRow row = sht.getRow(0);
            if (row == null) {
                System.out.println("Error: First row is empty in sheet " + sheet);
                return new String[][]{};
            }

            int r = sht.getPhysicalNumberOfRows();
            int c = row.getLastCellNum();
            data = new String[r - 1][c];

            for (int i = 1; i < r; i++) {
                row = sht.getRow(i);
                if (row == null) continue; // Skip empty rows

                for (int j = 0; j < c; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        data[i - 1][j] = ""; // Avoid null values
                    } else {
                        data[i - 1][j] = cell.getStringCellValue();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print full error stack trace
            return new String[][]{}; // Return empty array instead of null
        }

        return data;
    }
}
