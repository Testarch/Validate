package phpproject.automation.demoapp.util;

import phhpproject.automation.core.driver.Browsers;
import phpproject.automation.core.util.CommonUtil;
import phpproject.automation.core.util.EnvUtil;
import phpproject.automation.core.util.OS;

public class demoprojectDemoappConstants 


{
	public static final String Application_url = EnvUtil.getProperty("DEMO_APPLICATION_URL");
	
	public static final String UserName = EnvUtil.getProperty("DEFAULT_USERNAME");
	
	public static final String Password = EnvUtil.getProperty("DEFAULT_PASSWORD");
	
	public static final long PAGE_LOAD_TIME_OUT = Long.parseLong(EnvUtil.getProperty("DRIVER_PAGE_LOAD_WAIT"));
	
	public static final long DRIVER_IMPLICIT_WAIT = Long.parseLong(EnvUtil.getProperty("DRIVER_IMPLICIT_WAIT"));

	public static final String CHROME_DRIVER_SERVER = OS.get()==OS.WINDOWS ? EnvUtil.getProperty("WINDOWS_CHROME_DRIVER_SERVER") : EnvUtil.getProperty("LINUX_CHROME_DRIVER_SERVER");
	
	public static final String IE_DRIVER_SERVER = EnvUtil.getProperty("IE_DRIVER_SERVER");
	
	public static final String CHROME_DRIVER = "webdriver.chrome.driver";

	public static final String IE_DRIVER = "webdriver.ie.driver";
	
	public static final boolean CHROME_USE_GIVEN_PORT=Boolean.parseBoolean(EnvUtil.getProperty("CHROME_USE_PORT"));
	
	public static final int CHROME_PORT = Integer.parseInt(EnvUtil.getProperty("CHROME_PORT"));
	
	public static final boolean SAFARI_USE_GIVEN_PORT=Boolean.parseBoolean(EnvUtil.getProperty("SAFARI_USE_PORT"));
	
	public static final int SAFARI_PORT = Integer.parseInt(EnvUtil.getProperty("SAFARI_PORT"));
	
	public static final boolean IE_USE_GIVEN_PORT=Boolean.parseBoolean(EnvUtil.getProperty("IE_USE_PORT"));
	
	public static final int IE_PORT = Integer.parseInt(EnvUtil.getProperty("IE_PORT"));
	
	public static final Browsers BROWSER = Browsers.get(EnvUtil.getProperty("Browser"));
	
	public static final String ENVIRONMENT = EnvUtil.getProperty("Env").toUpperCase();
	
	public static String EXECUTION_START_TIME = CommonUtil.getDateTime();;
	
	
	//Devices
	public static final String TOSHIBA_SERIALID = "015d24a8394c1815";
	
	public static final String GALAXY_NEXUS_SERIALID = "0149BD8207010019";
	
}