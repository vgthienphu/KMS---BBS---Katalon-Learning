import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

'Select 30'
CustomKeywords.'calculator.Elements.selectNumber'(30)

'Tap Substract'
CustomKeywords.'calculator.Elements.tapSubstract'()

'Select 15'
CustomKeywords.'calculator.Elements.selectNumber'(15)

'Tap Equal'
CustomKeywords.'calculator.Elements.tapEqual'()

'Verify result'
CustomKeywords.'calculator.Elements.verifyCalculateResult'('15')

