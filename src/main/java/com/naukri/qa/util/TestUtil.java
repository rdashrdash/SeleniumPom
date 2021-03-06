package com.naukri.qa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long implicitWait = 20;
	public static long pageLoadTimeWait = 30;

	public static String testDataPath = "C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\"
			+ "src\\main\\java\\com\\naukri\\qa\\testdata\\SearchTestData.xlsx";

	private static XSSFWorkbook book;
	private static XSSFSheet sheet;

	public void switchFrame() {
		driver.switchTo().frame("");

	}

	public static void clickWhenReady(By locator, int timeout) {

		WebElement ele = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		ele.click();
	}

	public static void writeExcel(String sheetName, String result)
			throws IOException {
//		File file = new File(testDataPath);
//		FileInputStream inputStream = new FileInputStream(file);
//		Workbook inputWorkbook = null;
//		String fileExtensionName = fileName.substring(fileName.indexOf("."));
//		if (fileExtensionName.equals(".xlsx")) {
//			inputWorkbook = new XSSFWorkbook(inputStream);
//		} else if (fileExtensionName.equals(".xls")) {
//			inpputWorkbook = new HSSFWorkbook(inputStream);
//		}
//		Sheet sheet = inputWorkbook.getSheet(sheetName);

		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// book = WorkbookFactory.create(file);
			book = new XSSFWorkbook(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(result);
		}
		file.close();
		FileOutputStream outputStream = new FileOutputStream(testDataPath);
		book.write(outputStream);
		outputStream.close();
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// book = WorkbookFactory.create(file);
			book = new XSSFWorkbook(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

				// sheet.getRow(i + 1).getCell(j+1).setCellValue(result);

			}
		}
		return data;
	}

	public static void sendEmail() {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("username", "password"));
			email.setSSLOnConnect(true);
			email.setFrom("xyz@gmail.com");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail");
			email.addTo("abc.com");
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

	public static List<String[]> getCSVData(String csvFileName) {

		List<String[]> csvData = new ArrayList<String[]>();
		String testRow;
		try {

			BufferedReader br = new BufferedReader(new FileReader(csvFileName));
			while ((testRow = br.readLine()) != null) {

				String[] line = testRow.split(",");
				csvData.add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csvData;
	}

	public static String takeScreenshotForError(String fname) throws IOException {

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curDirectory = System.getProperty("user.dir");
		String destination = curDirectory + "\\Screenshot\\" + fname + ".png";
		FileUtils.copyFile(scr, new File(destination));

		return destination;
	}

}
