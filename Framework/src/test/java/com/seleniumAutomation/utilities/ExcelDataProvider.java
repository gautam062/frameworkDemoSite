package com.seleniumAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws FileNotFoundException {
		File src = new File("./Testdata/Data.xlsx");
			
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel File "+ e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();	
	}
	
	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();	
	}
	
	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		
	}

}
