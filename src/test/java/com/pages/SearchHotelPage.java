package com.pages;

import java.io.IOException;

import org.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ELAVARASAN
 * @Description POM for Adactin search hotel page
 * @Date 08-07-2022
 */
public class SearchHotelPage extends BaseClass {
	/**
	 * @Description login page driver initialize
	 * @Date 08-07-2022
	 */
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement selectlocation;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement roomNo;

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	@FindBy(id = "adult_room")
	private WebElement adultsInRoom;

	@FindBy(id = "child_room")
	private WebElement childRoom;

	@FindBy(id = "Submit")
	private WebElement click;

	@FindBy(id = "checkin_span")
	private WebElement checkIndateErrormsg;

	@FindBy(id = "checkout_span")
	private WebElement checkOutdateErrormsg;

	@FindBy(xpath = "//span[@id='location_span']")
	private WebElement locationErrorMsg;

	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement selectHotelMsg;

	public WebElement getCheckIndateErrormsg() {
		return checkIndateErrormsg;
	}

	public WebElement getCheckOutdateErrormsg() {
		return checkOutdateErrormsg;
	}

	public WebElement getLocationErrorMsg() {
		return locationErrorMsg;
	}

	public WebElement getSelectHotelMsg() {
		return selectHotelMsg;
	}

	public WebElement getSelectlocation() {
		return selectlocation;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNo() {
		return roomNo;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultsInRoom() {
		return adultsInRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getClick() {
		return click;
	}

	/**
	 * @Description Search hotel with all fields
	 * @Date 08-07-2022
	 * @param location
	 * @param hotel
	 * @param roomtype
	 * @param roomNo
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adults
	 * @param child
	 * @throws IOException
	 */
	public void searchHotel(String location, String hotel, String roomtype, String roomNo, String checkinDate,
			String checkoutDate, String adults, String child) throws IOException {

		SelectByVisibleText(getSelectlocation(), location);
		SelectByVisibleText(getHotels(), hotel);
		SelectByVisibleText(getRoomType(), roomtype);
		SelectByVisibleText(getRoomNo(), roomNo);
		clear(getCheckInDate());
		textPass(getCheckInDate(), checkinDate);
		clear(getCheckOutDate());
		textPass(getCheckOutDate(), checkoutDate);
		SelectByVisibleText(getAdultsInRoom(), adults);
		SelectByVisibleText(getChildRoom(), child);
		click(getClick());
	}

	/**
	 * @Description Search hotel with mandatory fields
	 * @Date 08-07-2022
	 * @param location
	 * @param numberofRooms
	 * @param checkinDate
	 * @param checkoutDate
	 * @param adults
	 * @throws IOException
	 */
	public void searchHotel(String location, String numberofRooms, String checkinDate, String checkoutDate,
			String adults) throws IOException {
		SelectByVisibleText(getSelectlocation(), location);
		SelectByVisibleText(getRoomNo(), numberofRooms);
		clear(getCheckInDate());
		textPass(getCheckInDate(), checkinDate);
		clear(getCheckOutDate());
		textPass(getCheckOutDate(), checkoutDate);
		SelectByVisibleText(getAdultsInRoom(), adults);
		click(getClick());
	}

	/**
	 * @Description Search without select any field
	 * @Date 08-07-2022
	 */
	public void searchHotel() {
		click(getClick());
	}

}
