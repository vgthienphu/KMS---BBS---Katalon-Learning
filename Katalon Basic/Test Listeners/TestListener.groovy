import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class TestListener {
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		if (DriverFactory.getExecutedBrowser() == WebUIDriverType.FIREFOX_DRIVER && testCaseContext.getTestCaseVariables().p_UseFireFoxProfile == true) {
			System.setProperty("webdriver.gecko.driver", "D:\\Katalon_Studio_Windows_64\\configuration\\resources\\drivers\\firefox_win64\\geckodriver.exe");
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 1)
			profile.setPreference("browser.download.manager.showWhenStarting", false)
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv")
	
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
	
			FirefoxDriver driver = new FirefoxDriver(options);
			
			DriverFactory.changeWebDriver(driver)	
		} else {
			'Open browser'
			WebUI.openBrowser('')
		}
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		'Close browser'
		WebUI.closeBrowser()
	}
}