package testCases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObejects.DreamDiaryPage;

@Epic("Dream Diary Application")
@Feature("Dream Diary Page Validation")
public class DreamDiaryTest extends TestBase {

    @Test
    @Story("Verify Dream Diary Table")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate dream diary entries, types, and recurrence.")
    public void testDreamDiaryValidation() {
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

        DreamDiaryPage diary = new DreamDiaryPage(driver);

        assertEquals(diary.getAllRows().size(), 10, "Should have 10 dream entries.");
        assertTrue(diary.allDreamsHaveValidTypes(), "Dream types must be Good or Bad.");
        assertTrue(diary.allRowsHaveThreeColumns(), "All rows must have 3 filled columns.");
        assertTrue(diary.countDreamOccurrences("Flying over mountains") >= 2,
                "Flying over mountains should be recurring.");
        assertTrue(diary.countDreamOccurrences("Lost in maze") >= 2,
                "Lost in maze should be recurring.");
    }
}
