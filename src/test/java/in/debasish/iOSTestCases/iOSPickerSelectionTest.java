package in.debasish.iOSTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOSPickerSelectionTest extends iOSBasicsTest{
	
	@Test
	public void IOSPickerTestDemo() throws InterruptedException {
		
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Picker View'")).click();
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Red color component view")).sendKeys("80");
		driver.findElement(AppiumBy.accessibilityId("Green color component view")).sendKeys("220");
		
	}

}
