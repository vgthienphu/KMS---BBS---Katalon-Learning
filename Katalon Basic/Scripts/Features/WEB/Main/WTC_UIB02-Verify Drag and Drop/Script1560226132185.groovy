import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Go to Drag and Drop page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Drag and Drop', ('p_PageHeader') : 'Drag and Drop'], 
    FailureHandling.STOP_ON_FAILURE)

'Drag and Drop column A to column B'
CustomKeywords.'utils.DragDropHelper.dragDrop'('#column-a', '#column-b')

'Verify column A changed to column B'
WebUI.verifyElementText(findTestObject('Page_Drag and Drop/lbl_A'), 'B')

'Verify column B changed to column A'
WebUI.verifyElementText(findTestObject('Page_Drag and Drop/lbl_B'), 'A')