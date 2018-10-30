package com.Admin.QA.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Admin.QA.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[2]/a")
	WebElement DashBoardLabel;
	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[3]/a")
	WebElement users_link;
	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[3]/a")
	WebElement operator_link;
	@FindBy(xpath = "html/body/div[1]/aside[1]/section/ul/li[5]/a")
	WebElement logout_link;
	@FindBy(xpath = "html/body/div[1]/aside[1]/section/div/div[2]")
	WebElement user_name;
	@FindBy(xpath = "html/body/div[1]/footer/strong")
	WebElement copyRight;
	@FindBy(xpath = "html/body/div[1]/footer/div/b")
	WebElement version;
	@FindBy(xpath = "html/body/div[1]/footer/div")
	WebElement succesfullylogouMsg;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	public String dashBoardTitle(){
		return driver.getTitle();
	}

	public String verifyDashBoardLabel() {
		return DashBoardLabel.getText();
	}

	public UsersPage verify_users_link() {
		users_link.click();
		return new UsersPage();
	}

	public OperatorPage verify_operator_link() {
		operator_link.click();
		return new OperatorPage();
	}

	public LoginPage verify_logout() {
		logout_link.click();
		return new LoginPage();
	}

	public String verifylogoutMsg() {

		return succesfullylogouMsg.getText();
	}

	public String verifyusername() {
		return user_name.getText();
	}

	public String verifyCopyRightlabel() {
		return copyRight.getText();
	}

	public String verifyVersion() {
		return version.getText();
	}

}