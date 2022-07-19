package com.pages;

import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description POM for Adactin BookingConfirmationPage
 * @Date 08-07-2022
 */
public class BookingConfirmationPage extends BaseClass {
	/**
	 * @Description Driver initialize for BookingConfirmationPage
	 * @Date 08-07-2022
	 */
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement orderPrint;

	public WebElement getOrderPrint() {
		return orderPrint;
	}

	/**
	 * @Description Getting booking OrderId
	 * @Date 08-07-2022
	 * @return String
	 * @throws IOException
	 */
	public String getOrderId() throws IOException {
		String orderId12 = getAttribute(getOrderPrint());
		System.out.println(orderId12);
		return orderId12;
	}

}
