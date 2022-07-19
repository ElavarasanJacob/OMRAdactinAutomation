package com.runner;

import java.io.IOException;

import org.Base.BaseClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * @Description To run all test from OMRBranchAdactinAutomation project
 * @Date 08-07-2022
 * @author ELAVARASAN
 */
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, plugin = { "pretty",
		"json:target/output.json" }, monochrome = true, features = {
				"src\\test\\resources\\Features" }, glue = { "com.stepDefinition" })

public class TestRunnerClass extends BaseClass {

	/**
	 * @Description To generate JVM reports for OMRBranchAdactinAutomation
	 * @Date 08-07-2022
	 * @throws IOException
	 */
	@AfterClass
	public static void afterClass() throws IOException {
		String reports = getPropertyFileValue("getReports");
		Reporting.getReports(reports);
	}

}
