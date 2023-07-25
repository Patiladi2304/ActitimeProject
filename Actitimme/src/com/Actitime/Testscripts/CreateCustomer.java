package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplemtation;
import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.TaskPage;
@Listeners(ListenerImplemtation.class)
public class CreateCustomer extends Baseclass{
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
		String name = f.readDataFromExcel("Pavan", 1, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDataFromExcel("Pavan", 1, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecustbtn().click();
		
		
		
	}

}
