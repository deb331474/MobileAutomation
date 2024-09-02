package in.debasish.iOSTestCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.debasish.testBase.iOSBaseTest;
import io.appium.java_client.AppiumBy;

public class iOSDatePickerPastTest extends iOSBaseTest {

	public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // Parse the date string using the provided pattern
    public LocalDate parseUserInputDate(String inputDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(inputDate, formatter);
    }

    // Fetch the displayed date from the UI
    public LocalDate getDisplayedDateFromUI() {
        // Locate the element that displays the current date (e.g., "17 Aug 2024")
        WebElement displayedDateElement = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name, ' ')]"));
        String displayedDateText = displayedDateElement.getAttribute("name"); // Example: "17 Aug 2024"

        // Parse the displayed date text into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return LocalDate.parse(displayedDateText, formatter);
    }

    // Method to select a date by navigating the date picker
    public void selectDate(String userInputDate, String pattern) {
        LocalDate userDate = parseUserInputDate(userInputDate, pattern);

        By previousBtn = By.xpath("//XCUIElementTypeButton[@name='Previous Month']");
        By nextBtn = By.xpath("//XCUIElementTypeButton[@name='Next Month']");

        while (true) {
            LocalDate displayedDate = getDisplayedDateFromUI();

            if (userDate.isBefore(displayedDate)) {
                driver.findElement(previousBtn).click();
            } else if (userDate.isAfter(displayedDate)) {
                driver.findElement(nextBtn).click();
            } else {
                break;
            }
        }
    }


    @Test
    public void testSelectPastDate() {
    	driver.findElement(AppiumBy.accessibilityId("Date Picker")).click();
        // User input date in the past
        String pastDate = "10 Aug 2023"; // Replace with an appropriate past date
        selectDate(pastDate, "dd MMM yyyy");

        // Verify if the correct date is selected
        Assert.assertEquals(getDisplayedDateFromUI(), parseUserInputDate(pastDate, "dd MMM yyyy"));
    }
}
