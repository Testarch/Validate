package phpproject.automation.core.report;

public class Report 

{

	 //static Logger log = Logger.getLogger(Report.class);
	 
	 
	//static String path = "C:\\Users\\341023\\workspace\\QiReEngg\\output\\";
	static String path = System.getProperty("user.dir")+"\\output\\";
	
	// To get and set the path of output 
	
	public static String getPath() 
	{
		return path;
	}

	public static void setPath(String path) 
	{
		Report.path = path;
	}

	

}
