package com.lohika.seleniumtool.sidebartests;

import com.lohika.seleniumtool.SingleDriverBaseTest;
import com.lohika.seleniumtool.pages.ConversationPage;
import com.lohika.seleniumtool.pages.LoginPage;
import com.lohika.seleniumtool.pages.MessengerPage;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendMessageTest extends SingleDriverBaseTest{
private Logger logger = LoggerFactory.getLogger(SendMessageTest.class);
	
	@Test
	public void OpenConversationFromSidebarTest() throws Exception{
		
		String userAName = "test2@hotmail.com";
		String userBName = "simon.test2@outlook.com";
		
		logger.info("Opening Outlook page for User A");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPageA = new LoginPage(driver);

		logger.info("Loging in");
		loginPageA.username.sendKeys(userAName);
         
        loginPageA.password.sendKeys("test");
         
        loginPageA.loginButton.click();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MessengerPage messengerPageA = new MessengerPage(driver);

        logger.info("Opening sidebar");
        messengerPageA.messagingIcon.click();
        
        logger.info("Check if sidebar is opened");
        Assert.assertTrue(messengerPageA.sidebar.isDisplayed(), "Sidebar was not visible");
        
        logger.info("Looking for '" + userBName + "' contact");
        messengerPageA.searchField.sendKeys(userBName);
        
        logger.info("Check if contact is found");
        Assert.assertTrue(messengerPageA.contactSearchResult.isDisplayed(), "Contact wasn't found!");
        
        logger.info("Opening conversation with contact");
        messengerPageA.contactSearchResult.click();
        
        ConversationPage conversationPageA = new ConversationPage(driver);

        logger.info("Check if conversation with " + userBName + " is opened");
        conversationPageA.assertName("claus Claus");
        
        logger.info("Sending a message from UseraA to UserB");
        conversationPageA.modernConversationInput.clear();
        conversationPageA.modernConversationInput.sendKeys("Hello world!");
        conversationPageA.modernConversationInput.sendKeys(Keys.RETURN);
        
        logger.info("Checking if message was sent");
        conversationPageA.assertMessage("Hello world!");
        
	}
}
