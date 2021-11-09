package phhpproject.automation.core.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import phpproject.automation.demoapp.util.demoprojectDemoappConstants;



class IEDriver implements IDriver 

{

	//Logger
	//Logger log = Logger.getLogger(IEDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static InternetExplorerDriverService ieService = null;
	private static WebDriver driver = null;
	
	
	// To set the page load timeout
	IEDriver()
	{
		PageLoadTimeOut = demoprojectDemoappConstants.PAGE_LOAD_TIME_OUT;
	}
	
	// To start the service
	public void startService() 
	{			
			System.setProperty(demoprojectDemoappConstants.IE_DRIVER, demoprojectDemoappConstants.IE_DRIVER_SERVER);
			
			if(!demoprojectDemoappConstants.IE_USE_GIVEN_PORT)
				ieService = new InternetExplorerDriverService.Builder()
						 .usingDriverExecutable(new File(demoprojectDemoappConstants.IE_DRIVER_SERVER))
						 .usingAnyFreePort()
						 .build();
			else
				ieService = new InternetExplorerDriverService.Builder()
			 			.usingDriverExecutable(new File(demoprojectDemoappConstants.IE_DRIVER_SERVER))
			 			.usingPort(demoprojectDemoappConstants.IE_PORT)
			 			.build();
			
			try 
			{
				ieService.start();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

// To stop the service	
	public void stopService() 
	{
		try
		{
			if(null!=ieService)
				ieService.stop();
		}
		catch(Exception e)
		{
			//log.fatal("Error Occurred while stopping IE server\n" + e.getMessage());
		}
		finally
		{
			ieService = null;
		}
	}

	// To start the driver
	public void startDriver() 
	{
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver(ieService, ieCapabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
	}

	// To stop the driver
	public void stopDriver() 
	{
		try
		{
			driver.close();
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
	public boolean isServiceRunning() {
		if(null!=ieService)
			return true;
		else
			return false;
	}

}