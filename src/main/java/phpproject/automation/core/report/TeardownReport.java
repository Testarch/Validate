package phpproject.automation.core.report;

import org.testng.annotations.AfterSuite;

public class TeardownReport 

{

	/**
	 * @param args
	 */
	 @AfterSuite
	 
	 // Executed at the end of the suite
	 
	 public void teardownReport() 
	 
	   {
		 HighLevelReportUtil.highlevelgenerateHTMLReport();
		 Zip.zipfile();
		}

}
