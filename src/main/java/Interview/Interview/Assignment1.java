package Interview.Interview;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Interview.Util.TestUtil;

public class Assignment1 extends TestUtil
{
    
	@BeforeMethod
    public void setup1()
    {
       TestUtil.setup();	
       driver.get("http://annauniv.edu/");
    }  
    
    @Test
    public void login() throws Exception
    
    {
    	WebElement ele = driver.findElement(By.xpath("//a[text()='Departments']"));
    	
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Departments']")));
       	ex = (JavascriptExecutor)driver;
    	ex.executeScript("arguments[0].click()", ele );
    	
    	WebElement element1 = driver.findElement(By.xpath("//strong[text()=\" Faculty of Civil Engineering \"]"));
    	System.out.println(element1);
    	action.moveToElement(element1).build().perform();
    	
    	action.moveToElement(driver.findElement(By.xpath("//div[@id='menuItemText32']"))).click().build().perform();
    	String title = driver.getTitle();
    	Assert.assertEquals(title, "Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts","title is not same");
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='link3']")));
    	action.moveToElement(driver.findElement(By.xpath("//a[@id='link3']"))).build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"menuItemText13\"]")));
    	action.moveToElement(driver.findElement(By.xpath("//div[@id=\"menuItemText13\"]"))).click().build().perform();
    	String title1 = driver.getTitle();
    	System.out.println(title1);
    	Assert.assertEquals(title1, ":: IOM - Institute For Ocean Management - Anna University ::","title is not same");
    	
    }
    
    @AfterMethod
    public void teardown()
    {
    	driver.quit();
    }
    
}
