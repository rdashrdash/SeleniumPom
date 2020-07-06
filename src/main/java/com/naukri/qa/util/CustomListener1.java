package com.naukri.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener1 implements ITestListener {

	// Before test annotation of methods
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start -- test name :-- " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success -- test name :-- " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure -- test name :-- " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped -- test name :-- " + result.getName());
	}

	// Before test<> tag of xml testng file , not for test method
	@Override
	public void onStart(ITestContext context) {
		System.out.println("on test start -- test name :-- " + context.getName());
		ITestNGMethod methods[] = context.getAllTestMethods();
		System.out.println("These methods will be executed.");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on test finish -- test name :-- " + context.getName());
	}
}
