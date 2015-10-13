package com.wipro.dias.util;


import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.io.IOException;
import java.io.File;
import java.lang.reflect.Method;
import java.awt.AWTException;
import java.awt.Robot;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class contains utility methods, which can be used in Steps and Pages
 * files.
 * 
 * @author Imran Khan
 */
public class Util {
	
	public static Properties OR;
	public static Properties OR_HOME_PAGE;

	public static Properties OR_HOME_PAGE_DESKTOP;
	public static Properties OR_ADOBE_PREPROD_AUTHOR_PAGE;
	public static Properties OR_SAMPLE_PAGE;
	
	public static Properties NEW_WINDOW;
	
	private static String language;
	private static String brandType;
	private static String platform;
	private static String browser;
	private static String adobeAemAuthorUrl;
	private static String adobeAemSiteAdminUrl;
	
	private static long defaultImplicitlyWait;
	
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /T /IM ";
	private static Set<String> beforeHandles;
	private static String winHandleBefore;
	private static String parentTabHandle;
	
	public static Logger APP_LOGS = Logger.getLogger(Util.class);
	
//=========================================CONFIGURATION METHODS==================================
	
	/**
	 * This method sets the browser.
	 * 	
	 * @param br
	 */
	private static void setBrowser(final String br){
		if ("CHROME".equals(br.toUpperCase())) {
			browser = Constants.CHROME;
		} else if ("FIREFOX".equals(br.toUpperCase())) {
			browser = Constants.FIREFOX;
		} else if("iexplorer".equals(br.toUpperCase())){
			browser = Constants.IEXPLORER;
		}
			else {
		
			APP_LOGS.info("(): ERROR: The platform \'" + browser + "\' is not supported.\n");
		}
	}

	/**
	 * This method sets the Platform.
	 * 
	 * @param platf
	 */
	private static void setPlatform(final String platf) {
		if ("DESKTOP".equals(platf.toUpperCase())) {
			platform = Constants.PLATFORM_DESKTOP;
		} else if ("MOBILE".equals(platf.toUpperCase())) {
			platform = Constants.PLATFORM_MOBILE;
		} else {
			APP_LOGS.info("(): ERROR: The platform \'" + platf + "\' is not supported.\n");
		}

	}

	/**
	 * This method sets the Brand.
	 * 
	 * @param brand
	 */
	private static void setBrand(final String brand) {
		if ("SS".equals(brand)) {
			setBrandType(Constants.SS);
		} else if ("AM".equals(brand)) {
			setBrandType(Constants.AM);
		} else if ("FK".equals(brand)) {
			setBrandType(Constants.FK);
		} else
			APP_LOGS.info("(): ERROR: The brand \'" + brand
					+ "\' is not supported.");
	}
	/**
	 * This method sets the Language.
	 * 
	 * @param lang
	 */
	private static void setLang(final String lang) {
		if ("EN".equals(lang)) {
			setLanguage(Constants.EN);
		} else if ("HI".equals(lang)) {
			setLanguage(Constants.HI);
		}else if ("IT".equals(lang)) {
			setLanguage(Constants.IT);
		}  
		else {
			APP_LOGS.info("(): ERROR: The language \'" + lang + "\' is not supprted.");
		}
	}

	/**
	 * This method sets the default waiting times.
	 * 
	 * @param defaultImplicitlyWait
	 */
	public static void setDefaultImplicitlyWait(final long defaultImplicitlyWait) {
		Util.defaultImplicitlyWait = defaultImplicitlyWait;
	}
	
	/**
	 * This method returns the Browser.
	 * 
	 * @return
	 */
	public static String getBrowser(){
		return browser;
	}
	
	/**
	 * This method returns the platform (i.e. Desktop, Csr, Kiosk, Mobile).
	 * 
	 * @return platform
	 */
	public static String getPlatform() {
		return platform;
	}
	
	/**
	 * This method returns the Language.
	 * 
	 * @return language
	 */
	public static String getLanguage() {
		return language;
	}

	/**
	 * This method sets the Language.
	 * 
	 * @param lang
	 */
	public static void setLanguage(final String lang) {
		language = lang;
	}
	
	/**
	 * This method returns the default wait times.
	 * 
	 * @return defaultImplicitlyWait
	 */
	public static long getDefaultImplicitlyWait() {
		return defaultImplicitlyWait;
	}

	/**
	 * This method returns the Brand value.
	 * 
	 * @return brandType
	 */
	public static String getBrandType() {
		return brandType;
	}

	/**
	 * This method sets the Brand value.
	 * 
	 * @param brand
	 */
	public static void setBrandType(final String brand) {
		brandType = brand;
	}
	
	public static String getAdobeAemAuthorUrl() {
		return adobeAemAuthorUrl;
	}

	public static void setAdobeAemAuthorUrl(final String adobeAemAuthorUrl) {
		Util.adobeAemAuthorUrl = adobeAemAuthorUrl;
	}
	
	public static String getAdobeAemSiteAdminUrl() {
		return adobeAemSiteAdminUrl;
	}

	public static void setAdobeAemSiteAdminUrl(final String adobeAemSiteAdminUrl) {
		Util.adobeAemSiteAdminUrl = adobeAemSiteAdminUrl;
	}
//==========================================LANGUAGE SETTING=====================================
	
	/**
	 * Based on the language, this method selects one of the input parameters.
	 * 
	 * @param en
	 *            includes a string in English
	 * @param fr
	 *            includes a string in French
	 * @return A string. Depends on the language one of the parameters will be
	 *         returned
	 */
	public static String englishOrHindi(final String en, final String fr) {
		String expected = null;
		if (Constants.EN.equals(language)) {
			expected = en;
		} else if (Constants.HI.equals(language)) {
			expected = fr;
		} else {
			APP_LOGS.info(Util.getMethodName(0) + "(): ERROR: The language is not supported!");
		}
		return expected;
	}


//==========================================INITIALIZING FUNCTIONS=====================================
		
	/**
	 * This method initializes the run time execution settings that are passed through the batch file.
	 * 
	 * @param brand
	 * 		Defines the Brand that is going to be executed.
	 * @param lang
	 * 		Defines the Language in which the validation will take place.
	 * @param platf
	 * 		Defines the platform in which the execution will take place.
	 * @param browser
	 * 		Defines the browser in which the execution will take place.
	 * @throws IOException
	 */
	public static void initializing(final String brand, final String lang,
			final String platf, final String browser, final String adobeAemAuthorUrl, final String adobeAemSiteAdminUrl) throws IOException {
		setBrand(brand);
		setLang(lang);
		setPlatform("DESKTOP");
		setDefaultImplicitlyWait(200000);
		brandConfigLoader(brand);
		setAdobeAemAuthorUrl(adobeAemAuthorUrl);
		setAdobeAemSiteAdminUrl(adobeAemSiteAdminUrl);
	}
	
	/**
	 * This method loads the property files corresponding the runtime parameters specified in the batch files.
	 * 
	 * @param brandType
	 * 		Brand.
	 * @throws IOException
	 */
	public static void brandConfigLoader(String brandType) throws IOException {
		FileInputStream brandConfigFile = null;

			APP_LOGS.info("brandConfigLoader(): brandType= "+brandType);
			APP_LOGS.info("brandConfigLoader(): Platform = "+getPlatform());

			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ brandType + "//" + Constants.HOME_PAGE+".properties");
			OR_HOME_PAGE = new Properties();
			OR_HOME_PAGE.load(brandConfigFile);
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ brandType + "//" + Constants.HOME_PAGE_DESKTOP+".properties");
			OR_HOME_PAGE_DESKTOP = new Properties();
			OR_HOME_PAGE_DESKTOP.load(brandConfigFile);
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ brandType + "//" + Constants.ADOBE_PREPROD_AUTHOR_PAGE+".properties");
			OR_ADOBE_PREPROD_AUTHOR_PAGE = new Properties();
			OR_ADOBE_PREPROD_AUTHOR_PAGE.load(brandConfigFile);
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ brandType + "//" + Constants.SAMPLE_PAGE+".properties");
			OR_SAMPLE_PAGE = new Properties();
			OR_SAMPLE_PAGE.load(brandConfigFile);
			
	    }
	
	public static void newWindoConfigLoader(String newWindow) throws IOException {
		FileInputStream brandConfigFile = null;
		brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ brandType + "//" + Constants.NEW_WINDOW+".properties");
		NEW_WINDOW = new Properties();
		NEW_WINDOW.load(brandConfigFile);
	}
	
	
//==========================================MOUSE HANDLERS============================================
	
	/**
	 * This method moves the pointer to (X,Y) point.
	 * 
	 * @param x
	 *            X-axis
	 * @param y
	 *            Y-axis
	 */
	public static void mouseMoveToPoint(final int x, final int y) {
		Robot robot = null;
		try {
			robot = new Robot();
			robot.mouseMove(x, y);
		} catch (AWTException e) {
			APP_LOGS.info(getMethodName(0) + "(): Error: Could not move mouse to (" + x + ", " + y + ")" + e);
		}
	}
	
//======================================METHOD HANDLER================================================
	
	public static String getMethodName(final int depth) {
		try {
			StackTraceElement element = (StackTraceElement) m.invoke(new Throwable(), depth + 1);
			return element.getMethodName();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//========================================Process Handlers==============================================
	
	/**
	 * This method helps to pause the execution for a specified amount of time.
	 * 
	 * @param waitTime
	 */
	public static void pause(int waitTime) {
		try {
			Thread.sleep(1000 * waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * This method kills the process if it is found to be running.
	 * 
	 * @param browser
	 * @throws Exception
	 */
	public static void killTheProcessIfRunning(final String browser) throws Exception {
		APP_LOGS.info("**********" + getMethodName(0) + "(): browser = " + browser);

		if (Constants.IEXPLORER.equalsIgnoreCase(browser)) {
			if (isProcessRunging("iexplorer.exe")) {
				killProcess("iexplorer.exe");
			}
		} else if (Constants.CHROME.equalsIgnoreCase(browser)) {
			if (isProcessRunging("chrome.exe")) {
				killProcess("chrome.exe");
			}
		} else if (Constants.FIREFOX.equalsIgnoreCase(browser)) {
			if (isProcessRunging("firefox.exe")) {
				killProcess("firefox.exe");
			}
		} else {
			APP_LOGS.info(getMethodName(0) + "ERROR: Unsupported browser");
		}
	}
	
	private static Method m;

	static {
		try {
			m = Throwable.class.getDeclaredMethod("getStackTraceElement", int.class);
			m.setAccessible(true);

		} catch (Exception e) {
			APP_LOGS.info(e);
		}
	}	

	private static boolean isProcessRunging(final String serviceName) throws IOException {
		APP_LOGS.info("**********" + getMethodName(0) + "(): looking for process: " + serviceName);

		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			if (line.contains(serviceName)) {
				return true;
			}
		}

		return false;
	}

	private static void killProcess(final String serviceName) throws Exception {
		APP_LOGS.debug("**********" + getMethodName(0) + "() Kill process: " + serviceName);
		Runtime.getRuntime().exec(KILL + serviceName);
	}
	
	/**
	 * @param driver
	 *            Current webDriver
	 * @return PASS/FAILE
	 */
	public static String synchronize(final WebDriver driver) {
		APP_LOGS.debug("synchronize(): Wait for the page to load");

		try {
			((JavascriptExecutor) driver).executeScript("function pageloadingtime()" + "{" + "return 'Page has completely loaded'" + "}"
					+ "return (window.onload=pageloadingtime());");
			return Constants.PASS;
		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
			return Constants.FAIL;
		}
	}
	
	/**
	 * Set order number in the workbook and note down the time that order
	 * started processing.
	 * 
	 * @param testCaseId
	 *            the Test Case ID this step is currently testing against
	 * @exception BiffException
	 *                maybe thrown when an error reading the BIFF file occurs.
	 * @exception IOException
	 *                maybe thrown when failed or interrupted io operations have
	 *                occurred.
	 * @exception WriteException
	 *                maybe thrown when using the API to generate an Excel file.
	 */
	public static void setExecutionStatus(final String testCaseId) throws BiffException, IOException,
			WriteException {
		Date date = new Date();
		Workbook workbookF = Workbook.getWorkbook(new File(System.getProperty("user.dir") + "//" + "outPutFinal.xls"));
		Sheet sheetF = workbookF.getSheet(0);
		WritableWorkbook writableWorkBookT = Workbook.createWorkbook(new File(System.getProperty("user.dir") + "//" +"outPutTemp.xls"), workbookF);
		WritableSheet writableSheetT = writableWorkBookT.getSheet(0);
		if (sheetF.getRows() == 0) {
			Label label1 = new Label(0, 0, "Test Case ID");
			writableSheetT.addCell(label1);
			Label label2 = new Label(1, 0, "Start Time (ms)");
			writableSheetT.addCell(label2);
			
		}
		Label label3 = new Label(0, writableSheetT.getRows(), testCaseId);
		writableSheetT.addCell(label3);
		Label label4 = new Label(1, writableSheetT.getRows() - 1, String.valueOf(date.getTime()));
		writableSheetT.addCell(label4);
		
		writableWorkBookT.write();
		writableWorkBookT.close();
		Workbook workbookT = Workbook.getWorkbook(new File(System.getProperty("user.dir") + "//" + "outPutTemp.xls"));
		WritableWorkbook writableWorkBookF = Workbook.createWorkbook(new File(System.getProperty("user.dir") + "//" + "outPutFinal.xls"), workbookT);
		writableWorkBookF.write();
		writableWorkBookF.close();
	
		
	}
	
//==========================================WINDOW HANDLERS==================================================

	/**
	 * This method finds the designated iFrame on the web page.
	 * 
	 * @param driver
	 * 
	 * @param iframe
	 * 
	 * @return Result
	 */
	private static int findIframe(final WebDriver driver, final String iframe) {
		APP_LOGS.debug("findIframe()");

		int iframeIndex = 0;
		try {
			List<WebElement> allIframeID = driver.findElements(By.tagName("iframe"));
			System.out.println(allIframeID.size());
			for (iframeIndex = 0; iframeIndex < allIframeID.size(); iframeIndex++) {
				if (allIframeID.get(iframeIndex).getAttribute("class").equals(iframe)) {
					break;
				}
			}
			if (iframeIndex < allIframeID.size()) {
				// The frame is found, return its index
				return (iframeIndex);
			} else {
			//assertThat("ERROR: could not find iframe \"iframe Name\"" + " to switch to ", false);
			}
		} catch (Exception e) {
			APP_LOGS.info("ERROR: could not switch to iframe \"iframe Name\" " + e);
			;
		}

		return (-1);
	}
	
	
	/**
	 * This method enables the driver to Switch to the iFrame that has been found earlier.
	 * 
	 * @param driver
	 *            Current webDriver
	 * @param iframe
	 *            A string indicating the frame name in the page
	 */
	public static void switchToFrame(final WebDriver driver, final String iframe) {
		APP_LOGS.debug(Util.getMethodName(0) + "(): iframe= " + iframe);
		int index = findIframe(driver, iframe);
		APP_LOGS.debug("switchToFrame(): Number of iFrame: index=" + index);
		if (index >= 0) {
			driver.switchTo().frame(index);
		} else {
			APP_LOGS.info("ERROR: Could not switch to iframe: \"" + iframe + "\"");
		}
	}
	
	
	/**
	 * This method enables the driver to Switch to the iFrame whose characteristics have been passed.
	 * 
	 * @param driver
	 *            Current webDriver
	 * @param iframe
	 *            A string indicating the frame name in the page
	 */
	public static void switchToSpecifiedFrame(final WebDriver driver, final String iframe) {
		APP_LOGS.debug(Util.getMethodName(0) + "(): iframe= " + iframe);
		driver.switchTo().frame(iframe);
	}

	/**
	 * This method bring you back to default window right before switching to
	 * iFrame.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void switchToDefaultWindow(final WebDriver driver) {
		// This method bring you back to default window right before switching
		// to iFrame
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to save parent window, so we can back to it.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void storeParentWindowHandler(final WebDriver driver) {
		APP_LOGS.info("storeParentWindowHandler()");
		beforeHandles = driver.getWindowHandles();
	}

	/**
	 * This method switches a window.
	 * 
	 * @param driver
	 *            CUrrent webDriver
	 */
	public static void switchToNewWindow(final WebDriver driver) {
		APP_LOGS.debug("switchToNewWindow()");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * This method closes the window.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void closeNewWindow(final WebDriver driver) {
		APP_LOGS.debug("closeNewWindow()");
		driver.close();
	}

	/**
	 * This method switches to parent window.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void switchToParentWindow(final WebDriver driver) {
		APP_LOGS.debug("switchToParentWindow()");
		driver.switchTo().window(winHandleBefore);
	}

	/**
	 * This method switches to a pop-up window.
	 * 
	 * @param driver
	 *            Current webDriver
	 * @return PASS/FAIL
	 */
	public static String switchToPopupWindow(final WebDriver driver) {
		APP_LOGS.info("switchToPopupWindow()");

		try {
			// wait for the new window to open
			new WebDriverWait(driver, 30) {
			}.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver driver) {
					boolean res;
					if (driver.getWindowHandles().size() >= beforeHandles.size()) {
						res = true;
					} else {
						res = false;
					}
					return res;
				}
			});
			// Get after handles
			Set<String> afterHandles = driver.getWindowHandles();
			// remove all before handles from after, if you need. Leaves you
			// with new window handle
			/*
			 * afterHandles.removeAll(beforeHandles);
			 * 
			 * //Switch to the new window String newWindowHandle =
			 * afterHandles.iterator().next();
			 * driver.switchTo().window(newWindowHandle);
			 */
			Iterator<String> ite = afterHandles.iterator();
			Iterator<String> iteBeforeHandles = beforeHandles.iterator();
			String handle = iteBeforeHandles.next().toString();
			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();
				if (!popupHandle.contains(handle)) {
					driver.switchTo().window(popupHandle);
					
					/* Here you can perform operation in pop-up window */
					// After finished your operation in pop-up just select the
					// main window again
					// driver.switchTo().window(beforeHandles);
				}
			}

		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
			return Constants.FAIL;
		}
		return Constants.PASS;
	}

	/**
	 * This method closes the pop-up window.
	 * 
	 * @param driver
	 *            Current webDriver
	 * @return PASS/FAIL
	 */
	public static String closePopupWindow(final WebDriver driver) {
		APP_LOGS.debug("closePopupWindow()");

		try {
			driver.close();
			switchToMainWindow(driver);

		} catch (Exception e) {
			APP_LOGS.info(e.getMessage());
			return Constants.FAIL;
		}
		return Constants.PASS;
	}

	/**
	 * This method switches to main window.
	 * 
	 * @param driver
	 *            Current webDriver
	 * @return PASS/FAIL
	 */
	public static String switchToMainWindow(final WebDriver driver) {
		APP_LOGS.debug(getMethodName(0) + "()");

		try {
			Iterator<String> ite = beforeHandles.iterator();
			String mainHandle = ite.next().toString();
			driver.switchTo().window(mainHandle);
		} catch (Exception e) {
			return Constants.FAIL + "Unable to switch to the main window. " + e.getMessage();
		}
		return Constants.PASS;
	}
	
	
	/**
	 * This method is used to save parent tab, so we can go back to it.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void storeParentTabHandler(final WebDriver driver) {
		parentTabHandle = driver.getWindowHandle();
	}	

	/**
	 * This method switches to a new tab.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void switchToNewTab(final WebDriver driver) {
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(parentTabHandle);
	}
	
	/**
	 * This method switches to back to parent tab.
	 * 
	 * @param driver
	 *            Current webDriver
	 */
	public static void switchToBackParentTab(final WebDriver driver) {
		driver.switchTo().window(parentTabHandle);
	}
	
//==========================================WEB ELEMENT HANDLERS================================

	/**
	 * This method waits for element visibility.
	 * 
	 * @param driver
	 *            The Current webDriver
	 * @param object
	 *            The xpath of element
	 * @param maxTime
	 *            The waiting time
	 * @return String (PASS/FAIL)
	 */
	public static String waitForElementVisibility(final WebDriver driver, final String object, final String maxTime) {
		APP_LOGS.debug("waitForElementVisibility()");

		int start = 0;
		int time = (int) Double.parseDouble(maxTime);
		try {
			while (start == time) {
				if (driver.findElements(By.xpath(object)).size() == 0) {
					pause(1);
					start++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			APP_LOGS.info("Object not found: " + object + ". Details: " + e.getMessage());
			return Constants.FAIL;
		}
		return Constants.PASS;
	}

	/**
	 * This method waits for the element to be displayed in the page.
	 * 
	 * @param webDriver
	 *            Current webDriver
	 * @param object
	 *            The element address in CSS
	 * @return A string (PASS/FAIL/ERROR)
	 * @throws InterruptedException
	 *             Exception
	 */
	public static String waitUntilDisplayed(final WebDriver webDriver, final String object) throws InterruptedException {
		APP_LOGS.debug("waitUntil()");

		int count = 0;
		WebElement element = null;
		try {
			do {
				element = webDriver.findElement(By.cssSelector(object));
				if (element.isDisplayed()) {
					break;
				}
				count++;
				Thread.sleep(Constants.WAIT_FOR_1000MS * 2);
			} while (count < Constants.NUM_OF_RETRY);
			if (count < Constants.NUM_OF_RETRY) {
				return Constants.PASS;
			} else {
				return Constants.FAIL + " -- Time is up and Object has not showed up.";
			}
		} catch (Exception e) {
			return Constants.ERROR + " Object not found: " + object + ". Details: " + e.getMessage();
		}
	}

	/**
	 * This method waits for an element to be enabled.
	 * 
	 * @param webDriver
	 *            Current webDriver
	 * @param object
	 *            The element address in CSS
	 * @return A string (PASS/FAIL/ERROR)
	 * @throws InterruptedException
	 *             exception
	 */
	public static String waitUntilEnabled(final WebDriver webDriver, final String object) throws InterruptedException {
		APP_LOGS.debug("waitUntil()");

		int count = 0;
		WebElement element = null;
		try {
			do {
				element = webDriver.findElement(By.cssSelector(object));
				if (element.isEnabled()) {
					break;
				}
				count++;
				Thread.sleep(Constants.WAIT_FOR_1000MS * 2);
			} while (count < Constants.NUM_OF_RETRY);
			if (count < Constants.NUM_OF_RETRY) {
				return Constants.PASS;
			} else {
				APP_LOGS.info("Time is up and Object has not showed up");
				return Constants.FAIL;
			}
		} catch (Exception e) {
			APP_LOGS.info(" Object not found: " + object + ". Details: " + e.getMessage());
			return Constants.ERROR;
		}
	}

	/**
	 * This method waits for element to be selected.
	 * 
	 * @param webDriver
	 *            Current webDriver
	 * @param object
	 *            Element address in CSS
	 * @return A string (PASS/FAIL/ERRRO)
	 * @throws InterruptedException
	 *             exception
	 */
	public static String waitUntilSelected(final WebDriver webDriver, final String object) throws InterruptedException {
		APP_LOGS.debug("waitUntil()");

		int count = 0;
		WebElement element = null;
		try {
			do {
				element = webDriver.findElement(By.cssSelector(object));
				if (element.isSelected()) {
					break;
				}
				count++;
				Thread.sleep(Constants.WAIT_FOR_1000MS * 2);
			} while (count < Constants.NUM_OF_RETRY);
			if (count < Constants.NUM_OF_RETRY) {
				return Constants.PASS;
			} else {
				APP_LOGS.info("Time is up and Object has not showed up.");
				return Constants.FAIL;
			}
		} catch (Exception e) {
			APP_LOGS.info(" Object not found: " + object + ". Details: " + e.getMessage());
			return Constants.ERROR;
		}
	}

	
	//==========================================WEB PAGE HANDLERS================================

		/**
		 * This method waits reloads/refreshes the page.
		 * 
		 * @param driver
		 *            The Current webDriver
		 */
		public static void reloadWebPage(final WebDriver driver) {
			APP_LOGS.debug("reloadWebPage()");
			driver.navigate().refresh();
			pause(10);
		}
//==========================================RANDOM DATA GENERATORS====================================
	
	/**
	 * This method creates a random integer type number for making username and
	 * email to create an account.
	 * 
	 * @return int
	 */
	public static int randomNumberGenerator() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt();
	}
	

}