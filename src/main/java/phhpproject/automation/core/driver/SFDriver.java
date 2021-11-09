package phhpproject.automation.core.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import phpproject.automation.demoapp.util.demoprojectDemoappConstants;




class SFDriver implements IDriver 

{

	//Logger
	//Logger log = Logger.getLogger(SFDriver.class);
	
 
	private static SafariOptions so = null;
	private static WebDriver driver = null;
	
	
	// To start the service
	
	
	public void startService()
	{
		so = new SafariOptions();
		if(demoprojectDemoappConstants.SAFARI_USE_GIVEN_PORT)
		{
			so.setPort(demoprojectDemoappConstants.SAFARI_PORT);
		}
		so.setUseCleanSession(true);
	}

	
	// To stop the service
	
	public void stopService() 
	
	{
		// TODO Auto-generated method stub
	}

	// To start the driver
	public void startDriver() 
	{
		driver = new SafariDriver(so);
		driver.manage().window().maximize();
	}

	// To stop the driver
	
	public void stopDriver() 
	{
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

	
	public WebDriver get()
	{
		if(null==driver)
			this.startDriver();
		return driver;
	}
	
	// To check whether service is running or not	
	public boolean isServiceRunning()
	{
		if(null!=so)
			return true;
		else
			return false;
	}
	
}