package com.dolibar.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dolibar.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 30;
	public static Sheet sheet;
	public static FileInputStream input;
	public static XSSFWorkbook workbook;
	public static String filepath = "E:\\Revise_selenium\\Dolibar\\src\\main\\java\\com\\dolibar\\Testdata\\Dolibar 3.2.2.xlsx";
	
	public static Object[][] getTestData(String sheetName)
	{
		try {
			 input = new FileInputStream(new File(filepath));
			 workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			Row row = sheet.getRow(i+1);
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				Cell cell = row.getCell(j);
				String value = cellToString(cell);
				data[i][j] = value;
			}
		}
		return data;
	}
	
	@SuppressWarnings("deprecation")
	public static String cellToString(Cell cell)
	{
		int type = cell.getCellType();
		
		if(type == Cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(type == Cell.CELL_TYPE_NUMERIC)
		{
			String str = NumberToTextConverter.toText(cell.getNumericCellValue());
			return str;
		}
		else if(type == Cell.CELL_TYPE_BOOLEAN)
		{
			String str = "Sorry!-------we cant have boolean";
			return str;
		}
		return null;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}

}
