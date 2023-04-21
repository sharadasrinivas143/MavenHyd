package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

    public class AppUtil {
    public static WebDriver driver;
    public static Properties Conpro;

   @BeforeSuite
    public static void setup()throws Throwable
    {
	   Conpro =new Properties();
	   Conpro.load(new FileInputStream("./PropertyFile/Environment.Properties"));
	   if (Conpro.getProperty("Browser").equalsIgnoreCase("chrome")) 
	   {
		   driver =new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get(Conpro.getProperty("Url"));
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	   else
		  if (Conpro.getProperty("Browser").equalsIgnoreCase("firefox")) 
		  {
			  driver =new FirefoxDriver();
			  driver.manage().window().maximize();
			  driver.get(Conpro.getProperty("Url"));
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  }
	   }
	    @AfterSuite
	     public static void tearDown()
	     {
	    	driver.quit();
    }
	}
	   
    


