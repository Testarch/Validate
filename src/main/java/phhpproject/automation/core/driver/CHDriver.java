package phhpproject.automation.core.driver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import phpproject.automation.core.util.OS;
import phpproject.automation.demoapp.util.demoprojectDemoappConstants;


@SuppressWarnings("unused")
class CHDriver implements IDriver 

{

	//Logger
	//Logger log = Logger.getLogger(CHDriver.class);
	
	private static long PageLoadTimeOut =0; 
	private static ChromeDriverService chService = null;
	private static WebDriver driver = null;

	CHDriver()
	{
		PageLoadTimeOut = demoprojectDemoappConstants.PAGE_LOAD_TIME_OUT;
	}
	
	
	// To start the service
	
	public void startService()
	{		
		//Kill existing running service
		//CommonUtil.killProcess(QiReEngGlobalConstants.CHROME_DRIVER_SERVER);
		
		//String ChromeDriverServer = demoprojectdemoappConstants.CHROME_DRIVER_SERVER;
		String ChromeDriverServer = System.getProperty("user.dir")+"/browserserver/chromedriver.exe";
				
		if(OS.get()==OS.MAC)
		{
			try 
			{
				//make it executable
				Runtime.getRuntime().exec("chmod 777 " + ChromeDriverServer);
			}
			catch (IOException e)
			{
				////log.fatal("UNABLE TO START CHROME DRIVER SERVER\n" + e.getMessage());
				//log.fatal("UNABLE TO START CHROME DRIVER SERVER\n" + e.getMessage());
			}
		}	
		
		System.setProperty(demoprojectDemoappConstants.CHROME_DRIVER, ChromeDriverServer);
	
		if(!demoprojectDemoappConstants.CHROME_USE_GIVEN_PORT)
			chService = new ChromeDriverService.Builder()
					 .usingDriverExecutable(new File(ChromeDriverServer))
					 .usingAnyFreePort()
					 .build();
		else
			chService = new ChromeDriverService.Builder()
					 .usingDriverExecutable(new File(ChromeDriverServer))
					 .usingPort(demoprojectDemoappConstants.CHROME_PORT)
					 .build();			
		try 
		{
			chService.start();
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
			if(null!=chService)
				chService.stop();
		}
		catch(Exception e)
		{
			//log.fatal("Error Occurred while stopping Chrome server\n" + e.getMessage());
		}
		chService = null;
	}

	
	// To start the driver

	public void startDriver() 
	{	
		try
		{
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions options = new ChromeOptions();
	    /*
	    Proxy proxy = new Proxy();
	    proxy.setProxyAutoconfigUrl("http://newproxy.ah.nl:8000/kpn.pac");
        //proxy.setHttpProxy("localhost:8888");
        //Add the proxy to our capabilities 
        capabilities.setCapability("proxy", proxy);
	    */
	    
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("profile.default_content_settings.popups", 0);
	    //prefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
	    //prefs.put("profile.default_content_setting_values.notifications", 1);
	    //prefs.put("download.default_directory", "D:\\downloads");
	    //prefs.put("savefile.default_directory", "D:\\downloads");
	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("test-type");
	    options.addArguments("disable-popup-blocking");
	    options.addArguments("disable-infobars");
	    options.addArguments("--start-maximized");
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(chService, capabilities);
	    //driver = new RemoteWebDriver(new URL("http://10.201.165.149:4444/wd/hub"),capabilities);
	    //driver = new RemoteWebDriver(new URL("http://10.135.15.67:4444/wd/hub"),capabilities);
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);	
		//System.out.println("********************************************************");
		//System.out.println();
		}
		
		catch(Exception e)
		
		{
			
		}
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

	
// To start the driver	
	
	public WebDriver get() 
	
	{
		
		if(null==driver)
			this.startDriver();
		
		return driver;
	}
	
	
	// To check service is running or not

	public boolean isServiceRunning() 
	
	{
		if(null!=chService)
			return true;
		else
			return false;
	}

}