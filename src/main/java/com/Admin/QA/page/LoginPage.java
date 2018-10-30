package com.Admin.QA.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Admin.QA.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "html/body/div[1]/div[1]")
	WebElement SubTitle;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SigninBtn;

	@FindBy(xpath = "//a[contains(text(),'Register a new membership')]")
	WebElement RegLink;
	
	@FindBy(xpath = ".//*[@id='email_error']")
	WebElement EmailErrormsg;
	
	@FindBy(xpath = ".//*[@id='password_error']")
	WebElement passwordErrormsg;

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}

	public String ValidateSubTitle() {
		return SubTitle.getText();
	}
	
	public String ValidateEmailErrorMsg(){
		return EmailErrormsg.getText();
	}
	public String ValidatePasswordErrorMsg(){
		return passwordErrormsg.getText();
	}
public String validateEmailTextBox(){
	return email.getAttribute("placeholder");
}	
public RegistrationPage reglink(){
	RegLink.click();
	
	return new RegistrationPage();
}

public String validatePasswordTextBox(){
	return password.getAttribute("placeholder");
}

	public DashboardPage login(String email1, String passwrd) {

		email.sendKeys(email1);
		password.sendKeys(passwrd);
		 SigninBtn.click();
		return new DashboardPage();
	}
}