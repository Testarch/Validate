package phpproject.automation.core.util;

import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;

import com.android.ddmlib.TimeoutException;
//import com.sun.glass.events.KeyEvent;

import phhpproject.automation.core.driver.WebConfig;
import phpproject.automation.core.report.ImageUtil;
import phpproject.automation.core.report.ReportUtil;



@SuppressWarnings("unused")
public class CommonUtil extends VariableController

{

public static WebDriver driver;  
private static StringBuffer verificationErrors = new StringBuffer();
//static  Logger log = Logger.getLogger(CommonUtil.class);
public static CommonUtil common = new CommonUtil();
public String testcaseName ;
public static boolean driverflag = false;
public static WebElement webelement;
public BufferedWriter loggingWriter;
public static String Browser;
public static ArrayList<String> arraylist = new ArrayList<String>();


// To get the driver

public static WebDriver getDriver()

{
	try
	
	{
		driver = WebConfig.driver;
		setBrowser(driver);
		return driver;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	return null;
	}
}


//To get the browser
public static String getBrowser() 

{
	return Browser;
}

// To check the Ip

public static String NVL(String ip)
{
	if("null"==ip || null==ip)
		return "";
	else
		return ip;
}


//To set the browser

public static void setBrowser(WebDriver driver) 

{
	String browserName;
	String v;
	try{
	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    browserName = cap.getBrowserName().toLowerCase();
    v = cap.getVersion().toString();
    
    browserName =  browserName.substring(0, 1).toUpperCase() + browserName.substring(1);
    
	Browser = browserName+"-- v."+v;
	
	}
	
	catch(Exception e){e.printStackTrace();}
}

// To check if element is displayed

public static boolean isDisplayed(By by) 

{
	try {
		if(driver.findElement(by).isDisplayed())
		
		{
			return true;
					
		}
			return false;
		}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}

// To clear the browser data

public static void clearBrowserData()

{
	CommonUtil.driver.get("chrome://settings/clearBrowserData");
 	CommonUtil.sleep(2000);
 	CommonUtil.driver.findElement(By.cssSelector("* /deep/ #clearBrowsingDataConfirm")).click();
 	CommonUtil.sleep(5000);
}


//To scroll down a webpage.
public static void scrolldown(By by) 

{
	
	try 
	{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			WebElement element = driver.findElement(by);

			js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
}

public static void scrolldown(String xpath) 

{
	
	try 
	
	{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			WebElement element = driver.findElement(By.xpath(xpath));

			js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
}


//To check if element is enabled

public static boolean isEnabled(By by) 

{
	try 
	
	{
		if(driver.findElement(by).isEnabled())
		
		{
			return true;
					
		}
			return false;
		}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}


//To check if element is displayed

public static boolean isElementDisplay(By by) 

{
	try 
	
	{
	if(driver.findElement(by).isDisplayed())
	
	{
		return true;
	}
	
		return false;

	}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}

//To check if element is enabled

public static boolean isElementEnable(By by) 

{
	try 
	
	{
	if(driver.findElement(by).isEnabled())
	
	{
		return true;
	}
	
		return false;

	}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}


//To check if element is present till a specific time
	public static boolean isElementPresent(By by,int time) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,time);
			wait.until( ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			//System.out.println("ELEMENT PRESENT................");
			return true;
		}
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}

//To check if element is present
public static boolean isElementPresent(By by) 

{
	try 
	
	{
	driver.findElement(by);
	//System.out.println("ELEMENT PRESENT................");

	return true;
		}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}

public static boolean isElementPresent(String xpath) 

{
	try {
	driver.findElement(By.xpath(xpath));
	return true;
		}
	catch (NoSuchElementException e) 
		{
		return false;
		}
}

//To check if an attribute is present
public static  boolean isAttribtuePresent(By by, String attribute) 

{
    Boolean result = false;
    try 
    
    {
    	if(isElementPresent(by))
    	{
    		 String value = driver.findElement(by).getAttribute(attribute);
    	        if (value != null){
    	            result = true;
    	        }
    	}
    } catch (Exception e) {}
	return result;
}


// To clean an array

public static String[] clean(final String[] v) 

{
	try
	
	{
		String[] stud = null ;
		// get the count
	    int count = 0;
	    int sum = 0;
	    for(int i = 0; i < v.length; i++)
	    
	    {
	        if(v[i] != null)
	        
	        {
	            count++;
	        }
	    }
	    
	    stud = new String[count];
	    for(int j = 0; j < v.length; j++)
	    
	    {
	        if(v[j] != null){
	        	stud[sum] = v[j];
	        	sum++;
	        }
	    }
	    
	    
	    return stud;
		
	}
	
	catch(Exception e){}
	return null;
}

// To close the driver
public static void CloseDriver() throws Exception 

{
	
	//driver.manage().deleteAllCookies();
	//driver.close();
	//driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) 
	
	{
		Assert.fail(verificationErrorString);
		}
	}

/*
public static String[] div(String fullpath)

{
	
	try
	
	{
		if(fullpath.substring(fullpath.length()-4, fullpath.length()).trim().equalsIgnoreCase("span"))
		
		{
			fullpath = fullpath.substring(0, fullpath.length()-5);
		}
		else if(fullpath.substring(fullpath.length()-1, fullpath.length()).trim().equalsIgnoreCase("a"))
		
		{
			fullpath = fullpath.substring(0, fullpath.length()-2);
		}
		else if(fullpath.substring(fullpath.length()-1, fullpath.length()).trim().equalsIgnoreCase("]"))
		
		{
			fullpath = fullpath.substring(0, fullpath.length()-4);
		}
		
		String s = fullpath.substring(31, fullpath.length());
		s = s.replace('[', ']');
		s = s.replace('/', ' ');
		s = s.replace('*', ' ');
		s = s.replace('u', ' ');
		s = s.replace('l', ' ');
		s = s.replace('i', ' ');
		s=s.replaceAll("\\s","");
		s=s.trim();
		String[] splitArray = s.split("]]");
		return splitArray;
	
	}
	
	catch(Exception e)
	
	{
		e.printStackTrace();
		return null;
	}
	
	
}

public ArrayList<Integer> occurrencesPos(String str, String substr) 

{
    final boolean ignoreCase = true;
    int substrLength = substr.length();
    int strLength = str.length();

    ArrayList<Integer> occurrenceArr = new ArrayList<Integer>();

    for(int i = 0; i < strLength - substrLength + 1; i++) {
        if(str.regionMatches(ignoreCase, i, substr, 0, substrLength))  
        
        {
            occurrenceArr.add(i);
        }
    }
    return occurrenceArr;
}

public static boolean comparetwoArray(String[] array1, String[]array2)

{
	int m ;
	int k = 0;
	 if(array1.length == array2.length){
		 for( m = 0; m <array1.length ; m++)
		 {
			 if(array1[m].equals(array2[m]))
			 {
				 k++;	 
			 }
		 }
		  if(array1.length == k)
		  {
			  return true;
		  }
	 }
	
	return false;
}

*/

// To CaptureScreenshot()

public static void CaptureScreenshot(String TestcaseName)

{
	DateFormat screenshotName1 = new SimpleDateFormat("dd-MMMM-yyyy_HH-mm-ss");
	Date screenshotDate = new Date();
	String picName = screenshotName1.format(screenshotDate);
	//String folderPath = "C:\\SeleniumWorks\\QiReEngg\\Screenshots\\"+TestcaseName+"\\"+picName+".png";
	String folderPath = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\"+TestcaseName+"\\screenshots\\"+picName+".png";
	System.out.println(picName);
	System.out.println(folderPath);
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	try 
	{
		FileUtils.copyFile(scrFile, new File(folderPath));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}

//Function to be used to sleep a thread for a given milli seconds. 

public static void sleep(int time) 
{
	try
	{
		Thread.sleep(time);
		
		/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(time, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);*/
	} 
	
	
	catch (InterruptedException e) 
	
	{
		e.printStackTrace();
	}
}


 //Function to be used for Reporting purpose. 


public static void report(String steps,String status,String ar)

{
	if(status.equalsIgnoreCase(pass))
	
	{
		//log.info(steps);
	}
	
	else if(status.equalsIgnoreCase(fail))
	{
		//log.fatal(steps);
	}
			try
			{
				ReportUtil.tcasestep.add(steps);
				ReportUtil.status.add(status);
				ReportUtil.description.add(ar);
				ReportUtil.Screenshot.add(ImageUtil.CaptureScreen(driver));
				
			}
			
			catch(Exception e)
			
			{}
		
	} 



public static void report(String steps,String status)

{
	
	if(status.equalsIgnoreCase(pass))
	
	{
		//log.info(steps);
	}
	
	else if(status.equalsIgnoreCase(fail))
	
	{
		//log.fatal(steps);
	}
		
			try{
				ReportUtil.tcasestep.add(steps);
				ReportUtil.status.add(status);
				ReportUtil.description.add(" ");
				ReportUtil.Screenshot.add(ImageUtil.CaptureScreen(driver));
				
			}catch(Exception e){}
		
	}

public static void report1(String steps,String status, String ar)

{
	
	if(status.equalsIgnoreCase(pass))
	
	{
		//log.info(steps);
	}
	
	else if(status.equalsIgnoreCase(fail))
	
	{
		//log.fatal(steps);
	}
		
			try
			{
				ReportUtil.tcasestep.add(steps);
				ReportUtil.status.add(status);
				ReportUtil.description.add(ar);
				ReportUtil.Screenshot.add(ImageUtil.CaptureScreen(driver));
				
			}
			
			catch(Exception e){}
		
	}

// to get system date time

public static String getDateTime(String Format)
{
	if(Format.trim().length()==0)
		Format = "yyyy_MM_dd_HH_mm_ss";
	DateFormat dateFormat = new SimpleDateFormat(Format);
	Date date = new Date();
	return (dateFormat.format(date));
}

public static String getDateTime()
{
	return (getDateTime(""));
}


// To kill processes

public static void killProcess(String ProcessName)
	{
		try 
		{
			if(OS.get()==OS.WINDOWS)
				Runtime.getRuntime().exec("taskkill /F /IM " + ProcessName);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


 // Description : Function to be used to get all  Tab Detail 



/*

 public static String[] gettabDetail(By by , String xpath) 


{
	int count;
	try{
	String[] listName = null; 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
	count = driver.findElements(by).size();
	if(count > 0){
		listName = new String[count];
		for(int i=0;i<count;i++ ){
			listName[i] = driver.findElement(By.xpath(xpath+"["+(i+1)+"]/a")).getText();
						}
		return listName;
	 	}
	 }
}
	
	catch(Exception e){//log.fatal(e.getMessage()); 
	return null;
	
}
return null;
}

*/




/*
public static boolean clickontab(By by , String xpath , String tabName) 

{
	int count;
	try{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
	count = driver.findElements(by).size();
	if(count > 0){
		for(int i=0;i<count;i++ ){
			if(driver.findElement(By.xpath(xpath+"["+(i+1)+"]/a")).getText().equals(tabName)){
			 driver.findElement(By.xpath(xpath+"["+(i+1)+"]/a")).click();
			 return true;
			}
			
						}
		return false;
	 	}
	 }
}
	
	catch(Exception e)
	{ 
	//log.fatal(e.getMessage()); return false;
	}
return false;
}

*/

// To get text

public static String getText(By by) 

{
	try
	
	{
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
		 return driver.findElement(by).getText();	
	 }
	}
	
	catch(Exception e)
	
	{
		//log.fatal(e.getMessage());
		return null;
	}
	return null;
}

// To get the title

public static String getTitle() 

{
	try
	
	{
		 return driver.getTitle();	
	 
	}
	
	catch(Exception e)
	
	{
		//log.fatal(e.getMessage());
	}
	return null;
	
}


public static String getText(String xpath) 

{
	try
	
	{
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 if(isElementPresent(By.xpath(xpath)))
	 
	 {
		 return driver.findElement(By.xpath(xpath)).getText();	
	 }
	}
	
	catch(Exception e)
	
	{
		//log.fatal(e.getMessage());
		return null;}
	return null;
}


// To get the attribute value

public static String getAttributeValue(By by, String value) 


{
	try
	
	{
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
		 return driver.findElement(by).getAttribute(value);	
	 	}
	 }
	
	catch(Exception e)
	
	{
		// log.fatal(e.getMessage()); 
		 return null;
		 
	}
	return null;	
}

//Function to be used to get the Dropdown first value


/*

public static String getFirstSelectedOption(By by) 

{
	try
	
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(isElementPresent(by))
	 
	 {
		 return new Select(driver.findElement(by)).getFirstSelectedOption().getText();
	 	}
	 }
	
	catch(Exception e)
	
	{
		 //log.fatal(e.getMessage()); 
		 return null;
		 
	}
	return null;
}


//Function to be used to get the list of name of elements of checkbox type


/*

public static String[] getCheckBoxListAll(By by)
{

	int size ;
	String[] listName = null; 
	
    if(isElementPresent(by))
    {
    	size = driver.findElements(by).size();
    	listName = new String[size];
    	for(int i=0;i<size;i++)
    	{
    		listName[i] =  driver.findElements(by).get(i).getAttribute("name");
    	}
    	listName = clean(listName);
    	return listName;
    }
    return null;
}

*/

// Function to be used for Uncommon list from two array


public static String differArrays(String[] arr1 , String []arr2)

{

	//this is to avoid calling Arrays.asList multiple times
	List<String> aL = Arrays.asList(arr1);
	List<String> bL = Arrays.asList(arr2);
	
	//finding the common element for both
	Set<String> common = new HashSet<String>(aL);
	common.retainAll(bL);
	
	
	//now, the real uncommon elements
	Set<String> uncommon = new HashSet<String>(aL);
	uncommon.addAll(bL);
	uncommon.removeAll(common);
	if(uncommon.toString().equals("[]")){
		return "";
	}
	return uncommon.toString();
	
}

// To check if a string is contained in another

public static boolean contains(String fullString , String contain)

{
	if(fullString.contains(contain)){return true;}else{return false;}
	
}

// Function to be used to get the list of name of selected elements of checkbox type

// To get a list of all checkbox selected

public static String[] getCheckBoxListSelected(By by)
{
	int size ;
	String[] listName = null; 
	
	if(CommonUtil.isElementPresent(by))
	{
		size = driver.findElements(by).size();
		listName = new String[size];
		for(int i=0;i<size;i++){
			if(driver.findElements(by).get(i).isSelected())
			{
				listName[i] =  driver.findElements(by).get(i).getAttribute("name");
			}
		}
		listName = CommonUtil.clean(listName);
		return listName;
	 }
	return null;
}



// Description : Function to be used to get List

public static String[] getlist(By by , String xpath) 

{
	int count;
	try{
		String[] listName = null; 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 if(isElementPresent(by)){
		count = driver.findElements(by).size();
		if(count > 0){
			listName = new String[count];
			for(int i=0;i<count;i++ ){
				listName[i] = driver.findElement(By.xpath(xpath+(i+1)+"]/td[1]/span[1]")).getText();
									}
			return listName; 
		 	}	
		 }
	}catch(Exception e){
		//log.fatal(e.getMessage()); 
		return null;}
	return null;
}

// To get a list of all radio buttons

public static String getradiolist(By by , String xpath)

{
	int noofColumn;
	try{
	String listName = null ; 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
		 
		 noofColumn = driver.findElements(by).size(); 
	if(noofColumn > 0 ){
			for(int j = 0;j<noofColumn;j++ ){				
				if(isAttribtuePresent(By.xpath(xpath+(j+1)+"]"),"checked")){
					
					if(driver.findElement(By.xpath(xpath+(j+1)+"]")).getAttribute("checked").equals("true")){
						listName = driver.findElement(By.xpath(xpath+(j+1)+"]")).getAttribute("value");
			
					}
				}
			}
	
		return listName;
		 
	 }
		
	}
	
	}
	
	catch(Exception e)
	
	{ 
		//log.fatal(e.getMessage()); 
		return null;
		
	}
	return null;
	}

//Function to be used to get List

public static String[] getlist(By by , String xpatha , String xpathb) 

{
	int count;
	try{
		String[] listName = null; 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 if(isElementPresent(by)){
		count = driver.findElements(by).size();
		if(count > 0)
		
		{
			listName = new String[count];
			for(int i=0;i<count;i++ )
			
			{
				listName[i] = driver.findElement(By.xpath(xpatha+(i+1)+xpathb)).getText();
			}
			return listName; 
		 	}	
		 }
	}
	
	catch(Exception e)
	
	{ 
		//log.fatal(e.getMessage()); 
		return null;}
	return null;
}


// To get table checkbox text
public static String[] getTableCheckBoxText(By by , By column , By row , String xpath) 

{
	int noofColumn,noofrow,count;
	int k = 0;
	try{
	String[] listName = null; 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(CommonUtil.isElementPresent(by)){
		 noofColumn = driver.findElements(column).size(); 
		 noofrow = driver.findElements(row).size(); 
	if(noofColumn > 0 && noofrow > 0){
		count = driver.findElements(by).size();
		listName = new String[count];
		for(int i=0;i<noofrow;i++ ){
			for(int j = 0;j<noofColumn;j++ )
			
			{				
				if(CommonUtil.isAttribtuePresent(By.xpath(xpath+(i+1)+"]/td["+(j+1)+"]/input[3]"),"checked")){
					if(driver.findElement(By.xpath(xpath+(i+1)+"]/td["+(j+1)+"]/input[3]")).getAttribute("checked").equals("true")){
						listName[k] = driver.findElement(By.xpath(xpath+(i+1)+"]/td["+(j+1)+"]")).getText();
						k++;
					}
				}
			}
	}
		listName = clean(listName);
		return listName;
		 
	 }
		
	}
	
	}catch(Exception e){report("getTableCheckBoxText","Fail",e.getMessage()); return null;}
	return null;
	}

// To get the checkbox checked
	 
public static String getChekboxChecked(By by ,By byy)

{
	int noofColumn;
	try{
	String listName = null; 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(isElementPresent(by)){
		 
		 noofColumn = driver.findElements(by).size(); 
	if(noofColumn > 0 ){				
				if(isAttribtuePresent(byy,"checked"))
				
				{
					if(driver.findElement(byy).getAttribute("checked").equals("true"))
					
					{
						listName = "checked";
			
					}
				}
				
				else
				
				{
					listName = "unchecked";
				}
			
	
		return listName;
		 
	 }
		
	}
	
	}catch(Exception e){report("getChekboxChecked","Fail",e.getMessage()); return null;}
	return null;
	}

// To click on a link

public static void clicksync(By by) 

{
	
	//sleep(2000);
	 if(isElementPresent(by))
	 
	 {
		 //pageLoadTimeout(120);
		 driver.findElement(by).click();
		 pageLoadTimeout(120);
		 
	 			}
}

	 
// To clear the contents of a webelement		 

public static void clear(By by) 

{
	
	//sleep(10000);
	 if(isElementPresent(by)){
		 driver.findElement(by).clear();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 			}
}

public static void clear(String xpath) 

{
	
	//sleep(10000);
	 if(isElementPresent(By.xpath(xpath))){
		 driver.findElement(By.xpath(xpath)).clear();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 			}
}

// To send text to a web element
public static void sendKeys(By by , String data) 

{
	
	//sleep(10000);
	 if(isElementPresent(by)){
		 driver.findElement(by).sendKeys(data);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 			}
}



// o define the page load timeout
public static void pageLoadTimeout(int time)

{
	if(EnvUtil.getProperty("Browser").equalsIgnoreCase("chrome")){
		driver.manage().timeouts().pageLoadTimeout(time,TimeUnit.SECONDS);
	}else if(EnvUtil.getProperty("Browser").equalsIgnoreCase("safari")){
		sleep(10000);
	}else{
		sleep(2000);
	}
}

// To click on the link
public static void clicksync(String  xpath) 

{
	
	try
	
	{
	//sleep(10000);
	 if(isElementPresent(By.xpath(xpath)))
	 
	 {
	pageLoadTimeout(120);
	driver.findElement(By.xpath(xpath)).click();
	pageLoadTimeout(120);
	sleep(3000);

    }
	}catch(Exception e){}
	}


public static void click(String  xpath) 

{
	
	pageLoadTimeout(120);
	driver.findElement(By.xpath(xpath)).click();
	pageLoadTimeout(120);
	}


public static void click(By by) 

{
	
	//pageLoadTimeout(120);
	driver.findElement(by).click();
	//pageLoadTimeout(120);
	}


public static boolean isSelected(By by) 

{
	
	if(driver.findElement(by).isSelected())
	
	{
		return true;
	}else {
		return false;
	}
	}


// To refresh a webpage

public static void refresh(String  url ) 

{
	sleep(timetowait);
	driver.get(url);
	//pageLoadTimeout(120);
	waitForpageToLoad();
	sleep(timetowait);
}

public static void pageRefresh() 

{
	sleep(timetowait);
	driver.navigate().refresh();
	//pageLoadTimeout(120);
	waitForpageToLoad();
	sleep(timetowait);
}

public static int getSize(By by ) 

{
	return  driver.findElements(by).size();
	
	}

// To move a mouse to an element

public static void mouseOverAction(By by ) 

{
	Actions action = new Actions(driver);
	WebElement we = driver.findElement(by);
	action.moveToElement(we);
	action.click().build().perform();
	}

public static int getSize(String  xpath ) 

{
	return  driver.findElements(By.xpath(xpath)).size();
	
	}

// To select dropdown value to visible text

public static void selectdropdownvaluebyvisibletext(String  xpath , String value ) 

{
	 if(isElementPresent(By.xpath(xpath)))
	 
	 {
		 Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		 dropdown.selectByVisibleText(value);
	 }
	}

//To select dropdown value to visible text

public static void selectdropdownvaluebyvisibletext(By by , String value ) 

{
	 if(isElementPresent(by))
	 
	 {
		 Select dropdown = new Select(driver.findElement(by));
		 dropdown.selectByVisibleText(value);
		// System.out.println("Dropdown selected");
	 }
	}

//To select dropdown value by index

public static void selectdropdownvaluebyIndex(By by , int index ) 

{
	 if(isElementPresent(by))
	 
	 {
		 Select dropdown = new Select(driver.findElement(by));
		 dropdown.selectByIndex(index);
	 }
	}

/*
public static String[] getRulesItems(String xpath)

{
	int listSize=driver.findElements(By.xpath(xpath)).size();
	String[] listName = null; 
	listName = new String[listSize];
	
	//*[@id='rules']/div[contains(@id,'wrapper_')]
	
	for(int i = 1;i<listSize;i++){
		if(!CommonUtil.isAttribtuePresent(By.xpath(xpath+"["+i+"]"), "hidden"))
		{
			 String ruleName = driver.findElement(By.xpath(xpath+"["+i+"]/div[1]/div[1]")).getText();
			 ruleName = ruleName.replace("\n", " ");
			 ruleName.replace("Remove Rule","");
			 ruleName = ruleName.substring(0, ruleName.length()-11);
			 ruleName.trim();					 
			 listName[i] = ruleName;
			 i++;
		}
		
		
	} 
	
	listName = CommonUtil.clean(listName);
	return listName;
}




// To get the second max value
public static String secondMaxvalue(String score1,String score2,String score3,String score4 ) 

{
	int array[] = new int[noofscores];   //noofscores
	int i, j,k = 0 ,temp;
	
	if(noofscores == 2){
		 array[k] = Integer.parseInt(score1);
		 array[k+1] = Integer.parseInt(score2);
	}else if(noofscores == 3){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
	}else if(noofscores == 4){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
		  array[k+3] = Integer.parseInt(score4);
		  
	}
	 for ( i = 0; i < ( noofscores - 1 ); i++) 
	 
	 {
	      for ( j = 0; j < noofscores - i - 1; j++) 
	      
	      {
	        if (array[j] < array[j+1]) 
	        {
	          temp = array[j];
	          array[j] = array[j+1];
	          array[j+1] = temp;
	        }
	      }
	    }
		return String.valueOf(array[1]);
		
	  }

//To get the third max value

public static String thirdMaxvalue(String score1,String score2,String score3,String score4 ) 

{
	int array[] = new int[noofscores];   //noofscores
	int i, j,k = 0 ,temp;
	
	if(noofscores == 2){
		 array[k] = Integer.parseInt(score1);
		 array[k+1] = Integer.parseInt(score2);
	}else if(noofscores == 3){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
	}else if(noofscores == 4){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
		  array[k+3] = Integer.parseInt(score4);
		  
	}
	 for ( i = 0; i < ( noofscores - 1 ); i++) {
	      for ( j = 0; j < noofscores - i - 1; j++) 
	      
	      {
	        if (array[j] < array[j+1]) 
	        {
	          temp = array[j];
	          array[j] = array[j+1];
	          array[j+1] = temp;
	        }
	      }
	    }
		return String.valueOf(array[2]);
		
	  }

//To get the fourth max value
public static String fourthtMaxvalue(String score1,String score2,String score3,String score4 ) 

{
	
	int array[] = new int[noofscores];   //noofscores
	int i, j,k = 0 ,temp;
	
	if(noofscores == 2){
		 array[k] = Integer.parseInt(score1);
		 array[k+1] = Integer.parseInt(score2);
	}else if(noofscores == 3){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
	}else if(noofscores == 4){
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
		  array[k+3] = Integer.parseInt(score4);
		  
	}
	 for ( i = 0; i < ( noofscores - 1 ); i++) {
	      for ( j = 0; j < noofscores - i - 1; j++) {
	        if (array[j] < array[j+1]) 
	        {
	          temp = array[j];
	          array[j] = array[j+1];
	          array[j+1] = temp;
	        }
	      }
	    }
		return String.valueOf(array[3]);
		
	  }

//To get the first max value
public static String firstMaxvalue(String score1,String score2,String score3,String score4 ) 

{
	int array[] = new int[noofscores];   //noofscores
	int i, j,k = 0 ,temp;
	
	if(noofscores == 2)
	
	{
		 array[k] = Integer.parseInt(score1);
		 array[k+1] = Integer.parseInt(score2);
	}
	
	else if(noofscores == 3)
	
	{
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
	}
	
	else if(noofscores == 4)
	
	{
		  array[k] = Integer.parseInt(score1);
		  array[k+1] = Integer.parseInt(score2);
		  array[k+2] = Integer.parseInt(score3);
		  array[k+3] = Integer.parseInt(score4);
		  
	}
	 for ( i = 0; i < ( noofscores - 1 ); i++) 
	 
	 {
	      for ( j = 0; j < noofscores - i - 1; j++) 
	      
	      {
	        if (array[j] < array[j+1]) 
	        {
	          temp = array[j];
	          array[j] = array[j+1];
	          array[j+1] = temp;
	        }
	      }
	    }
		return String.valueOf(array[0]);
		
	  }

public static boolean containvalue(String score1,String score2,String score3,String score4,String value) 

{
	 	
		arraylist.clear();
	  
		arraylist.add(score1.trim());
		arraylist.add(score2.trim());
		arraylist.add(score3.trim());
		arraylist.add(score4.trim());
	   
	   // Sorting in decreasing order
	   Collections.sort(arraylist, Collections.reverseOrder());
	   
	   if(arraylist.contains(value))
	   
	   {
		   return true;
	   }
	   return false;
	   
	}

*/


// To scroll the mouse to a webelement
public static void scrolltoview(By by) 

{
	 try 
	 
	 {
     	JavascriptExecutor jse = (JavascriptExecutor)CommonUtil.getDriver();
     	jse.executeScript("arguments[0].scrollIntoView(true);",CommonUtil.getDriver().findElement(by));
     	CommonUtil.sleep(5000);
     } catch (Exception e) {	  
     	e.printStackTrace();
     }
	 
}


// To wait for page to load
public static void waitForpageToLoad()

{
	int count = 0;
	//WebDriverWait wd = new WebDriverWait(driver, 30);
	//((JavascriptExecutor)driver).executeScript("return jQuery.ready"); 
    while(!((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")){
    	CommonUtil.sleep(3000);
    	count++;
    	
    	if(count > 2500)
    		break;
    }
}

public static void selectIframe() 

{
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
	
}


/*
public static void enterCredentials(String usernameval, String passwordval) throws InterruptedException, AWTException 

{
	
	String URL = "http://" + usernameval + ":" + passwordval + "@" + EnvUtil.getProperty("QAE_ML_URL");
	driver.get(URL);
	String msg = "Opened ML URL";	
	//log.info(msg);
	CommonUtil.report(msg,pass);
	//CommonUtil.sleep(30000);
	//driver.wait(30000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("query-list")));
}


public static void clickEnter(By by) 

{
	
	WebElement hoverElement = driver.findElement(by);
	Actions builder = new Actions(driver);
	builder.moveToElement(hoverElement).perform();
	CommonUtil.sleep(3000);
	CommonUtil.click(by);
	//builder.click(hoverElement).perform();
	//builder.click(hoverElement).build().perform();
	sleep(2000);
}

*/


public static void selectIframe_holidaypopup() 

{
	
	//driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[3]/div[2]/iframe")));
	driver.switchTo().frame(0);
	
}

public static void SelectDefaultWindow()
{
	driver.switchTo().defaultContent();
}

public static boolean verifyTextPresent(By by, String text) 

{
	
	String bodyText = driver.findElement(by).getText();
	if(bodyText.contains(text))
		return true;
	else
		return false;
 }

public static boolean verifyCurrentURL(String text) 

{
	
	String bodyText = driver.getTitle();
	String[] textTempArray1=bodyText.split(" :");
    String CurrentURL=textTempArray1[0];
   System.out.println(CurrentURL);
	if(CurrentURL.contains(text))
		return true;
	else
		return false;
 }

public static boolean verifyURL(String text) 

{
	
	String bodyText = driver.getCurrentUrl();
	String[] textTempArray1=bodyText.split("/");
    String CurrentURL=textTempArray1[3];
   System.out.println(CurrentURL);
	if(CurrentURL.contains(text))
		return true;
	else
		return false;
 }

/*
public static boolean verifycount(By by) 

{
	
	String bodyText = driver.findElement(by).getText();
	bodyText = bodyText.replace(",", "");
	//System.out.println(bodyText);
	int count = Integer.parseInt(bodyText);
	if(count>=0)
		return true;
	else
		return false;
 }


public static void enterAdminToolsCredentials(String usernameval, String passwordval) 

{
	
*/	/*ProfilesIni profile = new ProfilesIni();
    FirefoxProfile ffprofile = profile.getProfile("default");
	//FirefoxProfile profile = new FirefoxProfile();  
	//profile.setPreference("setAcceptUntrustedCertificates","true");
    ffprofile.setAcceptUntrustedCertificates(true);
	driver = new FirefoxDriver(ffprofile);
	String msg = "Firefox Driver setAcceptUntrustedCertificates(true)";	
	log.info(msg);
	CommonUtil.report(msg,pass);
	System.out.println(msg);*/
	
/*
String msg;
	try {
		String URL = "http://"+usernameval+":"+passwordval+"@"+ EnvUtil.getProperty("demoapp_Admin_Tools_Url")+"/";
		msg = URL;	
		CommonUtil.report(msg,pass);
		driver.get(URL);
		
	} 
	
	catch (Exception e) 
	
	{
		
		
	}
	sleep(5000);
	
	msg = "Opened Admin-Tools URL";	
	//log.info(msg+"/");
	CommonUtil.report(msg,pass);
	sleep(5000);
}
*/


// To wait for page to load
public static void waitforLoaderpageLoading() 

{
	
	int count = 0;
	//WebDriverWait wd = new WebDriverWait(driver, 30);
	//((JavascriptExecutor)driver).executeScript("return jQuery.ready"); 
	
	while(!driver.getTitle().equals("https://outsys.9238.ah.nl/WINK_FE/Login")){
	//while(!driver.getTitle().equals("https://outsys.9212.ah.nl/WINK_FE/Login")){
    //while(!driver.getTitle().equals("http://content.qae.onlinelibrary.demoproject.com:9090/content-loader-web/load")){
    	CommonUtil.sleep(15000);
    	count++;
    	
    	if(count > 25)
    		break;
    }
}

/*
public static void logoutMyProfile(By by) 

{
	
	clicksync(by);
}

*/

// To accept the alert
public static void alertAccept() 

{
	Alert alert = driver.switchTo().alert();
	alert.accept();	
}


// To double click on the link

public static void doubleClick(String text) 

{
	
	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(text))).doubleClick().perform();
	sleep(3000);
 }


// To wait for a webelement

public static void SyncTime(By Locator_ID,int time)
{
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Locator_ID));
	
}

public static void ExplicitWait(By locator,int time) 

{
	
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
 }




public static void ExplicitWaitElementClicakable(By locator,int time) 

{
	
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(locator));
 }



public static void SyncLoading(By Locator_ID,int time)
{
	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator_ID));
	
}


// To wait for some duration

public static void waitUntil(int time)
{
	CommonUtil.sleep(time);
	
}

/*

//To zoom into a webpage

public static void zoomin(int num) throws AWTException 

{
	
		
		Robot robot = new Robot();
		for (int i = 0; i <num; i++) 
		
		{ 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		}


}


public static void zoominDate() throws AWTException 

{

		Robot robot = new Robot();
		for (int i = 0; i < 5; i++) 
		
		{ 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		}


}

//To zoom out of a webpage

public static void zoomout(int num) throws AWTException 

{
	Robot robot = new Robot();
	for (int i = 0; i < num; i++) 
	{
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
	}
	
}



public static void zoomoutDate() throws AWTException 

{
	Robot robot = new Robot();
	for (int i = 0; i < 5; i++) 
	{
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
	}
	
}


//To update the Wink stock details
	public static void updatewinkstock() throws AWTException 

	{
		Robot robot = new Robot();
		
		     CommonUtil.sleep(2000);
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(2000);
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(2000);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     //CommonUtil.sleep(4000);

}


	
	
	public static void updatePastDate() throws AWTException 

	{
		
		
		Robot robot = new Robot();
		
		     CommonUtil.sleep(2000);
		     
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(2000);
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(3000);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     CommonUtil.sleep(200);

}

	
	public static void updateFutureDate() throws AWTException 

	{
		
		
		Robot robot = new Robot();
		
		     CommonUtil.sleep(2000);
		     
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(2000);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     CommonUtil.sleep(200);

}	
	
	
	public static void tabEnter(int count) throws AWTException 

	{
		
		
		Robot robot = new Robot();
		
		     CommonUtil.sleep(2000);
		     
		     for(int i=0; i<count; i++)
		     {
		     robot.keyPress(KeyEvent.VK_TAB);
		     robot.keyRelease(KeyEvent.VK_TAB);
		     CommonUtil.sleep(2000);
		     }
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     CommonUtil.sleep(200);

}*/
	

}