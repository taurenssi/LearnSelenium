package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MessengerPage {
	
	@FindBy (xpath = "//a[@id = 'c_hiconm' and not(contains(@class, 'c_md'))]")
	public WebElement messagingIcon;
	
	@FindBy (id = "sidebar")
	public WebElement sidebar;
	
	@FindBy (id = "search_filter")
	public WebElement searchField;
	
	@FindBy (xpath = "//*[@class='t_mbgc t_amtc csIcWrap']")
	public WebElement contactSearchResult;
	
}
