package com.Admin.QA.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Admin.QA.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath = "html/body/div[1]/div[2]/p")
	WebElement regLabel;

	@FindBy(xpath = "html/body/div[1]/div[1]")
	WebElement subTitle;

	@FindBy(xpath = ".//*[@id='name']")
	WebElement name;

	@FindBy(xpath = ".//*[@id='name_error']")
	WebElement NameErrorMsg;

	@FindBy(xpath = ".//*[@id='mobile']")
	WebElement mobile;

	@FindBy(xpath = ".//*[@id='mobile_error']")
	WebElement mobileErrorMsg;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement email;

	@FindBy(xpath = ".//*[@id='email_error']")
	WebElement emailErrorMsg;

	@FindBy(xpath = ".//*[@id='password']")
	WebElement password;

	@FindBy(xpath = ".//*[@id='password_error']")
	WebElement passwordErrorMsg;

	@FindBy(xpath = ".//*[@id='form']/div[5]/div/button")
	WebElement signBtn;
	
	@FindBy(xpath="html/body/div[1]/div[2]/a")
	WebElement alreadyMembersLink;

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyReglabel() {
		return regLabel.getText();
	}

	public String validateRegPageTitle() {
		return driver.getTitle();
	}
	
	public String validateRegPageSubTitle() {
		return subTitle.getText();
	}
	
	public String ValidateName() {
		return name.getAttribute("placeholder");
	}

	public String ValidateMobile() {
		return mobile.getAttribute("placeholder");
	}

	public String ValidateEmail() {
		return email.getAttribute("placeholder");
	}

	public String ValidatePassword() {
		return password.getAttribute("placeholder");
	}

	public String ValidateNameErrorMsg() {
		return NameErrorMsg.getText();
	}

	public String ValidateMobileErrorMsg() {
		return mobileErrorMsg.getText();
	}

	public String ValidateEmailErrorMsg() {
		return emailErrorMsg.getText();
	}

	public String ValidatePasswordErrorMsg() {
		return passwordErrorMsg.getText();
	}
public LoginPage validatealreadyMembersLink(){
	alreadyMembersLink.click();
	return new LoginPage();
	
}
	public void verifyRegPage(String Name, String Mobile, String Email, String Password) {

		name.sendKeys(Name);
		mobile.sendKeys(Mobile);
		email.sendKeys(Email);
		password.sendKeys(Password);
		signBtn.click();
		/*Alert al=driver.switchTo().alert();
		al.getText();
		al.accept();*/
	}

}
