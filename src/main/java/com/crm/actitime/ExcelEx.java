package com.crm.actitime;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.crm.generic.FileLib;

public class ExcelEx {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileLib fileLib=new FileLib();
		String data=fileLib.getExcelData("createCustomer", 1, 1);
		String data1=fileLib.getExcelData("createCustomer", 1, 2);
		System.out.println(data);//HDFC_001
		System.out.println(data1);//HDFC_001

	}

}
