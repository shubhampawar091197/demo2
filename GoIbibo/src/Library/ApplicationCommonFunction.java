package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ApplicationCommonFunction extends BaseClass { //single inheritance

	public ApplicationCommonFunction(WebDriver driver) {
		super(driver); //to allocate memory when object is created
	}

	//based on the elements we have created the common fuction
	public void clickElement(By element) throws InterruptedException {
		driver.findElement(element).click();
		Thread.sleep(2000);
	}
	
	//date
	public static String generateRuntimeDate() {
		 Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String strDate= formatter.format(date);
		    return strDate;
	}
	
	//To TakeScreen Shots If Any Errors Occurs
		public static void takeSnapShot(String fileWithPath) throws IOException {
			
			TakesScreenshot scrShot=((TakesScreenshot) driver);//interface 
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);//output to be file type
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp=new Timestamp(System.currentTimeMillis());
			File DestFile=new File(fileWithPath + dateFormat.format(timestamp)+".jpg");
			FileHandler.copy(srcFile,DestFile);
		}
		
	
	
	public static int selectDateDay() {
		
		String [] dateParts = generateRuntimeDate().split("/");
		String day = dateParts[1];
	
		int a=Integer.parseInt(day);
		return a;
	}
    public static int selectDateMonth() {
		
		String [] dateParts = generateRuntimeDate().split("/");
		
		String month = dateParts[0];
	
		
		 int a=Integer.parseInt(month);
		return a;
	}
public  static int selectDateYear() {
	
	String [] dateParts = generateRuntimeDate().split("/");
	
	String year = dateParts[2];
	
	 int a=Integer.parseInt(year);
	return a;
}



	public void enterData(By element, String data) throws InterruptedException {
		driver.findElement(element).clear();
		Thread.sleep(1500);
		driver.findElement(element).sendKeys(data);
		Thread.sleep(2000);
	}

	public void enterKeysOption() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	}

	public void compareTextValue(By element, String expectedText, String actualText) {
		actualText = driver.findElement(element).getText();
		if (actualText.contains(expectedText)) {
			System.out.println("actual value matches expected value");
		} else {
			System.out.println("actual value does not match expected value");
		}
	}

	public void checkIfEnabled(By element) throws InterruptedException {
		if (driver.findElement(element).isEnabled()) {
			System.out.println("The element is enabled");
		} else {
			System.out.println("The element should be enabled but isn't");
			
		}
		Thread.sleep(1500);
	}

	public void checkIfDisplayed(By element) throws Exception {
		
		if (driver.findElement(element).isDisplayed()) {
			System.out.println("The element is displayed");
		} else {
			System.out.println("The element should be displayed but isn't");
			takeSnapShot("C:\\temp\\");
		}
		Thread.sleep(1500);
	}
	
	
	
	@DataProvider(name="excel-data")   //
	public Object[][] excelDP(){
		//we are creating an object from the excel sheet data by calling a method that reads data from the excel stores locally in our system.
			
			Object[][] arrobj= getExcelData("C:\\Users\\Admin\\Desktop\\DataSheet.xlsx","DataSet");
			return arrobj ;
		}

	private String[][] getExcelData(String Filename, String Sheetname) {
		
		String[][] data=null;   //we have to return data in string array
		try {
		
			FileInputStream fis=new FileInputStream(Filename);
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);  //file
			
			XSSFSheet sh=wb.getSheet(Sheetname);	//sheet
			
			XSSFRow row=sh.getRow(0);
			
			int noOfRows=sh.getPhysicalNumberOfRows();  //give number of rows in sheet
			
			int noOfCols=row.getLastCellNum();     //get the cell value
			
			Cell cell;
			
			
			data=new String[noOfRows-1][noOfCols];   //we have to skip the 1st row ie noofrows-1
			
			for(int i=1;i<noOfRows;i++){
				for(int j=0;j<noOfCols;j++) {
					
					row=sh.getRow(i);
					cell=row.getCell(j);
					data[i-j][j]=cell.toString();   //will convert any cell value into string
				}	
			}
		}catch(Exception e) {
			System.out.println("The exception is: " +e.getMessage());
		}
		return data;
	}

	
	
	
	

}
 