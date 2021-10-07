package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountsSection=By.cssSelector("div.row.addresses-lists span");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public int getsAccountsSectionCount() {
		return driver.findElements(accountsSection).size();
	}
	
	public List<String> getsAccountsSectionList(){
		List<String> accountsList=new ArrayList<>();
		List<WebElement> list=driver.findElements(accountsSection);
		
		for(WebElement e:list) {
			accountsList.add(e.getText());
		}
		
		return accountsList;
		
	}
	
	public String getsAccountPageTitle() {
		return driver.getTitle();
	}
}
