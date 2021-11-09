package phhpproject.automation.core.driver;

import java.util.concurrent.TimeUnit;
import java.lang.Override;

import org.openqa.selenium.WebDriver;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;
import phpproject.automation.demoapp.util.demoprojectDemoappConstants;




@SuppressWarnings("unused")
class AndroidMobileDriver implements IDriver 

{
	
	//Logger
	//Logger log = Logger.getLogger(AndroidMobileDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static SelendroidLauncher selendroidServer = null;
	private static SelendroidConfiguration config = null;
	private static SelendroidCapabilities sc = null;
	private static WebDriver driver = null;
	private static String SerialID= null;
	
	// To declare the page load timeout for AndriodMobileDriver
	
	AndroidMobileDriver()
	{
		PageLoadTimeOut = demoprojectDemoappConstants.PAGE_LOAD_TIME_OUT;
	}
	
	AndroidMobileDriver(String id)
	{
		SerialID = id;
		PageLoadTimeOut = demoprojectDemoappConstants.PAGE_LOAD_TIME_OUT;
	}	
	
	
	// To start the selendroid service
	public void startService() 
	{
		try
		{
		 	config = new SelendroidConfiguration();
		    selendroidServer = new SelendroidLauncher(config);
		    selendroidServer.launchSelendroid();
		    sc = new SelendroidCapabilities();
			sc.setSerial(SerialID);
		}
		catch(Exception e)
		{
			//log.fatal("Exception occured while launching Andriod server\n" + e.getMessage());
		}

	}

	// To stop the service
	
	public void stopService() {
		try
		{
			if(null!=selendroidServer)
				selendroidServer.stopSelendroid();
		}
		catch(Exception e)
		{
			//log.fatal("Exception occurred while stopping the Andriod Server\n" + e.getMessage());
		}
	}

	// To start the driver
	
	@SuppressWarnings("static-access")
	public void startDriver()
	{
	    try 
	    {
	    	System.out.println("SERIAL="+sc.getSerial());
			driver = new SelendroidDriver(sc.android());
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
		} 
	    catch (Exception e)
	    {
			e.printStackTrace();
		}
	}

//To stop the driver
	
	public void stopDriver() {
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			//log.fatal("Exception while stopping the driver\n" + e.getMessage());
		}
		finally
		{
			driver = null;
		}

	}


//To get the webdriver	
	public WebDriver get() 
	
	{
		if(null==driver)
			this.startDriver();
		
		return driver;
	}
	
// T check whether service is running or not
	public boolean isServiceRunning() 
	
	{
		if(null!=selendroidServer)
			return true;
		else
			return false;
	}
}