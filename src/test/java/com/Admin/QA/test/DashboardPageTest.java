package com.Admin.QA.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Admin.QA.base.TestBase;
import com.Admin.QA.page.DashboardPage;
import com.Admin.QA.page.LoginPage;
import com.Admin.QA.page.OperatorPage;
import com.Admin.QA.page.UsersPage;

public class DashboardPageTest extends TestBase{
LoginPage loginPage;
DashboardPage dashboardPage;
UsersPage userPage;
OperatorPage operatorPage;
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		userPage=new UsersPage();
		 operatorPage=new OperatorPage() ;
		 loginPage.login(prop.getProperty("Email"),prop.getProperty("Password"));
	dashboardPage=new DashboardPage();
	}

	@Test(priority=1)
	public void verifyDashboardTitle(){
		String Actual_title=dashboardPage.dashBoardTitle();
	Assert.assertEquals(Actual_title, "AdminLTE 2 | Dashboard");	
	}
@Test(priority=2)
public void validateUsersLink(){
	dashboardPage.verify_users_link();
	String userpage_Title=userPage.verifyuserstitle();
Assert.assertEquals(userpage_Title, "AdminLTE 2 | User");	

}
@Test(priority=3)
public void validateOperatorLink(){
	dashboardPage.verify_operator_link();
	String operatorPage_title=operatorPage.operatorPagetitle();
	Assert.assertEquals(operatorPage_title, "AdminLTE 2 | Operators");
			
}
@Test(priority=4)
public void validateCopyright(){
	String Actual_copyright=dashboardPage.verifyCopyRightlabel();
	Assert.assertEquals(Actual_copyright, "Copyright © 2014-2015 JBK.");
}
@Test(priority=5)
public void validateVersion(){
	String Actual_version=dashboardPage.verifyVersion();
	Assert.assertEquals(Actual_version, "Version");
}
@Test(priority=6)
public void validateMenu(){
	
}
@AfterMethod
public void teardown(){
	driver.quit();
}
}
