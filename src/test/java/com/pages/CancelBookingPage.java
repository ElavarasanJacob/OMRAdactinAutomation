package com.pages;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description
 * @Date 08-07-2022
 */
public class CancelBookingPage extends BaseClass {
	/**
	 * @Description Driver initialize for CancelBookingPage
	 * @Date 08-07-2022
	 */
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_id_text")
	private WebElement enterOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement searchOrderId;

	@FindBy(id = "check_all")
	private WebElement radioBtnClick;

	@FindBy(xpath = "//input[contains(@id,'btn_id_')]")
	private WebElement cancelOrder;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bkdItinerary;

	@FindBy(xpath = "//label[@id='search_result_error']")
	private WebElement bookingCancelMsg;

	public WebElement getBookingCancelMsg() {
		return bookingCancelMsg;
	}

	public WebElement getEnterOrderId() {
		return enterOrderId;
	}

	public WebElement getSearchOrderId() {
		return searchOrderId;
	}

	public WebElement getRadioBtnClick() {
		return radioBtnClick;
	}

	public WebElement getCancelOrder() {
		return cancelOrder;
	}

	public WebElement getBkdItinerary() {
		return bkdItinerary;
	}

	/**
	 * @Description Canceling booking orderId
	 * @Date 08-07-2022
	 * @param orderid
	 * @throws InterruptedException
	 */
	public void cancelbkng(String orderid) throws InterruptedException {
		click(getBkdItinerary());
		textPass(getEnterOrderId(), orderid);
		click(getSearchOrderId());
		click(getRadioBtnClick());
		click(getCancelOrder());
		switctoAlert();
	}

}
