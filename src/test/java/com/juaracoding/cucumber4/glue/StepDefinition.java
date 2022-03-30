package com.juaracoding.cucumber4.glue;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.cucumber4.config.AutomationFrameworkConfig;
import com.juaracoding.cucumber4.drivers.DriverSingleton;
import com.juaracoding.cucumber4.utils.ConfigurationProperties;
import com.juaracoding.cucumber4.utils.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private WebDriver driver;
//	private LoginPage loginPage;
//	private BookingPage bookingPage;

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
//		loginPage = new LoginPage();
//		bookingPage = new BookingPage();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@When("Customer klik login button")
	public void customer_klik_login_button() {
//		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
	}

	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		// refresh
		driver.navigate().refresh();
		tunggu();
//		assertEquals(configurationProperties.getTextWelcome(), loginPage.getTextWelcome());
	}

	@When("Customer klik menu My Booking")
	public void customer_klik_menu_my_booking() {
//		bookingPage.goToMenuMyBooking();
	}

	@Then("Customer melihat page title")
	public void customer_melihat_page_title() {
//		assertEquals(configurationProperties.getTextTitleBookingPage(), bookingPage.getTextTitleBookingPage());
	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
