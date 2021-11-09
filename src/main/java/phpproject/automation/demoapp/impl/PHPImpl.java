package phpproject.automation.demoapp.impl;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.android.utils.GrabProcessOutput.Wait;
import com.google.common.base.Function;
import com.sun.tools.xjc.Driver;

import io.selendroid.exceptions.NoSuchElementException;
import io.selendroid.exceptions.StaleElementReferenceException;
import phhpproject.automation.core.driver.WebBrowser;
import phpproject.automation.core.util.CommonUtil;
import phpproject.automation.core.util.EnvUtil;
import phpproject.automation.core.util.ObjectLocator;


@SuppressWarnings("unused")
public class PHPImpl extends ObjectLocator 

{

 static //Logger log = Logger.getLogger(HomePageImpl.class);
 String msg;
 static String idname,getDOI;
 static int k=1;
 static int q=1;
 static int rowtocheck=0;
static String promotiepageprice;
static String localprice;


// To navigate to a URL
public static void navigateToDemoPage() 

{
	
	CommonUtil.refresh(EnvUtil.getProperty("Demoappnew_APPLICATION_URL"));
	CommonUtil.waitUntil(2000);
	
}

// Enter text in Wink Username field in Wink login page

  public static void typeUsername(String username) 
  {
    try
    
      {
    		CommonUtil.driver.findElement(usernameLocator).click();
    		CommonUtil.driver.findElement(usernameLocator).sendKeys(username);
    		CommonUtil.report("Enter Username in the Username field ","Pass","Username entered successfully");
            
    	}
    	
    	catch(Exception e)
    	
    	{
    		
    		msg = "Enter Username in the Username field";
        	CommonUtil.report(msg,fail,"Entering Username unsuccessful");
    	
    	}
    }
  
//Enter text in Wink Password field in Wink login page
  
    public static void typePassword(String password) 
    {
     
       try
       {
    		CommonUtil.driver.findElement(passwordLocator).click();
    		CommonUtil.driver.findElement(passwordLocator).sendKeys(password);
    		msg="Enter Password in the Password field";
    		CommonUtil.report(msg,"Pass","Password entered successfully");
        }
    	
    	catch(Exception e)
    	{
        	msg = "Enter Password in the Password field";
        	CommonUtil.report(msg,fail,"Entering Password unsuccessful");
    	
    		}    
    }
    
  
 // Click on the Login button in Wink Login page
 
	public static boolean submitLogin() 
	
	{

		try
		{
		
				
			CommonUtil.clicksync(loginbutton);
			Thread.sleep(3000);

  
        msg = "Click on login";
		CommonUtil.report(msg,pass,"Login button clicked successfully");
		return true;
        
      
       
        }
		
		catch(Exception e)
		
		{
        	msg = "Click on login";	
        	CommonUtil.report(msg,fail,e.getMessage());
    		return false;
    		}    
    }
	
	// To wait until the FFPM Page gets opened	
	
	public static boolean PHPLogin() throws InterruptedException 

	{
		try {
		WebElement ele=CommonUtil. driver.findElement(By.xpath("//a[text()='Demo']"));
		JavascriptExecutor js = (JavascriptExecutor) CommonUtil.driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		ele.click();
		CommonUtil.waitUntil(500);
		System.out.println("PHP -Demo link clicked successfully");
		msg = "PHP -Demo link ";
		CommonUtil.report(msg,pass,"PHP -Demo link clicked successfully");
		
		
		WebElement ele1=CommonUtil.driver.findElement(By.xpath("//a[text()='Pricing']"));
		JavascriptExecutor js1 = (JavascriptExecutor) CommonUtil.driver;
		js1.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele1);
		ele1.click();
		CommonUtil.waitUntil(500);
		System.out.println("PHP -Pricing link clicked successfully");
		msg = "PHP -Pricing link ";
		CommonUtil.report(msg,pass,"PHP -Pricing link clicked successfully");
		
		
		CommonUtil.driver.findElement(By.xpath("//div//span[text()='Features']")).click();
		System.out.println("PHP -Feature name clicked successfully");
		msg = "PHP -Feature name clicked ";
		CommonUtil.report(msg,pass,"PHP -Feature name clicked clicked successfully");
		
		WebElement ele3=CommonUtil.driver.findElement(By.xpath("//a[@class='lvl-0 link nav-link' and text()='Integrations']"));
		JavascriptExecutor js3 = (JavascriptExecutor) CommonUtil.driver;
		js3.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele3);
		ele3.click();
		CommonUtil.waitUntil(500);
		System.out.println("PHP -Integrations clicked successfully");
		msg = "PHP -Integrations name clicked ";
		CommonUtil.report(msg,pass,"PHP -Integrations  clicked successfully");
		
		
		CommonUtil.driver.findElement(By.xpath("//a[text()='Docs']")).click();
		System.out.println("PHP -Docs clicked successfully");
		msg = "PHP -Feature name clicked ";
		CommonUtil.report(msg,pass,"PHP -Docs  clicked successfully");
		
		CommonUtil.driver.findElement(By.xpath("//a[text()='Blog']")).click();
		System.out.println("PHP -Blog clicked successfully");
		msg = "PHP -Feature name clicked ";
		CommonUtil.report(msg,pass,"PHP -Blog  clicked successfully");
		
		CommonUtil.driver.findElement(By.xpath("//a[text()='Login']")).click();
		System.out.println("PHP -Login clicked successfully");
		msg = "PHP -Login clicked ";
		CommonUtil.report(msg,pass,"PHP -Login  clicked successfully");
		/*
	  for(int i=0;i<25;i++)
	  {

		  if (CommonUtil.isElementPresent(usernameLocator)&&CommonUtil.isElementPresent(passwordLocator)!=true)
		  {
			  	CommonUtil.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			  
		  }

	  }

		
			
	typeUsername(username);
	CommonUtil.waitUntil(1000);
	typePassword(password);
	CommonUtil.waitUntil(1000);*/
	return true;

	
	
	}
catch(Exception e)
	
	{
    	msg = "Failed Step";
    	CommonUtil.report(msg,fail,"PHP page navigation unsuccessful");
		return false;
	} 
		
	}	
	
//Register inside PHP login
	public static boolean PHPRegister() throws InterruptedException 

	{
		try
		{
			//Login button from Home page
			WebElement elelogin=CommonUtil.driver.findElement(By.xpath("//a[text()='Login']"));
			JavascriptExecutor js3 = (JavascriptExecutor) CommonUtil.driver;
			js3.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", elelogin);
			elelogin.click();
			System.out.println("PHP -Login clicked successfully");
			msg = "PHP -Login clicked ";
			CommonUtil.report(msg,pass,"PHP -Login  clicked successfully");
			
			//Navigate to another URL for registration - https://phptravels.org/index.php?rp=/login
			//String url="https://phptravels.org/index.php?rp=/login";
			//CommonUtil.driver.navigate().to(url);
			
			//select registration page for new user
			//switch to new window
			for(String winHandle : CommonUtil.driver.getWindowHandles()){
				CommonUtil.driver.switchTo().window(winHandle);
			}
			//Open dropdown
			CommonUtil.driver.findElement(By.xpath("//div[@id='primary-nav']/ul[@class='nav navbar-nav navbar-right']/li[@id='Secondary_Navbar-Account']/a[@class='dropdown-toggle']/b[@class='caret']")).click();
			//Select 'Registration' for new user
			CommonUtil.driver.findElement(By.xpath("//div[@id='primary-nav']/ul[@class='nav navbar-nav navbar-right']/li[@id='Secondary_Navbar-Account']/ul[@class='dropdown-menu']/li[@id='Secondary_Navbar-Account-Register']")).click();
			System.out.println("Registration page clicked successfully");
			
			
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[1]/div/input[@id='inputFirstName']")).sendKeys("Test1");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[2]/div/input[@id='inputLastName']")).sendKeys("Test2");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[3]/div/input[@id='inputEmail']")).sendKeys("Test@gmail.com");

			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[4]/div/div/div/div/div[3]"));
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[4]/div/div/div/ul/li[102]"));
			
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[2]/div[4]/div/div/input[@id='inputPhone']")).sendKeys("9123456780");

			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[1]/div/input[@id='inputCompanyName']")).sendKeys("Testcomp");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[2]/div/input[@id='inputAddress1']")).sendKeys("Testaddr1");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[3]/div/input[@id='inputAddress2']")).sendKeys("Testaddr2");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[4]/div/input[@id='inputCity']")).sendKeys("TestCity");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[5]/div/input[@id='stateinput']")).sendKeys("Testinput");
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[6]/div/input[@id='inputPostcode']")).sendKeys("800001");
			//CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[7]/div/input[@id='inputCountry']")).click();
			//CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[7]/div/input[@id='inputCountry']/option[102]"));
			
			//Select drpCountry = new Select(CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[4]/div[7]/div/input[@id='inputCountry']")));
			//drpCountry.selectByVisibleText("India");
			
			CommonUtil.driver.findElement(By.xpath("//div[@id='registration']/form[@id='frmCheckout']/div[@id='containerNewUserSignup']/div[6]/div[1]/div/div/input[@id='customfield2']")).sendKeys("1111111111");
			
			
			
			
			return true;
		}
	
		catch(Exception e)
		
		{
	    	msg = "Failed Step";
	    	CommonUtil.report(msg,fail,"PHP page navigation unsuccessful");
			return false;
		} 
			
	}	
// Verify Wink Homepage is open	
	public static boolean openHomePage() 
{
		
		try
		
	{
			WebDriverWait wait = new WebDriverWait(CommonUtil.driver, 60); 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(verifyHomePageTitle)); 

		if(CommonUtil.driver.findElement(verifyHomePageTitle).getText().contentEquals("Home"))
		{
			msg = "Home page verification";
			CommonUtil.report(msg,pass,"Home Page displayed successfully");
			return true;
			
		}
		
			
		msg = "Home page verification";
		CommonUtil.report(msg,fail,"Home page verification unsuccessful");
		
        return false;

  
   
	}
	
	catch(Exception e)
	
	{
    	msg = "Failed Step";
    	CommonUtil.report(msg,fail,"Home page verification unsuccessful");
		return false;
	}    

}	
}


