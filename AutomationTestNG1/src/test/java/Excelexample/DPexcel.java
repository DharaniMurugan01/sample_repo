package Excelexample;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class DPexcel {
    @DataProvider(name = "exceldata",parallel=true)
    public Object[][] excelProvider() throws IOException {
        Object[][] object= getExcelData("C:\\Users\\ADMIN\\git\\repositorytest\\AutomationTestNG1\\src\\test\\resources\\Book1.xlsx", "Sheet1");
        return object;
    }
    public String[][] getExcelData(String file,String sheet) throws IOException{
  	  String[][] data=null;
  	  try {
  	  FileInputStream fis=new FileInputStream(file);
  	  XSSFWorkbook wrkBk=new XSSFWorkbook(fis);
  	  XSSFSheet sht=wrkBk.getSheet(sheet);
  	  XSSFRow row=sht.getRow(0);
  	  int r=sht.getPhysicalNumberOfRows();
  	  int c=row.getLastCellNum();
  	  Cell cell;
  	  data=new String[r-1][c];
  	  for(int i=1;i<r;i++) {
  		  for(int j=0;j<c;j++) {
  			  row=sht.getRow(i);
  			  cell=row.getCell(j);
  			  data[i-1][j]=cell.getStringCellValue();
  		  }
  	  }
  	  }catch(Exception e) {
  		  System.out.println(e.getMessage());
  	  }
  	  return data;
    }
}
