package com.wipro.dias.steps;

import net.thucydides.core.pages.Pages;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.wipro.dias.pages.HomePageDesktop;
import com.wipro.dias.util.Util;

/**
 * This class includes overloaded methods of test steps of Home page in DESKTOP
 * platform.
 * 
 * @author Imran Khan
 * 
 */
@SuppressWarnings("serial")
public class HomeStepsDesktop extends AbstractPlatform {

	private static Logger appLogs = Logger.getLogger(HomeStepsDesktop.class);

	/**
	 * Constructor.
	 * 
	 * @param pages
	 *            An instance of Pages class
	 */
	public HomeStepsDesktop(final Pages pages) {
		super(pages);
		appLogs.log(Level.INFO, getClass().getPackage().getName() + " Instantiated");
	}

	private HomePageDesktop homePageDesktop;

	
	@Override
	protected void theUserIsInHomePage() {
		appLogs.info(Util.getMethodName(0) + "(): in class: " + this.getClass().getName());
		homePageDesktop.open();
		Util.pause(2);
	}

}
