package com.stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author ELAVARASAN
 * @Description
 * @Date 08-07-2022
 */
public class CancelBookingStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description canceling orderId
	 * @Date 08-07-2022
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Then("User should cancel the orderId")
	public void userShouldCancelTheOrderId() throws InterruptedException, IOException {
		String orderId1 = pom.getBookingConfirmation().getOrderId();
		pom.getCancelBookingPage().cancelbkng(orderId1);
	}

	/**
	 * @Description verifying cancel message
	 * @Date 08-07-2022
	 * @param expbookingCancelMsg
	 */
	@Then("User should verify cancel message on Booked Itinerary page  {string}")
	public void userShouldVerifyCancelMessageOnBookedItineraryPage(String expbookingCancelMsg) {
		Assert.assertEquals("Verify Booking cancel msg", expbookingCancelMsg,
				pom.getCancelBookingPage().getBookingCancelMsg().getText());
	}

	/**
	 * @Description Cancel the booked orderId
	 * @Date 08-07-2022
	 * @param bookedOrdderId
	 * @throws InterruptedException
	 */
	@Then("User should cancel the booked orderid {string}")
	public void userShouldCancelTheBookedOrderid(String bookedOrdderId) throws InterruptedException {
		pom.getCancelBookingPage().cancelbkng(bookedOrdderId);
	}

}
