package calculator

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

public class Elements {
	@Keyword
	public void selectNumber(int number) {
		String numbStr = number.toString()
		int length = numbStr.length()

		for (int i = 0; i < length; i++) {
			Mobile.tap(findTestObject('Object Repository/Calculator/btn_Number', [number: numbStr.charAt(i)]), GlobalVariable.ShortTime)
		}
	}

	@Keyword
	public void tapPlus() {
		Mobile.tap(findTestObject('Calculator/btn_Plus'), GlobalVariable.ShortTime)
	}

	@Keyword
	public void tapSubstract() {
		Mobile.tap(findTestObject('Object Repository/Calculator/btn_Substract'), GlobalVariable.ShortTime)
	}

	@Keyword
	public void tapMultiply() {
		Mobile.tap(findTestObject('Object Repository/Calculator/btn_Multiply'), GlobalVariable.ShortTime)
	}

	@Keyword
	public void tapDivide() {
		Mobile.tap(findTestObject('Object Repository/Calculator/btn_Divide'), GlobalVariable.ShortTime)
	}

	@Keyword
	public void tapEqual() {
		Mobile.tap(findTestObject('Calculator/btn_Equal'), GlobalVariable.ShortTime)
	}

	@Keyword
	public void verifyCalculateResult(String expectedResult) {
		Mobile.verifyElementText(findTestObject('Calculator/lbl_Result'), expectedResult)
	}
}
