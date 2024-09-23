package BCL;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;

public class BCl_Publication extends basicbcl {

    @SuppressWarnings("deprecation")
    @Test
    public void News() throws MalformedURLException, InterruptedException {
        
        // Create report        
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
      
        Thread.sleep(5000); 
        
        // Login
        FormPage formPage = new FormPage(driver);
        formPage.setPhone("01700704427");
        formPage.setPassword("123456");
        formPage.setLogin();
        Thread.sleep(3000); 

        // Check BC club        
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.btracsolutions.bananiclub:id/rlMenu']/android.widget.ImageView")).click();
        Thread.sleep(3000);

        // Call the method to click a random news link
        clickRandomNewsLink();
    }

    // Method to scroll down
	private void scrollDown() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 300, "width", 800, "height", 1500,
			    "direction", "down",
			    "percent", 90.0
			));  // Replaced Thread.sleep with custom wait method
		
		Thread.sleep(3000);
    }

    private void scrollUp() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 300, "width", 800, "height", 1500,
			    "direction", "up",
			    "percent", 90.0
			));  // Replaced Thread.sleep with custom wait method
		
		Thread.sleep(3000); // Replaced Thread.sleep with custom wait method
    }

    // Method to click a random news link
    public void clickRandomNewsLink() throws InterruptedException {
        // Click on the News section
        driver.findElement(By.xpath("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.btracsolutions.bananiclub:id/llPublications\"]/android.widget.RelativeLayout"))
              .click();
        Thread.sleep(3000);
        
        scrollDown(); // Scroll down if necessary to bring more links into view

        // Find all news links
        List<WebElement> newsLinks = driver.findElements(By.xpath("(//android.view.View[@resource-id=\"com.btracsolutions.bananiclub:id/view\"])"));
        
        // Select a random news link
        if (!newsLinks.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(newsLinks.size()); // Select a random index
            newsLinks.get(randomIndex).click();  // Click the randomly selected link            
            Thread.sleep(3000);
            
        } else {
            System.out.println("No news links found.");
        }
        
        driver. navigate(). back(); 
        Thread.sleep(10000);
        scrollUp();
        scrollDown();
 
    }
}
