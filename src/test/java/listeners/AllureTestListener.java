package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;
import utilities.ScreenshotUtils;

public class AllureTestListener extends TestBase implements ITestListener
{
	 @Override
	    public void onTestFailure(ITestResult result) {
	        ScreenshotUtils.takeScreenshot(driver);
	    }

}
