import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Go to WYSIWYG Editor page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'WYSIWYG Editor', ('p_PageHeader') : 'An iFrame containing the TinyMCE WYSIWYG Editor'], 
    FailureHandling.STOP_ON_FAILURE)

'Switch to the editor'
WebUI.switchToFrame(findTestObject('Page_WYSIWYG Editor/ifr_Editor'), GlobalVariable.LongTime)

'Verify the default content'
WebUI.verifyElementText(findTestObject('Page_WYSIWYG Editor/txt_Editor'), 'Your content goes here.')

for (def _D : p_Data) {
	'Set new content'
	p_NewContent = _D.content
	
	'Clear default content'
	WebUI.clearText(findTestObject('Page_WYSIWYG Editor/txt_Editor'))
	
	'Set new content'
	if ((p_ExecutedBrowser == WebUIDriverType.EDGE_DRIVER) || (p_ExecutedBrowser == WebUIDriverType.IE_DRIVER)) {
		'Set new content on Edge or IE'
		CustomKeywords.'utils.Utils.editContentByJS'(findTestObject('Page_WYSIWYG Editor/txt_Editor'), p_NewContent)
	} else {
		'Set new content on other browsers'
		WebUI.sendKeys(findTestObject('Page_WYSIWYG Editor/txt_Editor'), p_NewContent)
	}
	
	'Verify the content after setting the new one'
	WebUI.verifyElementText(findTestObject('Page_WYSIWYG Editor/txt_Editor'), p_NewContent)
}

@com.kms.katalon.core.annotation.SetUp
def setUp() {
    'Get which browser the test is being run on'
    p_ExecutedBrowser = DriverFactory.getExecutedBrowser()

	'Get test data'
    p_Data = WebUI.callTestCase(findTestCase('Common/WEB/Prepare Data'), [('p_DataFileName') : 'Data Files/WEB/Main/Frame Content'], FailureHandling.STOP_ON_FAILURE)
}

