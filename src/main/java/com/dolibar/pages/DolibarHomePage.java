package com.dolibar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibar.base.TestBase;

public class DolibarHomePage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Third parties')]")
	WebElement thirdPartieslink;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement homelink;
	
	@FindBy(xpath = "//span[contains(text(),'Products/Services')]")
	WebElement ProductsServiceslink;
	
	@FindBy(xpath = "//span[contains(text(),'Commercial')]")
	WebElement Commerciallink;
	
	@FindBy(xpath = "//span[contains(text(),'Financial')]")
	WebElement Financiallink;
	
	@FindBy(xpath = "//span[contains(text(),'Bank/Cash')]")
	WebElement BankCashlink;
	
	@FindBy(xpath = "//span[contains(text(),'Projects')]")
	WebElement Projectslink;
	
	@FindBy(xpath = "//span[contains(text(),'Members')]")
	WebElement Memberslink;
	
	@FindBy(xpath = "//span[contains(text(),'Documents')]")
	WebElement Documentslink;
	
	@FindBy(xpath = "//span[contains(text(),'Point of sale')]")
	WebElement PointofSalelink;
	
	@FindBy(xpath = "//span[contains(text(),'Agenda')]")
	WebElement Agendalink;
	
	@FindBy(xpath = "//span[contains(text(),'Holidays')]")
	WebElement Holidayslink;
	
	public DolibarHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homepageTitle()
	{
		return driver.getTitle();
	}
	
	public ThirdPartiesPage clickOnthirdPartieslink()
	{
		thirdPartieslink.click();
		return new ThirdPartiesPage();
		
	}
	
	public boolean homelink()
	{
		return homelink.isDisplayed();
		
	}
	
	public ProductServicesPage clickOnProductsServiceslink()
	{
		ProductsServiceslink.click();
		return new ProductServicesPage();
		
	}
	
	public CommercialPage clickOnCommerciallink()
	{
		Commerciallink.click();
		return new CommercialPage();
		
	}
	
	public FinancialPage clickOnFinanciallink()
	{
		Financiallink.click();
		return new FinancialPage();
		
	}
	
	public BankCashPage clickOnBankCashlink()
	{
		BankCashlink.click();
		return new BankCashPage();
		
	}
	
	public ProjectsPage clickOnProjectslink()
	{
		Projectslink.click();
		return new ProjectsPage();
		
	}
	
	public MembersPage clickOnMemberslink()
	{
		Memberslink.click();
		return new MembersPage();
		
	}
	
	public DocumentsPage clickOnDocumentslink()
	{
		Documentslink.click();
		return new DocumentsPage();
		
	}
	
	public PointOfSalePage clickOnPointofSalelink()
	{
		PointofSalelink.click();
		return new PointOfSalePage();
		
	}
	
	public AgendaPage clickOnAgendalink()
	{
		Agendalink.click();
		return new AgendaPage();
		
	}
	
	public HolidaysPage clickOnHolidayslink()
	{
		Holidayslink.click();
		return new HolidaysPage();
		
	}
	

}
