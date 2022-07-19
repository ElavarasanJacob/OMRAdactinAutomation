package com.pages;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description POM for Adactin Book hotel page
 * @Date 08-07-2022
 */
public class BookHotelPage extends BaseClass {
	/**
	 * @Description BookHotel page driver initialize
	 * @Date 08-07-2022
	 */
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement cardno;

	@FindBy(id = "cc_type")
	private WebElement cardType;

	@FindBy(id = "cc_exp_month")
	private WebElement expMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement expYear;

	@FindBy(id = "cc_cvv")
	private WebElement ccvNo;

	@FindBy(id = "book_now")
	private WebElement book;

	@FindBy(id = "first_name_span")
	private WebElement firstNameErrorMsg;

	@FindBy(id = "last_name_span")
	private WebElement lastNameErrorMsg;

	@FindBy(id = "address_span")
	private WebElement addresErrorMsg;

	@FindBy(id = "cc_num_span")
	private WebElement cardNoErrorMsg;

	@FindBy(id = "cc_type_span")
	private WebElement cardTypeErrorMsg;

	@FindBy(id = "cc_expiry_span")
	private WebElement cardExpMonthErrorMsg;

	@FindBy(id = "cc_cvv_span")
	private WebElement cardCvvErrorMsg;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement bookingConfirmationMsg;

	public WebElement getFirstNameErrorMsg() {
		return firstNameErrorMsg;
	}

	public WebElement getLastNameErrorMsg() {
		return lastNameErrorMsg;
	}

	public WebElement getAddresErrorMsg() {
		return addresErrorMsg;
	}

	public WebElement getCardNoErrorMsg() {
		return cardNoErrorMsg;
	}

	public WebElement getCardTypeErrorMsg() {
		return cardTypeErrorMsg;
	}

	public WebElement getCardExpMonthErrorMsg() {
		return cardExpMonthErrorMsg;
	}

	public WebElement getCardCvvErrorMsg() {
		return cardCvvErrorMsg;
	}

	public WebElement getBookingConfirmationMsg() {
		return bookingConfirmationMsg;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardno() {
		return cardno;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCcvNo() {
		return ccvNo;
	}

	public WebElement getBook() {
		return book;
	}

	/**
	 * @Description Book hotel by filling all fields
	 * @Date 08-07-2022
	 * @param fstName
	 * @param lstName
	 * @param address
	 * @param cardno
	 * @param cardType
	 * @param expmnth
	 * @param expYear
	 * @param ccvNo
	 */
	public void bookHotel(String fstName, String lastName, String address, String cardno, String cardType,
			String expmnth, String expYear, String ccvNo) {
		textPass(getFirstName(), fstName);
		textPass(getLastName(), lastName);
		textPass(getAddress(), address);
		textPass(getCardno(), cardno);
		SelectByVisibleText(getCardType(), cardType);
		SelectByVisibleText(getExpMonth(), expmnth);
		SelectByVisibleText(getExpYear(), expYear);
		textPass(getCcvNo(), ccvNo);
		click(getBook());
	}

	/**
	 * @Description Book hotel without enter any fields
	 * @Date 08-07-2022
	 */
	public void bookHotel() {

		click(getBook());

	}

}
