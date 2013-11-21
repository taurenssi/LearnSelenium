package com.lohika.seleniumtool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import pages.MailPage;

public class SidebarTest {
private Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@Test
	public void OpenConversationFromSidebarTest() throws Exception{
		
		String searchName = "skypeqa011";
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        
        logger.info("Opening sidebar");
        mailPage.messagingIcon.click();
        
        logger.info("Check if sidebar is opened");
        Assert.assertTrue(mailPage.sidebar.isDisplayed(), "Sidebar was not visible");
        
        logger.info("Looking for '" + searchName + "' contact");
        mailPage.searchField.sendKeys(searchName);
        
        logger.info("Reinitializing elements on main page");
        PageFactory.initElements(driver, mailPage);
        
        logger.info("Check if contact is found");
        Assert.assertTrue(mailPage.contactSearchInfoBar.isDisplayed(), "Contact wasn't found!");
        
        logger.info("Opening conversation with contact");
        for (WebElement element: mailPage.contactSearchResult){
        	if (element.getText().equals(searchName)){
        		element.click();
        	}
        }
        
        logger.info("Check if conversation with " + searchName + " is opened");
        Assert.assertTrue(mailPage.conversationTitle.getText().equals(searchName), "Conversation with contact 'Svyatoslav Saliy' wasn't opened!");
            
        driver.quit();
	}
}
