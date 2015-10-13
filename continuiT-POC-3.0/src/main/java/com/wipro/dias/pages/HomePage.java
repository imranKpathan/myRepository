package com.wipro.dias.pages;

import net.thucydides.core.pages.PageObject;

import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageObject {
	// private static Logger appLogs = Logger.getLogger(HomePage.class);
	public static Logger APP_LOGS = Logger.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
		APP_LOGS.info("HomePage instantiated");
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();		
	}
/*
	public void hoverLinkEntertainmentClickFindPackage() {
		String element1 = Util.OR_HOME_PAGE.getProperty("tabEntertainment");
		Actions builder = new Actions(getDriver());
		Action mouseOverEntertainment = builder.moveToElement($(element1))
				.build();
		String element2 = Util.OR_HOME_PAGE.getProperty("linkFindYourPackage");
		Action mouseOverFindYourPackage = builder.moveToElement($(element2))
				.click().build();
		mouseOverEntertainment.perform();
		Util.pause(10);
		mouseOverFindYourPackage.perform();
		Util.mouseMoveToPoint(20, 20);
	}

	public final void typeFieldSearchBox(final String keyword) {
		APP_LOGS.info("Search Keyword = " + keyword);
		Util.pause(2);
		String element = Util.OR_HOME_PAGE.getProperty("fieldSearchBox");
		$(element).type(keyword);
	}

	public final void clickButtonSearch() {
		String element = Util.OR_HOME_PAGE.getProperty("buttonSearch");
		$(element).click();
	}

	public String verifySearchTitleInSearchResultsPage() {
		// //*[@id="selectedFilters"]/div/span[1]
		String element = Util.OR_PLP.getProperty("titleSearch");
		return $(element).getText();
	}
*/	
	public boolean verifySevenSeasLogo() {
		String element = Util.OR_HOME_PAGE.getProperty("logoSevenSeas");
		boolean hasLogoSevenSeas = $(element).isPresent();
		return hasLogoSevenSeas;
	}
	
	public boolean verifyNavigationTable() {
		String element = Util.OR_HOME_PAGE.getProperty("tableNavigationLinks");
		boolean hasNavigationTable = $(element).isPresent();
		return hasNavigationTable;
	}
	
	public boolean verifyMenu() {
		String element = Util.OR_HOME_PAGE.getProperty("textMenu");
		boolean hasMenu = $(element).isPresent();
		return hasMenu;
	}

	public final void clickButtonNextOnCarousel() {
		String element = Util.OR_HOME_PAGE.getProperty("buttonNextCarousel");
		$(element).click();
	}

	public final void clickLinkActiveOnNavigationTable() {
		String element = Util.OR_HOME_PAGE.getProperty("linkActiveNAvigationTable");
		$(element).click();
	}
	
	public final String getTextActivePageTitle() {
		String element = Util.OR_HOME_PAGE.getProperty("textActivePageTitle");
		return $(element).getText();
	}

	public final void clickButtonMenu() {
		String element = Util.OR_HOME_PAGE.getProperty("buttonMenu");
		$(element).click();
	}
	
	public boolean verifyNavigationOverlay() {
		String element = Util.OR_HOME_PAGE.getProperty("linkActiveNavigationOverlay");
		boolean hasLogoSevenSeas = $(element).isPresent();
		return hasLogoSevenSeas;
	}

	public final void clickLinkActiveNavigationOverlay() {
		String element = Util.OR_HOME_PAGE.getProperty("linkActiveNavigationOverlay");
		$(element).click();
	}
}
