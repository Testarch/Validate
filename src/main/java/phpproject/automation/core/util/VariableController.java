package phpproject.automation.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import phpproject.automation.core.report.ReportUtil;

public class VariableController

{
	
	static
	
	{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
	    System.setProperty("current.date", dateFormat.format(new Date()));
	}
		//static Logger log = Logger.getLogger(VariableController.class);	
	
	//Variables
		
		public static String TestCaseName;
		public static String TestCaseDescription;
		public static String TestCaseScenario;
		public static String TestDescription;
		public static int timetowait = 2000;
		public String MAX_WAIT_TIME_PAGE_LOAD_IN_MS = "180000";
		public int MAX_WAIT_TIME_PAGE_LOAD_IN_SEC = 120;
		public int MAX_WAIT_TIME_IN_SEC = 10;
		public static Date StartTime;

		
		// Location of the excel file which stores test data
		
		public static String datasheet = System.getProperty("user.dir")+"\\tests\\DataSheet.xls";
		
	// Name of the sheet in the excel which contains Boxplosive test cases
		public static String PHPwebsiteValidation = "PHPwebsiteValidation";
		public static String PartialPromotion = "PartialPromotion";
		public static String MainPromotion = "MainPromotion";
		public static String RepeatPromotion = "RepeatPromotion";
		
		
	//-------------------Do not Delete the code below--------------------------------------------------------------------	
		
		
		public static String pass = "Pass";
		public static String fail = "Fail";
		public static String matched = "Condition Satisfiled";
		public static String notmatched = "Condition Not Satisfiled";
		public static String SMUP = "SentenceMarkup";
		public static boolean smuLoadSVG = false;
		public static boolean smuLabelasButton = false;
		public static boolean itemSuppressChkbox = false;
		public static boolean smuLabelasButtonCreate = false;
		public static boolean smuLabelasButtonUpdate = false;
		public static boolean overlay1 = false;
		
		

		public static int noofscores,noofsecs;
		public static boolean scicond = false;
		public static String promptHTML;
		public static String sciscore1,scilable1,sciscore2,scilable2,sciscore3,scilable3,sciscore4,scilable4;
		public static String obLabel,osHeader,ossection1,ossection2; 
	
				
		public static int itemCount = 0;
		
		public static String getTestCaseName() 
		{
			return TestCaseName;
		}
		
		public static String getTestScenario() 
		{
			return TestCaseScenario;
		}
		

		public static String getTestDescription() 
		{
			return TestDescription;
		}
		
		public static void setTestCaseName(String testCaseName, String TCDescription, String testCaseScenario) 
		{

			TestCaseName = testCaseName;
			TestDescription = TCDescription;
			TestCaseScenario = testCaseScenario;
			StartTime =  new java.util.Date();
			ReportUtil.createDirectory();
			ReportUtil.copyFiles();
			highlevelReport(StartTime);
		}

		public static void setTestCaseName(String testCaseName,String testCaseScenario) 
		
		{
			TestCaseName = testCaseName;
			TestCaseScenario = testCaseScenario;
			StartTime =  new java.util.Date();
			ReportUtil.createDirectory();
			ReportUtil.copyFiles();
			highlevelReport(StartTime);
		}
		
		
		public static void highlevelReport(Date startTime) 
		{
			try
			{
				ReportUtil.tcases.add(getTestCaseName());
				ReportUtil.tcdescription.add(getTestDescription());
				ReportUtil.tcasesscenario.add(getTestScenario());
				ReportUtil.tcasesstarttime.add(startTime);
			}
			
			catch(Exception e)
			
			{
				
				e.printStackTrace();
			
			}
		}
		
	
}
