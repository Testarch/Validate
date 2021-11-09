package phpproject.automation.core.util;

import org.openqa.selenium.By;


@SuppressWarnings("unused")
public class ObjectRepository extends VariableController

{

	//-------------------------------------Boxplosive--------------------------------------------------------------------------------------//
	public static String Googlesearch_xpath="//*[@class=/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input";
	
	public static String usernameLocator_xpath="//*[@id='usernameInput']";
	public static String passwordLocator_xpath="//*[@id='passwordInput']";
	public static String loginbutton_id="loginButton";
	public static String verifyHomePageTitle_xpath="//a[contains(text(),'Home')]";
	
	public static String searchButton_id="mxui_widget_ControlBarButton_2";
	public static String orinNrTextbox_xpath="//*[@id='mxui_widget_SearchInput_1']/div[2]/input";
	public static String zoekenButton_id="mxui_widget_Button_0";
	public static String displayData_xpath="//*[@class='mx-name-index-0']";
	
	
    
	//page options   
		public static String pageOptionsXpathByName(String option)
		{
			
			String pageOptions_xpath="//a[contains(text(),'"+option+"')]";
		
		return pageOptions_xpath;
		}

		public static String weekOptionsXpathByName(String option)
		{
			
			String pageOptions_xpath="//div[contains(text(),'"+option+"')]";
		
		return pageOptions_xpath;
		}
}
	










