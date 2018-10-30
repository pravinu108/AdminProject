package com.Admin.QA.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Admin.QA.Util.webEventListner;
import com.Admin.QA.base.TestBase;

public class UsersPage extends TestBase {

	@FindBy(xpath = "html/body/div[1]/div[1]/section[1]/h1")
	WebElement Users_label;
	@FindBy(xpath = "html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[1]")
	WebElement users_table;
@FindBy(xpath="html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")
WebElement addUser;
	// @FindBy(tagName="tr")
	// WebElement users_table;

	/*
	 * public String Table(){
	 * 
	 * String clm=null; List<WebElement>
	 * tr=users_table.findElements(By.tagName("tr")); for(WebElement row:tr){
	 * 
	 * List<WebElement> td=row.findElements(By.tagName("td")); for(WebElement
	 * col:td){ clm=col.getText(); System.out.println( col.getText()); } }
	 * return clm;
	 * 
	 * }
	 */

	public void table() {
		for (int j = 2; j <= 5; j++) {
			for (int i = 1; i <= 8; i++) {
				WebElement table = driver
						.findElement(By.xpath("html/body/div[1]/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr["
								+ j + "]/td[" + i + "]"));

				System.out.print(" " + table.getText());

			}
			System.out.println();
		}

	}

	public UsersPage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyuserstitle() {
		return driver.getTitle();
	}

	public String verifyUsertable() {
		return users_table.getText();
	}
	public void adduserbtn(){
		addUser.click();
		
	}
}