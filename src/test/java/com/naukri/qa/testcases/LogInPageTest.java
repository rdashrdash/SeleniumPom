package com.naukri.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.JobSearchResults;
import com.naukri.qa.pages.LandingPage;
import com.naukri.qa.pages.SearchJobsPage;
import com.naukri.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInPageTest extends TestBase{

	ExtentReports report;
	ExtentTest test;
	
	LandingPage landingPage;
	SearchJobsPage searchPage;
	JobSearchResults resultsPage;

//	public LogInPageTest() {
//		super();
//	}
//	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browserName) {
		try {
			report = new ExtentReports("C:\\Users\\NITISH DASH\\SeleniumCucumber\\DataDriven\\test-output\\logTest.html");
			test = report.startTest("Verify Test");
			initialization(browserName);
			test.log(LogStatus.INFO, "Browser started");
			landingPage = new LandingPage();

			System.out.println("Browser started from grid base class.");
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void landingPageTitleTest() {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com", title);
	//	test.log(LogStatus.PASS, "Title verified");
	}

	@AfterMethod
	public void tearDown(ITestResult tresult) throws IOException {
		if(tresult.getStatus() == ITestResult.FAILURE) {
			String path = TestUtil.takeScreenshotForError(tresult.getName());			
		
			String imgPath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify title", imgPath);
		}
		
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
