package phpproject.automation.core.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class SuiteUtil 
{
	
	//Logger
	//public static Logger log = Logger.getLogger(SuiteUtil.class);
	public static String Suite;
	public static HashSet<String> TCList; 
	
	
	// To read the suite
	
	public  static void readSuite(String suiteFileName)
	
	{
		Suite = suiteFileName;
		TCList = readSuiteFile(Suite.trim());
		
		if(null!=TCList && !TCList.isEmpty())
		{
			System.out.println();
			//System.out.println(Suite + ".suite.txt file has Active Test cases to be executed");
			//log.info(Suite + ".suite.txt file has Active Test cases to be executed");
		}
		else
		{
			System.out.println();
			System.out.println(Suite + ".suite.txt file does not have any Active Test cases to be executed");
			//log.info(Suite + ".suite.txt file does not have any Active Test cases to be executed");
		}
	}
	
	private static HashSet<String> readSuiteFile(String suiteFileName)
	{
		
		BufferedReader br = null;
		HashSet<String> TCList = null;
		
		try
		{
 			String sCurrentLine;
 			TCList = new HashSet<String>();
 			br = new BufferedReader(new FileReader(System.getProperty("user.dir") +   "/suite/" + suiteFileName + ".suite.txt"));
 			while ((sCurrentLine = br.readLine()) != null)
			{
				if(!(sCurrentLine.isEmpty()) && !sCurrentLine.trim().startsWith("'"))
				{
					TCList.add(sCurrentLine);
				}
			}
 
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)
					br.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}		
		return TCList;
	}

}

	
