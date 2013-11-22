package com.lohika.seleniumtool;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;

import pages.ConversationPage;
import pages.LoginPage;
import pages.MailPage;
import pages.SidebarPage;

public class SidebarTest extends SingleDriverBaseTest{
	
	private Logger logger = LoggerFactory.getLogger(SidebarTest.class);
	
	private String validSearchName = "skypeqa011";
	private String invalidSearchName = "Tester";
	
	@Test
	public void openConversationFromSidebarTest() throws Exception{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
            
        logger.info("Opening sidebar");
        mailPage.messagingIcon.click();
        
        SidebarPage sidebarPage = new SidebarPage(driver);
        PageFactory.initElements(driver, sidebarPage);
        
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
        PageFactory.initElements(driver, conversationPage);
        
        logger.info("Check if conversation with " + validSearchName + " is opened");
        conversationPage.assertName(validSearchName);
	}
	
	@Test
	public void searchNoResultsTest() throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
            
        logger.info("Opening sidebar");
        mailPage.messagingIcon.click();
        
        SidebarPage sidebarPage = new SidebarPage(driver);
        PageFactory.initElements(driver, sidebarPage);
        
        logger.info("Check if sidebar is opened");
        Assert.assertTrue(sidebarPage.isDisplayed(), "Sidebar was not visible");
        
        logger.info("Looking for '" + invalidSearchName + "' contact");
        sidebarPage.searchField.click();
        sidebarPage.searchField.sendKeys(invalidSearchName);
            
        logger.info("Check if contact is NOT found");
        Assert.assertTrue(sidebarPage.getContactFromSearchResult(invalidSearchName) == null, "Contact '" + invalidSearchName + "' was found!");
	}
}
