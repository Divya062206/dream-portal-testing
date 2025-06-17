package base;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class TestBase 
{
	public WebDriver driver;

    @BeforeClass
    public void setUp() 
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void captureFailureArtifacts(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveTextLog("Test Failed: " + result.getName());
            saveScreenshot();
            attachPageSource();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Page Source", type = "text/html")
    public String attachPageSource() {
        return driver.getPageSource();
    }
}
	
	    