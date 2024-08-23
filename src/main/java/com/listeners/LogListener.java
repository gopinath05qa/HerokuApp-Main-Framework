package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.util.LoggerUtil;

public class LogListener implements ITestListener {

	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		LoggerUtil.info(getTestName(result) + ": Test started");
		System.out.println("LogListener: onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtil.info(getTestName(result) + " : Test Passed");
		LoggerUtil.info(getTestDescription(result) + ":onTest Success");
		System.out.println("LogListener: onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		LoggerUtil.getLogger().fatal(getTestName(result) + " : Test Failed : " + cause);
		System.out.println("LogListener: onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtil.info(getTestName(result) + " : Test Skipped");
		System.out.println("LogListener: onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("LogListener: onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("LogListener: onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("LogListener: onFinish");
	}

}
