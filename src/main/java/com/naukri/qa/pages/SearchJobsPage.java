package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class SearchJobsPage extends TestBase{

	@FindBy(xpath = "//*[@placeholder='Skills, Designations, Companies']")
	WebElement skill;

	@FindBy(xpath = "//*[@placeholder='Enter Locations…']")
	WebElement locations;

	@FindBy(xpath = "//*[@class='search-btn']")
	WebElement btnSearch;

	public SearchJobsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateSearchPageTitle() {
		return driver.getTitle();
	}
	
	public JobSearchResults searchJobsResults() {

		skill.sendKeys("testing");
		locations.sendKeys("Bhubaneshwar");
		btnSearch.click();

		return new JobSearchResults();

	}
}
