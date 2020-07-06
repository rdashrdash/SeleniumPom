package com.naukri.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.naukri.qa.pages.JobSearchResults;
import com.naukri.qa.pages.LandingPage;
import com.naukri.qa.pages.SearchJobsPage;
import com.naukri.qa.util.TestUtil;

public class GridTestBase {

	protected WebDriver driver;
	LandingPage landingPage;
	SearchJobsPage searchPage;
	JobSearchResults resultsPage;

	
	@Parameters({"platform", "browser", "version", "url"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String platform, String browser, String version, String url) throws MalformedURLException {
		
		driver = getDriverInstance(platform, browser, version, url);
		landingPage = PageFactory.initElements(driver, LandingPage.class);
	}
	
	public static WebDriver getDriverInstance(String platform, String browser, String version, String url) throws MalformedURLException {
		
		String nodeURL = "http://192.168.8.152:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(platform.equalsIgnoreCase("WINDOWS")) {
			cap.setPlatform(Platform.WINDOWS);
		}
		if(platform.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		}
		
		cap.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeURL), cap);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeWait, TimeUnit.SECONDS);
		driver.get(url);

		return driver;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}