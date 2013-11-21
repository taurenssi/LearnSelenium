package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConversationPage {
	
	@FindBy (xpath = "//h1[@class='Title']")
	public WebElement conversationTitle;
	
	@FindBy(xpath = "//*[@class = 'DefaultText _DefaultText ModernConversationInputControl ModernConversationInputControl_DefaultText']")
	public WebElement ModernConversationInput;
	
	public void assertName(WebDriver driver, String name){
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='Title' and text()='"+name+"']")).isDisplayed());
	}
	
}
