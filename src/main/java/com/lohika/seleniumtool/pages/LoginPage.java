package com.lohika.seleniumtool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	private String name = "svyatest9@hotmail.com";
	private String pass = "skypet3st3r";
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

    @FindBy (name = "login")
    public WebElement username;
    
    @FindBy (name = "passwd")
    public WebElement password;
    
    @FindBy (id = "idSIButton9")
    public WebElement loginButton;
    
    public boolean isDisplayed(){
		return (username.isDisplayed() && loginButton.isDisplayed());
	}
    
    public void login() throws Exception{
		username.sendKeys(name);
         
        password.sendKeys(pass);
         
        loginButton.click();
    }
    
}