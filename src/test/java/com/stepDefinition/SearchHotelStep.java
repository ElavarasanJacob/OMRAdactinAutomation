package com.stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author ELAVARASAN
 * @Description Adactin search hotel page steps
 * @Date 08-07-2022
 * 
 */
public class SearchHotelStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description To select all fields and search
	 * @Date 08-07-2022
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param checkInDate
	 * @param ceckOutDate
	 * @param adults
	 * @param child
	 * @throws IOException
	 */
	@Then("User should select all fields and search {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSelectAllFieldsAndSearchAnd(String location, String hotels, String roomType, String noOfRooms,
			String checkInDate, String ceckOutDate, String adults, String child) throws IOException {

		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, noOfRooms, checkInDate, ceckOutDate, adults,
				child);

	}

	/**
	 * @Description To select all fields and search
	 * @Date 08-07-2022
	 * @param expSelectHotelMsg
	 */
	@Then("User should verify after search {string}")
	public void userShouldVerifyAfterSearch(String expSelectHotelMsg) {
	
		Assert.assertEquals("verify Select hotel Msg", expSelectHotelMsg, pom.getSearchHotelPage().getSelectHotelMsg().getText());

	}

	/**
	 * @Description To select all fields and search
	 * @Date 08-07-2022
	 * @param location
	 * @param noOfRooms
	 * @param checkInDate
	 * @param ceckOutDate
	 * @param adults
	 * @throws IOException
	 */
	@Then("User should select only manatory fields and search {string},{string},{string},{string}and{string}")
	public void userShouldSelectOnlyManatoryFieldsAndSearchAnd(String location, String noOfRooms, String checkInDate,
			String ceckOutDate, String adults) throws IOException {

		pom.getSearchHotelPage().searchHotel(location, noOfRooms, checkInDate, ceckOutDate, adults);

	}

	/**
	 * @Description Get date error msg
	 * @Date 08-07-2022
	 * @param expCheckInDateErrMsg
	 * @param expCheckoutDateErrMsg
	 */
	@Then("User should verify after search get date error message of {string},{string}")
	public void userShouldVerifyAfterSearchGetDateErrorMessageOf(String expCheckInDateErrMsg,
			String expCheckoutDateErrMsg) {
		Assert.assertEquals("Verify CheckIndate error msg", expCheckInDateErrMsg,
				pom.getSearchHotelPage().getCheckIndateErrormsg().getText());
		Assert.assertEquals("Verify CheckOutdate error msg", expCheckoutDateErrMsg,
				pom.getSearchHotelPage().getCheckOutdateErrormsg().getText());
	}

	/**
	 * @Description Search without select any fields
	 * @Date 08-07-2022
	 */
	@Then("User should not select any fields and click search")
	public void userShouldNotSelectAnyFieldsAndClickSearch() {
		pom.getSearchHotelPage().searchHotel();
	}

	/**
	 * @Description Get error msg of Please Select a Location
	 * @Date 08-07-2022
	 * @param expSelectlocationErrMsg
	 */
	@Then("User should verify after search get error message in search hotel page  {string}")
	public void userShouldVerifyAfterSearchGetErrorMessageInSearchHotelPage(String expSelectlocationErrMsg) {
		Assert.assertEquals("Verify search hotel error msg", expSelectlocationErrMsg,
				pom.getSearchHotelPage().getLocationErrorMsg().getText());

	}

}
