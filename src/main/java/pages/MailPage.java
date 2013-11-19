package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {

	@FindBy (id = "contentFolderQuickViewList")
	public WebElement contentFolder;
	
	@FindBy (id = "c_hiconm")
	public WebElement messagingIcon;
	
	@FindBy (id = "sidebar")
	public WebElement sidebar;
	
	@FindBy (id = "search_filter")
	public WebElement searchField;
	
	@FindBy (xpath = "//*[@class='ContactSearchResult']")
	public WebElement contactSearchResultsList;
	
	@FindBy (xpath = "//*[@class='t_mbgc t_amtc csIcWrap']")
	public WebElement[] contactSearchResult;

	@FindBy (xpath = "//*[@class='contactSearchInfoBar']")
	public WebElement contactSearchInfoBar;
	
	@FindBy (xpath = "//*[@class='Title']")
	public WebElement conversationTitle;

	
	
	public boolean isDisplayed(){
		return contentFolder.isDisplayed();
	}
}
