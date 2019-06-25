package utils

import java.awt.Robot
import java.awt.event.KeyEvent

import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class SliderHelper {
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
}
