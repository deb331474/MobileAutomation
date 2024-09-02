package in.debasish.generalStore;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC7_GeneralStoreAppTest extends AndroidBaseTest{
	
	@Test
	public void fillForm() throws InterruptedException {
	
    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Debasish");
    driver.hideKeyboard();
    
    Thread.sleep(4000);
    
    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
    
    driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
    
    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
    
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
    
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    
    /*String prodText=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
    
    System.out.println(prodText);
    
    Assert.assertEquals(prodText, "Products");*/

}
}

