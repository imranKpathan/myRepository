package com.wipro.dias.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.wipro.dias.pages.SamplePage;
import com.wipro.dias.util.Constants;
import com.wipro.dias.util.Util;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class SampleSteps extends ScenarioSteps {

	SamplePage user;

	private static Logger appLogs = Logger.getLogger(SampleSteps.class);
	
	@Given("the user is in Training home page")
	public void theUserIsInTrainingHomePage() throws Exception {
		user.open();
		Util.pause(5);
	}

	@When("the user clicks on signin button")
	public void theUserClicksOnSigninButton() throws Exception {
		Util.pause(5);
		user.clickSignInLink();
	}

	@When("the user clicks '$elementName' on '$pageName'")
	public void theUserClicksOnSigninButton(final String elementName, final String pageName) throws Exception {
		Util.pause(5);
		user.clickElement(elementName, pageName);
	}

	@When("the user signs in with '<emailId>' and '<password>'")
	@Alias("the user logs in with'<emailId>' and '<password>'")
	public void theUserSignsInWithEmailIdAndPassword(
			@Named("emailId") final String emailId,
			@Named("password") final String password) {
		user.typeEmail(emailId);
		user.typePassword(password);
		user.clickSignInButton();
	}
	


	@Then("the user has signed in successfully")
	public void theUserVerifyUserSignedInSuccessfully() {
		assert (user.verifySignInSuccess());
		
	}
	
	@Then("the user signs out")
	public void theUserClicksOnSignOutLink() {
		user.clickSignOutLink();
	}


	@When("the user clicks on amazon logo")
	public void theUserClicksOnTrainingLogo() {
		user.clicksOnLogo();
		Util.pause(10);
	}

	@When("the user clicks on my account link")
	public void theUSerClicksOnMyAccountLink() throws Exception {
		user.clickMyAccountLink();
	}

	@When("the user clicks on manage address book")
	public void theUserClicksOnManageAddressBook() {
		user.clickManageAddressBookLink();
	}

	@When("the user types data in all the fields")
	public void theUserTypesDataInAllTheFields() throws Exception {
		if (Util.getBrandType().contains(Constants.AM)) {
		user.clickButtonEnterNewAddress();
		Util.pause(5);
		}
		user.typeFullName();
		user.typeAddress();
		user.typeTown();
		user.typeState();
		user.typePincode();
		user.typePhoneNumber();
	}

	@When("the user clicks on save and continue")
	public void theUserClicksOnSaveAndContinue() {
		user.clickSaveAndContinue();
	}

	@Then("the user verify the save address in address book")
	public void theUserVerifyTheSaveAddressInAddressBook() {
		assert (user.verifyTheSavedAddress());
	}

	@Then("the user deletes the newly added address in address book")
	public void theUserDeletesTheNewlyAddedAddressInAddressBook() {
		if(user.verifyTheSavedAddress()) {
			user.clickDeleteAddressButton();	
		} else {
			appLogs.info(Util.getMethodName(0) + "No Address detected to delete!!");
		}
	}

}
