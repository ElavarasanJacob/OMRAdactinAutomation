package com.stepDefinition;

import org.Base.BaseClass;
import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * @author ELAVARASAN
 * @Description Common steps for Adactin hotel
 * @Date 08-07-2022
 */
public class CommonSteps extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description
	 * @Date 08-07-2022
	 * @param expLoginMsg
	 */
	@Then("User should verify after login {string}")
	public void userShouldVerifyAfterLogin(String expLoginMsg) {
		Assert.assertEquals("verifying welcome msg", expLoginMsg,
				pom.getLoginpage().getWelComeMsg().getAttribute("value"));

	}

}
