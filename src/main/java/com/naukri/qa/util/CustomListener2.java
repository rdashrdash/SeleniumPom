package com.naukri.qa.util;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener2 implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("Before invocation : " + testResult.getTestClass().getName() + "---" 
				+ method.getTestMethod().getMethodName());
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("After invocation : " + testResult.getTestClass().getName() + "---" 
				+ method.getTestMethod().getMethodName());
	}

	}
