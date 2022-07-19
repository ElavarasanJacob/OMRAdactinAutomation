package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description POM for Adactin login page locators
 * @Date 08-07-2022
 *
 */
public class LoginPage extends BaseClass {
	/**
	 * @Description Login page driver initialize
	 * @Date 08-07-2022
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(id = "username_show")
	private WebElement welComeMsg;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement loginErrorMsg;

	public WebElement getWelComeMsg() {
		return welComeMsg;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}

	/**
	 * @Description Login with btnClick
	 * @Date 08-07-2022
	 * @param name
	 * @param pass
	 * @throws IOException 
	 */
	public void login(String name, String pass) throws IOException {
		String username = getPropertyFileValue(name);
		textPass(getTxtUsername(), username);
		String password = getPropertyFileValue(pass);
		textPass(getTxtPassword(), password);
		click(getBtnLogin());
	}

	/**
	 * @Description Login by using enter key
	 * @Date 08-07-2022
	 * @param name
	 * @param pass
	 * @throws AWTException
	 * @throws IOException 
	 */
	public void loginWithEnter(String name, String pass) throws AWTException, IOException {
		String username = getPropertyFileValue(name);
		textPass(getTxtUsername(), username);
		String password = getPropertyFileValue(pass);
		textPass(getTxtPassword(), password);
		robotClass(KeyEvent.VK_TAB, KeyEvent.VK_TAB);
		robotClass(KeyEvent.VK_TAB, KeyEvent.VK_TAB);
		robotClass(KeyEvent.VK_ENTER, KeyEvent.VK_ENTER);

	}

}