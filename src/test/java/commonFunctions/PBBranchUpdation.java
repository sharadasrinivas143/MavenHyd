package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBBranchUpdation {
     WebDriver driver;
     public PBBranchUpdation(WebDriver driver)
     {
    	 this.driver =driver;
     }
     @FindBy(xpath = "(//img)[10]")
     WebElement ClickEdit;
     @FindBy(xpath = "//input[@id='txtbnameU']")
     WebElement EnterBranch;
     @FindBy(xpath ="(//input[@id='txtadd1u'])[1]" )
     WebElement EnterAddress;
     @FindBy(xpath ="//input[@id='txtareaU']" )
     WebElement EnterArea;
     @FindBy(xpath = "//input[@id='txtzipu']")
     WebElement EnterZip;
     @FindBy(xpath ="//input[@id='btnupdate']" )
     WebElement clickUpdate;
     public boolean verify_Updatebranch(String branch,String Address,String Area,String Zipcode) throws Throwable
     {
    	 this.ClickEdit.click();
    	 this.EnterBranch.clear();
    	 this.EnterBranch.sendKeys(branch);
    	 this.EnterAddress.clear();
    	 this.EnterAddress.sendKeys(Address);
    	 this.EnterArea.clear();
    	 this.EnterArea.sendKeys(Area);
    	 this.EnterZip.clear();
    	 this.EnterZip.sendKeys(Zipcode);
    	 this.clickUpdate.click();
    	 String ExpectedAlert =driver.switchTo().alert().getText();
    	 Thread.sleep(4000);
    	 driver.switchTo().alert().getText();
    	 String ActualAlert ="Branch Updated";
    	 if (ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase()))
    	 {
    		 Reporter.log(ExpectedAlert,true);
    		 return true;
    		}
    	 else
    	 {
    		 Reporter.log("Unable to update Branch ",true);
    		 return false;
    	 }
    			 
     }

}
     
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
	

