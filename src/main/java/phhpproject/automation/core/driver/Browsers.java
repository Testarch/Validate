package phhpproject.automation.core.driver;


public enum Browsers 
{
	IE,
	FIREFOX,
	CHROME,
	SAFARI,
	NEXUS,
	TOSHIBA,
	IPHONE,
	IPAD,
	OTHER;
	
	//Get the Enum
	public static Browsers get(String s)
	{
		return Browsers.valueOf(s.trim().toUpperCase());
	}
	
}