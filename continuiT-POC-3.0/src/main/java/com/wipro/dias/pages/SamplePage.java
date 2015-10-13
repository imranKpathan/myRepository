package com.wipro.dias.pages;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

//@DefaultUrl("http://amazon.in")
public class SamplePage extends PageObject {

	public void clickSignInLink() throws Exception {

		if (Util.getBrandType().contains(Constants.AM)) {
			String element1 = Util.OR_SAMPLE_PAGE
					.getProperty("linkNavigateToYourAccount");
			Actions builder = new Actions(getDriver());
			Action mouseOverMyAccount = builder.moveToElement($(element1))
					.build();
			String element2 = Util.OR_SAMPLE_PAGE.getProperty("buttonSignIn");
			Action mouseOverSignIn = builder.moveToElement($(element2)).click()
					.build();
			mouseOverMyAccount.perform();
			Util.pause(5);
			mouseOverSignIn.perform();
		} else {
			String element = Util.OR_SAMPLE_PAGE.getProperty("linkSignIn");
			$(element).click();

		}
	}

	public void clickSignOutLink() {
		if (Util.getBrandType().contains(Constants.AM)) {
			String element1 = Util.OR_SAMPLE_PAGE
					.getProperty("linkNavigateToYourAccount");
			Actions builder = new Actions(getDriver());
			Action mouseOverMyAccount = builder.moveToElement($(element1))
					.build();
			String element2 = Util.OR_SAMPLE_PAGE.getProperty("linkSignOut");
			Action mouseOverSignIn = builder.moveToElement($(element2)).click()
					.build();
			mouseOverMyAccount.perform();
			Util.pause(5);
			mouseOverSignIn.perform();
		} else {
			String element = Util.OR_SAMPLE_PAGE.getProperty("linkSignOut");
			$(element).click();
		}
	}

	public void typeEmail(final String emailId) {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textEmail");
		$(element).type(emailId);
	}
	
	public void clickElement(final String elementName, final String pageName) {
		
		
		String elementBegin = "Util.OR_";
		
		String elementEnd = "_PAGE.getProperty(elementName)";
		
		String element = elementBegin + pageName + elementEnd;
		$(element).click();
	}

	public void typePassword(final String password) {

		String element = Util.OR_SAMPLE_PAGE.getProperty("textPassword");
		$(element).type(password);
	}

	public void clickSignInButton() {
		String element = Util.OR_SAMPLE_PAGE
				.getProperty("buttonSingInUsingSecureServer");
		$(element).click();
	}

	public void clicksOnLogo() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("websiteLogo");
		$(element).click();
	}

	public void clickMyAccountLink() throws Exception {
		/*
		 * String element = "//*[@id='nav-link-yourAccount']";
		 * $(element).click();
		 */
		if (Util.getBrandType().contains(Constants.AM)) {
		String element1 = Util.OR_SAMPLE_PAGE
				.getProperty("linkNavigateToYourAccount");
		Actions builder = new Actions(getDriver());
		Action mouseOverMyAccount = builder.moveToElement($(element1)).build();
		String element2 = Util.OR_SAMPLE_PAGE.getProperty("linkYourAccount");
		Action mouseOverSignIn = builder.moveToElement($(element2)).click()
				.build();
		mouseOverMyAccount.perform();
		Thread.sleep(5000);
		mouseOverSignIn.perform();
		} else {
			String element = Util.OR_SAMPLE_PAGE
					.getProperty("linkNavigateToYourAccount");
			 $(element).click();
		}
	}

	public void clickManageAddressBookLink() {
		String element = Util.OR_SAMPLE_PAGE
				.getProperty("linkManageAddressBook");
		$(element).click();
	}

	public void clickButtonEnterNewAddress() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("buttonNewAddress");
		$(element).click();
	}

	public void typeFullName() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textFullName");
		$(element).type("Test Full Name");

	}

	public void typeAddress() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textAddress");
		$(element).type("TestAddress");

	}

	public void typeTown() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textTown");
		$(element).type("Kurnool");

	}

	public void typeState() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textState");
		if (Util.getBrandType().contains(Constants.AM)) {
		$(element).type("Andhra Pradesh");
		} else {
			$(element).selectByVisibleText("Andhra Pradesh");
		}

	}

	public void typePincode() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textPincode");
		$(element).type("518002");

	}

	public void typePhoneNumber() {
		String element = Util.OR_SAMPLE_PAGE.getProperty("textPhoneNumber");
		$(element).type("7890123456");

	}

	public void clickSaveAndContinue() {
		String element = Util.OR_SAMPLE_PAGE
				.getProperty("buttonSaveAndContinue");
		$(element).click();

	}
	
	public boolean verifySignInSuccess() {
		String element = Util.OR_SAMPLE_PAGE
				.getProperty("textSignInConfirmation");
		boolean elementPresent = $(element).isPresent();

		return elementPresent;
	}

	public boolean verifyTheSavedAddress() {
		String element = Util.OR_SAMPLE_PAGE
				.getProperty("textTheSavedAddress");
		boolean elementPresent = $(element).isPresent();

		return elementPresent;
	}

	public void clickDeleteAddressButton() {
		String element1 = Util.OR_SAMPLE_PAGE
				.getProperty("buttonDeleteAddress");
		$(element1).click();
		Util.pause(5);
		String element2 = Util.OR_SAMPLE_PAGE
				.getProperty("buttonConfirmDeleteAddress");
		$(element2).click();

	}

}
