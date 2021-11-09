package phhpproject.automation.core.driver;

import org.openqa.selenium.WebDriver;


public class WebBrowser

{

		//Logger
		//Logger log = Logger.getLogger(WebBrowser.class);	
	
		WebBrowser() {};
		
		private static WebDriver driver = null;

	// To set the browser type	
		public void setBrowserType(String BrowserType)
		{
			//log.info("Browser Type=" + BrowserType);
			driver = DriverManager.startDriver(BrowserType);
			WebConfig.driver = driver;
		}
		
		// To navigate to a URL	
		
		public void NavigateTo(String BrowserType, String URL)
		{
			setBrowserType(BrowserType);
			
			//log.info("Passed URL=" + URL);
			driver.get(URL);
		}
		


		public void NavigateTo(String URL)
		{
			//log.info("Passed URL=" + URL);
			driver.get(URL);
		}
		
		public WebDriver getDriver()
		{
			return driver;
		}
	
		
		// To stop the driver
		public void Quit()
		{
			
			//log.info("Closing the Browser");
			DriverManager.stopDriver();
			//log.info("Browser & pages nullified");

		}
		
}