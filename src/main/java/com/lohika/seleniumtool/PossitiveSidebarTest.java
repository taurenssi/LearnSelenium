package com.lohika.seleniumtool;

import com.lohika.seleniumtool.pages.ConversationPage;
import com.lohika.seleniumtool.pages.LoginPage;
import com.lohika.seleniumtool.pages.MailPage;
import com.lohika.seleniumtool.pages.SidebarPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PossitiveSidebarTest extends SingleDriverBaseTest{
	
	private Logger logger = LoggerFactory.getLogger(PossitiveSidebarTest.class);
	
	private String validSearchName = "test";
	
	@Test
	public void openConversationFromSidebarTest() throws Exception{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage(driver);

    	logger.info("Loging in");
    	loginPage.login();
         
        MailPage mailPage = new MailPage(driver);

        logger.info("Check if user is logged in");
        Assert.assertTrue(mailPage.isDisplayed(), "User was not logged in");
            
        logger.info("Opening sidebar");
        mailPage.messagingIcon.click();
        
        SidebarPage sidebarPage = new SidebarPage(driver);

        logger.info("Check if sidebar is opened");
        Assert.assertTrue(sidebarPage.isDisplayed(), "Sidebar was not visible");
        
        logger.info("Looking for '" + validSearchName + "' contact");
        sidebarPage.searchField.click();
        sidebarPage.searchField.sendKeys(validSearchName);
            
        logger.info("Check if contact is found");
        Assert.assertTrue(sidebarPage.getContactFromSearchResult(validSearchName) != null, "Contact '" + validSearchName + "' wasn't found!");
        
        logger.info("Opening conversation with contact");
        sidebarPage.getContactFromSearchResult(validSearchName).click();
        
        ConversationPage conversationPage = new ConversationPage(driver);

        logger.info("Check if conversation with " + validSearchName + " is opened");
        conversationPage.assertName(validSearchName);
	}
}
