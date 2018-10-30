package com.Admin.QA.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import com.Admin.QA.base.TestBase;

public class AddUsersPage extends TestBase {

	@FindBy(xpath = ".//*[@id='username']")
	WebElement userName;
	@FindBy(xpath = ".//*[@id='mobile']")
	WebElement mobile_no;
	@FindBy(xpath = ".//*[@id='email']")
	WebElement email_id;
	@FindBy(xpath = ".//*[@id='Male']")
	WebElement male;
	@FindBy(xpath = ".//*[@id='Female']")
	WebElement female;
	@FindBy(xpath = "html/body/div[1]/div[1]/section[2]/div/div/div/form/div[1]/div[5]/div/select")
	WebElement select;
	@FindBy(xpath = ".//*[@id='password']")
	WebElement password_box;
	@FindBy(xpath = "html/body/div[1]/div[1]/section[2]/div/div/div/form/div[2]/a/span")
	WebElement cancel_btn;
	@FindBy(xpath = ".//*[@id='submit']")
	WebElement submit_btn;
	@FindBy(xpath="html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")
	WebElement Adduser_btn;
	
	public AddUsersPage(){
		PageFactory.initElements(driver, this);
	}
	public String adduserPageTitle(){
		return driver.getTitle();
	}
	public String usernamePlaceholder(){
		return userName.getAttribute("placeholder");
	}
	public String mobilePlaceholder(){
		return mobile_no.getAttribute("placeholder");
	}
	public String emailPlaceholder(){
		return email_id.getAttribute("placeholder");
	}
	public String passwordPlaceholder(){
		return password_box.getAttribute("placeholder");
	}
	public void submitBtn(){
		submit_btn.click();
	}
	public void cancelBtn(){
		cancel_btn.click();
	}
	public void maleBtn(){
		male.click();
	}
public void femalebBtn(){
	female.click();
}
public void Adduser(){
	Adduser_btn.click();
}

public void AdduserFielsFilling(String username,String mobileNo,String email,String Password,String state,String gender){
	userName.sendKeys(username);
	mobile_no.sendKeys(mobileNo);
	email_id.sendKeys(email);
	password_box.sendKeys(Password);
	if(gender=="male"){
	male.click();
	}else{
		female.click();
	}
	Select select1=new Select(select);
	select1.selectByVisibleText(state);
	
	submit_btn.click();

}

}