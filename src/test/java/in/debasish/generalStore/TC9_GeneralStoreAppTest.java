package in.debasish.generalStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import in.debasish.testBase.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class TC9_GeneralStoreAppTest extends AndroidBaseTest {

    @Test
    public void addtoCart() throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Debasish");
        driver.hideKeyboard();

        Thread.sleep(4000);

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));

        Thread.sleep(3000);

        driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        Thread.sleep(4000);

        String[] productsToAdd = {"Air Jordan 9 Retro", "Jordan 6 Rings"};
        Set<String> productsAdded = new HashSet<>();

        while (productsAdded.size() < productsToAdd.length) {
            List<WebElement> allProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
            List<WebElement> addToCartButtons = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));

            for (int i = 0; i < allProducts.size(); i++) {
                WebElement productElement = allProducts.get(i);
                String productName = productElement.getText();

                if (productsAdded.contains(productName)) {
                    continue;
                }

                for (String product : productsToAdd) {
                    if (productName.equalsIgnoreCase(product)) {
                        addToCartButtons.get(i).click();
                        productsAdded.add(productName);
                        Thread.sleep(3000);
                        break;
                    }
                }

                if (productsAdded.size() == productsToAdd.length) {
                    break;
                }
            }

            if (productsAdded.size() < productsToAdd.length) {
                ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                        "left", 100, "top", 100, "width", 200, "height", 200,
                        "direction", "down",
                        "percent", 5.0
                ));
            }
        }
        
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        String airJordanPrice=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"$170.97\")")).getText().replace("$", "");
        System.out.println(airJordanPrice);
        String Jordan6RingsPrice=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"$165.0\")")).getText().replace("$", "");
        System.out.println(Jordan6RingsPrice);
        String totalPurchaseAmnt=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().replace("$", "");
        System.out.println(totalPurchaseAmnt);
        
        float airJordanPriceFloat = Float.parseFloat(airJordanPrice);
        float Jordan6RingsPriceFloat = Float.parseFloat(Jordan6RingsPrice);

        float totalPrice = airJordanPriceFloat + Jordan6RingsPriceFloat;

        String formattedTotalPrice = String.format("%.2f", totalPrice);
        String expectedTotalPrice = "335.97";

        System.out.println("Calculated Total Price: " + formattedTotalPrice);

        Assert.assertEquals(formattedTotalPrice, expectedTotalPrice, "The total price does not match the expected value.");
        
        WebElement termNcon = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressActions(termNcon);

        driver.findElement(By.id("android:id/button1")).click();

        WebElement visitBtn = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
        wait.until(ExpectedConditions.visibilityOf(visitBtn)).click();

        Thread.sleep(5000);

        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }
        
        
        
    }
}
