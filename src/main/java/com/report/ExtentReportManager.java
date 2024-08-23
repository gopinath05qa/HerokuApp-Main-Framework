package com.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.context.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * The Class handles the report activities.
 *
 * @author Omprakash darsi
 */
public class ExtentReportManager {

	/** The extent reports. */
	private static ExtentReports extentReports;

	/** The map. */
	private static Map<Long, ExtentTest> map = new HashMap<>();

	/**
	 * Gets the extent reports.
	 *
	 * @return the extent reports
	 */
	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports(Constants.REPORT_DIRECTORY);
			extentReports.assignProject(Constants.PROJECT_NAME);
			extentReports.loadConfig(new File(Constants.EXTENT_CONFIG_PATH));
		}
		return extentReports;
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc     the desc
	 */
	public synchronized static void startTest(String testName, String desc) {
		ExtentTest test = getExtentReports().startTest(testName, desc);
//		map.put(Thread.currentThread().getId(), test); // Here i faced deprecation issue that's why i changed below
		// line.
		map.put(Thread.currentThread().threadId(), test);
	}

	/**
	 * Gets the current test.
	 *
	 * @return the current test
	 */
	public synchronized static ExtentTest getCurrentTest() {
//		return map.get(Thread.currentThread().getId()); //same deprecation issue as like above one.
		return map.get(Thread.currentThread().threadId());
	}

	/**
	 * End current test.
	 */
	public synchronized static void endCurrentTest() {
		getExtentReports().endTest(getCurrentTest());
	}
}
