package com.stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.Base.BaseClass;
import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author ELAVARASAN
 * @Description Adactin hotel login page steps
 * @Date 08-07-2022
 */
public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description empty
	 * @Date Date 08-07-2022
	 */
	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() {

	}

	/**
	 * @Description user login with click
	 * @Date 08-07-2022
	 * @param userName
	 * @param password
	 * @throws IOException
	 */
	@When("User should login {string},{string}")
	public void userShouldLogin(String userName, String password) throws IOException {
		pom.getLoginpage().login(userName, password);
	}

	/**
	 * @Description user login with Enter Key
	 * @Date 08-07-2022
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @throws IOException
	 */
	@When("User should login {string},{string} with Enter key")
	public void userShouldLoginWithEnterKey(String userName, String password) throws AWTException, IOException {
		pom.getLoginpage().login(userName, password);

	}

	/**
	 * @Description user login error Msg
	 * @Date 08-07-2022
	 * @param expErrorloginMsg
	 */
	@Then("User should verify after login error message  {string}")
	public void userShouldVerifyAfterLoginErrorMessage(String expErrorloginMsg) {
		Assert.assertTrue(pom.getLoginpage().getLoginErrorMsg().getText().contains(expErrorloginMsg));

	}

}
