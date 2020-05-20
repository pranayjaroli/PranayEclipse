package com.Interview.Util;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestUtil 
{
    public static WebDriverWait wait;  
    public static JavascriptExecutor exe;
    public static WebDriver driver;
    public static boolean flag = false;
    public static Actions action; 
	public JavascriptExecutor ex;
    
    
    
    public static void setup()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranay.jaroli\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	action = new Actions(driver);
    	
    	driver.manage().window().maximize();
    	wait = new WebDriverWait(driver , 10);  
    }
    
	public static void waiting(By by , WebDriver driver)
      {   
		  wait = new WebDriverWait(driver , 15);
    	  wait.until(ExpectedConditions.elementToBeClickable(by));
      }
	
	 public static void javaexecutor(WebDriver driver , WebElement element)
	 {
		 exe = (JavascriptExecutor)driver;
		 
		
         
	     exe.executeScript("arguments[0].click();", element );
	 }
	 
	 public static void waiting1(By by , WebDriver driver)
     {   
		 wait = new WebDriverWait(driver , 10);
   	     wait.until(ExpectedConditions.visibilityOfElementLocated(by));
     }
	 
	 public static void scroll(WebElement element)
	 {
		 exe.executeScript("arguments[0].scrollIntoView(true);", element);
     }
	 
	 public static void dateclicker(WebDriver driver)
	 {
		 String beforexpath = "//div[@class='ui-datepicker-group ui-datepicker-group-last']//tbody/tr[";
		 String afterxpath  = "]/td[";
		 
		 line1 :
		 for(int i=2; i<7;i++)
		 {   
			 
			 for(int j=1;j<7;j++)
			 {
				  
				 if(!flag)
				 
				 {
								 String date = "10";
								 String end = driver.findElement(By.xpath(beforexpath+i+afterxpath+j+"]")).getText();
								 System.out.println(end);
								 WebElement ele = driver.findElement(By.xpath(beforexpath+i+afterxpath+j+"]"));
								 if(date.equals(end))
								 {
									 flag = true;
									 javaexecutor(driver, ele);
								 }
				 }
			     
				 else
				 {
					 break line1;
				 }
				 
			 }
			 
		 }
	 }
	 
	 
	 // switching to new tab
	 
	 public static void switchTONewTab(WebDriver driver , int tabNumber)
	 {
		 ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs_windows.get(tabNumber));
	 }
	 
	 public static void javascriptsetattribute(WebElement ele , String Text, WebDriver driver)
	 {
		 exe = (JavascriptExecutor)driver;
		 exe.executeScript("arguments[0].setAttribute('value', '"+Text+"')", ele);
	 }
	 
}

