package com.crm.testscript;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;
import com.crm.generic.FileLib;
import com.crm.objectrepository.Enter_Time_TrackPage;
import com.crm.objectrepository.TaskListPage;

public class CreateCustomerTest extends BaseClass {
	@Test
	public void createCustomerTest() throws InterruptedException, EncryptedDocumentException, IOException {
		FileLib fileLib=new FileLib();
		
		String expectedCustomerName=fileLib.getExcelData("createCustomer", 1, 1);
		String description=fileLib.getExcelData("createCustomer", 1, 2);
		Enter_Time_TrackPage enter_Time_TrackPage=new Enter_Time_TrackPage(driver);
		enter_Time_TrackPage.clickOnTasksModule();
		TaskListPage listPage=new TaskListPage(driver);
		listPage.clickOnAddNewButton();
		listPage.clickOnnewCustomerButton();
		listPage.enterDataInCustomernameTextFiled(expectedCustomerName);
		listPage.enterDataIncustomerDescriptionTextFiled(description);
		listPage.clickOnDropDown();
		listPage.selectOurCompany();
		listPage.clickOncreateCustomerButton();
		String actualCustomerName = listPage.verifyCustomerName();
		Assert.assertEquals(actualCustomerName, expectedCustomerName);	
	     fileLib.setExcelData("createCustomer", 1, 3, "pass");
	}
}
