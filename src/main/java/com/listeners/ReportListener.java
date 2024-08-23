package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.report.ExtentReportManager;
import com.util.ReportUtil;

public class ReportListener implements ITestListener {

	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(getTestName(result), getTestDescription(result));
		System.out.println("ReportListener: onTestStart");
	}

//  **Commented by Gopinath, why: on the extend report the final result screenshot two times showing. That's why commented**//	
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		ReportUtil.addScreenShot(LogStatus.PASS, "Test Completed");
//	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		ReportUtil.addScreenShot(LogStatus.FAIL, "Test Failed : " + cause);
		System.out.println("ReportListener: onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("ReportListener: onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("ReportListener: onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("ReportListener: onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("ReportListener: onFinish");
		ExtentReportManager.endCurrentTest();
		ExtentReportManager.getExtentReports().flush();
	}

}
