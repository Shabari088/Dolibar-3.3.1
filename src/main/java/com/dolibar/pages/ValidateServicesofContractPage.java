package com.dolibar.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.dolibar.base.TestBase;

public class ValidateServicesofContractPage extends TestBase{
	
	@FindBy(xpath = "//td[text()='Service #1']/following-sibling::td/descendant::table/following-sibling::table/tbody/tr/td/a/img")
	WebElement modifyLink1;
	
	@FindBy(xpath = "//td[text()='Service #2']/following-sibling::td/descendant::table/following-sibling::table/tbody/tr/td/a/img")
	WebElement modifyLink2;
	
	@FindBy(xpath = "//td[text()='Service #3']/following-sibling::td/descendant::table/following-sibling::table/tbody/tr/td/a/img")
	WebElement modifyLink3;
	
	@FindBy(name = "end")
	WebElement date;
	
	@FindBy(xpath = "//input[@value='Activate']")
	WebElement ActivateButton;
	
	@FindBy(xpath ="//input[@value='Close']")
	WebElement closeButton;
	
	public ValidateServicesofContractPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ActivateRunningNotExpiredService() throws InterruptedException
	{
		modifyLink1.click();
		Thread.sleep(2000);
		ActivateButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		Thread.sleep(2000);
		modifyLink2.click();
		Thread.sleep(2000);
		ActivateButton.click();
		
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
	}
	
	public void ActivateRunningExpiredService() throws InterruptedException
	{
		modifyLink3.click();
		Thread.sleep(2000);
		date.sendKeys("03/05/2018");
		Thread.sleep(2000);
		ActivateButton.click();	
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
	}
	
	public void closeRunningnotExpiredService() throws InterruptedException
	{
		modifyLink2.click();
		Thread.sleep(2000);
		date.sendKeys("03/05/2018");
		Thread.sleep(2000);
		closeButton.click();	
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
	}
	

}
