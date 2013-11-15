package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {

	@FindBy (id = "contentFolderQuickViewList")
	public WebElement contentFolder;
	
	public boolean isDisplayed(){
		return contentFolder.isDisplayed();
	}
}
