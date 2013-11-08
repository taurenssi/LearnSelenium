package com.lohika.seleniumtool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@BeforeSuite 
	public void setupTests(){
		config = new Config(configURL);
	}
	
	@BeforeTest
	public void initDriver(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(config.url);
	}
	
	@AfterTest
	public void closeDriver(){
		driver.close();
	}
	
	@Test
	public void possitiveLoginTest() {
		
		LoginPage loginPage = new LoginPage();
		
		PageFactory.initElements(driver, loginPage);
		
		loginPage.username.sendKeys(config.name);
		
		loginPage.password.sendKeys(config.pass);
		
		loginPage.loginButton.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='c_meun' and text()='Test Me9']")).isDisplayed(), "Test case failed");

	}
	
}