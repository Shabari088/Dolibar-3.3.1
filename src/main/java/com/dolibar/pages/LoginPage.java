package com.dolibar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibar.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login_btn;
	
	@FindBy(id = "img_logo")
	WebElement img_Logo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateDolibarImage()
	{
		return img_Logo.isDisplayed();
	}
	
	public DolibarHomePage login(String un,String pswd)
	{
		
		username.sendKeys(un);
		
		password.sendKeys(pswd);
		
		login_btn.click();
		
		return new DolibarHomePage();
	}

}
