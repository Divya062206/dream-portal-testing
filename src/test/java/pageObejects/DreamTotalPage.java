package pageObejects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DreamTotalPage {
    WebDriver driver;

    @FindBy(xpath = "//td[text()='Good Dreams']/following-sibling::td")
    WebElement goodDreams;

    @FindBy(xpath = "//td[text()='Bad Dreams']/following-sibling::td")
    WebElement badDreams;

    @FindBy(xpath = "//td[text()='Total Dreams']/following-sibling::td")
    WebElement totalDreams;

    @FindBy(xpath = "//td[text()='Recurring Dreams']/following-sibling::td")
    WebElement recurringDreams;

    @FindBy(xpath = "//td[text()='Dreams This Week']/following-sibling::td")
    WebElement dreamsThisWeek;

    public DreamTotalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get Good Dreams count")
    public int getGoodDreamsCount() {
        return Integer.parseInt(goodDreams.getText().trim());
    }

    @Step("Get Bad Dreams count")
    public int getBadDreamsCount() {
        return Integer.parseInt(badDreams.getText().trim());
    }

    @Step("Get Total Dreams count")
    public int getTotalDreamsCount() {
        return Integer.parseInt(totalDreams.getText().trim());
    }

    @Step("Get Recurring Dreams count")
    public int getRecurringDreamsCount() {
        return Integer.parseInt(recurringDreams.getText().trim());
    }

    @Step("Get Dreams This Week count")
    public int getDreamsThisWeekCount() {
        return Integer.parseInt(dreamsThisWeek.getText().trim());
    }
}