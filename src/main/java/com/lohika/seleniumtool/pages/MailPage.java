package com.lohika.seleniumtool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BasePage {
	
	public MailPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy (id = "contentFolderQuickViewList")
	public WebElement contentFolder;
	
	@FindBy (xpath = "//a[@id = 'c_hiconm' and not(contains(@class, 'c_md'))]")
	public WebElement messagingIcon;
	
	@FindBy (xpath = "//img[@class = 'is_img' and @alt = 'All services']")
	public WebElement servicesMenu;
	
	@FindBy (id = "c_h_ppl")
	public WebElement peopleHeaderItem;
	
	public boolean isDisplayed(){
		return contentFolder.isDisplayed();
	}
}
