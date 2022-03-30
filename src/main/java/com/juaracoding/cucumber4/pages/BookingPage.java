package com.juaracoding.cucumber4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.cucumber4.drivers.DriverSingleton;

public class BookingPage {
	WebDriver driver;

	public BookingPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#fadein > div.sidebar-nav > div > div.sidebar-menu-wrap > ul > li:nth-child(2) > a")
	WebElement btnMyBooking;

	public void goToMenuMyBooking() {
		btnMyBooking.click();
	}

	public String getTextTitleBookingPage() {
		return driver.getTitle();
	}

}
