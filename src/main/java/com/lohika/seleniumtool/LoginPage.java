package com.lohika.seleniumtool;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy (name = "login")
	public WebElement username;
	
	@FindBy (name = "passwd")
	public WebElement password;
	
	@FindBy (id = "idSIButton9")
	public WebElement loginButton;
	
}
