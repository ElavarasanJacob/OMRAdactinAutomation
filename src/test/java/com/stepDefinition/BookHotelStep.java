package com.stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author ELAVARASAN
 * @Description Adactin book hotel steps
 * @Date 08-07-2022
 */
public class BookHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description Fill all fields in book hotel page
	 * @Date 08-07-2022
	 * @param firstName
	 * @param laststName
	 * @param billingAdd
	 * @param dataTable
	 */
	@Then("User should fill all fields {string},{string}and{string}")
	public void userShouldFillAllFieldsAnd(String firstName, String laststName, String billingAdd,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> e = dataTable.asMaps();
		Map<String, String> m = e.get(1);
		String cardNo = m.get("CreditCardNo");
		String cardType = m.get("CreditCardType");
		String expMonth = m.get("ExpiryMonth");
		String expYr = m.get("Expiry Year");
		String cvvNo = m.get("CVVNumber");
		pom.getBookHotelPage().bookHotel(firstName, laststName, billingAdd, cardNo, cardType, expMonth, expYr, cvvNo);

	}

	/**
	 * @Description Verify booking confirmation msg
	 * @Date 08-07-2022
	 * @param expbookingConfirmMsg
	 */
	@Then("User should verify after booking on booking confirmation page {string}")
	public void userShouldVerifyAfterBookingOnBookingConfirmationPage(String expbookingConfirmMsg) {
		Assert.assertEquals("Verify Booking conifrmation Page", expbookingConfirmMsg,
				pom.getBookHotelPage().getBookingConfirmationMsg().getText());
	}

	/**
	 * @Description verify without enter any fields search
	 * @Date 08-07-2022
	 */
	@Then("User should verify without enter any fields")
	public void userShouldVerifyWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookHotel();

	}

	/**
	 * @Description verify an error message on Book a hotel page
	 * @Date 08-07-2022
	 * @param firstNameErrMsg
	 * @param lastNameErrMsg
	 * @param expAddressErrMsg
	 * @param expCreditCardNoErrMsg
	 * @param expCardTypeErrMsg
	 * @param expCardMonthYearErrMsg
	 * @param expCVVErrMsg
	 */
	@Then("User should verify an error message on Book a hotel page {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAnErrorMessageOnBookAHotelPageAnd(String firstNameErrMsg, String lastNameErrMsg,
			String expAddressErrMsg, String expCreditCardNoErrMsg, String expCardTypeErrMsg,
			String expCardMonthYearErrMsg, String expCVVErrMsg) {
		Assert.assertEquals("Verify firstname error message", firstNameErrMsg,
				pom.getBookHotelPage().getFirstNameErrorMsg().getText());
		Assert.assertEquals("Verify lastname error message", lastNameErrMsg,
				pom.getBookHotelPage().getLastNameErrorMsg().getText());
		Assert.assertEquals("Verify Address error message", expAddressErrMsg,
				pom.getBookHotelPage().getAddresErrorMsg().getText());
		Assert.assertEquals("Verify creditCard  error message", expCreditCardNoErrMsg,
				pom.getBookHotelPage().getCardNoErrorMsg().getText());
		Assert.assertEquals("Verify card year error message", expCardTypeErrMsg,
				pom.getBookHotelPage().getCardTypeErrorMsg().getText());
		Assert.assertEquals("Verify card Month error message", expCardMonthYearErrMsg,
				pom.getBookHotelPage().getCardExpMonthErrorMsg().getText());
		Assert.assertEquals("Verify Cvv error message", expCVVErrMsg,
				pom.getBookHotelPage().getCardCvvErrorMsg().getText());

	}

}