package com.dolibar.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dolibar.base.TestBase;
import com.dolibar.pages.AddContractPage;
import com.dolibar.pages.AddPointofContactPage;
import com.dolibar.pages.AddProposalPage;
import com.dolibar.pages.AddServiceToTheContractPage;
import com.dolibar.pages.DolibarHomePage;
import com.dolibar.pages.LoginPage;
import com.dolibar.pages.ThirdPartiesPage;

public class AddServiceToTheContractTestPage extends TestBase{
	
	LoginPage loginpage;

	DolibarHomePage homepage;

	ThirdPartiesPage partiesPage;

	AddProposalPage proposalPage;

	AddPointofContactPage PocPage;
	
	AddContractPage contractPage;
	
	AddServiceToTheContractPage servicePage;
	
	public AddServiceToTheContractTestPage() {
		super();
	}
	
	@BeforeMethod
	public void startUp() throws InterruptedException
	{
		initialize();
		homepage = new DolibarHomePage();
		loginpage = new LoginPage();
		partiesPage = new ThirdPartiesPage();
		PocPage = new AddPointofContactPage();
		proposalPage =new AddProposalPage();
		contractPage = new AddContractPage();
		servicePage = new AddServiceToTheContractPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		partiesPage = homepage.clickOnthirdPartieslink();
		 PocPage.clickOnPointofConatctLink();
		 proposalPage.ClickonCustomerTab();
	}
	
	@Test(priority = 1)
	public void ValidateUnitPrice()
	{
		servicePage.ClickOnContractLink();
		boolean price = servicePage.unitPrice();
		Assert.assertEquals(price, false, "This feild should not be there because we are not charging anything in free service");
	}
	
	@Test(priority=2)
	public void ValidateaddService()
	{
		servicePage.ClickOnContractLink();
		servicePage.AddServicetoContract();
	}
	
	@Test(priority=3)
	public void ValidateaddSecondService()
	{
		servicePage.ClickOnContractLink();
		servicePage.AddSecondServicetoContract();
	}
	
	@Test(priority=3)
	public void ValidateaddThirdService()
	{
		servicePage.ClickOnContractLink();
		servicePage.AddThirdServicetoContract();
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
