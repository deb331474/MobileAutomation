package in.debasish.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC4_APIDemosAppTest extends AndroidBaseTest{
	
	/*@Test
	public void doScrollingFirstWay() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		Thread.sleep(2000);
	}*/
	
	/*@Test
	public void doScrollingSecondWay() {

	    driver.findElement(AppiumBy.accessibilityId("Views")).click();

	    int maxScrolls = 10;
	    int scrollCount = 0;

	    while (scrollCount < maxScrolls) {
	        try {
	         
	            WebElement targetElement = driver.findElement(AppiumBy.accessibilityId("WebView3"));
	            System.out.println("Element found: " + targetElement.getText());
	            break;
	        } catch (NoSuchElementException e) {
	            System.out.println("Element not found, scrolling down...");
	            ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	                    "left", 100, 
	                    "top", 100, 
	                    "width", 100,
	                    "height", 100,
	                    "direction", "down",
	                    "percent", 2.0
	            ));
	        }

	        scrollCount++;	    }

	    if (scrollCount == maxScrolls) {
	        System.out.println("Element not found after maximum scroll attempts.");
	    }
	}  */
	    
	    @Test
	    public void scrollToEnd() {
	        // Click on Views
	        driver.findElement(AppiumBy.accessibilityId("Views")).click();

	        boolean canScrollMore;
	        do {
	            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
	                "left", 100, // X-coordinate of the top-left corner of the scrollable area
	                "top", 200, // Y-coordinate of the top-left corner of the scrollable area
	                "width", 800, // Width of the scrollable area (e.g., screen width)
	                "height", 600, // Height of the scrollable area (e.g., screen height)
	                "direction", "down",
	                "percent", 1.0
	            ));

	            // Add a small delay to simulate user interaction and to give time for UI updates
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }

	        } while (canScrollMore);

	        System.out.println("Reached the end of the scrollable area.");
	    }

    }
