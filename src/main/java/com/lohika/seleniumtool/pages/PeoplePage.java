package com.lohika.seleniumtool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PeoplePage extends BasePage{
	public PeoplePage(WebDriver driver){
        super(driver);
	}
	
	@FindBy (xpath = "//*[@class = 'ContactsListArea']")
	public WebElement contactListArea;
	
	@FindBy (id = "c_search_SearchBoxControl_box")
	public WebElement searchBox;
	
	@FindBy (xpath = "//*[@class = 'CL_Contact']")
	public List<WebElement> contactSearchResult;
	
	@FindBy (xpath = "//*[@class = 'CP_ViewDetails']")
	public WebElement contactDetailsView;
	
	@FindBy (xpath = "//*[@class = 'CP_SelectionCommandButton' and text() = 'Send message']")
	public WebElement sendMessageButton;
	
	@FindBy (xpath = "//*[@class = 'CP_SelectionCommandButton' and text() = 'Send message']//*[@class = 'CP_Scb_value']")
	public WebElement sendMessageValue;
	
	@Override
	public boolean isDisplayed() {
		return contactListArea.isDisplayed();
	}
	
	public WebElement getContactFromSearchResult(String match) throws InterruptedException {

		Thread.sleep(1000);
		
        WebElement contact = null;
        contactSearchResult = driver.findElements(By.xpath("/*//*[@class='CL_Contact']"));
		for (WebElement element: contactSearchResult){
			System.out.println(element.getText());
        	if (element.getText().equals(match)){
        		contact = element;
        		break;
        	}
        }
		return contact;
	}
}
