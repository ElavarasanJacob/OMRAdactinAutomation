package com.stepDefinition;

import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @Description to implements Hooks
 * @Date 08-07-2022
 * @author ELAVARASAN
 *
 */
public class HooksClass extends BaseClass {
	/**
	 * @Description To launch Browser
	 * @throws IOException
	 * @Date 08-07-2022
	 */
	@Before
	public void beforeScenario() throws IOException {
		getDriver(getPropertyFileValue("browserType"));
		launchURL(getPropertyFileValue("Url"));
		maximizeWindow();
		implicityWaits(50);
	}

	/**
	 * @Description Take screenshot for every after scenario
	 * @param sc
	 * @Date 08-07-2022
	 */
	@After
	public void afterScenario(Scenario sc) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		sc.embed(screenshotAs, "EveryScenario");
		closeCurrentBrowser();

	}

}
