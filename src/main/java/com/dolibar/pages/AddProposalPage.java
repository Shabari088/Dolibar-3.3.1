package com.dolibar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.dolibar.base.TestBase;

public class AddProposalPage extends TestBase{
	
	Select select;

	@FindBy(xpath = "//a[text()='Customer']")
	WebElement Customertab;
	
	@FindBy(xpath = "//a[text()='Add proposal']")
	WebElement AddProposalButton;
	
	@FindBy(name = "ref_client")
	WebElement RefCustomer;
	
	@FindBy(id = "contactidp")
	WebElement ContactId;
	
	@FindBy(id = "selectmode_reglement_id")
	WebElement PaymentType;
	
	@FindBy(name = "demand_reason_id")
	WebElement Source;
	
	@FindBy(name = "availability_id")
	WebElement AvailabilityDelay;
	
	@FindBy(name = "liv_")
	WebElement DeliveryDate;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement CreateDraft;
	
	public AddProposalPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickonCustomerTab()
	{
		Customertab.click();
	}
	
	public void createNewCustomerProposal(String refCustomer,String contactId,String paymentType,String source,String availabilityDelay)
	{
				
		AddProposalButton.click();
		RefCustomer.sendKeys(refCustomer);
		select = new Select(ContactId);
		select.selectByVisibleText(contactId);
		select = new Select(PaymentType);
		select.selectByVisibleText(paymentType);
		select = new Select(Source);
		select.selectByVisibleText(source);
		select = new Select(AvailabilityDelay);
		select.selectByVisibleText(availabilityDelay);
		DeliveryDate.sendKeys("03/21/2018");
		CreateDraft.click();
		
		
	}
	
	
}
