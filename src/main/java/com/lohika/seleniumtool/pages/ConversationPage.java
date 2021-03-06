package com.lohika.seleniumtool.pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConversationPage extends BasePage {
	
	public ConversationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy (xpath = "//h1[@class='Title']")
	public WebElement conversationTitle;
	
	//@FindBy(xpath = "//*[@class = 'DefaultText _DefaultText ModernConversationInputControl ModernConversationInputControl_DefaultText']")
	//public WebElement ModernConversationInput;
	
	@FindBy (xpath = "//*[@class = 'CommandBar' and @sutra='chatviewcommandbar']")
	public WebElement commandBar;
	
	@FindBy(xpath = "//textarea[@class = 'ModernConversationInputControl_TextBox']" )
	public WebElement  modernConversationInput;
	
	@FindBy(xpath = "//div[@class = 'ModernConversationHistoryItemNode_Text' and text() = 'Hello World!']")
	public WebElement conversationHistoryItem;
	
	public void assertName(String name){
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='Title' and text()='"+name+"']")).isDisplayed());
	}
	
	public void assertMessage(String message){
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'ModernConversationHistoryItemNode_Text']/span[text() = '"+message+"']")).isDisplayed());
	}
	
	public boolean isDisplayed(){
		return commandBar.isDisplayed();
	}
	
}
