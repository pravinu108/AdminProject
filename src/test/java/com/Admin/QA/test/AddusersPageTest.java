package com.Admin.QA.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Admin.QA.Util.TestUtil;
import com.Admin.QA.base.TestBase;
import com.Admin.QA.page.AddUsersPage;
import com.Admin.QA.page.DashboardPage;
import com.Admin.QA.page.LoginPage;
import com.Admin.QA.page.UsersPage;

public class AddusersPageTest extends TestBase {
	AddUsersPage addUserpage;
	LoginPage loginPage;
	String sheetName = "Sheet1";
	UsersPage userPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		addUserpage = new AddUsersPage();
		loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
		userPage = new UsersPage();
		dashboardPage = new DashboardPage();
		dashboardPage.verify_users_link();
		userPage.adduserbtn();

	}

	@Test(priority = 1)
	public void addUserPlaceholders() {
		String[] actual_placeholder = new String[4];
		actual_placeholder[0] = addUserpage.usernamePlaceholder();
		actual_placeholder[1] = addUserpage.mobilePlaceholder();
		actual_placeholder[2] = addUserpage.emailPlaceholder();
		actual_placeholder[3] = addUserpage.passwordPlaceholder();

		String[] expected_placeholders = new String[4];
		expected_placeholders[0] = "Username";
		expected_placeholders[1] = "Mobile";
		expected_placeholders[2] = "Email";
		expected_placeholders[3] = "Password";
		for (int i = 0; i < 4; i++) {
			Assert.assertEquals(actual_placeholder[i], expected_placeholders[i]);
		}
	}

	@Test(priority = 2, dataProvider = "TextField")
	public void adduserErrors(String username, String mobileNo, String email, String Password, String state,
			String gender) throws Exception {

		addUserpage.AdduserFielsFilling(username, mobileNo, email, Password, state, gender);
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		String alert_msg = al.getText();
		// System.out.println(alert_msg);
		Assert.assertEquals(alert_msg, "User Added Successfully. You can not see added user.");
	}

	@DataProvider(name = "TextField")
	public Object[][] PassData() throws Exception, InvalidFormatException, IOException {

		Object data[][] = TestUtil.getTestData(sheetName);
		Thread.sleep(3000);
		return data;

	}
@Test(priority=3)
public void validateCancelBtn(){
	addUserpage.cancelBtn();
	String users_title=userPage.verifyuserstitle();
	Assert.assertEquals(users_title, "AdminLTE 2 | User");
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}