package com.naukri.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.JobSearchResults;
import com.naukri.qa.pages.LandingPage;
import com.naukri.qa.pages.SearchJobsPage;
import com.naukri.qa.util.TestUtil;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SearchjobsPageTest extends TestBase {

	private static final Logger log = LogManager.getLogger(SearchjobsPageTest.class.getName());

	LandingPage landingPage;
	SearchJobsPage searchPage;
	JobSearchResults resultsPage;

	String sheetName = "Search";

//	public static String csvFile = "C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\"
//			+ "src\\main\\java\\com\\naukri\\qa\\testdata\\CsvDataFile.csv";
	
	public SearchjobsPageTest() {
		super();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {
		try {
			initialization(browserName);
			landingPage = new LandingPage();

			Thread.sleep(10000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//CSV File as data source
/*	public static List<String[]> readCSV() {
		List<String[]> records = TestUtil.getCSVData(csvFile);
		for(String[] record : records) {
			for(String field : record) {
				System.out.println(field);
			}
		}
	}
*/	
		
	@DataProvider
	public Object[][] getSearchTestdata() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getSearchTestdata")
	public void searchResultsTest(String skills, String locations) throws InterruptedException {
		log.info("Entering the details.");
			resultsPage = landingPage.searchJobsResults(skills, locations);
			Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
}
