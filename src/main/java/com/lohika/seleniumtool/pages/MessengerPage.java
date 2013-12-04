package com.lohika.seleniumtool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MessengerPage extends BasePage {

    public MessengerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return sidebar.isDisplayed();
    }

	@FindBy (xpath = "//a[@id = 'c_hiconm' and not(contains(@class, 'c_md'))]")
	public WebElement messagingIcon;
	
	@FindBy (id = "sidebar")
	public WebElement sidebar;
	
	@FindBy (id = "search_filter")
	public WebElement searchField;
	
	@FindBy (xpath = "//*[@class='t_mbgc t_amtc csIcWrap']")
	public WebElement contactSearchResult;
	
}
