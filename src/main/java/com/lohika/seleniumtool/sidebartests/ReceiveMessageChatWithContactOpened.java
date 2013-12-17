package com.lohika.seleniumtool.sidebartests;
import com.lohika.seleniumtool.DoubleDriverBaseTest;
import com.lohika.seleniumtool.pages.ConversationPage;
import com.lohika.seleniumtool.pages.LoginPage;
import com.lohika.seleniumtool.pages.MessengerPage;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ReceiveMessageChatWithContactOpened extends DoubleDriverBaseTest{
	
	private Logger logger = LoggerFactory.getLogger(ReceiveMessageChatWithContactOpened.class);
		
	@Test
	public void ReceiveMessageChatWithContactOpenedTest() throws Exception{
			
		String userAName = "svyattest2@hotmail.com";
		String userBName = "simon.test2@outlook.com";
			
		logger.info("Opening Outlook page for User A");
		driver.get("http://www.outlook.com/");
			
		LoginPage loginPageA = new LoginPage(driver);

		logger.info("Loging in");
		loginPageA.username.sendKeys(userAName);
	         
		loginPageA.password.sendKeys("skypet3st3r");
	         
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
	        
		logger.info("Opening Outlook page for User B");
		driver2.get("http://www.outlook.com/");
			
		LoginPage loginPageB = new LoginPage(driver2);

		logger.info("Loging in");
		loginPageB.username.sendKeys(userBName);
	         
		loginPageB.password.sendKeys("skypet3st3r");
	         
		loginPageB.loginButton.click();
	        
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MessengerPage messengerPageB = new MessengerPage(driver);

		logger.info("Opening sidebar");
		messengerPageB.messagingIcon.click();
	        
		logger.info("Check if sidebar is opened");
		Assert.assertTrue(messengerPageB.sidebar.isDisplayed(), "Sidebar was not visible");
	        
		logger.info("Looking for '" + userAName + "' contact");
		messengerPageB.searchField.sendKeys(userAName);
	        
		logger.info("Check if contact is found");
		Assert.assertTrue(messengerPageB.contactSearchResult.isDisplayed(), "Contact wasn't found!");
	        
		logger.info("Opening conversation with contact");
		messengerPageB.contactSearchResult.click();
	        
		ConversationPage conversationPageB = new ConversationPage(driver2);

		logger.info("Check if conversation with " + userAName + " is opened");
		conversationPageB.assertName("زمانی ئوردی و زمانی کوردی. ئەلفوبێی");
	        
		logger.info("Sending a message from UseraA to UserB");
		conversationPageA.modernConversationInput.clear();
		conversationPageA.modernConversationInput.sendKeys("Hello world!");
		conversationPageA.modernConversationInput.sendKeys(Keys.RETURN);
	        
		logger.info("Checking if message was sent");
		conversationPageA.assertMessage("Hello world!");
	        
		logger.info("Checking if message was received");
		conversationPageB.assertMessage("Hello world!");
	         
		driver.quit();
		driver2.quit();
	}
}

