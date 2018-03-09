package com.dolibar.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import com.dolibar.base.TestBase;

public class ValidateContractPage extends TestBase{
	
	@FindBy(xpath = "//a[text()='Validate']")
	WebElement ValidateButton;
	
	@FindBy(xpath = "//span[text()='Yes']")
	WebElement SayYes;
	
	public ValidateContractPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnValidateButton()
	{
		ValidateButton.click();
		SayYes.click();
	}

}
