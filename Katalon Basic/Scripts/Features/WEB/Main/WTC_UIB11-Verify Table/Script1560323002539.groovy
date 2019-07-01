import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Go to Data Tables page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Sortable Data Tables', ('p_PageHeader') : 'Data Tables'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify header at column 3 on Table 1'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Data Tables/tbl_Table Headers', [('tblId') : 'table1', ('colIndex') : 3]), 
    'Email')

'Verify cell value (row 3, column 2) on Table 1'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Data Tables/tbl_Cells in Table Body', [('tblId') : 'table1'
            , ('rowIndex') : 3, ('colIndex') : 2]), 'Jason')

'Verify cell value (row 2, column 4) on Table 1'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Data Tables/tbl_Cells in Table Body', [('tblId') : 'table1'
            , ('rowIndex') : 2, ('colIndex') : 4]), '$51.00')

'Click on \'Email\' header column on Table 2'
WebUI.click(findTestObject('Object Repository/Page_Data Tables/tbl_Table Headers', [('tblId') : 'table2', ('colIndex') : 3]))

'Get the list of email elements of table 2 after sorting'
List<WebElement> _ListEmailElmnt = WebUiCommonHelper.findWebElements(findTestObject('Page_Data Tables/tbl_List of Emails', 
        [('tblId') : 'table2']), GlobalVariable.MediumTime)

'Add emails to the list'
_ListEmailElmnt.each({ 
        p_ListEmailStr.add(it.getText())
    })

'Verify order of emails in the list is ascending'
WebUI.verifyEqual(CustomKeywords.'com.kms.web.Utilities.getSortOrderStatus'(p_ListEmailStr), 'ascending')

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	'Create an empty list of email (String)'
	p_ListEmailStr = new ArrayList()
}

