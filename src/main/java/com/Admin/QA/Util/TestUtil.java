package com.Admin.QA.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.Admin.QA.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestUtil extends TestBase {
	public static ExtentReports extents;
	public static ExtentTest extentTest;
	public static XSSFWorkbook wb;
	XSSFSheet sheet1;
	XSSFCell cell;
	XSSFRow Row;
	static Workbook workbook;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH="E:/jbk/WorkSpace/AdminLTEfull/src/main/java/com/Admin/QA/Testdata/AddUsers.xlsx";
	public TestUtil(String excelPath) {
		
		try {
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet1 = wb.getSheetAt(0);
		} catch (Exception e) {

			System.out.println(e.getStackTrace());
		}
	}

	public String getData(int sheetNumber, int row1, int column) {
		String data=null;
			Row=(XSSFRow)sheet1.getRow(row1);
		cell=Row.getCell(column);
if(cell.getCellTypeEnum()==CellType.STRING){
	data=cell.getStringCellValue();
}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
	data=String.valueOf((long) cell.getNumericCellValue());
}
return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row;
		return row;
	}

public static void takeScreenshotAtEndOfTest() throws IOException{
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir=System.getProperty("user.dir");
	FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/"+System.currentTimeMillis()+".png"));
}

public static String getScreenshot(WebDriver driver,String screenshotName)throws IOException{
	String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"/FailedTestsScreenshot/"+screenshotName+dateName+".jpg";
	File finalDestination=new File(destination);
FileUtils.copyFile(source, finalDestination);
	return destination;
}

public static void tearDown1(ITestResult result) throws Exception{
	if(result.getStatus()==ITestResult.FAILURE){
		extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getName());
	extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
	String screenshotPath=TestUtil.getScreenshot(driver, result.getName());
	extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
	//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
	}
	else if(result.getStatus()==ITestResult.SKIP){
		extentTest.log(LogStatus.SKIP,"test case SKIPPED IS"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS){
		extentTest.log(LogStatus.PASS, "Test case passed is"+result.getName());
	}
	extents.endTest(extentTest);
	

	
}
//for Addusers
public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException, InvalidFormatException{
	FileInputStream file=null;
	
		
	file=new FileInputStream(TESTDATA_SHEET_PATH);
	
	
		workbook=WorkbookFactory.create(file);

	
	sheet=workbook.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++){
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			
			
		}
	}
	
	return data;
	
}

}





