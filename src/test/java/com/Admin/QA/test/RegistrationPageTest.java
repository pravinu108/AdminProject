package com.Admin.QA.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Admin.QA.Util.TestUtil;
import com.Admin.QA.base.TestBase;
import com.Admin.QA.page.DashboardPage;
import com.Admin.QA.page.LoginPage;
import com.Admin.QA.page.RegistrationPage;

public class RegistrationPageTest extends TestBase {

	LoginPage loginPage;

	RegistrationPage registrationPage;
	SoftAssert sa;

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		registrationPage = new RegistrationPage();
		loginPage.reglink();
		sa = new SoftAssert();
	}

	@Test(priority = 1)
	public void verifyPageTitle() {

		String Actual_title = registrationPage.validateRegPageTitle();
		Assert.assertEquals(Actual_title, "AdminLTE 2 | Registration Page");
	}

	@Test(priority = 2)
	public void verifySubTitle() {
		String Actual_subTitle = registrationPage.validateRegPageSubTitle();
		Assert.assertEquals(Actual_subTitle, "AdminLTE");
	}

	@Test(priority = 3)
	public void verifyLabel() {
		String Actual_label = registrationPage.verifyReglabel();
		Assert.assertEquals(Actual_label, "Register a new membershi");
	}

	@Test(priority = 4)
	public void verifyPaceholders() {
		String[] Actual_placeholder = new String[4];
		Actual_placeholder[0] = registrationPage.ValidateName();
		Actual_placeholder[1] = registrationPage.ValidateMobile();
		Actual_placeholder[2] = registrationPage.ValidateEmail();
		Actual_placeholder[3] = registrationPage.ValidatePassword();

		String[] Expected_placeholder = new String[4];
		Expected_placeholder[0] = "Name";
		Expected_placeholder[1] = "Mobile1";
		Expected_placeholder[2] = "Email";
		Expected_placeholder[3] = "Password";

		for (int i = 0; i <= 3; i++) {

			sa.assertEquals(Actual_placeholder[i], Expected_placeholder[i]);
			sa.assertAll();
		}

	}

	@Test(priority = 5)
	public void verifyErrorMsg() {
		registrationPage.verifyRegPage("", "", "", "");

		String NameErrMsg = registrationPage.ValidateNameErrorMsg();
		Assert.assertEquals(NameErrMsg, "Please enter Name.");

		String mobileErrMsg = registrationPage.ValidateMobileErrorMsg();
		Assert.assertEquals(mobileErrMsg, "Please enter Mobile.");

		String emailErrMsg = registrationPage.ValidateEmailErrorMsg();
		Assert.assertEquals(emailErrMsg, "Please enter Email.");

		String passwordErrMsg = registrationPage.ValidatePasswordErrorMsg();
		Assert.assertEquals(passwordErrMsg, "Please enter Password.");

	}

	@Test(priority = 6)
	public void verifyRegistration() {
		registrationPage.verifyRegPage("pravin", "76767", "pravin@gmail.com", "dsdas");

		Alert al = driver.switchTo().alert();
		String alertMsg = al.getText();
		Assert.assertEquals(alertMsg, "User registered successfully.");
		al.accept();

	}

	@Test(priority = 7)
	public void verifyAlreadyMembersLink() {
		registrationPage.validatealreadyMembersLink();
		String loginPageTitle = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "AdminLTE 2 | Log in");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
