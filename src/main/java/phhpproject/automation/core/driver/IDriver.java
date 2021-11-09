package phhpproject.automation.core.driver;


import org.openqa.selenium.WebDriver;

public interface IDriver 
{
	void startService();
	void stopService();
	void startDriver();
	void stopDriver();
	WebDriver get();
	boolean isServiceRunning();
}