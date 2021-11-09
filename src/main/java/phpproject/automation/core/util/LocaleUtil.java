package phpproject.automation.core.util;

import java.util.Properties;

public class LocaleUtil {
	
	//Logger
	//static Logger log = Logger.getLogger(LocaleUtil.class);
	
	private static String locale = null;
	private static Properties props = null;
	
	
	// To load all properties from properties file
	
	public static void loadProperties(String value)
	{
		//log.info("Passed Locale:" + value);
		locale = value;
		String FileName = "messages_" + locale.trim().toLowerCase() + ".properties";
		//log.info("Locale FileName:" + FileName);
		props = PropertyReader.getProperties("/data/locale/messages.properties");
		props.putAll(PropertyReader.getProperties("/data/locale/"+ FileName));
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