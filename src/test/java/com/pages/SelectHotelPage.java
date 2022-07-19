package com.pages;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description POM for Adactin SelectHotelPage
 * @Date 08-07-2022
 */
public class SelectHotelPage extends BaseClass {
	/**
	 * @Description SelectHotelPage driver initialize
	 * @Date 08-07-2022
	 */
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='radiobutton_0']")
	private WebElement radiobtn;

	@FindBy(css = "input#continue")
	private WebElement continueClick;

	@FindBy(xpath = "(//td[@class='login_title'])[2]")
	private WebElement bookAHotelMsg;

	@FindBy(xpath = "//label[@id='radiobutton_span']")
	private WebElement selectHotelErrorMsg;

	public WebElement getBookAHotelMsg() {
		return bookAHotelMsg;
	}

	public WebElement getSelectHotelErrorMsg() {
		return selectHotelErrorMsg;
	}

	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getContinueClick() {
		return continueClick;
	}

	/**
	 * @Description Selecting Hotel and click continue
	 * @Date 08-07-2022
	 */
	public void selectHotelAndContinue() {
		click(getRadiobtn());
		click(getContinueClick());
	}

	/**
	 * @Description Without Selecting Hotel and click continue
	 * @Date 08-07-2022
	 */
	public void withoutSelectHotelContinue() {
		click(getContinueClick());
	}

}
