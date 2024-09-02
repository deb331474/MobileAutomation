package in.debasish.iOSTestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import in.debasish.testBase.iOSBaseTest;
import io.appium.java_client.AppiumBy;

public class iOS_OtherAlertViewTest extends iOSBaseTest{
	
	@Test
	public void getPopUpText() {
	
		//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Alert Views\"`]")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Other'")).click();
		String headerText=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeAlert[`name == 'A Short Title Is Best'`]")).getText();
		System.out.println("The header text is:;"+headerText);
		Assert.assertTrue(true, headerText);
		Assert.assertTrue(headerText.contains("A Short Title Is Best"),"Both the messages are mismatched");
		
		WebElement choice1Btn= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name =='Choice One'`]"));
		WebElement choice2Btn= driver.findElement(AppiumBy.iOSNsPredicateString("name =='Choice Two'"));
		WebElement cancelBtn= driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name =='Horizontal scroll bar, 1 page'`][2]"));
		//choice2Btn.click();
		cancelBtn.click();
		
	}

}
