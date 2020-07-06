package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class JobSearchResults extends TestBase {

	@FindBy(xpath = "//*[@class='fleft grey-text mr-5 fs12']")
	WebElement totalResults;

	public JobSearchResults() {
		PageFactory.initElements(driver, this);
	}

	public boolean totalSearchResults() {
		return totalResults.isDisplayed();
		
	}
	
}
