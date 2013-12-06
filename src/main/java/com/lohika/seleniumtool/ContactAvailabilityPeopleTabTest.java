package com.lohika.seleniumtool;

import com.lohika.seleniumtool.pages.ConversationPage;
import com.lohika.seleniumtool.pages.LoginPage;
import com.lohika.seleniumtool.pages.MailPage;
import com.lohika.seleniumtool.pages.PeoplePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactAvailabilityPeopleTabTest extends SingleDriverBaseTest {
	private Logger logger = LoggerFactory.getLogger(ContactAvailabilityPeopleTabTest.class);
	
	private String validContactName = "skypeqa011";
	
	@Test
	public void contactAvailabilityOnPeopleTabTest() throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.info("Opening Outlook page");
		driver.get("http://www.outlook.com/");
		
		LoginPage loginPage = new LoginPage(driver);

    	logger.info("Loging in");
    	loginPage.login();
         
        MailPage mailPage = new MailPage(driver);

        logger.info("Check if user is logged in");
        Assert.assertTrue(mailPage.isDisplayed(), "User was not logged in");
            
        logger.info("Opening People Tab");

        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='c_clogoc']//img")));

        int tries = 0;
        long timeout = System.currentTimeMillis() + 20000;
        while (System.currentTimeMillis() < timeout) {
            WebElement e = driver.findElement(By.xpath("//a[@id='c_clogoc']//img"));
            try {
                e.isDisplayed();
                tries++;
                if (tries == 3) {
                    break;
                }
            }
            catch (NoSuchElementException e1) {
                logger.debug("NoSuchElementException");
                tries = 0;
            }
            catch (StaleElementReferenceException e2) {
                logger.debug("StaleElementReferenceException");
                tries = 0;
            }
            Thread.sleep(1000);
        }

        mailPage.servicesMenu.click();
        mailPage.peopleHeaderItem.click();
        
        PeoplePage peoplePage = new PeoplePage(driver);

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

        logger.info("Check if conversation with " + validContactName + " is opened");
        conversationPage.assertName(validContactName);
	}
}
