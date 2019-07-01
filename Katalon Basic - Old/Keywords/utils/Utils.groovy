package utils

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit
import java.util.function.Function

import org.openqa.selenium.Keys
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Utils {
	@Keyword
	public void sendKeyWithKeyboard(String key) {
		new Actions(DriverFactory.getWebDriver()).sendKeys(key).build().perform()
	}

	@Keyword
	public void sendKeyWithKeyboard(Keys key) {
		new Actions(DriverFactory.getWebDriver()).sendKeys(key).build().perform()
	}


	@Keyword
	public void clickByJS(TestObject to) {
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(to, GlobalVariable.MediumTime)))
	}

	@Keyword
	public void editContentByJS(TestObject to, String newContent) {
		WebUI.executeJavaScript("arguments[0].innerText = arguments[1]", Arrays.asList(WebUiCommonHelper.findWebElement(to, GlobalVariable.MediumTime), newContent))
	}

	@Keyword
	public void clickBySelenium(TestObject to) {
		WebUiCommonHelper.findWebElement(to, GlobalVariable.MediumTime).click()
	}

	@Keyword
	public void pressAltS() {
		Robot robot = new Robot()
		robot.setAutoDelay(250)
		robot.keyPress(KeyEvent.VK_ALT)
		WebUI.delay(GlobalVariable.ShortTime)
		robot.keyPress(KeyEvent.VK_S)
		robot.keyRelease(KeyEvent.VK_ALT)
		robot.keyRelease(KeyEvent.VK_S)
	}

	@Keyword
	public void delayOn(WebUIDriverType browser, int waitTimeInSeconds) {
		if (DriverFactory.getExecutedBrowser() == browser) {
			WebUI.delay(GlobalVariable.ShortTime)
		}
	}
}
