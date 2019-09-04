import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	public static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public static int rowCount;
	public static int lastColumn;
  	public static final String Path_TestData = System.getProperty("user.dir") + "//";
	public static final String File_TestData = "MS_Ref.xlsx";
	
	//this method is to set the file path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		
		try {
			//open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			
			//Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			rowCount = ExcelWSheet.getLastRowNum();
			lastColumn = ExcelWSheet.getRow(0).getLastCellNum();
			
		} catch (Exception e){
			throw (e);
		}
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			
		}catch (Exception e){
			return "";
		}
	}
	
	//This method is to write in the Excel cell, Row num and Col num are the parameters
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception{
		
		try{
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			
	//Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Path_TestData + File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
		} catch(Exception e){
			throw (e);
		}
	}

	
	
	

}
