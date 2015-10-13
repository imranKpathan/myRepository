package com.wipro.dias.steps;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.steps.StepFactory;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

import com.wipro.dias.pages.HomePage;
import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;



public class HomeSteps extends ScenarioSteps {
	private SampleSteps sample;
	private HomePage homePage;
	@Steps
	private AbstractPlatform platform;
	
	private static Logger appLogs = Logger.getLogger(HomeSteps.class);
	
	/**
	 * Constructor.
	 * 
	 * @param pages
	 *            Pages object
	 * @throws ClassNotFoundException
	 *             Class not found exception
	 * @throws InstantiationException
	 *             Instantiation exception
	 * @throws IllegalAccessException
	 *             Illegal access exception
	 * @throws NoSuchMethodException
	 *             No such method exception
	 * @throws InvocationTargetException
	 *             Invocation target exception
	 */
	public HomeSteps(final Pages pages) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		super(pages);
		appLogs.log(Level.INFO, getClass().getPackage().getName()
				+ " Instantiated");
		thePages = pages;
	}

	private Pages thePages;

	public Pages getThePages() {
		return thePages;
	}
	
	
	private AbstractPlatform getThePlatform() throws ClassNotFoundException {
		String platformClassName = getClass().getPackage().getName()
				+ ".HomeSteps" + Util.getPlatform();
		platform = (AbstractPlatform) new StepFactory(getThePages())
				.instantiateNewStepLibraryFor(Class.forName(platformClassName));
		appLogs.info(Util.getMethodName(0) + "(): instantiated. platform = "
				+ Util.getPlatform());
		return platform;
	}
	
	@Given("the user is in homepage")
	public void theUserIsInHomePage() throws ClassNotFoundException {

		getThePlatform().theUserIsInHomePage();
	
	}
	
	/**
	 * This method opens home page of Adobe CEM.
	 */
	@Given("the user is in Adobe Pre-Prod author home page")
	public void theUserIsInAdobePreProdAuthorHomePage() {
		appLogs.info(Util.getMethodName(0) + "(): in class: "
				+ this.getClass().getName());
		homePage.openAt(Util.getAdobeAemAuthorUrl());
	}
	
	/**
	 * This method opens Site Admin page of Adobe CEM.
	 */
	@Given("the user is in Site Admin page")
	public void theUserIsInAdobeSiteAdminPage() {
		appLogs.info(Util.getMethodName(0) + "(): in class: "
				+ this.getClass().getName());
		homePage.openAt(Util.getAdobeAemSiteAdminUrl());
	}
	
	@Then("the user waits for '$waitTime' seconds")
	public void theUserWaitsForGivenAmountOfTime(final int waitTime) {
		Util.pause(waitTime);
	}
	
	@Given("the user sees the logo on the homepage")
	public void theUserSeesTheLogoOnHomePage(){
		assert(homePage.verifySevenSeasLogo());
	}
	
	@Given("the user sees navigation table")
	public void theUserSeesNavigationTable(){
		assert(homePage.verifyNavigationTable());
	}
	
	@Given("the user sees menu on the top left corner of the homepage")
	public void theUserSeesMenuOnHomepage(){
		assert(homePage.verifyMenu());
	}
	
	@When("the user clicks next button on the carousel")
	public void userClickNextButtonOnCarousel() {
		sample.theUserSignsInWithEmailIdAndPassword("E1", "P1");
		homePage.clickButtonNextOnCarousel();
	}
	
	@Then("the user sees the carousel")
	public void userSeesTheCarousel() {
		//To be implemented.
	}
	
	@When("the user clicks on Active link in the Navigation table")
	public void clickActiveLink() {
		homePage.clickLinkActiveOnNavigationTable();
	}
	
	@Then("the user is in Active page")
	public void userIsInActivePage() {
		String expected = "Active";
		String actual = homePage.getTextActivePageTitle();
		assert(actual.toLowerCase().contains(expected.toLowerCase()));
	}
	
	@When("the user clicks to open menu")
	public void clickMenuOpen() {
		homePage.clickButtonMenu();
	}
	
	@Then("a navigation overlay appears")
	public void viewNavigationOverlay() {
		assert(homePage.verifyNavigationOverlay());
	}
	
	@When("the user clicks Active link in Navigation overlay")
	public void clickActiveLinkInNavigationOverlay() {
		homePage.clickLinkActiveNavigationOverlay();
	}

/*	*//**
	 * This is reference method for Hover feature. This step is not used anywhere.
	 * 
	 *//*
	@When("the user hovers on Entertainment tab selects Find Your Package")
	public void userHoversOverEntertainmentAndSelectsFindYourPackage(){
		homePage.hoverLinkEntertainmentClickFindPackage();
		appLogs.info(Util.getMethodName(0) + "() in class: " + this.getClass().getName());
	}
	
	@When("the user searches for a product with '<keyword>' from HomePage")
	public void theUserLooksFor(@Named("keyword") final String keyword) {
		appLogs.info("Search Keyword = " + keyword);
		homePage.typeFieldSearchBox(keyword);
		homePage.clickButtonSearch();
	}
	
	@Then("the user is in search results page")
	public void theUserIsInSearchResultsPage(){
		String expected = "Search:";
		String actual = homePage.verifySearchTitleInSearchResultsPage();
		//assertThat(actual.toLowerCase(), containsString(expected.toLowerCase()));
		assert(actual.toLowerCase().contains(expected.toLowerCase()));
		//assertThat(actual,is(expected));
		//assertTrue("Search Title is not visible", actual.toLowerCase().contains(expected.toLowerCase()));
	}
	*/
}
