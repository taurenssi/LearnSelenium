package com.lohika.seleniumtool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(MailPage.class);
	
	public MailPage(WebDriver driver){
        super(driver);
	}

	@FindBy (id = "contentFolderQuickViewList")
	public WebElement contentFolder;
	
	@FindBy (xpath = "//a[@id = 'c_hiconm' and not(contains(@class, 'c_md'))]")
	public WebElement messagingIcon;
	
	//@FindBy (xpath = "//img[@class = 'is_img' and @alt = 'All services']")
	@FindBy (xpath="//a[@id='c_clogoc']")
	public WebElement servicesMenu;
	
	@FindBy (id = "c_h_ppl")
	public WebElement peopleHeaderItem;
	
	public boolean isDisplayed(){
        logger.info("Check if page " + getClass().getSimpleName() + " is displayed");
        return contentFolder.isDisplayed();
	}
}
