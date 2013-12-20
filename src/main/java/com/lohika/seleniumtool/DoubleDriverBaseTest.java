package com.lohika.seleniumtool;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({com.lohika.seleniumtool.DoubleTestListener.class})
public class DoubleDriverBaseTest {
	protected WebDriver driver;
	protected WebDriver driver2;

	@BeforeMethod
	public void init() throws MalformedURLException{
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		driver2 = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
	}

	@AfterMethod
	public void finalize(){
		driver.quit();
		driver2.quit();
	}
}
