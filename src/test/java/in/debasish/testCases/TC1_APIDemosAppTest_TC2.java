package in.debasish.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC1_APIDemosAppTest_TC2 extends AndroidBaseTest{

	@Test
	public void miscellaneousOrientationTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"3. Preference dependencies\")")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
		
		DeviceRotation landscape=new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
		
		Thread.sleep(2000);
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//driver.findElement(By.className("android.widget.EditText")).sendKeys("Debasish Pruseth");
		
		//driver.findElement(By.id("android:id/button1")).click();
		
		//Setting the clipboard text and pasting it in the wifi settings dialog
		
		driver.sendSMS("9938241129", "Hello Deb?");
		
		driver.setClipboardText("My Another Wifi");
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
	}
}
