package in.debasish.testBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    @Parameters({"apkFile"})
    public void configureAppiumServer(String apkFile) throws MalformedURLException {
        File app = new File(apkFile);
        File js = new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js");

        service = new AppiumServiceBuilder()
                        .withAppiumJS(js)
                        .withIPAddress("0.0.0.0")
                        .usingPort(4722)
                        .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setApp(app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://0.0.0.0:4722"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void longPressActions(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
    }
}