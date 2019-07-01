import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Go to Key Presses page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Key Presses', ('p_PageHeader') : 'Key Presses'], 
    FailureHandling.STOP_ON_FAILURE)

'Get result message web element'
TestObject _Result = findTestObject('Page_Key Presses/lbl_Result')

'Enter keys and verify the result'
for (String _Key : p_StringKeys) {
    CustomKeywords.'utils.Utils.sendKeyWithKeyboard'(_Key)

    WebUI.verifyElementText(_Result, 'You entered: ' + _Key.toUpperCase())
}

'Enter keys and verify the result'
for (Keys _Key : p_SpecialKeys) {
    CustomKeywords.'utils.Utils.sendKeyWithKeyboard'(_Key)

    WebUI.verifyElementText(_Result, 'You entered: ' + _Key.name())
}

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	'Set keys that need to be entered'
	p_StringKeys = ['g', 'a', 'b']
	
	'Set keys that need to be entered'
	p_SpecialKeys = [Keys.ENTER, Keys.TAB]
}

