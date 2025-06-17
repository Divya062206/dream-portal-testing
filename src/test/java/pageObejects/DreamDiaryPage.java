package pageObejects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DreamDiaryPage {
    WebDriver driver;

    @FindBy(tagName = "tbody")
    WebElement tableBody;

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting all dream diary rows")
    public List<WebElement> getAllRows() {
        return tableBody.findElements(By.tagName("tr"));
    }

    @Step("Validating all dreams have valid types (Good or Bad)")
    public boolean allDreamsHaveValidTypes() {
        for (WebElement row : getAllRows()) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            String type = cols.get(2).getText().trim();
            if (!type.equals("Good") && !type.equals("Bad")) {
                return false;
            }
        }
        return true;
    }

    @Step("Checking all rows have three non-empty columns")
    public boolean allRowsHaveThreeColumns() {
        for (WebElement row : getAllRows()) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() != 3) return false;
            if (cols.get(0).getText().isEmpty() ||
                cols.get(1).getText().isEmpty() ||
                cols.get(2).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Step("Counting occurrences of dream: {dreamName}")
    public int countDreamOccurrences(String dreamName) {
        int count = 0;
        for (WebElement row : getAllRows()) {
            String name = row.findElements(By.tagName("td")).get(0).getText().trim();
            if (name.equalsIgnoreCase(dreamName)) {
                count++;
            }
        }
        return count;
    }
}