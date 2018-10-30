package com.Admin.QA.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Admin.QA.base.TestBase;

public class OperatorPage extends TestBase {

	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[4]/a")
	WebElement operator_link;

	public OperatorPage() {
		PageFactory.initElements(driver, this);
	}

	public String operatorPagetitle() {
		operator_link.click();
		return driver.getTitle();
	}
}
