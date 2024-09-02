package in.debasish.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC3_APIDemosAppTest extends AndroidBaseTest {

	@Test
	public void longPressGestures() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.TextView[1]"));
		longPressActions(ele);
		Thread.sleep(2000);

	}

}
