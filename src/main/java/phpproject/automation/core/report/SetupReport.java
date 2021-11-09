package phpproject.automation.core.report;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import phpproject.automation.core.util.EnvUtil;
import phpproject.automation.core.util.SuiteUtil;

public class SetupReport 

{
	//static Logger log = Logger.getLogger(SetupReport.class);	
	
	
	/**
	 * 
	 * 
	 * @param args
	 * 
	 * if Maven then 
	 * Omit --  @Parameters({ "env","browser","suite"})
	 * and 
	 * Change TesTNG to Maven 
	 * and 
	 * public void setupReport() {
	 */
	
	
	 @Parameters({ "env","browser","suite"})
	 @BeforeSuite
	 public void setupReport(String env, String browser , String suite) 
	 
	 {
     //public void setupReport() {
		  try
		  
		  {
			  EnvUtil.loadProperties(env);						// For TestNG
			  //EnvUtil.loadProperties(System.getProperty("env"));   // For Maven 
			   EnvUtil.SetProperty("Browser", browser.toLowerCase()); 	// For TestNG
			   //EnvUtil.SetProperty("Browser", System.getProperty("browser").toLowerCase());  // For Maven 
			  EnvUtil.SetProperty("Env", env.toLowerCase()); 	// For TestNG
			   //EnvUtil.SetProperty("Env", System.getProperty("env").toLowerCase());  // For Maven 
			  EnvUtil.SetProperty("Suite", suite.toLowerCase()); 	// For TestNG
			   //EnvUtil.SetProperty("Suite", System.getProperty("suite").toLowerCase());  // For Maven 
			  
			  DeleteDirectory.deleteoutput();
			  
			  HighLevelReportUtil.createDirectorys();
			  HighLevelReportUtil.highlevelcopyFiles();
			  SuiteUtil.readSuite( EnvUtil.getProperty("Suite"));
			  
				 
			  	}
		  
		  catch(Exception e)
		  
		  {e.printStackTrace();}
			  }
		
		}
