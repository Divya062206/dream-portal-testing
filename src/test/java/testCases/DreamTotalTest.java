package testCases;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObejects.DreamTotalPage;

@Epic("Dream Diary Application")
@Feature("Dream Summary Page")
public class DreamTotalTest extends TestBase {

    @Test
    @Story("Verify Dream Totals and Stats")
    @Severity(SeverityLevel.NORMAL)
    @Description("Checks good/bad/total/weekly/recurring dream counts.")
    public void testDreamSummaryPage() {
        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");

        DreamTotalPage totalPage = new DreamTotalPage(driver);

        assertEquals(totalPage.getGoodDreamsCount(), 6, "Good dreams count should be 6");
        assertEquals(totalPage.getBadDreamsCount(), 4, "Bad dreams count should be 4");
        assertEquals(totalPage.getTotalDreamsCount(), 10, "Total dreams should be 10");
        assertEquals(totalPage.getDreamsThisWeekCount(), 7, "Dreams this week should be 7");
        assertEquals(totalPage.getRecurringDreamsCount(), 2, "Recurring dreams should be 2");
    }
}
