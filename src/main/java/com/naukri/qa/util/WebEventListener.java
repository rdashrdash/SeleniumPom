package com.naukri.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;

import com.naukri.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: '" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + "before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(ITestResult result, Throwable throwable, WebDriver driver) {
		try {
			TestUtil.takeScreenshotForError(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to  find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Start of script : " + script);
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("End of script : " + script);
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Ready to accept alert");
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert accepted");
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Ready to dismiss alert");
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert dismissed");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("page set to be refreshed");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page refreshed");
	}

	public void beforeChangeValue(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before changing value for : " + element);
	}

	public void afterChangeValue(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Changed value for : " + element);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Moving to window :" + windowName);
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Current window is : " + windowName);
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Initializing screenshot process");
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("Completing screenshot process");
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Ready to get text value of :" + element);
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("Obtaineed value for : " + element);
	}

	public void onException(Throwable throwable, WebDriver driver) {
	}
}
