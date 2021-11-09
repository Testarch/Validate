package phpproject.automation.core.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@SuppressWarnings("unused")
public class ObjectLocator extends ObjectRepository 
{
	
	
	//---------------------------------Boxplosive--------------------------------------------------------------------------------------//
	
	
	public static By Googlesearch=By.xpath(Googlesearch_xpath);
	
    public static By usernameLocator=By.xpath(usernameLocator_xpath);
    public static By passwordLocator=By.xpath(passwordLocator_xpath);
    public static By loginbutton=By.id(loginbutton_id);
    public static By verifyHomePageTitle=By.xpath(verifyHomePageTitle_xpath);
    
    public static By searchButton=By.id(searchButton_id);
    public static By orinNrTextbox=By.xpath(orinNrTextbox_xpath);
    public static By zoekenButton=By.id(zoekenButton_id);
    public static By displayData=By.xpath(displayData_xpath);
    
  
    
    
    public static By weekSelection(String week)
    {
      return By.xpath("//div[contains(text(),'"+week+"')]");
    }

    public static By generalDropDown(String fieldName)
   {
      return By.xpath("//th[contains(normalize-space(),'"+fieldName+"')]/following-sibling::td//select");
    }
  

    public static By generalTextbox(String fieldName)
    {
      return By.xpath("//th[contains(normalize-space(),'"+fieldName+"')]/following-sibling::td//input");
    }
  

    public static By generalCheckbox(String fieldName)
    {
      return By.xpath("//th[contains(normalize-space(),'"+fieldName+"')]/following-sibling::td//input[@type='checkbox']");
    }

    public static By deptSelect(String fieldName)
    {
      return By.xpath("//div[contains(@class,'modal-content')]//tr[contains(normalize-space(),'"+fieldName+"')]");
    }

   
    public static By generalModalButton(String btnName)
    {
      return By.xpath("//div[contains(@class,'modal-body')]//button[contains(normalize-space(),'"+btnName+"')]");
    }
  
    public static By generalSpan(String label)
    {
      return By.xpath("//th[contains(normalize-space(),'"+label+"')]/following-sibling::td//button//span");
    }
    
    public static By removeFilter(int index)
    {
    	By removeFilterByIndex = By.xpath("(//span[contains(@class,'ui-icon ui-icon-close')])["+index+"]");
      return removeFilterByIndex;
    }
    
    
  //page options
    public static By pageOptionsByContains(String option)
	{
		By pageOptions=By.xpath(pageOptionsXpathByName(option));
		return pageOptions;
	}
    
    public static By weekOptionsByContains(String option)
	{
		By pageOptions=By.xpath(weekOptionsXpathByName(option));
		return pageOptions;
	}
} 

