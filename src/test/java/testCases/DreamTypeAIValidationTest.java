package testCases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObejects.DreamDiaryPage;
import utilities.AIUtils;

@Epic("AI Validation")
@Feature("Dream Type Classification")
public class DreamTypeAIValidationTest extends TestBase {

    @Test(description = "AI classification of dream types")
    @Severity(SeverityLevel.MINOR)
    @Description("Uses OpenAI to classify each dream and compares it with table value.")
    public void testDreamTypesWithAI() {
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

        DreamDiaryPage diary = new DreamDiaryPage(driver);
        List<WebElement> rows = diary.getAllRows();

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            String dreamName = cols.get(0).getText().trim();
            String actualType = cols.get(2).getText().trim();

            String predictedType = AIUtils.classifyDream(dreamName);
            System.out.println("Dream: " + dreamName + " | Actual: " + actualType + " | AI: " + predictedType);

            assertTrue(
                predictedType.toLowerCase().contains(actualType.toLowerCase()),
                "AI prediction mismatch for: " + dreamName
            );
        }
    }
}