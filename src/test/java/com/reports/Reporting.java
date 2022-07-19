package com.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.Base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author ELAVARASAN
 * @Description JVM report
 * @Date 08-07-2022
 */
public class Reporting extends BaseClass {

	/**
	 * @Description JVM report generating
	 * @Date 08-07-2022
	 * @param jsonFile
	 * @throws IOException
	 */
	public static void getReports(String jsonFile) throws IOException {
		File f = new File(getPropertyFileValue("JVMReport"));
		Configuration configuration = new Configuration(f, "Adactin Hotel Booking Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "103");
		configuration.addClassifications("OS", "WIN10");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
	}
}
