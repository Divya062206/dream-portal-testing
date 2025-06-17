package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "loadingAnimation")
    WebElement loadingAnimation;

    @FindBy(id = "mainContent")
    WebElement mainContent;

    @FindBy(xpath = "//button[text()='MY DREAMS']")
    WebElement myDreamsButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Check if loading animation is visible")
    public boolean isLoadingAnimationVisible() {
        return loadingAnimation.isDisplayed();
    }

    @Step("Check if main content is visible")
    public boolean isMainContentVisible() {
        return mainContent.isDisplayed();
    }

    @Step("Clicking 'MY DREAMS' button")
    public void clickMyDreams() {
        myDreamsButton.click();
    }
}

