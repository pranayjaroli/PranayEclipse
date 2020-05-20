package Interview.Interview;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Interview.Util.TestUtil;

public class Assignment2 extends TestUtil

{

	public WebElement element;
	public String StartDate = "25";
	
	
	@BeforeMethod
   public void initialization() throws InterruptedException
   {
		TestUtil.setup();
		driver.get("https://www.triphobo.com/");
   }
	
	
	
   @Test
   public void task() throws InterruptedException
   {
	  driver.findElement(By.xpath("//a[@id='plan-my-trip']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Where do you want to go?']")));
	  driver.findElement(By.xpath("//input[@placeholder='Where do you want to go?']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter City, Country or Region']")));
	  driver.findElement(By.xpath("//input[@placeholder='Enter City, Country or Region']")).sendKeys("Houston");
      
	  
	  
	  TestUtil.waiting1(By.cssSelector("ul.city-list-collection"),driver);
	  element = driver.findElement(By.cssSelector("ul.city-list-collection"));
	  List<WebElement> list = element.findElements(By.tagName("li"));
      System.out.println(list.size());
      
      for(int i=0;i<list.size();i++)
      {
    	  String text = list.get(i).getText();
    	  System.out.println(text);
    	  if(text.equals("Houston, Texas, United States"))
    	  {
              list.get(i).click();    		  
    	  }
      }
      
      //picking up the dates
      
      WebElement el = driver.findElement(By.xpath("//input[@placeholder='Start Date']"));
      el.click();
      System.out.println(element);
      
      //picking up the start date
      element = driver.findElement(By.xpath("//div[@class ='ui-datepicker-group ui-datepicker-group-first']//table/tbody"));
      List<WebElement> list1 = element.findElements(By.tagName("td"));
      
      System.out.println(list1.size());
     
      for (int i=0;i<list1.size();i++)
      {
    	  if(StartDate.equals(list1.get(i).getText()))
    	  {
    		  System.out.println(list1.get(i));
    		  list1.get(i).click();
    		  break;
    	  }
      }
      
      //picking end date
      TestUtil.dateclicker(driver);
     
     
      
      driver.findElement(By.xpath("//span[@class='button p-color full-width start-planning']")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_city_next_step_title")));
      driver.findElement(By.id("js_city_next_step_title")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='profile select-profile-3 ']//span[text()='Things to do']")));
      driver.findElement(By.xpath("//div[@class ='profile select-profile-3 ']//span[text()='Things to do']")).click();
      
      TestUtil.waiting(By.xpath("//span[text() = 'Next' ]"), driver);
      element = driver.findElement(By.xpath("//div[@class='next-pri-btn']//span[text()='Next']"));
      
      /***********************************************************************************************************************/
      
         
         
         int Counter=0;
      	   {
    		  do
    		  {
    		  try
    		  		{
    			  		element = driver.findElement(By.xpath("//div[@class='next-pri-btn']//span[text()='Next']"));
                        TestUtil.waiting(By.xpath("//span[text() = 'Next' ]"), driver);
    			  		if(true)
    			  	   {
						    		 
    			  			 ex = (JavascriptExecutor)driver;
    			  			 ex.executeScript("arguments[0].click();", element );
						     continue;
    			  	   }
    		        }
    		  catch(Exception r)
   	   	  	  {
    			  	r.printStackTrace();
    			  	break;
   	   	  	  }
    		  
    		  
    		  }
    		  
    		  while(Counter == 0);
      	   } 
         
      	   
           TestUtil.waiting1(By.xpath("//div[@class= 'entry-point solo-ep']"), driver);
           driver.findElement(By.xpath("//div[@class= 'entry-point solo-ep']")).click();
           
           TestUtil.waiting1(By.xpath("//span[text() = 'Next']"), driver);
           driver.findElement(By.xpath("//span[text() = 'Next']")).click();
           
           try
    	   {
    		   TestUtil.waiting(By.xpath("//span[@class='icon-close']"), driver);
        	   driver.findElement(By.xpath("//span[@class='icon-close']")).click();
    	   }
    	   catch(Exception r)
    	   {
    		   
    		   r.printStackTrace();
    	   }
           
           
           
           TestUtil.waiting(By.xpath("//span[text() = 'Editable view']"), driver);
           driver.findElement(By.xpath("//span[text() = 'Editable view']")).click();
           
           TestUtil.waiting1(By.xpath("//div[@title='Childrens Museum Of Houston']/../.."),driver);
           WebElement element = driver.findElement(By.xpath("//div[@title='Childrens Museum Of Houston']/../.."));
           
           String BeforeXpath = "//div[@class='fc-content-skeleton']//tbody//tr//td[";
           String AfterXpath  = "]//div[@class = 'fc-event-container']";
           
           List<WebElement> listnew =  driver.findElements(By.xpath("//div[@class='fc-row fc-widget-header']//th//p"));    
           System.out.println(listnew.size());
           for(int i=0;i<listnew.size();i++)
           {
        	   System.out.println(listnew.get(i).getText());
        	   if(listnew.get(i).getText().contains("4"))
        	   {
        		   int k = i+2;
        		   System.out.println(k);
        		   WebElement element2 =  driver.findElement(By.xpath(BeforeXpath+k+AfterXpath));
        		   action.clickAndHold(element).moveToElement(element2).release(element2).build().perform();
        	   }
           }
           
           
           
           
           
   }
           
 	

   @AfterMethod
   public void tearDown()
   {
	   driver.quit();
   }
}
