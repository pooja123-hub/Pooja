package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
public static void captureScreenShot(WebDriver driver,int id) throws IOException {
		
		SimpleDateFormat sysDate = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String value =sysDate.format(date);
		
		TakesScreenshot take = (TakesScreenshot)driver;
		
		File src =take.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\ABC\\Documents\\Test_Screenshots\\Facebook-" + id + " " + value + ".jpeg");

		FileHandler.copy(src, dest);
		
	}
	
	
	public static String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\ABC\\Desktop\\Practice.xlsx");
		
		Cell cell =WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		
		String value;
		try {
			 value =cell.getStringCellValue();
		}
		catch(IllegalStateException e) {
			
			double numValue=cell.getNumericCellValue();
			long num= (long) numValue;
			
			value=Long.toString(num);
		}
		
		return value;
	}

}
