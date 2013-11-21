package com.lohika.seleniumtool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class SendMessageTest {
private Logger logger = LoggerFactory.getLogger(SendMessageTest.class);
	
	@Test
	public void OpenConversationFromSidebarTest() throws Exception{
		
		String searchName = "svyattest2@hotmail.com";
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driverA = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		
		logger.info("Opening Outlook page for User A");
		driverA.get("http://www.outlook.com/");
		
		LoginPage loginPageA = new LoginPage();
		PageFactory.initElements(driverA, loginPageA);
		
		logger.info("Loging in");
		loginPageA.username.sendKeys("simon.test2@outlook.com");
         
        loginPageA.password.sendKeys("skypet3st3r");
         
        loginPageA.loginButton.click();
        
        driverA.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MessengerPage messengerPageA = new MessengerPage();
        PageFactory.initElements(driverA, messengerPageA);      
        
        logger.info("Opening sidebar");
        messengerPageA.messagingIcon.click();
        
        logger.info("Check if sidebar is opened");
        Assert.assertTrue(messengerPageA.sidebar.isDisplayed(), "Sidebar was not visible");
        
        logger.info("Looking for '" + searchName + "' contact");
        messengerPageA.searchField.sendKeys(searchName);
        
        logger.info("Check if contact is found");
        Assert.assertTrue(messengerPageA.contactSearchResult.isDisplayed(), "Contact wasn't found!");
        
        logger.info("Opening conversation with contact");
        messengerPageA.contactSearchResult.click();
        
        ConversationPage conversationPageA = new ConversationPage();
        PageFactory.initElements(driverA, conversationPageA);
        
        logger.info("Check if conversation with " + searchName + " is opened");
        conversationPageA.assertName(driverA, "Svyat Test2");
         
        driverA.quit();
	}
}
