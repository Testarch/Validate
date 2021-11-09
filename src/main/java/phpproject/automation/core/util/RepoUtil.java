package phpproject.automation.core.util;

import java.util.Properties;

public class RepoUtil 

{
	
	//Logger
	//static Logger log = Logger.getLogger(RepoUtil.class);
	
	private static Properties props = null;
	
	// To load the properties from object repository
	public static void loadProperties()
	{
		String FileName = "Repository.properties";
		//log.info("Repository FileName:" + FileName);
		props = PropertyReader.getProperties("/objectrepository/");
		props.putAll(PropertyReader.getProperties("/objectrepository/"+ FileName));
		//log.info("locale properties loaded");
	}
	
	public static String getProperty(String key)
	{
		//log.info("Locale Value Request: Key=" + key);
		String keyvalue = props.getProperty(key);
		//log.info("Locale Value Request: Value=" + keyvalue);
		return keyvalue;
	}
	
	
}