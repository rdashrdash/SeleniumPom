package com.naukri.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.JobSearchResults;
import com.naukri.qa.pages.LandingPage;
import com.naukri.qa.pages.SearchJobsPage;

public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	SearchJobsPage searchPage;
	JobSearchResults resultsPage;

	public LandingPageTest() {
		super();
	}

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browserName) {
		try {
			initialization(browserName);
			landingPage = new LandingPage();

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void landingPageTitleTest() {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com", title);
	}

	@Test(priority = 2)
	public void naukriImageTest() {
		boolean flag = landingPage.validateNaukriImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void searchJobsTest() {
		searchPage = landingPage.searchJobs();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}