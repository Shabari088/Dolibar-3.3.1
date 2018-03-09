package com.dolibar.pages;

import com.dolibar.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddPointofContactPage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(),'List of customers')]")
	WebElement ListofCustomersLink;
	
	@FindBy(xpath = "//a[contains(text(),'RaviToyota')]")
	WebElement CustomersLink;
	
	@FindBy(xpath = "//a[contains(text(),'Add contact/address ')]")
	WebElement PointofContact;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="civilite_id")
	WebElement title;
	
	@FindBy(name="poste")
	WebElement PostOrFunction;
	
	@FindBy(xpath = "//a[contains(text(),'Fill address with thirdparty address')]")
	WebElement AddressLink;
	
	@FindBy(id="phone_pro")
	WebElement ProfessionalPhone;
	
	@FindBy(id="phone_perso")
	WebElement PersonalPhone;
	
	@FindBy(id="phone_mobile")
	WebElement MobilePhone;
	
	@FindBy(id="fax")
	WebElement Fax;
	
	@FindBy(name="jabberid")
	WebElement InstantMessaging;
	
	@FindBy(id="birthday")
	WebElement Birthday;
	
	@FindBy(name="add")
	WebElement Addbtn;
	
	public AddPointofContactPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPointofConatctLink() throws InterruptedException
	{
		ListofCustomersLink.click();
		Thread.sleep(2000);
		CustomersLink.click();
		
	}
	
	public void createNewPointofContact(String LastName,String FirstName,String Title,String postorfunction,
			String professionalPhone,String personalPhone, String mobilephone,String fax,
			String Instantmessaging,String birthday) throws InterruptedException
	{
		PointofContact.click();
		lastname.sendKeys(LastName);
		firstname.sendKeys(FirstName);
		Select select = new Select(title);
		select.selectByVisibleText(Title);
		PostOrFunction.sendKeys(postorfunction);
		AddressLink.click();
		Thread.sleep(2000);
		ProfessionalPhone.sendKeys(professionalPhone);
		PersonalPhone.sendKeys(personalPhone);
		MobilePhone.sendKeys(mobilephone);
		Fax.sendKeys(fax);
		InstantMessaging.sendKeys(Instantmessaging);
		Birthday.sendKeys(birthday);
		Addbtn.click();
	}

}
