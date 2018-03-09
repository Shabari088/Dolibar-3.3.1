package com.dolibar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.dolibar.base.TestBase;

public class CloseProposalWithSignedPage extends TestBase{
		
	@FindBy(xpath = "//tr[@class='pair']/td/following-sibling::td[3]/img[@title='Opened']")
	WebElement ProposalLink;
	
	@FindBy(xpath = "//a[text()='Close']")
	WebElement CloseButton;
	
	@FindBy(id="statut")
	WebElement CloseWithStatusType;
	
	@FindBy(name = "validate")
	WebElement ValidateButton;
	
	public CloseProposalWithSignedPage() {

		
		PageFactory.initElements(driver, this);
		
	}
	
	public void closeWithSignedStatus()
	{
		
		ProposalLink.click();
		CloseButton.click();
		Select select = new Select(CloseWithStatusType);
		select.selectByVisibleText("Signed (needs billing)");
		ValidateButton.click();
	}
	

}
