package in.debasish.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC6_APIDemosAppTest extends AndroidBaseTest {
	
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@Test
	public void doMessagingTest() {
		
	
	WebElement osBtn=driver.findElement(AppiumBy.accessibilityId("OS"));
	
	osBtn.click();
	
	WebElement smsMsging=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"SMS Messaging\")"));
	
	wait.until(ExpectedConditions.visibilityOf(smsMsging));
	smsMsging.click();
	
    //WebElement wrngMsg=driver.findElement(AppiumBy.accessibilityId("OS"));
	
	//osBtn.click();
	
	String wrngMsg = driver.findElement(By.xpath("//android.widget.TextView[contains(@content-desc, 'WARNING: this demo can send actual text message')]")).getText();

	Assert.assertEquals(wrngMsg, "WARNING: this demo can send actual text messages (one at a time), so be sure to test with the Android emulator or have a text messaging plan with your carrier.");
	
	WebElement enableSMSBraodChkbox=driver.findElement(By.className("android.widget.CheckBox"));
	
	enableSMSBraodChkbox.click();
	
	WebElement recipientText=driver.findElement(By.id("io.appium.android.apis:id/sms_recipient"));
	recipientText.sendKeys("Debasish Pruseth");
	
	WebElement msgBody=driver.findElement(By.id("io.appium.android.apis:id/sms_content"));
	msgBody.sendKeys("Message about fuck up");
	
	driver.findElement(AppiumBy.accessibilityId("Send")).click();
	
	
	
	}
}
