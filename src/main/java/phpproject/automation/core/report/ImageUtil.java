package phpproject.automation.core.report;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import phpproject.automation.core.util.VariableController;

public class ImageUtil {
	
// To capture the screenshot
	
	public static String CaptureScreen(WebDriver driver)
	
	{
		String Path;
		DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
		Date screenshotDate = new Date();
		String picName = screenshotName1.format(screenshotDate);
		//String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
		String folderPath =  System.getProperty("user.dir")+"\\output\\"+VariableController.getTestCaseName()+"\\screenshots\\"+picName+".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(folderPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path = "../"+VariableController.getTestCaseName()+"/screenshots/"+picName+".png";
		
		return Path;
	}
}