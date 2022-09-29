package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	 public static void captureScreenshot(WebDriver driver, int testID) throws Throwable {
		 Calendar cal=Calendar.getInstance();
		 Date time=cal.getTime();
		 String timeStamp=time.toString().replace(":", " ");
		 
		 TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
		 File file=takeScreenshot.getScreenshotAs(OutputType.FILE);
		 File destination=new File("C:\\Users\\ADMIN\\Desktop\\Software Testing\\Screenshots\\Test-"+testID+" "+timeStamp+".jpeg");
		 FileHandler.copy(file, destination);
	 }
	 
	 public static String fetchExcelData(String sheet, int row, int cellValue) throws Throwable {
		 String path="C:\\Users\\ADMIN\\Desktop\\Software Testing\\Excel Fetch.xlsx";
		 FileInputStream file=new FileInputStream(path);
		 Cell cell=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cellValue);
		 
		 try {
			 String data=cell.getStringCellValue();
			 return data;
		 }
		 catch(Exception e) {
			 double value=cell.getNumericCellValue();
			 String result=String.valueOf(value);
			 return result;
		 }
	 }

}
