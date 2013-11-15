package com.lohika.seleniumtool;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import pages.MailPage;

public class LoginTest {
	
	private Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@Test
	public void testCorrectLogin() throws Exception{
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		
		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage();
		PageFactory.initElements(driver, loginPage);
		
		logger.info("Loging in");
		loginPage.username.sendKeys("svyatest9@hotmail.com");
         
        loginPage.password.sendKeys("skypet3st3r");
         
        loginPage.loginButton.click();
         
        MailPage mailPage = new MailPage();
        PageFactory.initElements(driver, mailPage);
        
        logger.info("Check if page is displayed");
        Assert.assertTrue(mailPage.isDisplayed(), "Mail Page was not visible"); 
        
        driver.quit();
	}

}
