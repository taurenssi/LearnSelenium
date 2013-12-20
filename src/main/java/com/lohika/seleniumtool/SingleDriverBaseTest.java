package com.lohika.seleniumtool;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.MDC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({com.lohika.seleniumtool.SingleTestListener.class})
public class SingleDriverBaseTest{
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void init() throws MalformedURLException{
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new RemoteWebDriverScreenshot(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MDC.put("tcid", getClass().getSimpleName());
	}
	
	@AfterMethod
	public void finalize(){
		driver.quit();
	}
}
