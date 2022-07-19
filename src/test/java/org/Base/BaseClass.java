package org.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @Description Reusable Codes
 * @author ELAVARASAN
 * @Date 25-06-2022
 */
public class BaseClass {

	public static WebDriver driver;

	/**
	 * @Description
	 * @Date 08-07-2022
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {

		case "chromeDriver":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * @Description Get the Value from property file
	 * @Date 08-07-2022
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws IOException {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		Object name = properties.get(key);
		String value = (String) name;
		return value;

	}

	/**
	 * @Description launch the URL
	 * @Date 08-07-2022
	 * @param url
	 */
	public static void launchURL(String url) {
		driver.get(url);
	}

	/**
	 * * @Description Get the current browser title
	 * 
	 * @Date 08-07-2022
	 * @return String
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @Description To get the current URL
	 * @Date 08-07-2022
	 */
	public void getCurrentUrl() {
		driver.getCurrentUrl();
	}

	/**
	 * @Description To get Page source code from the WebPage
	 * @Date 08-07-2022
	 * @return String
	 */
	public String getPageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * @Description To close the current browser
	 * @Date 08-07-2022
	 */
	public static void closeCurrentBrowser() {
		driver.close();
	}

	/**
	 * @Description To close Entire browser Tabs
	 * @Date 08-07-2022
	 */
	public void quitWindow() {
		driver.quit();
	}

	/**
	 * @Description Insert value into text box with enter key
	 * @Date 08-07-2022
	 * @param element
	 * @param text
	 */
	public void textPasswithEnter(WebElement element, String text) {
		element.sendKeys(text, Keys.ENTER);
	}

	/**
	 * @Description Send text to textbox
	 * @Date 08-07-2022
	 * @param element
	 * @param text
	 */
	public void textPass(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @Description TO get the Attribute value from WebElement
	 * @Date 08-07-2022
	 * @param element
	 * @return String
	 */
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @Description To get text from WebElement
	 * @Date 08-07-2022
	 * @param element
	 * @return String
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @Description To maximize the window
	 * @Date 08-07-2022
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @Description Navigate to one URL to another URL
	 * @Date 08-07-2022
	 * @param nextURL
	 */
	public void navigateTo(String nextURL) {
		driver.navigate().to(nextURL);
	}

	/**
	 * @Description To refresh the WebPage
	 * @Date 08-07-2022
	 */
	public void refereshWindow() {
		driver.navigate().refresh();
	}

	/**
	 * @Description Navigate to backward window
	 * @Date 08-07-2022
	 */
	public void backwardWindow() {
		driver.navigate().back();
	}

	/**
	 * @Description Navigate to forward window
	 * @Date 08-07-2022
	 */
	public void forward() {
		driver.navigate().forward();
	}

	/**
	 * @Description To set window size by passing value
	 * @Date 08-07-2022
	 * @param a
	 * @param b
	 */
	public void setWindowSize(int a, int b) {
		Dimension d = new Dimension(a, b);
		driver.manage().window().setSize(d);
	}

	/**
	 * @Description To set window position by passing value
	 * @Date 08-07-2022
	 * @param a
	 * @param b
	 */
	public void setPosition(int a, int b) {
		Point p = new Point(a, b);
		driver.manage().window().setPosition(p);
	}

	/**
	 * @Description Switch to parentWindow
	 * @Date 08-07-2022
	 * @return String
	 */
	public String parentWindow() {
		String parId = driver.getWindowHandle();
		return parId;
	}

	/**
	 * @Description Used to handle multiple windows
	 * @Date 08-07-2022
	 * @return Set<String>
	 */
	public Set<String> childWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * @Description Find Element by ID
	 * @Date 08-07-2022
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement LocateByID(String attributevalue) {
		WebElement findElement = driver.findElement(By.id(attributevalue));
		return findElement;
	}

	/**
	 * @Description Find Element by name
	 * @Date 08-07-2022
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement LocateByName(String attributevalue) {
		WebElement findElement = driver.findElement(By.name(attributevalue));
		return findElement;
	}

	/**
	 * @Description Find Element by className
	 * @Date 08-07-2022
	 * @param attributevalue
	 * @return WebElement
	 */
	public WebElement LocateByClassName(String attributevalue) {
		WebElement findElement = driver.findElement(By.className(attributevalue));
		return findElement;
	}

	/**
	 * @Description Find Element by TagName
	 * @Date 08-07-2022
	 * @param tagname
	 * @return WebElement
	 */
	public WebElement LocateByTagName(String tagname) {
		WebElement findElement = driver.findElement(By.tagName(tagname));
		return findElement;
	}

	/**
	 * @Description Find Element by linkText
	 * @Date 08-07-2022
	 * @param linktext
	 * @return WebElement
	 */
	public WebElement LocateByLinkText(String linktext) {
		WebElement findElement = driver.findElement(By.linkText(linktext));
		return findElement;
	}

	/**
	 * @Description Find Element by PartialLinkText
	 * @Date 08-07-2022
	 * @param partialtext
	 * @return WebElement
	 */
	public WebElement LocateByPartialLinkText(String partialtext) {
		WebElement findElement = driver.findElement(By.partialLinkText(partialtext));
		return findElement;
	}

	/**
	 * @Description Find Element by Css Selector
	 * @Date 08-07-2022
	 * @param cssSelector
	 * @return WebElement
	 */
	public WebElement CSSLocator(String cssSelector) {
		WebElement findElement = driver.findElement(By.cssSelector(cssSelector));
		return findElement;
	}

	/**
	 * @Description Find Element by
	 * @Date 08-07-2022
	 * @param xpath
	 * @return WebElement
	 */
	public WebElement XpathLocator(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	/**
	 * @Description Used to click the WebElement
	 * @Date 08-07-2022
	 * @param element
	 */
	public void click(WebElement element) {
		element.click();
	}

	/**
	 * @Description To check WebElement isEnabled or not
	 * @Date 08-07-2022
	 * @param element
	 * @return boolean
	 */
	public boolean isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	/**
	 * @Description To check WebElement isDisplayed or not
	 * @Date 08-07-2022
	 * @param element
	 * @return boolean
	 */
	public boolean isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	/**
	 * @Description Used to submit
	 * @Date 08-07-2022
	 * @param element
	 */
	public void submit(WebElement element) {
		element.submit();
	}

	/**
	 * @Description Scrolling function using JavaScript
	 * @Date 08-07-2022
	 * @param element
	 * @param cmnd
	 */
	public void scrolling(WebElement element, boolean cmnd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(" + cmnd + ")", element);
	}

	/**
	 * @Description Using JavaScript click the button
	 * @Date 08-07-2022
	 * @param element
	 */
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * @Description Using JavaScript insert the text into TextBox
	 * @Date 08-07-2022
	 * @param element
	 * @param data
	 */
	public void jsSendText(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value'," + data + ")", element);
	}

	/**
	 * @Description Take Screenshot
	 * @Date 08-07-2022
	 * @param newLocation
	 * @throws IOException
	 */
	public void takeScreenShot(String newLocation) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File screenshotAs = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(newLocation));
	}

	/**
	 * @Description MouserOver Actions
	 * @Date 08-07-2022
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * @Description Click the button by using Actions class
	 * @Date 08-07-2022
	 * @param element
	 */
	public void actionClick(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();
	}

	/**
	 * @Description To do double click by Action class
	 * @Date 08-07-2022
	 * @param element
	 */

	public void actionDoubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	/**
	 * @Description RightClick in mouse by using action class
	 * @Date 08-07-2022
	 * @param element
	 */
	public void actionRightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * @Description Drag and Drop in Action Class
	 * @Date 08-07-2022
	 * @param srce
	 * @param targt
	 */
	public void dragAndDrop(WebElement srce, WebElement targt) {
		Actions a = new Actions(driver);
		a.dragAndDrop(srce, targt).perform();
	}

	/**
	 * @Description Click and hold in Action Class
	 * @Date 08-07-2022
	 * @param srce
	 * @param targt
	 */
	public void clickAndHold(WebElement srce, WebElement targt) {
		Actions a = new Actions(driver);
		a.clickAndHold(srce).moveToElement(targt).release().perform();
	}

	/**
	 * @Description Using Robot class to do Keyboard actions
	 * @Date 08-07-2022
	 */
	public void robotClass(int keyPress, int keyRelease) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keyPress);
		r.keyRelease(keyRelease); // doubt
	}

	/**
	 * @Description To get current date
	 * @Date 08-07-2022
	 * @return Date
	 */
	public Date date() {
		Date d = new Date();
		return d;
	}

	/**
	 * @Description To check isMultiple or not in DropDown
	 * @Date 08-07-2022
	 * @param element
	 * @return boolean
	 */
	public boolean checkIsMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	/**
	 * @Description Select by index in DropDown
	 * @Date 08-07-2022
	 * @param element
	 * @param index
	 */
	public void SelectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * @Description Select by Value in DropDown
	 * @Date 08-07-2022
	 * @param element
	 * @param value
	 */
	public void SelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * @Description Select by Visible Text in DropDown
	 * @Date 08-07-2022
	 * @param element
	 * @param text
	 */
	public void SelectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * @Description To get options from drop down
	 * @Date 08-07-2022
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> getOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}

	/**
	 * @Description Get all selected options in drop down
	 * @Date 08-07-2022
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> getAllSelectedOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * @Description Get only selected option in drop down
	 * @Date 08-07-2022
	 * @param element
	 * @return WebElement
	 */
	public WebElement getSelectOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	/**
	 * @Description Deselect all in drop down
	 * @Date 08-07-2022
	 * @param element
	 */
	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	/**
	 * @Description Deselect by index in drop down
	 * @Date 08-07-2022
	 * @param element
	 * @param index
	 */
	public void deSelectbyIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	/**
	 * @Description Deselect by value in drop down
	 * @Date 08-07-2022
	 * @param element
	 * @param value
	 */
	public void deSelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	/**
	 * @Description Deselect by visible text in drop down
	 * @Date 08-07-2022
	 * @param element
	 * @param value
	 */
	public void deselectByVisibleText(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}

	/**
	 * @Description Accept the Alert
	 * @Date 08-07-2022
	 * @return Alert
	 */
	public Alert switctoAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	/**
	 * @Description Dismiss the Alert
	 * @Date 08-07-2022
	 * @return Alert
	 */
	public void dismissAlert(Alert alert) {
		alert.dismiss();

	}

	/**
	 * @Description Accept the Alert without switch to
	 * @Date 08-07-2022
	 * @return Alert
	 */
	public void accept(Alert alert) {
		alert.accept();
	}

	/**
	 * @Description Insert the text into Alert text box
	 * @Date 08-07-2022
	 * @return Alert
	 */
	public void sendText(Alert alert, String text) {
		alert.sendKeys(text);
	}

	/**
	 * @Description Get the text from Alert text box
	 * @Date 08-07-2022
	 * @param alert
	 * @return String
	 */
	public String getAlertText(Alert alert) {
		String text = alert.getText();
		return text;
	}

	/**
	 * @Description Switch to frame by index
	 * @Date 08-07-2022
	 * @param index
	 */
	public void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @Description Switch to frame by value
	 * @Date 08-07-2022
	 * @param value
	 */
	public void frameValue(String value) {
		driver.switchTo().frame(value);
	}

	/**
	 * @Description Switch to frame by WebElement ref
	 * @Date 08-07-2022
	 * @param element
	 */
	public void frameByWebRef(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * @Description To switch frame to parent frame
	 * @Date 08-07-2022
	 */
	public void frameParid() {
		driver.switchTo().parentFrame();
	}

	/**
	 * @Description To switch frame to mainWindow
	 * @Date 08-07-2022
	 */
	public void frameToWebPage() {
		driver.switchTo().defaultContent();
	}

	/*
	 * public int lengthOfString(String s) { int length = s.length(); return length;
	 * }
	 * 
	 * public boolean containsString(String s, String contains) { boolean contains2
	 * = s.contains(contains); return contains2; }
	 * 
	 * public int indexofString(String s, char d) { int indexOf = s.indexOf(d);
	 * return indexOf; }
	 * 
	 * public int lastIndexOf(String s, char e) { int lastIndexOf =
	 * s.lastIndexOf(e); return lastIndexOf; }
	 * 
	 * public char CharAt(String s, int f) { char charAt = s.charAt(f); return
	 * charAt; }
	 * 
	 * public String toUpperCase(String s) { String upperCase = s.toUpperCase();
	 * return upperCase; }
	 * 
	 * public String toLowerCase(String s) { String lowerCase = s.toLowerCase();
	 * return lowerCase; }
	 * 
	 * public boolean startsWith(String s, String c) { boolean startsWith =
	 * s.startsWith(c); return startsWith; }
	 * 
	 * public boolean endsWith(String s, String d) { boolean endsWith =
	 * s.endsWith(d); return endsWith; }
	 * 
	 * public int compareTo(String s, String w) { int compareTo = s.compareTo(w);
	 * return compareTo; }
	 * 
	 * public boolean equals(String s, String d) { boolean equals = s.equals(d);
	 * return equals; }
	 * 
	 * public boolean equalsIgnoreCase(String s, String d) { boolean
	 * equalsIgnoreCase = s.equalsIgnoreCase(d); return equalsIgnoreCase; }
	 * 
	 * public String subString(String s, int a) { String substring = s.substring(a);
	 * return substring; }
	 * 
	 * public String subStringBy2(String s, int a, int o) { String substring =
	 * s.substring(a, o); return substring; }
	 */
	/**
	 * @Description Read data from Excel
	 * @Date 08-07-2022
	 * @param path
	 * @param name
	 * @param rowNo
	 * @param cellno
	 * @return String
	 * @throws IOException
	 */
	public String readFile(String path, String name, int rowNo, int cellno) throws IOException {
		String res = null;
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		@SuppressWarnings("resource")
		Workbook w = new XSSFWorkbook(stream);
		Sheet createSheet = w.getSheet(name);
		Row createRow = createSheet.getRow(rowNo);
		Cell cell = createRow.getCell(cellno);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
				res = s.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				BigDecimal bigDecimal = BigDecimal.valueOf(l);
				res = bigDecimal.toString();
			}
			break;

		default:
			break;
		}
		return res;
	}

	/**
	 * @Description To modify the excel data
	 * @Date 08-07-2022
	 * @param name
	 * @param rowNo
	 * @param cellno
	 * @param oldname
	 * @param newname
	 * @throws IOException
	 */
	public void modifyData(String name, int rowNo, int cellno, String oldname, String newname) throws IOException {
		File f = new File("C:\\Maven\\Excel\\Task Read excele.xlsx");
		FileInputStream stream = new FileInputStream(f);
		@SuppressWarnings("resource")
		Workbook workBook = new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellno);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldname)) {
			cell.setCellValue(newname);
		}
		FileOutputStream s = new FileOutputStream(f);
		workBook.write(s);
	}

	/**
	 * @Description Write data to excel
	 * @Date 08-07-2022
	 * @param fileaddress
	 * @param name
	 * @param rowNo
	 * @param cellno
	 * @param data
	 * @throws IOException
	 */
	public void writeData(String fileaddress, String name, int rowNo, int cellno, String data) throws IOException {
		File f = new File(fileaddress);
		FileInputStream stream = new FileInputStream(f);
		@SuppressWarnings("resource")
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell createCell = row.createCell(cellno);
		createCell.setCellValue(data);
		FileOutputStream s = new FileOutputStream(f);
		w.write(s);

	}

	/**
	 * @Description Create the Row in Excel
	 * @Date 08-07-2022
	 * @param fileaddress
	 * @param name
	 * @param rowNo
	 * @param cellno
	 * @param data
	 * @throws IOException
	 */
	public void createRow(String fileaddress, String name, int rowNo, int cellno, String data) throws IOException {
		File f = new File(fileaddress);
		FileInputStream stream = new FileInputStream(f);
		@SuppressWarnings("resource")
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(name);
		Row row = sheet.createRow(rowNo);
		Cell createCell = row.createCell(cellno);
		createCell.setCellValue(data);
		FileOutputStream s = new FileOutputStream(f);
		w.write(s);
	}

	/**
	 * @Description Get attribute by using JavaScript
	 * @Date 08-07-2022
	 * @param element
	 * @param data
	 * @return JavascriptExecutor
	 */
	public JavascriptExecutor jsGetText(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].getAttribute('value'," + data + ")", element);
		return js;
	}

	/**
	 * @Description To clear all
	 * @Date 08-07-2022
	 */
	public void clear(WebElement element) {
		element.clear();
	}
/**
  * @Description To give interrupted to selenium 
 * @Date 08-07-2022
 * @param miles
 * @throws InterruptedException
 */
	public void threadSleep(int miles) throws InterruptedException {
		Thread.sleep(miles);
	}
/**
  * @Description To give implicitly wait by SECONDS
 * @Date 08-07-2022
 * @param a
 */
	public static void implicityWaits(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
/**
  * @Description  
 * @Date 08-07-2022
 * @param linktext
 * @return WebElement
 */
	public WebElement findByLinkText(String linktext) {
		WebElement findElement = driver.findElement(By.linkText(linktext));
		return findElement;
	}

	public WebElement findByPartialText(String patext) {
		WebElement findElement = driver.findElement(By.partialLinkText(patext));
		return findElement;
	}

}
