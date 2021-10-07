package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//Locators
	private By email=By.id("email");
	private By password=By.id("passwd");
	private By signInButton=By.id("SubmitLogin");
	private By forgotPswdLink=By.linkText("Forgot your password?");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//behavior
	//for every step in feature file we have to create a method here
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPswdLinkExists() {
		return driver.findElement(forgotPswdLink).isDisplayed();
	}
	
	public void enterEmail(String emailText) {
		driver.findElement(email).sendKeys(emailText);
		
	}
	public void enterPassword(String psswd) {
		driver.findElement(password).sendKeys(psswd);
		
	}
	
	public AccountsPage clickOnLogin() {
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}
	
	
}
