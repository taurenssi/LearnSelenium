package com.lohika.seleniumtool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ConversationPage;
import pages.LoginPage;
import pages.MailPage;
import pages.PeoplePage;

public class ContactAvailabilityPeopleTabTest extends SingleDriverBaseTest {
	private Logger logger = LoggerFactory.getLogger(ContactAvailabilityPeopleTabTest.class);
	
	private String validContactName = "skypeqa011";
	
	@Test
	public void contactAvailabilityOnPeopleTabTest() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		
    	logger.info("Loging in");
    	loginPage.login();
         
        MailPage mailPage = new MailPage(driver);
        PageFactory.initElements(driver, mailPage);
        
        logger.info("Check if user is logged in");
        Assert.assertTrue(mailPage.isDisplayed(), "User was not logged in");
            
        logger.info("Opening People Tab");
        mailPage.servicesMenu.click();
        mailPage.peopleHeaderItem.click();
        
        PeoplePage peoplePage = new PeoplePage(driver);
        PageFactory.initElements(driver, peoplePage);
        
        logger.info("Check if people page is opened");
        Assert.assertTrue(peoplePage.isDisplayed(), "People page is not opened");
        
        logger.info("Looking for '" + validContactName + "' contact");
        peoplePage.searchBox.click();
        peoplePage.searchBox.sendKeys(validContactName);
        
        logger.info("Check if contact is found");
        Assert.assertTrue(peoplePage.getContactFromSearchResult(validContactName) != null, "Contact '" + validContactName + "' wasn't found!");
        
        logger.info("Opening profile view for contact");
        peoplePage.getContactFromSearchResult(validContactName).click();
        
        logger.info("Check if contact profile view is opened");
        Assert.assertTrue(peoplePage.contactDetailsView.isDisplayed(), "Contact profile view wasn't opened!");
        
        logger.info("Opening conversation with contact");
        peoplePage.sendMessageButton.click();
        
        ConversationPage conversationPage = new ConversationPage(driver);
        PageFactory.initElements(driver, conversationPage);
        
        logger.info("Check if conversation with " + validContactName + " is opened");
        conversationPage.assertName(validContactName);
	}
}
