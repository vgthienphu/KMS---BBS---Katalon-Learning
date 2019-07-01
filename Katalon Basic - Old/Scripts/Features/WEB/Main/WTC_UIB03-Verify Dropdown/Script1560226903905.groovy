import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Go to Dropdown List page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Dropdown', ('p_PageHeader') : 'Dropdown List'], 
    FailureHandling.STOP_ON_FAILURE)

'Get dropdown list web element'
def _Dropdown = findTestObject('Page_Dropdown List/cbo_Dropdown')

'Select item by label \'Option 2\' '
WebUI.selectOptionByLabel(_Dropdown, 'Option 2', GlobalVariable.NotRegex)

'The current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(_Dropdown, 'Option 2', GlobalVariable.NotRegex, GlobalVariable.ShortTime)

'Select item by index 1'
WebUI.selectOptionByIndex(_Dropdown, 1)

'The current item is \'Option 1\''
WebUI.verifyOptionSelectedByLabel(_Dropdown, 'Option 1', GlobalVariable.NotRegex, GlobalVariable.ShortTime)

'Select item by value 2'
WebUI.selectOptionByValue(_Dropdown, '2', GlobalVariable.NotRegex)

'The current item is \'Option 2\''
WebUI.verifyOptionSelectedByLabel(_Dropdown, 'Option 2', GlobalVariable.NotRegex, GlobalVariable.ShortTime)

