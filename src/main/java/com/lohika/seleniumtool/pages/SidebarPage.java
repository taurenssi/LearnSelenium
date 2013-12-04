package com.lohika.seleniumtool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SidebarPage extends BasePage {
	
	public SidebarPage(WebDriver driver){
        super(driver);
	}
	
	@FindBy (id = "sidebar")
	public WebElement sidebar;
	
	@FindBy (id = "search_filter")
	public WebElement searchField;
	
	@FindBy (xpath = "//*[@class='ContactSearchResult']")
	public WebElement contactSearchResultsList;
	
	@FindBy (xpath = "//*[@class='t_mbgc t_amtc csIcWrap']")
	public List<WebElement> contactSearchResult;

	@FindBy (xpath = "//*[@class='contactSearchInfoBar']")
	public WebElement contactSearchInfoBar;
	
	@FindBy (xpath = "//*[@class='Title']")
	public WebElement conversationTitle;
	
	public boolean isDisplayed(){
		return sidebar.isDisplayed();
	}
	
	public WebElement getContactFromSearchResult(String match){
        WebElement contact = null;
        contactSearchResult = driver.findElements(By.xpath("//*[@class='t_mbgc t_amtc csIcWrap']"));
		for (WebElement element: contactSearchResult){
        	if (element.getText().equals(match)){
        		contact = element;
        		break;
        	}
        }
		return contact;
	}
}
