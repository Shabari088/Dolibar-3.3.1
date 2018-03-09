package com.dolibar.pages;

import org.openqa.selenium.WebElement;

import com.dolibar.base.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ThirdPartiesPage extends TestBase{
	
	Select select;
	
	@FindBy(xpath = "//a[contains(text(),'New customer')]")
	WebElement NewCustomerLink;
	
	@FindBy(name="nom")
	WebElement ThirdPartyName;
		
	@FindBy(name="client")
	WebElement ProspectORCustomerType;
	
	@FindBy(name = "code_client")
	WebElement Customercode;
	
	@FindBy(name = "adresse")
	WebElement Address;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
		
	@FindBy(id="town")
	WebElement city;
	
	@FindBy(id="selectcountry_id")
	WebElement Country;
	
	@FindBy(id="departement_id")
	WebElement StateORProvince;
	
	@FindBy(name="phone")
	WebElement PhoneNumber;
	
	@FindBy(name="fax")
	WebElement FaxNumber;
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="url")
	WebElement Website;
	
	@FindBy(name="idprof1")
	WebElement ProfId1;
	
	@FindBy(name="idprof2")
	WebElement ProfId2;
	
	@FindBy(name="idprof3")
	WebElement ProfId3;
	
	@FindBy(name="idprof4")
	WebElement ProfId4;
	
	@FindBy(name="idprof5")
	WebElement ProfId5;
	
	@FindBy(name="tva_intra")
	WebElement VatNumber;
	
	@FindBy(id="typent_id")
	WebElement ThirdPartyType;
	
	@FindBy(id="photoinput")
	WebElement PhotoOfCustomer;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement AddThirdParty;
	
	public ThirdPartiesPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonNewCustomerLink()
	{
		NewCustomerLink.click();
	}
	
	public void CreateNewCustomer
	(String thirdpartyname,String prospectorCustomer,String customercode,String address,String Zipcode,String City,String country,
			String stateorprovince,String phonenumber,String faxnumber,String email,String website,String
			profid1,String profid2,String profid3,String profid4,String profid5,String vatnumber,String thirdpartytype) throws InterruptedException
	{
		ThirdPartyName.sendKeys(thirdpartyname);
		select = new Select(ProspectORCustomerType);
		select.selectByVisibleText(prospectorCustomer);
		Customercode.sendKeys(customercode);
		Address.sendKeys(address);
		zipcode.sendKeys(Zipcode);
		city.sendKeys(City);
		Country.sendKeys(country);
		select = new Select(StateORProvince);
		select.selectByVisibleText(stateorprovince);
		PhoneNumber.sendKeys(phonenumber);
		FaxNumber.sendKeys(faxnumber);
		Email.sendKeys(email);
		Website.sendKeys(website);
		ProfId1.sendKeys(profid1);
		ProfId2.sendKeys(profid2);
		ProfId3.sendKeys(profid3);
		ProfId4.sendKeys(profid4);
		ProfId5.sendKeys(profid5);
		VatNumber.sendKeys(vatnumber);
		select =  new Select(ThirdPartyType);
		select.selectByVisibleText(thirdpartytype);
		PhotoOfCustomer.sendKeys("E:\\Revise_selenium\\Dolibar\\IMG20160905120345.jpg");
		Thread.sleep(5000);
		AddThirdParty.click();
	}
	
}
