package com.stepDefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author ELAVARASAN
 * @Description Adactin select hotel page steps
 * @Date 08-07-2022
 *
 */
public class SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description Select hotel
	 * @Date 08-07-2022
	 */
	@Then("User should select hotel")
	public void userShouldSelectHotel() {
		pom.getSelectHotelPage().selectHotelAndContinue();
	}

	/**
	 * @Description Verify Book A Hotel msg
	 * @Date 08-07-2022
	 * @param expBookAHotelMsg
	 */
	@Then("User should verify after select hotel in book a hotel page {string}")
	public void userShouldVerifyAfterSelectHotelInBookAHotelPage(String expBookAHotelMsg) {
		Assert.assertEquals("Verify Book A Hotel msg", expBookAHotelMsg,
				pom.getSelectHotelPage().getBookAHotelMsg().getText());
	}

	/**
	 * @Description Without selecting any hotel
	 * @Date 08-07-2022
	 */
	@Then("User should click continue without selecting any hotel")
	public void userShouldClickContinueWithoutSelectingAnyHotel() {
		pom.getSelectHotelPage().withoutSelectHotelContinue();
	}

	/**
	 * @Description Get error message on select a hotel page
	 * @Date 08-07-2022
	 * @param expPleaseSelectHotelErrMsg
	 */
	@Then("User should verify without select hotel get error message on select a hotel page {string}")
	public void userShouldVerifyWithoutSelectHotelGetErrorMessageOnSelectAHotelPage(String expPleaseSelectHotelErrMsg) {
		Assert.assertEquals("Verify Please Select a Hotel msg", expPleaseSelectHotelErrMsg,
				pom.getSelectHotelPage().getSelectHotelErrorMsg().getText());
	}

}
