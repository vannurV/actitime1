package com.crm.testscript;


import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;
import com.crm.generic.FileLib;
import com.crm.objectrepository.Enter_Time_TrackPage;
import com.crm.objectrepository.TaskListPage;
@Listeners(com.crm.generic.ListenerImplementation.class)
public class CreateCustomerTest extends BaseClass {
	@Test
	public void createCustomerTest() throws InterruptedException, EncryptedDocumentException, IOException {
		FileLib fileLib=new FileLib();
		Random r=new Random();
		int r1 = r.nextInt(1000);
		String random=Integer.toString(r1);
		String expectedCustomerName=fileLib.getExcelData("createCustomer", 1, 1);
		String description=fileLib.getExcelData("createCustomer", 1, 2);
		Enter_Time_TrackPage enter_Time_TrackPage=new Enter_Time_TrackPage(driver);
		enter_Time_TrackPage.clickOnTasksModule();
		TaskListPage listPage=new TaskListPage(driver);
		listPage.clickOnAddNewButton();
		listPage.clickOnnewCustomerButton();
		listPage.enterDataInCustomernameTextFiled(expectedCustomerName+random);
		listPage.enterDataIncustomerDescriptionTextFiled(description);
		//listPage.clickOnDropDown();
		//listPage.selectOurCompany();
		listPage.clickOncreateCustomerButton();
		String actualCustomerName = listPage.verifyCustomerName();
		Assert.assertEquals(actualCustomerName, expectedCustomerName+random);	
	     fileLib.setExcelData("createCustomer", 1, 3, "pass");
	}
}
