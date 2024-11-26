import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class FitPeo {
	static String browser = "chrome"; 
	static WebDriver driver = launchBrowser(browser);
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Change this to "safari" or "edge" for testing other browsers
       // Navigate to FitPeo homepage
		
		
	        try {
				if (driver != null) {
					
					 driver.manage().window().maximize();
				    driver.get("https://www.fitpeo.com/");
				    
				    
				    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				    
				    WebElement Logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt=\"FitPeo\"]")));
				    
				    if(Logo.isDisplayed())
				    {
				    	System.out.println("Successfully navigated to FitPeo Page");
				    }
				    TakeScreenshot("FitPeo HomePage");
				    
				    //Navigate to Revenue Calculator
				    
				  
				    driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				    
				    WebElement RevenueHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Total Gross Revenue Per Year']")));
				    
				    if(RevenueHeader.isDisplayed())
				    {
				    	System.out.println("Successfully navigated to FitPeoRevenueCalculator Page");
				    }
				    TakeScreenshot("FitPeoRevenueCalculator Page ");
				    
				    
				    //Scroll down to the Slider Section
				   
				    WebElement Slider=driver.findElement(By.xpath("//input[@aria-orientation='horizontal' and @type='range']"));
				    JavascriptExecutor js = (JavascriptExecutor) driver;
				    js.executeScript("arguments[0].scrollIntoView(true);", Slider);
				    ((JavascriptExecutor) driver).executeScript(
				    	    "var rect = arguments[0].getBoundingClientRect();" +
				    	    "window.scrollBy(0, rect.top - 100);", // Adjust -100 for offset
				    	    Slider
				    	);
				    TakeScreenshot("Scroll down to the Slider Section");
				   
				    
				    
				    
				    //Update the text field
				    
				   String value="560";
				    
				    WebElement InputBox=driver.findElement(By.xpath("//input[@type='number']"));
				    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				    wait.until(ExpectedConditions.elementToBeClickable(InputBox));
				    InputBox.click();
				    
				    js.executeScript("arguments[0].click();", InputBox);
				   
				    //Clear the text in Inputbox
				    while (!InputBox.getAttribute("value").equals("")) {
				    	InputBox.sendKeys(Keys.BACK_SPACE);
				       }
				    InputBox.sendKeys(value);
				    
				   
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    System.out.println("Slider value set to: " + Slider.getAttribute("value"));
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				    
				    TakeScreenshot("Update the text field");
				    
				    
				    
				    //Adjust the slider
				    
				    
				    
				    int sliderWidth = Slider.getSize().width;

				    // Define slider value range (e.g., 0–100)
				    double minValue = 0;
				    double maxValue = 2000;

				    // Desired value
				    double desiredValue = 820.00;

				    // Calculate the offset in pixels (scaled to integer)
				    int offset = (int) Math.round((desiredValue / (maxValue - minValue)) * sliderWidth);

				    // Use Actions class to move the slider
				    Actions action = new Actions(driver);
				    action.clickAndHold(Slider)
				      .moveByOffset(42, 0) // Offset in pixels (integer)
				      .release()
				      .perform();
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    
				    
				    
				    String value1="820";
				    
				    InputBox=driver.findElement(By.xpath("//input[@type='number']"));
				    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				    InputBox.click();
				    js.executeScript("arguments[0].click();", InputBox);
				    
				   
				    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				   
				    //Clear the text in Inputbox
				    while (!InputBox.getAttribute("value").equals("")) {
				    	InputBox.sendKeys(Keys.BACK_SPACE);
				       }
				    InputBox.sendKeys(value1);
				    
				   
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    //System.out.println("Slider value set to: " + Slider.getAttribute("value"));
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				    
				    if(value1.equalsIgnoreCase(Slider.getAttribute("value")))
				    {
				    	System.out.println("The slider is set to " +Slider.getAttribute("value"));
				    }
				    
				    TakeScreenshot("Update the text field to 820");
				    
				    
				    //Select CPT Codes
				    
				    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    
				    
				    
				    WebElement CPT_99091_cb=driver.findElement(By.xpath("//p[text()='CPT-99091']//following::input[1]"));
				    js.executeScript("arguments[0].scrollIntoView(true);", CPT_99091_cb);
				    ((JavascriptExecutor) driver).executeScript(
				    	    "var rect = arguments[0].getBoundingClientRect();" +
				    	    "window.scrollBy(0, rect.top - 100);", // Adjust -100 for offset
				    	    CPT_99091_cb
				    	);
				   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[text()='CPT-99091']//following::input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox'])[1]")));
				    CPT_99091_cb.click();
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    
				    
				    WebElement CPT_99453_cb=driver.findElement(By.xpath("//p[text()='CPT-99453']//following::input[1]"));
				    js.executeScript("arguments[0].scrollIntoView(true);", CPT_99453_cb);
				    ((JavascriptExecutor) driver).executeScript(
				    	    "var rect = arguments[0].getBoundingClientRect();" +
				    	    "window.scrollBy(0, rect.top - 100);", // Adjust -100 for offset
				    	    CPT_99453_cb
				    	);
				    CPT_99453_cb.click();
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    
				    
				    WebElement CPT_99454_cb=driver.findElement(By.xpath("//p[text()='CPT-99454']//following::input[1]"));
				    js.executeScript("arguments[0].scrollIntoView(true);", CPT_99454_cb);
				    ((JavascriptExecutor) driver).executeScript(
				    	    "var rect = arguments[0].getBoundingClientRect();" +
				    	    "window.scrollBy(0, rect.top - 100);", // Adjust -100 for offset
				    	    CPT_99454_cb
				    	);
				    CPT_99454_cb.click();
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    
				    
				    WebElement CPT_99474_cb=driver.findElement(By.xpath("//p[text()='CPT-99474']//following::input[1]"));
				    js.executeScript("arguments[0].scrollIntoView(true);", CPT_99474_cb);
				    ((JavascriptExecutor) driver).executeScript(
				    	    "var rect = arguments[0].getBoundingClientRect();" +
				    	    "window.scrollBy(0, rect.top - 100);", // Adjust -100 for offset
				    	    CPT_99474_cb
				    	);
				    CPT_99474_cb.click();
				    
				    wait=new WebDriverWait(driver,Duration.ofSeconds(200));
				    TakeScreenshot("CPT CODES");
				    
				    
				    //Validating Recurring deposit
				    String ExpectedAmount="110700";
				    
				    WebElement RecurringAMount=driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:']//p[text()='"+ExpectedAmount+"']"));
				    if(RecurringAMount.isDisplayed())
				    {
				    	System.out.println("Recurring deposit value is"+ExpectedAmount);
				    }
				    driver.quit();
				    
				    
				   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	            
	            
	//Launch browser as per the requirement
	public static WebDriver launchBrowser(String browserName) {
		        WebDriver driver = null;

		        switch (browserName.toLowerCase()) {
		            case "chrome":
		                System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		            	// driver = new ChromeDriver();
		            	 
		            	 //WebDriverManager.chromedriver().setup();
		                 driver = new ChromeDriver();
		                break;
		                
		            case "edge":
		                System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
		                driver = new EdgeDriver();
		                break;
		                
		            case "safari":
		                // Safari driver does not require a separate executable but needs Safari automation enabled
		                driver = new SafariDriver();
		                break;
		                
		            default:
		                System.out.println("Invalid browser name provided: " + browserName);
		                System.out.println("Supported browsers: chrome, edge, safari.");
		        }
		        
		        return driver;
		    }
	public static void TakeScreenshot(String FileName)
	        throws IOException
	    {
	        // Creating instance of File
	        File File = ((TakesScreenshot)driver)
	                        .getScreenshotAs(OutputType.FILE);
	        
	        Files.copy(File,
                    new File("C:\\Users\\LENOVO\\Downloads\\FitPeo_Screenshots\\"
                            + FileName + ".jpeg"));

	        
	    }

	
	
	
	
	
	
	

		   

}
