package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addnewButton;
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	private WebElement newCustomerButton;
	@FindBy(xpath = "//div[@class='customerNameDiv']/input[@placeholder='Enter Customer Name']")
	private WebElement enterCustomernameTextFiled;
	@FindBy(xpath = "//div[@class='inputContainer']/textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDescriptionTextFiled;
	@FindBy(xpath = "//div[contains(text(),'Select Customer') and @class='emptySelection']")
	private WebElement customerDropdown;
	@FindBy(xpath = "//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourCompanyOption;
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerButton;
	@FindBy(xpath = "//div[@class='titleEditButtonContainer']/div[@class='title']")
	private WebElement customerName;
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddNewButton() {
		addnewButton.click();
	}
	public void clickOnnewCustomerButton() {
		newCustomerButton.click();
	}
	public void enterDataInCustomernameTextFiled(String customername) {
		enterCustomernameTextFiled.sendKeys(customername);
	}
	public void enterDataIncustomerDescriptionTextFiled(String description) {
		customerDescriptionTextFiled.sendKeys(description);
	}
	public void clickOnDropDown() {
		customerDropdown.click();
	}
	public void selectOurCompany() {
		ourCompanyOption.click();
	}
	public void clickOncreateCustomerButton() {
		createCustomerButton.click();
	}
	public String verifyCustomerName() throws InterruptedException {
		Thread.sleep(2000);
		String data = customerName.getText();
		return data;
	}
	public void clickOnLogout() {
		logoutLink.click();
	}
}
