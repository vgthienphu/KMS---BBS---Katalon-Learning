package com.kms.web
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.testng.reporters.Files.readFile

import java.awt.Robot
import java.awt.event.KeyEvent

import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class Elements {
	@Keyword
	public void selectContextMenu(List<String> menuTexts) {
		TestObject menu

		menuTexts.each {
			menu = findTestObject('Object Repository/Page_JQuery UI Menu/mnu_Any Menu', [mnuTxt: it])

			WebUI.waitForElementVisible(menu, GlobalVariable.MediumTime)

			clickByJS(menu)
		}
	}

	@Keyword
	public void clickByJS(TestObject to) {
		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(WebUiCommonHelper.findWebElement(to, GlobalVariable.MediumTime)))
	}
	
	public int getPixelsToMove(double valueToMove, double sldrWidth, double sldrMin, double sldrMax, double sldrStep) {
		double numberOfSteps = (sldrMax - sldrMin) / sldrStep
		println 'numberOfSteps ' + numberOfSteps

		double widthEachStep = sldrWidth / numberOfSteps
		println 'widthEachStep ' + widthEachStep

		double numberOfStepsToSlide = (valueToMove / sldrStep)
		println 'numberOfStepsToSlide' + numberOfStepsToSlide

		int pixels = numberOfStepsToSlide * widthEachStep
		println 'pixels ' + pixels

		println 'expected value ' + valueToMove

		return pixels
	}

	// For Edge
	@Keyword
	public void slideTo(TestObject slider, double value, double additionalPixels) {
		double min = Double.parseDouble(WebUI.getAttribute(slider, 'min'))
		double max = Double.parseDouble(WebUI.getAttribute(slider, 'max'))
		double step = Double.parseDouble(WebUI.getAttribute(slider, 'step'))
		double width = Double.parseDouble(WebUI.getCSSValue(slider, 'width') - ~/px$/)

		int startValuePosition = - (width / 2) - 10
		int pixels = getPixelsToMove(value, width, min, max, step)

		if (pixels < 0) {
			pixels -= (int) additionalPixels
		} else {
			pixels += (int) additionalPixels
		}

		println 'final pixels ' + pixels

		new Actions(DriverFactory.getWebDriver())
				.clickAndHold(WebUiCommonHelper
				.findWebElement(slider, GlobalVariable.MediumTime))
				.moveByOffset(startValuePosition, 0)
				.moveByOffset(pixels, 0)
				.release().build().perform()
	}


	//For IE
	@Keyword
	public void slideToByPressingArrowKeys(TestObject slider, double expectedValue) {
		double currentValue = Double.parseDouble(WebUI.getAttribute(slider, 'value'))
		double step = Double.parseDouble(WebUI.getAttribute(slider, 'step'))

		Robot robot = new Robot()

		if (expectedValue > currentValue) {
			int numberOfArrowRight = (int) ((expectedValue - currentValue) / step);

			for (int i = 0; i < numberOfArrowRight; i++) {
				WebUI.click(slider)
				robot.keyPress(KeyEvent.VK_RIGHT)
			}
		} else {
			if (expectedValue < currentValue) {
				int numberOfArrowLeft = (int) ((currentValue - expectedValue) / step);

				for (int i = 0; i < numberOfArrowLeft; i++) {
					WebUI.click(slider)
					robot.keyPress(KeyEvent.VK_LEFT)
				}
			}
		}
	}

	@Keyword
	public void slideTo(TestObject slider, double value) {
		double min = Double.parseDouble(WebUI.getAttribute(slider, 'min'))
		double max = Double.parseDouble(WebUI.getAttribute(slider, 'max'))
		double step = Double.parseDouble(WebUI.getAttribute(slider, 'step'))
		double width = Double.parseDouble(WebUI.getCSSValue(slider, 'width') - ~/px$/)

		int startValuePosition = - (width / 2)
		int pixels = getPixelsToMove(value, width, min, max, step)
		new Actions(DriverFactory.getWebDriver())
				.clickAndHold(WebUiCommonHelper
				.findWebElement(slider, GlobalVariable.MediumTime))
				.moveByOffset(startValuePosition, 0)
				.moveByOffset(pixels, 0)
				.release().build().perform()
	}

	@Keyword
	public void verifySliderValue(TestObject slider, double expectedValue) {
		double currentValue = Float.parseFloat(WebUI.getAttribute(slider, 'value'))

		WebUI.verifyEqual(currentValue, expectedValue)
	}
	
	@Keyword
	public void delayOn(WebUIDriverType browser, int waitTimeInSeconds) {
		if (DriverFactory.getExecutedBrowser() == browser) {
			WebUI.delay(GlobalVariable.ShortTime)
		}
	}
	
	@Keyword
	public void editContentByJS(TestObject to, String newContent) {
		WebUI.executeJavaScript("arguments[0].innerText = arguments[1]", Arrays.asList(WebUiCommonHelper.findWebElement(to, GlobalVariable.MediumTime), newContent))
	}
	
	@Keyword
	public void dragDrop(String cssSelectorFrom, cssSelectorTo) {
		String simulateJS = ""

		try {
			simulateJS = readFile(new File(RunConfiguration.getProjectDir() + "\\Plugins\\Javascript Helper\\drag_and_drop_helper.js"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		WebUI.executeJavaScript(simulateJS, null)

		String dragDropScript = '$(arguments[0]).simulateDragDrop({ dropTarget: arguments[1]});'
		WebUI.executeJavaScript(dragDropScript, Arrays.asList(cssSelectorFrom, cssSelectorTo))
	}
}