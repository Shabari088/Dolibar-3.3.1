package com.dolibar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibar.base.TestBase;

public class AddContractPage extends TestBase{
	
	@FindBy(xpath ="//a[text()='Add contract']")
	WebElement AddContractButton;
	
	@FindBy(name = "note_public")
	WebElement PublicNoteText;
	
	@FindBy(name = "note")
	WebElement PrivateNoteText;
	
	@FindBy(xpath = "//input[@value='Create']")
	WebElement CreateButton;
	
	public AddContractPage() {
		
		PageFactory.initElements(driver,this);
	
	}
	
	public void createContract()
	{
		AddContractButton.click();
		PublicNoteText.sendKeys("This is RaviToyota's Contract");
		PrivateNoteText.sendKeys("This is RaviToyota's Contract");
		CreateButton.click();
	}
	

}
