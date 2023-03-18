package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enter_Time_TrackPage {
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement tasksButton;
	public Enter_Time_TrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnTasksModule() {
		tasksButton.click();
	}
}
