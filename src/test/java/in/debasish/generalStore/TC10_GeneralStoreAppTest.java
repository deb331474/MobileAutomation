package in.debasish.generalStore;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC10_GeneralStoreAppTest extends AndroidBaseTest {

	@Test
    public void addtoCart() throws InterruptedException {
        try {
            driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Debasish");
            driver.hideKeyboard();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='India']"))).click();

            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/productAddCart")));
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();

            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

            wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

            List<WebElement> prodPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
            
            double sum = 0;

            for (WebElement priceElement : prodPrices) {
                String amountString = priceElement.getText();
                double price = Double.parseDouble(amountString.substring(1));
                sum += price;
            }

            String displayedSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
            double displayedTotalSum = Double.parseDouble(displayedSum.substring(1));

            Assert.assertEquals(sum, displayedTotalSum, "Values are not matched");

            WebElement termNcon = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
            
            longPressActions(termNcon);

            driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

            WebElement visitBtn = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
            wait.until(ExpectedConditions.visibilityOf(visitBtn)).click();

            Thread.sleep(5000);

            Set<String> contexts = driver.getContextHandles();
            for (String contextName : contexts) {
                System.out.println(contextName);
            }
            
            driver.context("WEBVIEW_com.androidsample.generalstore");
            
            driver.findElement(By.name("q")).sendKeys("Debasish Pruseth");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.context("NATIVE_APP");
            
            WebElement letShopBtn=driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
            
            Assert.assertTrue(letShopBtn.isDisplayed(),"Back To Native App");
            
        } catch (StaleElementReferenceException e) {
        	
            System.out.println("Exception occurred: " + e.getMessage());
            
            e.printStackTrace();
        }
    }
}
