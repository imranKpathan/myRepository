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





import com.wipro.dias.pages.AdobePreProdAuthorPage;
import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;



public class AdobePreProdAuthorSteps extends ScenarioSteps {
	
	private AdobePreProdAuthorPage adobePreProdAuthorPage;
	@Steps
	private AbstractPlatform platform;
	
	private static Logger appLogs = Logger.getLogger(AdobePreProdAuthorSteps.class);
	
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
	public AdobePreProdAuthorSteps(final Pages pages) throws ClassNotFoundException,
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
	
	@When("the user logs in as a Pre-Prod Author with '<userName>' and '<password>'")
	public void theAuthorLogsIn(@Named("userName") final String userName, @Named("password") final String password) {
		//String userName = "admin";
		//String password = "madmin2015preprod";
		adobePreProdAuthorPage.typeAuthorUserName(userName);
		Util.pause(2);
		adobePreProdAuthorPage.typeAuthorPassword(password);
		Util.pause(2);
		adobePreProdAuthorPage.clickSignIn();
	
	}
	
	@Then("the user is logged on to the AEM-Touch UI")
	public void theUSerIsLoggedOnToAemTouchUi() {
		assert(adobePreProdAuthorPage.verifyUserProfileAvatar());
	}
	
	@When("the user logs clicks Sites link in the left hand side column")
	public void theUserClicksSitesLink() {
		adobePreProdAuthorPage.clickLinkSitesInLeftColumn();
	}
	
	@Then("the user sees the sites page")
	public void theUserSeesTheSitesPage() {
		assert (adobePreProdAuthorPage.getTitleBlackBar().contains("Sites"));
	}

	
	@When("the user clicks Classic UI Icon in Sites")
	public void theUserClicksClassicUiIConInSites() {
		Util.storeParentTabHandler(getDriver());
		Util.pause(5);
		//adobePreProdAuthorPage.clickIconClassicUiInSites();
		adobePreProdAuthorPage.hoverLinkSitesAndClickClassicUiIcon();
	}
	
	@Then("the user sees the Adobe AEM in Classic UI mode")
	public void theUserIsInClassicUiMode() {
		/*
		Util.switchToNewTab(getDriver());
		Util.pause(5);
		*/
		assert(adobePreProdAuthorPage.verifyAemLogoInClassicUi());
		Util.pause(20);
	}
	
	@When("the user clicks Site Admin button")
	public void theUserClicksSiteAdminButton() {
		adobePreProdAuthorPage.clickButtonSiteAdmin();
	}
	
	@When("the user selects Seven Seas")
	public void theUserClicksSevenSeasLink() {
		Util.storeParentWindowHandler(getDriver());
		Util.pause(5);
		Util.switchToNewWindow(getDriver());
		Util.pause(5);
		adobePreProdAuthorPage.clickLinkSevenSeas();
		Util.pause(2);
	}
	
	@When("the user selects English Malaysia")
	public void theUserClicksEnglishMalaysiaLink() {
		adobePreProdAuthorPage.clickLinkEnglishMalaysia();
		Util.pause(2);
	}
	
	@When("the user selects Test Page")
	public void theUserClicksTestPageLink() {
		/*Util.storeParentTabHandler(getDriver());
		Util.pause(5);
		*/
		adobePreProdAuthorPage.clickLinkTestPage();
		Util.pause(10);
		/*
		Util.pause(10);
		Util.switchToNewWindow(getDriver());*/
	}
	
	@Then("the user sees the Test Page in AEM content finder")
	public void verifySevenSeasLogoInTestPage() {
		
		Util.storeParentWindowHandler(getDriver());
		Util.pause(5);
		Util.switchToNewWindow(getDriver());
		Util.pause(5);
		/*
		String iframe = "cq-cf-frame";
		Util.switchToSpecifiedFrame(getDriver(), iframe);
		Util.pause(5);
		*/
		//assert(adobePreProdAuthorPage.verifySevenSeasLogoInTestPage());
		//Util.pause(5);
		
		//adobePreProdAuthorPage.clickLinkMenuInTestPage();
	}
	
	@Then("the user sees the AEM Sidekick")
	public void verifyAemSideKick() {
		/*
		Util.switchToDefaultWindow(getDriver());
		Util.pause(5);
		
		assert(adobePreProdAuthorPage.verifyAemSideKickTestPage());
		*/
	}
	
	@When("the user drags and drops the benefit icons into the container")
	public void theUserDragsAndDropsBenefitIcons() {
		//Util.pause(10);
		adobePreProdAuthorPage.dragAndDropBenefitIcons();
		/*
		String iframe = "cq-cf-frame";
		 Util.switchToSpecifiedFrame(getDriver(), iframe);
		 */
		 //adobePreProdAuthorPage.clickLinkMenuInTestPage();
		 Util.pause(10);
	}
	
	@When("the user adds the benefit icons to the container")
	public void theAddsBenefitIconsToTheContainer() {
		
		String iframe = "cq-cf-frame";
		Util.switchToSpecifiedFrame(getDriver(), iframe);
		adobePreProdAuthorPage.doubleClickEditRolloverContainer();
		Util.pause(2);
		//Util.switchToDefaultWindow(getDriver());
		assert(adobePreProdAuthorPage.verifyInsertNewComponentWindow());
		Util.pause(2);
		adobePreProdAuthorPage.selectBenefitIconsInInsertNewComponentWindow();
		Util.pause(2);
		adobePreProdAuthorPage.clickButtonOkInInsertNewComponentWindow();
		Util.pause(2);
	}
	
	@Then("the user sees the Benefit Icons section")
	public void verifyBenefitIconsSection() {
		/*
		String iframe = "cq-cf-frame";
		Util.switchToSpecifiedFrame(getDriver(), iframe);
		*/
		assert(adobePreProdAuthorPage.verifyBenefitIconsSeciontTestPage());
	}
	
	@When("the user selects to edit the component")
	public void theUserSelectsToEditComponent() {
		
		adobePreProdAuthorPage.clickComponentToEdit();
		Util.pause(5);
		
	}
	
	@Then("the user sees the Edit Component window")
	public void verifyEditComponentWindow() {
		//Util.switchToDefaultWindow(getDriver());
		//Util.pause(5);
		assert(adobePreProdAuthorPage.verifyEditComponentWindow());
	}
	
	@When("the user enters data in the Asterisk field '<testInput>'")
	public void theUserEntersDataInAsteriskField(@Named("testInput") final String testInput) {
		adobePreProdAuthorPage.typeDataInAsteriskField(testInput);
		//adobePreProdAuthorPage.clickOkButtonInEditComponentDialog();
	}
	
	@When("the user selects plus button to add more components in Edit Component Window")
	public void theUserSelectsPlusButtonInEditComponentWindow() {
		adobePreProdAuthorPage.clickPlusButtonInEditComponentDialog();
	}
	
	@When("the user searches to add Benefit Icons in Edit Component Window")
	public void theUserAddsBenefitIconsInEditComponentWindow() {
		adobePreProdAuthorPage.clickButtonSearchBenefitIconsInEditComponentDialog();
		Util.pause(5);
	}
	
	@Then("the user sees the Select Path window")
	public void verifySelectPathWindow() {
		assert(adobePreProdAuthorPage.verifySelectPathWindow());
	}
	
	@When("the user selects the path of the image")
	public void theUserSelectsPathOfTheImage() {
		//Assets>>MErck>>Healthcare>>Consumer Health>>Global Brand>>SevenSeas>>General Assets>>Images>>Benefit Icons>>Test Icons
		adobePreProdAuthorPage.selectAssetsInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectMerckInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectHealthcareInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectConsumerHealthInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectGlobalBrandInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectSevenSeasInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectGeneralAssetsInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectImagesInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectBenefitIconsInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectTestIconsInSelectPathWindow();
		Util.pause(2);
		adobePreProdAuthorPage.selectOkInSelectPathWindow();
	}
	
	@When("the user enters data in the Headline field '<testHeadlineInput>'")
	public void theUserEntersDataInHeadlineField(@Named("testHeadlineInput") final String testHeadlineInput) {
		adobePreProdAuthorPage.typeDataInHeadlineField(testHeadlineInput);
		//adobePreProdAuthorPage.clickOkButtonInEditComponentDialog();
	}
	
	@When("the user click OK button to close Edit Component window")
	public void theUserClicksOkButton(){
		adobePreProdAuthorPage.clickOkButtonInEditComponentDialog();
	}
	
	@When("the user Page button in AEM Sidekick")
	public void theUserClicksPageButtonInAemSidekick(){
		Util.switchToDefaultWindow(getDriver());
		Util.pause(5);
		adobePreProdAuthorPage.clickPageButtonInAemSideKick();
	}
	
	@When("the user selects Activate Page link in AEM Sidekick")
	public void theUserClicksActivatePageLinkInAemSidekick(){
		adobePreProdAuthorPage.clickLinkActivatePageInAemSideKick();
		Util.pause(5);
	}
	
}
