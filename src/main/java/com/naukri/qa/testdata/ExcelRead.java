package com.naukri.qa.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {

		String testDataPath = "C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\"
				+ "src\\main\\java\\com\\naukri\\qa\\testdata\\SearchTestData.xlsx";

		String sheetName = "Search";

		XSSFWorkbook excelBook;
		XSSFSheet sheet;
		XSSFCell cell;

		try {
			FileInputStream excelFile = new FileInputStream(testDataPath);
			excelBook = new XSSFWorkbook(excelFile);
			sheet = excelBook.getSheet(sheetName);
			
			cell = sheet.getRow(0).getCell(0);
			String cellData = cell.getStringCellValue();
			System.out.println("Data is : " + cellData);
			
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					String data = sheet.getRow(i + 1).getCell(j).toString();
					System.out.println(data);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
