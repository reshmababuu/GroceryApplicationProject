package utilitieS;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtility
{
	public static FileInputStream f;
	 public static XSSFWorkbook w;
	 public static XSSFSheet s;
		
	 public static String readStringData(int row, int column) throws IOException
	 {
	 f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excelfile\\Book1.xlsx");
	// f=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GroceryApp\\src\\main\\resources\\excelfile\\Book1.xlsx");//location
		 w = new XSSFWorkbook(f); //opening the book
	  s = w.getSheet("Sheet1"); // page of the book
	  Row r = s.getRow(row); //row interface , getting to the row
	  org.apache.poi.ss.usermodel.Cell c = r.getCell(column); //getting to the column using row
	  return c.getStringCellValue(); 
	 }
		
	 public static String readIntegerData(int row, int column) throws IOException
	 {
	  f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\excelfile\\Book1.xlsx");
		// f=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\GroceryApp\\src\\main\\resources\\excelfile\\Book1.xlsx");
	  w = new XSSFWorkbook(f);
	  s = w.getSheet("Sheet1");
	  Row r = s.getRow(row);
	  org.apache.poi.ss.usermodel.Cell c =  r.getCell(column);
	  int a =(int) c.getNumericCellValue();
	  return String.valueOf(a);
	 }
		
	
}
