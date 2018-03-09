package com.dolibar.Testcases;

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
import com.dolibar.pages.ValidateContractPage;

public class ValidateContractTestPage extends TestBase{
	
	LoginPage loginpage;

	DolibarHomePage homepage;

	ThirdPartiesPage partiesPage;

	AddProposalPage proposalPage;

	AddPointofContactPage PocPage;
	
	AddContractPage contractPage;
	
	ValidateContractPage validatePage;
	
	AddServiceToTheContractPage servicePage;
	
	public ValidateContractTestPage() {

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
		validatePage = new ValidateContractPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("password"));
		partiesPage = homepage.clickOnthirdPartieslink();
		 PocPage.clickOnPointofConatctLink();
		 proposalPage.ClickonCustomerTab();
		 servicePage.ClickOnContractLink();
	}
	
	@Test
	public void ValidateClickonValidateButton()
	{
		validatePage.ClickOnValidateButton();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
