package com.lohika.seleniumtool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import pages.MailPage;

public class LoginTest extends SingleDriverBaseTest{

	private Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	private String validName = "svyatest9@hotmail.com";
	private String validPass = "skypet3st3r";
	
	@Test
	public void testCorrectLogin() throws Exception{

		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		
		logger.info("Loging in");
		loginPage.username.sendKeys(validName);
         
        loginPage.password.sendKeys(validPass);
         
        loginPage.loginButton.click();
         
        MailPage mailPage = new MailPage(driver);
        PageFactory.initElements(driver, mailPage);
        
        logger.info("Check if page is displayed");
        Assert.assertTrue(mailPage.isDisplayed(), "Mail Page was not visible"); 
	}
}
