package com.Admin.QA.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Admin.QA.base.TestBase;
import com.Admin.QA.page.DashboardPage;
import com.Admin.QA.page.LoginPage;
import com.Admin.QA.page.UsersPage;

public class UsersPageTest extends TestBase {
	LoginPage loginPage;
	UsersPage userPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
		dashboardPage = new DashboardPage();
		dashboardPage.verify_users_link();
		userPage = new UsersPage();
	}

	@Test(priority = 1)
	public void ValidateUsersTable() {

		userPage.table();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
