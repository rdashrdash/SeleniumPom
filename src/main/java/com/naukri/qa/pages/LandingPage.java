package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath = "//*[@class='mTxt' and text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//*[@class='mTxt' and text()='Jobs']")
	WebElement Jobs;

	@FindBy(xpath = "//a[@title='Search Jobs' and @data-ga-track='Main Navigation Jobs|Search Jobs']")
	WebElement SearchJobs;

	@FindBy(xpath = "//img[@itemprop='logo']")
	WebElement NaukriLogo;

	@FindBy(xpath = "//*[@placeholder='Skills, Designations, Companies']")
	WebElement skill;

	@FindBy(xpath = "//*[@placeholder='Enter Locations…']")
	WebElement locations;

	@FindBy(xpath = "//*[@class='search-btn']")
	WebElement btnSearch;

	// initiate all web elements
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Declare actions
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}

	public boolean validateNaukriImage() {
		return NaukriLogo.isDisplayed();
	}

	public String validateSearchPageTitle() {
		return driver.getTitle();
	}

	public SearchJobsPage searchJobs() {
		Actions act = new Actions(driver);
		act.moveToElement(Jobs).build().perform();

		SearchJobs.click();
		return new SearchJobsPage();
	}

	public JobSearchResults searchJobsResults(String skillSet, String location) {
		skill.sendKeys(skillSet);
		locations.sendKeys(location);
		btnSearch.click();

		return new JobSearchResults();
	}
}
