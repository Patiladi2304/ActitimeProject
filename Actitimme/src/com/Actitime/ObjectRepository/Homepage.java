package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath = "//div[.='Time-Track']")
	private WebElement timetracktab;
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath = "//div[.='Reports']")	
private WebElement reportstab;

@FindBy(xpath = "//div[.='Users']")
private WebElement usertab;

@FindBy(id = "logoutLink")
private WebElement lgoutlnk;



//initilization
public Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


//utilization
public WebElement getTimetracktab() {
	return timetracktab;
}

public WebElement getTasktab() {
	return tasktab;
}

public WebElement getReportstab() {
	return reportstab;
}

public WebElement getUsertab() {
	return usertab;
}

public WebElement getLgoutlnk() {
	return lgoutlnk;
}








}
