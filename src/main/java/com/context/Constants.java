package com.context;

/**
 * The Class is for Constants.
 *
 */
public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant REPORT_DIRECTORY. */
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationTestReport.html";

	/** The Constant PROJECT_NAME. */
	public final static String PROJECT_NAME = "Jinglebid Web-Automation";

	/** The Constant EXTENT_CONFIG_PATH. */
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";
//	/** The Constant PROPERTY_FILE_PATH. */
//	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/main/resources/mainresource/main1.properties";

	/** The Constant CHROME_DRIVER_PATH. */
//	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/chromedriver/chromedriver.exe";
	
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/main/resources/ChromeDriver/chromedriver127.exe";
	
//	public final static String CHROME_Headless_DRIVER_PATH = WORKING_DIRECTORY + "/src/main/resources/ChromeHeadLessShell/chromeheadlessshell127.exe";        //no use.

	/** The Constant FIREFOX_DRIVER_PATH. */
	public final static String FIREFOX_DRIVER_PATH = WORKING_DIRECTORY
			+ "/src/test/resources/drivers/firefoxdriver.exe";

	public static String MAIL_SUBJECT = "Jinglebid Web Buyer Automation Report";

}
