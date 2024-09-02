package in.debasish.iOSTestCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import in.debasish.testBase.iOSBaseTest;
import io.appium.java_client.AppiumBy;

public class iOSDatePickerTest extends iOSBaseTest{
	
	
	@Test
	public void selectDateTest() {
		
		 driver.findElement(AppiumBy.accessibilityId("Date Picker")).click();

	        // Get the current date in the desired format
	        LocalDate today = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
	        String currentDate = today.format(formatter);

	        // Find all buttons within the date picker
	        List<WebElement> dateButtons = driver.findElements(By.xpath("//XCUIElementTypeDatePicker//XCUIElementTypeButton"));

	        // Create a list to store the dates
	        List<String> dateList = new ArrayList<>();

	        // Populate the list with the button names
	        for (WebElement button : dateButtons) {
	            dateList.add(button.getAttribute("name"));
	        }

	        // Check if the current date is in the list
	        boolean dateFound = false;
	        int index = 0;  // Corrected from 'I' to 'index' to avoid confusion with 'I' for index
	        while (index < dateList.size()) {
	            if (dateList.get(index).equals(currentDate)) {
	                // Click the button if the date matches
	                dateButtons.get(index).click();
	                dateFound = true;
	                System.out.println("Selected Date: " + currentDate);
	                break;
	            }
	            index++;
	        }

	        // If the date is not found
	        if (!dateFound) {
	            System.out.println("Date not found: " + currentDate);
	        }
	    }

}
