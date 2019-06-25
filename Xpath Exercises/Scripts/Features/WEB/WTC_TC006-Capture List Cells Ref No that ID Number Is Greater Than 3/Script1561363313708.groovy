import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

def cells = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_Admin Dashboard/lbl_List Cells'), GlobalVariable.MediumTime)

def expectedValues = ['5013', '2840', '8906']
for (def i = 0; i < cells.size(); i++) {
	WebUI.verifyEqual(cells[i].getText(), expectedValues[i])
}

	
