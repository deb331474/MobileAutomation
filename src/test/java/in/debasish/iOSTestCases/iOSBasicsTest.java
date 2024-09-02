package in.debasish.iOSTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import in.debasish.testBase.iOSBaseTest;
import io.appium.java_client.AppiumBy;

public class iOSBasicsTest extends iOSBaseTest{
	
	@Test
	public void getPopUpText() {
		
		//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Alert Views\"`]")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("value='Text Entry'")).sendKeys("Debasish Pruseth");
		driver.switchTo().alert().accept();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Secure Text Entry'")).click();
	    driver.switchTo().alert().sendKeys("Hello How r u?????");
		//driver.switchTo().alert().accept();
		String secureTextEntryText=driver.switchTo().alert().getText();
		
		Assert.assertTrue(secureTextEntryText.contains("A Short Title Is Best"));
		
	
		
	}

}
