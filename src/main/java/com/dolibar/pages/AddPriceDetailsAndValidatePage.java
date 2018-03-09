package com.dolibar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.dolibar.base.TestBase;

public class AddPriceDetailsAndValidatePage extends TestBase{
	
	Select select;
	
	@FindBy(xpath = "//tr[@class='pair']/td/following-sibling::td[3]/img[@title='Opened']")
	WebElement ProposalLink;
	
	@FindBy(id = "select_type")
	WebElement SelectType;
	
	@FindBy(id = "dp_desc")
	WebElement  ProductName;
	
	@FindBy(name = "price_ht")
	WebElement ProductPrice;
	
	@FindBy(xpath = "//tr[@class='pair nodrag nodrop']/descendant::input[@type='submit']")
	WebElement AddButton;
	
	@FindBy(xpath = "//a[text()='Validate']")
	WebElement validateButton;
	
	
	
	public AddPriceDetailsAndValidatePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void addPriceDetails(String selectType,String productName,String productPrice) throws InterruptedException
	{
		ProposalLink.click();
		Thread.sleep(2000);
		select = new Select(SelectType);
		select.selectByVisibleText(selectType);
		ProductName.sendKeys(productName);
		ProductPrice.sendKeys(productPrice);
		AddButton.click();
		Thread.sleep(2000);
		validateButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
	}
	

}
