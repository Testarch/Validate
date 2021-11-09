package phpproject.automation.core.util;

public enum OS 
{
	WINDOWS,
	MAC,
	LINUX;
	
	//Get the Enum
	public static OS get()
	{
		String os = System.getProperty("os.name").toLowerCase();
		
		if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0 ){
			
			return OS.LINUX;
		}
		else
		{
			return OS.WINDOWS;
		}
	}
}