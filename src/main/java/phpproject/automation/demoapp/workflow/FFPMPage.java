package phpproject.automation.demoapp.workflow;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import phpproject.automation.core.util.CommonUtil;
import phpproject.automation.core.util.EnvUtil;
import phpproject.automation.core.util.ObjectLocator;
import phpproject.automation.demoapp.impl.PHPImpl;

@SuppressWarnings("unused")
public class FFPMPage extends ObjectLocator 

{

	private final WebDriver driver;
	
	//static Logger log = Logger.getLogger(HomePage.class);

	
	static PHPImpl misc;
	
	// Redirecting functions

	public FFPMPage(WebDriver driver) 

      {
		this.driver = driver;
		misc = new PHPImpl();
		// Check that we're on the right page.
		
	}



	public static boolean FFPMLogin(String username,String password) throws InterruptedException
	{
		return PHPImpl.PHPLogin();
			
	}

	
	
	public static boolean openHomePage()
	{
		return PHPImpl.openHomePage();
		
	}
		

}

