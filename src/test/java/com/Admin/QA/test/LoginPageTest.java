package com.Admin.QA.test;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Admin.QA.Util.TestUtil;
import com.Admin.QA.base.TestBase;
import com.Admin.QA.page.DashboardPage;
import com.Admin.QA.page.LoginPage;
import com.Admin.QA.page.RegistrationPage;

public class LoginPageTest extends TestBase {
LoginPage login;
TestUtil excelconfig;
DashboardPage dashboardPage;
RegistrationPage registrationPage;

@BeforeMethod
public void setUp(){
	initialization();
	excelconfig=new TestUtil("E:/jbk/WorkSpace/AdminLTEfull/src/main/java/com/Admin/QA/Testdata/AdminLoginData.xlsx");
	login=new LoginPage();
}
@Test(priority = 1)
public  void loginPagetitle() {
	String Actual_Title=login.ValidateLoginPageTitle();
	Assert.assertEquals(Actual_Title, "AdminLTE 2 | Log in");
	
}
@Test(priority=2)
public void loginpageSubTitle(){
	String Actual_subTitle=login.ValidateSubTitle();
	Assert.assertEquals(Actual_subTitle, "AdminLTE");
}
@Test(priority=3)
public void email_placeholder(){
	String email_placeholder=login.validateEmailTextBox();
	Assert.assertEquals(email_placeholder, "Email");
}
@Test(priority=4)
public void password_placeholder(){
	String password_placeholder=login.validatePasswordTextBox();
	Assert.assertEquals(password_placeholder, "Password");
}
@Test(priority=5,dataProvider="AdminLogin")

public void verifyloginPageTextBox(String Email,String password){
	dashboardPage=login.login(Email, password);
	if(Email==null && password==null){
		String ActualEmailErrorMsg=login.ValidateEmailErrorMsg();
		Assert.assertEquals(ActualEmailErrorMsg, "Please enter email.");
		String ActualPasswordErrorMsg=login.ValidatePasswordErrorMsg();
		Assert.assertEquals(ActualPasswordErrorMsg,"Please enter password.");
	}else if(Email=="kiran@gmail.com" && password!="123456"){
		
		String ActualPasswordErrorMsg=login.ValidatePasswordErrorMsg();
		Assert.assertEquals(ActualPasswordErrorMsg,"Please enter password.");
		
	}else if(Email!="kiran@gmail.com"){
	String ActualEmailErrorMsg=login.ValidateEmailErrorMsg();
	Assert.assertEquals(ActualEmailErrorMsg, "Please enter email as kiran@gmail.com");
	String ActualPasswordErrorMsg=login.ValidatePasswordErrorMsg();
	Assert.assertEquals(ActualPasswordErrorMsg,"");
	}
	
		}

@DataProvider(name="AdminLogin")
public Object[][] PassData()  {
	  excelconfig =new TestUtil("E:/jbk/WorkSpace/AdminLTEfull/src/main/java/com/Admin/QA/Testdata/AdminLoginData.xlsx");
	 int row=excelconfig.getRowCount(0);
	  Object [][] data=new Object[row][2];
	  for(int i=1;i<row;i++){
		  data[i][0]=excelconfig.getData(0, i, 0);
		  data[i][1]=excelconfig.getData(0, i, 1);
		 
	  }
		  return data;
		  
				  
	  }

@Test(priority=6)
public void veryfylogin(){
	dashboardPage=login.login(prop.getProperty("Email"), prop.getProperty("Password"));
	String Dashlabel=dashboardPage.verifyDashBoardLabel();
	Assert.assertEquals(Dashlabel, "Dashboard");
}
 @Test(priority=7)
 public void verifyRegLink(){
	registrationPage=login.reglink();
	String reglabel=registrationPage.verifyReglabel();
	Assert.assertEquals(reglabel, "Register a new membership");
 }

@AfterMethod

public void tearDown(ITestResult result){
try {
	TestUtil.tearDown1(result);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	driver.quit();
}
}
