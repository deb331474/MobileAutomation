package in.debasish.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC5_APIDemosAppTest extends AndroidBaseTest{
	
	@Test
	public void getScrollingTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Photos\")")).click();
		
		WebElement firstImg=driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		
		//swipeActions(firstImg,"left");
		
		for (int i = 1; i <= 3; i++) {
            WebElement img = driver.findElement(By.xpath("//android.widget.ImageView[" + i + "]"));
            if (img.isDisplayed()) {
                System.out.println("Image " + i + " is displayed");
                    swipeActions(img, "left");
                    Thread.sleep(2000);
                    if(i>3)
                    	break;
                   
                }
             else {
                System.out.println("Image " + i + " is not displayed");
            }
        }
    }

		

	public void swipeActions(WebElement element, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 1.0,"speed",1000
			));
	}

}
