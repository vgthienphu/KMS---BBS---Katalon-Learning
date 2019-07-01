import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Go to JavaScript Alerts page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'JavaScript Alerts', ('p_PageHeader') : 'JavaScript Alerts'], 
    FailureHandling.STOP_ON_FAILURE)

'Click on \'Click for JS Alert\' button'
WebUI.click(findTestObject('Object Repository/Page_JavaScript Alerts/btn_JS Button', [('btnText') : 'Click for JS Alert']))

'\'I am a JS Alert\' messge is displayed'
WebUI.verifyEqual(WebUI.getAlertText(), 'I am a JS Alert')

'Click \'OK\' button to close Alert'
WebUI.acceptAlert()

'On Edge, wait before verifying result message'
CustomKeywords.'com.kms.web.Elements.delayOn'(WebUIDriverType.EDGE_DRIVER, GlobalVariable.ShortTime)

'Get result message web element'
TestObject _Result = findTestObject('Page_JavaScript Alerts/lbl_Result')

'Verify the result message'
WebUI.verifyElementText(_Result, 'You successfuly clicked an alert')

'Click on \'Click for JS Confirm\' button'
WebUI.click(findTestObject('Object Repository/Page_JavaScript Alerts/btn_JS Button', [('btnText') : 'Click for JS Confirm']))

'Click \'Cancel\' button to close Alert'
WebUI.dismissAlert()

'On Edge, wait before verifying result message'
CustomKeywords.'com.kms.web.Elements.delayOn'(WebUIDriverType.EDGE_DRIVER, GlobalVariable.ShortTime)

'Verify the result message'
WebUI.verifyElementText(_Result, 'You clicked: Cancel')

'Click on \'Click for JS Prompt\' button'
WebUI.click(findTestObject('Object Repository/Page_JavaScript Alerts/btn_JS Button', [('btnText') : 'Click for JS Prompt']))

'Set expected text which will be enter to the alert'
String _ExpectedText = 'Hello'

'Set text to the alert'
WebUI.setAlertText(_ExpectedText)

'Click \'OK\' button to close Alert'
WebUI.acceptAlert()

'On Edge, wait before verifying result message'
CustomKeywords.'com.kms.web.Elements.delayOn'(WebUIDriverType.EDGE_DRIVER, GlobalVariable.ShortTime)

'Verify the result message'
WebUI.verifyElementText(_Result, 'You entered: ' + _ExpectedText)


