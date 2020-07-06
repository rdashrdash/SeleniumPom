package com.naukri.qa.testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.JobSearchResults;
import com.naukri.qa.pages.LandingPage;
import com.naukri.qa.pages.SearchJobsPage;
import com.naukri.qa.util.TestUtil;

public class SearchjobsPageTestJSON extends TestBase {

	LandingPage landingPage;
	SearchJobsPage searchPage;
	JobSearchResults resultsPage;

	String sheetName = "Search";
	public String skills;
	public String locations;
	JSONParser parser=new JSONParser();

	public static String jsonFilePath = "C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\src\\main\\resources\\testdata.json";
	
	public static String csvFile = "C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\"
			+ "src\\main\\java\\com\\naukri\\qa\\testdata\\CsvDataFile.csv";
	
	public SearchjobsPageTestJSON() {
		super();
	}

	// JSON file as data source
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) throws FileNotFoundException, IOException, ParseException {
		try {
			initialization(browserName);
			Object obj = parser.parse(new FileReader(jsonFilePath));

			JSONObject jsonObject = (JSONObject) obj;
			
			skills = (String) jsonObject.get("Skill");
			locations = (String) jsonObject.get("Location");
			
			landingPage = new LandingPage();

			Thread.sleep(10000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void jsonRunData() throws InterruptedException {
		resultsPage = landingPage.searchJobsResults(skills, locations);
		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
}
