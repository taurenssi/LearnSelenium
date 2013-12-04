package com.lohika.seleniumtool.loginandregistrationtests;

import com.lohika.seleniumtool.SingleDriverBaseTest;
import com.lohika.seleniumtool.pages.LoginPage;
import com.lohika.seleniumtool.pages.MailPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SingleDriverBaseTest{

	private Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	private String validName = "svyatest9@hotmail.com";
	private String validPass = "skypet3st3r";
	
	@Test
	public void testCorrectLogin() throws Exception{

		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage(driver);

		logger.info("Loging in");
		loginPage.username.sendKeys(validName);
         
        loginPage.password.sendKeys(validPass);
         
        loginPage.loginButton.click();
         
        MailPage mailPage = new MailPage(driver);

        logger.info("Check if page is displayed");
        Assert.assertTrue(mailPage.isDisplayed(), "Mail Page was not visible"); 
	}
}
