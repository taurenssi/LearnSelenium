package com.lohika.seleniumtool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
	
	public Config config;
	public String url = "https://www.outlook.com";
	public String configURL = "./src/Config.txt";
	
	
	@BeforeSuite 
	public void setupTests(){
		config = new Config(configURL);
	}
	
	@Test
	public void possitiveLoginTest() {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);

		LoginPage loginPage = new LoginPage();
		
		PageFactory.initElements(driver, loginPage);
		
		loginPage.username.sendKeys(config.name);
		
		loginPage.password.sendKeys(config.pass);
		
		loginPage.loginButton.click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='c_meun' and text()='Test Me9']")).isDisplayed(), "Test case failed");
		
		//driver.close();
		
	}
	
}
