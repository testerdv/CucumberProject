package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
	
	public WebDriver driver;
	
	private By subjectHeading=By.id("id_contact");
	private By email =By.id("email");
	private By orderRef=By.id("id_order");
	private By message=By.id("message");
	private By sendButton=By.id("submitMessage");
	private By successfulMsg=By.cssSelector("div#center_column p");
	
	public ContactUs(WebDriver driver) {
		this.driver=driver;	
	}
	
	public void selectSubjectHeading(String subHeading) {
		
		Select select=new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(subHeading);
	}
	
	public void setEmail(String emailid) {
		driver.findElement(email).sendKeys(emailid);
		
	}

	public void setOrderRef(String oRef) {
		driver.findElement(orderRef).sendKeys(oRef);
	}
	
	public void setMessage(String msg) {
		driver.findElement(message).sendKeys(msg);
	}
	
	public void clickSendButton() {
		driver.findElement(sendButton).click();
	}
	
	public String getSuccessfulMessage() {
		
		return driver.findElement(successfulMsg).getText(); 
	}
}
