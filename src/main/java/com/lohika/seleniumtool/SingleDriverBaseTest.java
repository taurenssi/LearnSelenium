package com.lohika.seleniumtool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.MDC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class SingleDriverBaseTest{
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void init() throws MalformedURLException{
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

        MDC.put("tcid", getClass().getSimpleName());
	}
	
	@AfterMethod
	public void finalize(){
		driver.quit();
	}
}
