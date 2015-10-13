package com.wipro.dias.steps;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;

import net.serenitybdd.jbehave.SerenityStories;

public class AcceptanceTestSuite extends SerenityStories {

	/**
	 * This is a logger variable and can be re-used whenever you need to print
	 * some information on the console during execution.
	 * 
	 */
	public static Logger APP_LOGS = Logger.getLogger(AcceptanceTestSuite.class);

	public static String baseUrl;

	public AcceptanceTestSuite() throws IOException {
	//public void main() throws IOException {

		baseUrl = getEnvironmentVariables().getProperty("webdriver.base.url");
		APP_LOGS.info("AcceptanceTestSuite(): baseUrl=" + baseUrl);

		/**
		 * NAMING STANDARDS FOR STORIES.
		 * 
		 */

		findStoriesCalled("*verify*.story");

		/**
		 * PRINTING WHICH STORIES ARE BEING EXECUTED ON THE CONSOLE OUTPUT.
		 * 
		 */
		List<String> storyPaths = storyPaths();
		if (storyPaths.size() == 1) {
			APP_LOGS.info("Running story: " + storyPaths.get(0));
		} else {
			outputWhichStoriesAreBeingRun(storyPaths.subList(0,
					storyPaths.size() - 1));
		}

		/**
		 * This segment loads the Properties files corresponding to the Brand
		 * which is defined in the Batch configuration file.
		 * 
		 */
		if (baseUrl.toLowerCase().contains(Constants.SS_PROD)) {
			Util.brandConfigLoader(Constants.SS);
		} else if (baseUrl.toLowerCase().contains(Constants.AM_PROD)) {
			Util.brandConfigLoader(Constants.AM);
		} else if (baseUrl.toLowerCase().contains(Constants.FK_PROD)) {
			Util.brandConfigLoader(Constants.FK);
		} else {
		APP_LOGS.info("Not supported URL: \"" + baseUrl + "\"");
		}

		/**
		 * This segment calls the initializing function defined in Util.java.
		 * This sets up the Brand, Test Environment, Language etc. to be re-used
		 * as and when required.
		 * 
		 */
		Util.initializing(getEnvironmentVariables().getProperty("brand"),
				getEnvironmentVariables().getProperty("lan"),
				getEnvironmentVariables().getProperty("platform"),
				getEnvironmentVariables().getProperty("webdriver.driver"),
				getEnvironmentVariables().getProperty("adobeAemAuthorUrl"),
				getEnvironmentVariables().getProperty("adobeSiteAdminUrl"));
		// Util.initializing("OD","EN","DESKTOP","firefox");
		
	}
	private void outputWhichStoriesAreBeingRun(final List<String> stories) {
		APP_LOGS.info("Running stories: ");
		APP_LOGS.info("stories: " + stories);
		for (String story : stories) {
			APP_LOGS.info(" - " + story);
		}
	}

}
