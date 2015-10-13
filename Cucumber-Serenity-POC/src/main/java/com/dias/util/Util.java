package com.dias.util;



import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

import com.dias.util.Constants;

/**
 * This class contains utility methods, which can be used in Steps and Pages
 * files.
 * 
 * @author Imran Khan
 */
public class Util {
	
	public static Properties OR;
	public static Properties OR_HOME_PAGE;
	public static Properties OR_RESPONSE_RULE_PAGE;
	public static Properties OR_NEW_TEMPLATE_PAGE;
	
	private static String nameCurrentResponseRule;
	
	public static Logger APP_LOGS = Logger.getLogger(Util.class);
	
//=========================================CONFIGURATION METHODS==================================
	
	
	
	/**
	 * This method loads the property files corresponding the runtime parameters specified in the batch files.
	 * 
	 * @param brandType
	 * 		Brand.
	 * @throws IOException
	 */
	public static void brandConfigLoader() throws IOException {
		FileInputStream brandConfigFile = null;
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ Constants.HOME_PAGE+".properties");
			OR_HOME_PAGE = new Properties();
			OR_HOME_PAGE.load(brandConfigFile);
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ Constants.RESPONSE_RULE_PAGE+".properties");
			OR_RESPONSE_RULE_PAGE = new Properties();
			OR_RESPONSE_RULE_PAGE.load(brandConfigFile);
			
			brandConfigFile = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//"+ Constants.NEW_TEMPLATE_PAGE+".properties");
			OR_NEW_TEMPLATE_PAGE = new Properties();
			OR_NEW_TEMPLATE_PAGE.load(brandConfigFile);
			
		
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
	
//==================================================CUSTOME METHODS========================================
	/**
	 * This method returns the Response Rule's name.
	 * 
	 * @return getNameCurrentResponseRule
	 */
	public static String getNameCurrentResponseRule() {
		return nameCurrentResponseRule;
	}

	/**
	 * This method sets the the Response Rule's name.
	 * 
	 * @param name
	 */
	public static void setNameCurrentResponseRule(final String name) {
		nameCurrentResponseRule = name;
	}
}