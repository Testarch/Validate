package phpproject.automation.demoapp.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import phhpproject.automation.core.driver.BrowserList;
import phhpproject.automation.core.driver.WebBrowser;
import phpproject.automation.core.report.ReportUtil;
import phpproject.automation.core.util.CommonUtil;
import phpproject.automation.core.util.EnvUtil;
import phpproject.automation.core.util.ReadExcelDataProvider;
import phpproject.automation.core.util.VariableController;
import phpproject.automation.demoapp.impl.PHPImpl;
//import phpproject.automation.demoapp.impl.FFPMItemFlowValidation;
//import phpproject.automation.demoapp.impl.FFPMPartialPromotion;
//import phpproject.automation.demoapp.impl.PromotionMainImpl;
import phpproject.automation.demoapp.workflow.FFPMPage;


@SuppressWarnings("unused")
public class PHPApplication extends VariableController 

{
	
	protected WebBrowser DEMOAPPBrowser = null;
	private  WebDriver driver;
	String Status;
	String value1,value2;
	static String DOI_local = null;

	
	@BeforeMethod
	
	// To launch the browser with  URL	
	public void Setup()
  {
	   //log.info("Before Test");
		try 
		
		{
		
			DEMOAPPBrowser = BrowserList.Browser("QI");
			DEMOAPPBrowser.NavigateTo(EnvUtil.getProperty("Browser"),EnvUtil.getProperty("PHP_APPLICATION_URL"));
			
			driver = CommonUtil.getDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
			
			Status = null;
		
		} 
		
		catch (Exception e) 
		
		{
			
			e.printStackTrace();
		}     
  }
	
@AfterMethod

// To close the browser
/*	 
public void TearDown()

{
			try 
			
			{
				DEMOAPPBrowser.Quit();
				DEMOAPPBrowser = null;
				CommonUtil.CloseDriver();
				Status = null;
			} 
			
			catch (Exception e) 
			{

				e.printStackTrace();
			}
			
			finally
			
			{
				if(DEMOAPPBrowser != null)
				
				{
					DEMOAPPBrowser.Quit();
					DEMOAPPBrowser = null;
					Status = null;
				}
			}
	    }

*/

@DataProvider(name="PHPwebsiteValidation")
public Object[][] FFPMItemFlowValidation() 

{
Object[][] arrayObject = ReadExcelDataProvider.getExcelData(VariableController.datasheet,VariableController.PHPwebsiteValidation,"T1-T8TC");

		return arrayObject;
}
@Test(dataProvider="PHPwebsiteValidation")
public void FFPMItemFlowValidation(
	   
		   String No,
		   String Active,
		   String Scenario,
		   String TestCase,
		   String TCDescription,
		   String Username,
		   String Password,
		   String Item
	   
	  ) 



{
String msg;

try

{
	
	JavascriptExecutor je = (JavascriptExecutor) driver;
	setTestCaseName(No , TCDescription, Scenario);
	
	//assertTrue(PHPImpl.PHPLogin(), "PHP application login Successful");
	assertTrue(PHPImpl.PHPRegister(),"PHP application login successful");
	Status = "Pass";

}

catch(Exception e)

{
	msg="Failed step";
	CommonUtil.report(msg,fail);
	CommonUtil.refresh(EnvUtil.getProperty("PHP_APPLICATION_URL"));
	 Status = "Fail";
	 
}


finally
{
	if(Status == null)
		Status = "Fail";
	ReportUtil.generateHTMLReport(Status);
	
}
}



}

 

 
