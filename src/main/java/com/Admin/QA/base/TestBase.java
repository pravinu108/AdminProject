package com.Admin.QA.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Admin.QA.Util.webEventListner;

public class TestBase {
public static Properties prop;
public static WebDriver driver;
public static EventFiringWebDriver e_driver;
public static webEventListner eventListener;
public TestBase() {
	prop=new Properties();
	FileInputStream fi;
	try {
		fi = new FileInputStream("E:\\jbk\\WorkSpace\\AdminLTEfull\\src\\main\\java\\com\\Admin\\QA\\config\\config.properties");
		prop.load(fi);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void initialization(){
	String browserName=prop.getProperty("browser");
	if(browserName.equals("firefox")){
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\PRAVIN\\geckodriver.exe");
	driver=new FirefoxDriver();
	
	}else{
		System.setProperty("webdriver.chrome.driver", "E:\\jbk\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	//e_driver=new EventFiringWebDriver(driver);
	//eventListener=new webEventListner();
	//e_driver.register(eventListener);
	//driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
}




}
