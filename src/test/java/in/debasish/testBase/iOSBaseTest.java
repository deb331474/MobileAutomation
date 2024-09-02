package in.debasish.testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest {

	public IOSDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppiumServer() throws MalformedURLException {

        File js = new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js");

        service = new AppiumServiceBuilder()
                        .withAppiumJS(js)
                        .withIPAddress("0.0.0.0")
                        .usingPort(4722)
                        .build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15 Pro");
        options.setApp("/Users/debasishpruseth/Desktop/UIKitCatalog.app");
        options.setPlatformVersion("17.5");
        options.setAutomationName("XCUITest");

        driver = new IOSDriver(new URL("http://0.0.0.0:4722"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
    }
}