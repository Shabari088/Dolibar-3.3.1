package com.dolibar.pages;

import com.dolibar.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddServiceToTheContractPage extends TestBase{
	
	@FindBy(xpath = "//a[text()='CT1803-0004']")
	WebElement ContractLink;
	
	@FindBy(name = "dp_desc")
	WebElement ServiceDescriptionText;
	
	@FindBy(name = "price_ht")
	WebElement PriceForService;
	
	@FindBy(id ="date_start_sl")
	WebElement startDate;
	
	@FindBy(id ="date_end_sl")
	WebElement endDate;
	
	@FindBy(xpath = "//tr[@class='pair nodrag nodrop']/descendant::input[@type='submit']")
	WebElement addButton;
	
	
	public AddServiceToTheContractPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnContractLink()
	{
		ContractLink.click();
	}
	public boolean unitPrice()
	{
		
		return PriceForService.isDisplayed();
	}
	public void AddServicetoContract()
	{
		ServiceDescriptionText.sendKeys("Free Puncther Service");
		startDate.sendKeys("03/06/2018");
		endDate.sendKeys("03/02/2018");
		PriceForService.sendKeys("1");
		addButton.click();
	}
	public void AddSecondServicetoContract()
	{
		ServiceDescriptionText.sendKeys("Free Water Service");
		startDate.sendKeys("03/06/2018");
		endDate.sendKeys("03/02/2018");
		PriceForService.sendKeys("1");
		addButton.click();
	}
	public void AddThirdServicetoContract()
	{
		ServiceDescriptionText.sendKeys("Free Bumper Service");
		startDate.sendKeys("03/06/2018");
		endDate.sendKeys("03/02/2018");
		PriceForService.sendKeys("1");
		addButton.click();
	}

}
