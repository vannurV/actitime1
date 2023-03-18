package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(id ="username")
	private WebElement usernameTextBox;
	@FindBy(name = "pwd")
	private WebElement passwordTextBox;
	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement loginButton;
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	//utilization
	public void enterTextInUsername(String username) {
		usernameTextBox.sendKeys(username);
	}
	public void enterTextInPasswordTextBox(String password) {
		passwordTextBox.sendKeys(password);	
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	//business logic
	public void login(String username,String password) {
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);	
		loginButton.click();
	}
}
