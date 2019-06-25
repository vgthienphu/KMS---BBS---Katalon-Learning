import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Go to Checkboxes page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Checkboxes', ('p_PageHeader') : 'Checkboxes'], 
    FailureHandling.STOP_ON_FAILURE)

'Check \'checkbox 1\''
WebUI.check(findTestObject('Object Repository/Page_Checkboxes/chk_Checkbox', [chkLabel: 'checkbox 1']))

'Uncheck \'checkbox 2\''
WebUI.uncheck(findTestObject('Object Repository/Page_Checkboxes/chk_Checkbox', [chkLabel: 'checkbox 2']))

'Verify \'checkbox 1\' is checked'
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_Checkboxes/chk_Checkbox', [chkLabel: 'checkbox 1']), GlobalVariable.ShortTime)

'Verify \'checkbox 2\' is un-checked'
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_Checkboxes/chk_Checkbox', [chkLabel: 'checkbox 2']), GlobalVariable.ShortTime)
