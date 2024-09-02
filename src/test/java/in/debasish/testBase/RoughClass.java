package in.debasish.testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class RoughClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File app =new File("//Users//debasishpruseth//Downloads//appium-api-demos-3-3-1.apk");
		  
		//File js = new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js");
		
		//File js = new File(".//lib//main.js");
		
		//File js = new File("/opt/homebrew/bin/node");
		
		//File js = new File("/Users/debasishpruseth/.appium/node_modules/appium/build/lib/main.js");
		
		File js = new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js");



		AppiumDriverLocalService service =
		  new AppiumServiceBuilder()
		  .withAppiumJS(js)
		  .withIPAddress("0.0.0.0")
		  .withArgument(GeneralServerFlag.BASEPATH, "wd/hub")
		  .usingPort(4722)
		  .build();
		  service.start();
		  
		  DesiredCapabilities cap = new DesiredCapabilities();
			 
		  cap.setCapability("appium:app", app.getAbsolutePath());
		  cap.setCapability("appium:deviceName", "emulator-5554");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("appium:automationName","uiautomator2"); 
		  
		  AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4722/wd/hub"), cap);
		  
		  
		  driver.findElement(AppiumBy.accessibilityId("Views")).click();
		     driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		     driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		     WebElement ele=driver.findElement(By.xpath("//android.widget.ExpandableListView/android.widget.TextView[1]"));
		     ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    		    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
		    		)); 
			Thread.sleep(2000);
	}

}
