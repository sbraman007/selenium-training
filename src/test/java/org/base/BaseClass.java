package org.base;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static  WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();

	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void pagetitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	public static void passText(String string, WebElement ele) {
		ele.sendKeys(string);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	public static void screenShot(String imgname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgName.png");
		FileUtils.copyFile(f, image);
	}
	public static Actions a;
	
	public static void moveTheCurser(WebElement targetWebElement ) {
		a= new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragDrop(WebElement dragWebelement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebelement, dropElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0[.scrollIntoView(true)", tarWebEle);
	}
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public static void click(WebElement click) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", click);
	}
	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException  {
		File f = new File("excelLocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Data");
		Row r = mySheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value = "";
		if (cellType == 1) {
			String value2 = c.getStringCellValue();
			}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd  = (Date) c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);
		}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			String valueOf = String.valueOf(l);
		}
	}
	public static void createNewExcelFile( int rowNum, int cellNum , String sheetData) throws IOException  {
		File f = new File("C:\\Users\\DEMON\\eclipse-workspace\\NewMaven\\Excel\\chal.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet("Datas");
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(sheetData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}
	public static void createCell( int rowNum, int cellNum , String newData) throws IOException  {
		File f = new File("C:\\Users\\DEMON\\eclipse-workspace\\NewMaven\\Excel\\chal.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row rr = s.getRow(rowNum);
		Cell c  = rr.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fid = new FileOutputStream(f);
		wb.write(fid);
	}
	public static void createRow(int creRow, int creCell, String newData) throws IOException  {
		File f = new File("C:\\Users\\DEMON\\eclipse-workspace\\NewMaven\\Excel\\chal.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	public static void updateDatatoParticularCell(int getTheRow, int getThecell, String existingData,String writeNewData) throws IOException  {
		File f = new File("C:\\Users\\DEMON\\eclipse-workspace\\NewMaven\\Excel\\chal.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getThecell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(writeNewData);
	}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	
	}
}
	