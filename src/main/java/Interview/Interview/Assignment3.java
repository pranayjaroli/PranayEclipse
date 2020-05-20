package Interview.Interview;

import java.awt.AWTException;
import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Interview.Util.TestUtil;
//import java.awt.Robot;	
//import java.awt.event.KeyEvent;	
public class Assignment3 extends TestUtil
{
	
	public Point p;
	public Robot rb;
	public static WebElement element;
	
    
	@BeforeMethod
    public void setup1() throws AWTException
    {
        TestUtil.setup();
        driver.get("https://www.google.com/");
    }
    
    @Test
    public void login() throws Exception
    {
      	action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"))).keyDown(Keys.LEFT_CONTROL).click().build().perform();
    	Set <String> set = driver.getWindowHandles();
    	System.out.println(set.size());
    	
    	Iterator<String> it = set.iterator();
    	
    	String w1 = it.next();
    	String w2 = it.next();
    	
    	driver.switchTo().window(w2);
    	
    	List <WebElement> list = driver.findElements(By.xpath("//a[contains(text(),'Sign in')]"));
    	int j=0;
    	while(j<list.size())	
    	{
    		System.out.println(list.get(0));
    		p = list.get(j).getLocation();
    		int X = p.getX();
    		int Y = p.getY();
    		System.out.println(X + " " + Y);
    		
    		if((X!= 0))
    		{
    			
    			list.get(j).click();
    			
    			
    		    break;
    		}
    		j++;
    		
    	}
    	
    	
    	TestUtil.switchTONewTab(driver, 2);
    	driver.get(driver.getCurrentUrl());
    	
    	
    	WebElement ele1 = driver.findElement(By.xpath("//input[@type = 'email' and @aria-label='Email or phone']"));
    	TestUtil.waiting1(By.xpath("//input[@type = 'email' and @aria-label='Email or phone']"), driver);
        
    	action.moveToElement(driver.findElement(By.xpath("//input[@type = 'email' and @aria-label='Email or phone']"))).click().build().perform();
    	   	
    	TestUtil.javascriptsetattribute(ele1, "123@gmail.com", driver);
    	
    	element = driver.findElement(By.xpath("//span[text() = 'Next']"));
    	TestUtil.javaexecutor(driver, element);
        
    	TestUtil.switchTONewTab(driver, 0);
    	TestUtil.waiting(By.xpath("//input[@title ='Search' and @type='text']"), driver);
    	WebElement element1 = driver.findElement(By.xpath("//input[@title ='Search' and @type='text']"));
    	System.out.println(element1);
    	String title = driver.getTitle();
    	if(title.equals("Google"))
    				{
    			        
    			
    					TestUtil.javascriptsetattribute(element1, "Selenium WebDriver", driver);
    					
    	
    			        
    			       
    			        
    				}
    	}
    
    @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }
    	
    	
    
    	
    }
    

