package in.debasish.iOSTestCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import in.debasish.testBase.iOSBaseTest;
import io.appium.java_client.AppiumBy;

public class iOSLongPressTest extends iOSBaseTest{
	
	@Test
	public void longPressTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		
		WebElement ele=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		Map<String, Object> params=new HashMap<String, Object>();
		
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		
		driver.executeScript("mobile:touchAndHold",params);
		
	}

}
