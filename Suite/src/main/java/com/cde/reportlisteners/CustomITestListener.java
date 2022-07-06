package com.cde.reportlisteners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class CustomITestListener implements ITestListener{
	private static final Logger logger = LogManager.getLogger(CustomITestListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("**** Started executing " + result.getMethod() + " Test case ****");			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("**** End of executing " + result.getMethod() + " Test case ****");

	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			//TakeScreenShot.takeScreenshot1(result.getMethod().getMethodName());
			logger.info("**** End of executing " + result.getMethod() + " Test case ****");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("**** End of executing " + result.getMethod() + " Test case ****");

		}

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("**** Skipped executing " + result.getMethod() + " Test case ****");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start Of Execution(TEST)->"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("END Of Execution(TEST)->"+context.getName());

	}
}
