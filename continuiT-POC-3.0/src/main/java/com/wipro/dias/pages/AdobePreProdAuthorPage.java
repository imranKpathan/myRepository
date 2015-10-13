package com.wipro.dias.pages;

import net.thucydides.core.pages.PageObject;

import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AdobePreProdAuthorPage extends PageObject {
	// private static Logger appLogs = Logger.getLogger(HomePage.class);
	public static Logger APP_LOGS = Logger.getLogger(AdobePreProdAuthorPage.class);

	public AdobePreProdAuthorPage(WebDriver driver) {
		super(driver);
		APP_LOGS.info("AdobePreProdAuthorPage instantiated");
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();		
	}
	
	public void typeAuthorUserName(String userName) {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("fieldUserName");
		$(element).type(userName);
	}
	
	public void typeAuthorPassword(String password) {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("fieldPassword");
		$(element).type(password);
	}
	
	public void clickSignIn() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonSignIn");
		$(element).click();
	}
	
	public boolean verifyUserProfileAvatar() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("logoUserProfileAvatar");
		boolean hasLogoUserProfileAvatar = $(element).isPresent();
		return hasLogoUserProfileAvatar;
	}
	
	public void clickLinkSitesInLeftColumn() {
		Util.pause(10);
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkSitesLeftColumn");
		//Util.waitForElementVisibility(getDriver(), element, "20");
		$(element).click();
	}
	
	public String getTitleBlackBar() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkSitesLeftColumn");
		return ($(element).getText());
	}
	
	public void clickIconClassicUiInSites() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkClassicUiIconInSites");
		$(element).click();
	}
	
	public boolean verifyAemLogoInClassicUi() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("logoAemInClassicUi");
		boolean hasLogoLogoAemInClassicUi = $(element).isPresent();
		return hasLogoLogoAemInClassicUi;
	}
	
	public void hoverLinkSitesAndClickClassicUiIcon() {
		String element1 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkSitesLeftColumn");
		Actions builder = new Actions(getDriver());
		Action mouseOverSites = builder.moveToElement($(element1))
				.build();
		String element2 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkClassicUiIconInSites");
		Action mouseOverIconClassicUi = builder.moveToElement($(element2))
				.click().build();
		mouseOverSites.perform();
		Util.pause(10);
		mouseOverIconClassicUi.perform();
		//Util.mouseMoveToPoint(20, 20);
	}
	
	public void clickButtonSiteAdmin() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonSiteAdmin");
		$(element).click();
	}
	
	public void clickLinkSevenSeas() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkSevenSeasInSiteAdminPage");
		$(element).click();
	}
	
	public void clickLinkEnglishMalaysia() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkEnglishMalaysia");
		$(element).click();
	}
	
	public void clickLinkTestPage() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkTestPage");
		//$(element).click();
		Actions action = new Actions(getDriver()).doubleClick($(element));
		action.build().perform();
	}
	
	public boolean verifySevenSeasLogoInTestPage() {
		/*
		WebDriver driver = getDriver();
		driver.switchTo().frame("cq-cf-frame");
		*/
		
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("logoSevenSeasInTestPage");
		boolean hasLogoLogoAemInClassicUi = $(element).isVisible();
		return hasLogoLogoAemInClassicUi;
	}
	
	public boolean verifyAemSideKickTestPage() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerAemSideKick");
		boolean hasAemSidekick = $(element).isVisible();
		return hasAemSidekick;
	}
	
	public void clickPageButtonInAemSideKick() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonPageAemSideKick");
		$(element).click();
	}
	
	public void clickLinkActivatePageInAemSideKick() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkActivatePageAemSideKick");
		$(element).click();
	}
	
	public boolean verifyBenefitIconsSeciontTestPage() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerBenefitIcons");
		boolean hasSectionBenefitIcons = $(element).isVisible();
		return hasSectionBenefitIcons;
	}
	
	public void dragAndDropBenefitIcons() {
		
		//Util.switchToFrame(getDriver(), "cq-cf-frame");
		//Util.switchToFrame(getDriver(), "cq-frame");
		/*
		WebDriver driver = getDriver();
		driver.switchTo().frame("cq-cf-frame");
		Util.pause(5);
		*/
		/*
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("testElement");
		$(element).click();
		Util.pause(5);
		*/
		/*
		$(element).click();
		Util.pause(5);
		*/
		/*
		Actions builder = new Actions(getDriver());
		String element1 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkBenefitIcon");
		String element2 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkContentHolder");
		Action dragAndDrop = builder.clickAndHold($(element1))
		   .moveToElement($(element2))
		   .release($(element2))
		   .build();
		Util.pause(2);
		dragAndDrop.perform();
		*/
		/*
		String element1 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkBenefitIcon");
		Actions builder = new Actions(getDriver());
		Action clickAndHoldBenefitIcons = builder.clickAndHold($(element1))
				.build();
		String element2 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkContentHolder");
		
		Action dropBenefitIconsInContentHolder = builder.moveToElement($(element2)).release($(element2))
		   .build();
		clickAndHoldBenefitIcons.perform();
		Util.pause(10);
		String iframe = "cq-cf-frame";
		Util.switchToSpecifiedFrame(getDriver(), iframe);
		dropBenefitIconsInContentHolder.perform();
		*/
		
		WebDriver driver = getDriver();
		driver.switchTo().defaultContent();
        String element1 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkBenefitIcon");
		 String element2 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkContentHolder");
		 Actions builder = new Actions(getDriver());
        builder.clickAndHold($(element1));
        Action action = builder.build();
        action.perform();

        //Util.pause(5);
		 String iframe = "cq-cf-frame";
		 Util.switchToSpecifiedFrame(getDriver(), iframe);
        
        //builder.moveToElement($(element2));
        builder.moveToElement($(element2)).release($(element2)).click();
        Action action2 = builder.build();
        action2.perform();
        Util.pause(10);
        //Util.reloadWebPage(getDriver());
        
		/*
        String element1 = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkBenefitIcon");
		Actions builder = new Actions(getDriver());
        builder.dragAndDropBy(($(element1)), -450, -300);
        Action action = builder.build();
        action.perform();
        */
	}
	
	public void doubleClickEditRolloverContainer() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkContentHolder");
		Actions action = new Actions(getDriver()).doubleClick($(element));
		action.build().perform();
	}
	
	public boolean verifyInsertNewComponentWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerInsertNewComponentWindow");
		boolean hasEditComponentWindow = $(element).isVisible();
		return hasEditComponentWindow;
	}
	
	public void selectBenefitIconsInInsertNewComponentWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonBenefitIconsInsertNewComponentWindow");
		$(element).click();
	}
	
	public void clickButtonOkInInsertNewComponentWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonOkInsertNewComponentWindow");
		$(element).click();
	}
	
	public void clickLinkMenuInTestPage() {
		
		//String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("logoSevenSeasInTestPage");
		 //String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkContentHolder");
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkMenuInTestPage");
		
		$(element).click();
	}
	
	public void clickComponentToEdit() {
		/*
		WebDriver driver = getDriver();
		driver.switchTo().defaultContent();
        */
		//String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkModifyBenefitIcons");
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerBenefitIcons");
		Actions action = new Actions(getDriver()).doubleClick($(element));
		action.build().perform();
	}
	
	public boolean verifyEditComponentWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerEditComponentWindow");
		boolean hasEditComponentWindow = $(element).isVisible();
		return hasEditComponentWindow;
	}
	
	public void typeDataInAsteriskField(String input) {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("fieldAsterisk");
		$(element).type(input);
	}
	
	public void typeDataInHeadlineField(String input) {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("fieldHeadline");
		$(element).type(input);
	}
	
	public void clickOkButtonInEditComponentDialog() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonOkEditComponentDialog");
		$(element).click();
	}
	
	public void clickPlusButtonInEditComponentDialog() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonPlusEditComponentDialog");
		$(element).click();
	}
	
	public void clickButtonSearchBenefitIconsInEditComponentDialog() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonSearchBenefitIconsEditComponentDialog");
		$(element).click();
	}
	
	public boolean verifySelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("headerSelectPathWindow");
		boolean hasSelectPathWindow = $(element).isVisible();
		return hasSelectPathWindow;
	}
	
	public void selectOkInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("buttonOkInSelectPathWindow");
		$(element).click();
	}
	
	public void selectAssetsInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkAssetsInSelectPathWindow");
		$(element).click();
	}
	
	public void selectMerckInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkMerckInSelectPathWindow");
		$(element).click();
	}
	
	public void selectHealthcareInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkHealthcareInSelectPathWindow");
		$(element).click();
	}
	
	public void selectConsumerHealthInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkConsumerHealthInSelectPathWindow");
		$(element).click();
	}
	
	public void selectGlobalBrandInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkGlobalBrandInSelectPathWindow");
		$(element).click();
	}
	
	public void selectSevenSeasInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkSevenSeasInSelectPathWindow");
		$(element).click();
	}
	
	public void selectGeneralAssetsInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkGeneralAssetsInSelectPathWindow");
		$(element).click();
	}
	
	public void selectImagesInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkImagesInSelectPathWindow");
		$(element).click();
	}
	
	public void selectBenefitIconsInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkBenefitIconsInSelectPathWindow");
		$(element).click();
	}
	
	public void selectTestIconsInSelectPathWindow() {
		String element = Util.OR_ADOBE_PREPROD_AUTHOR_PAGE.getProperty("linkTestIconsInSelectPathWindow");
		$(element).click();
	}

}
