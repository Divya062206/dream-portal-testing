package testCases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Dream Diary Application")
@Feature("Home Page")
public class HomePageTest extends TestBase {

    @Test
    @Story("Load Home Page and Click Button")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verifies that the home page loads and the My Dreams button is clickable.")
    public void testHomePageLoads() {
        driver.get("https://arjitnigam.github.io/myDreams/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement myDreamsBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("dreamButton"))
            );

            assertTrue(myDreamsBtn.isDisplayed(), "My Dreams button should be visible");
            myDreamsBtn.click();

            System.out.println("Button found and clicked successfully.");

        } catch (TimeoutException e) {
            System.out.println("Timeout: My Dreams button did not appear");
            fail("Test failed because button not visible");
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
            fail("Unexpected failure: " + e.getMessage());
        }
    }
}
