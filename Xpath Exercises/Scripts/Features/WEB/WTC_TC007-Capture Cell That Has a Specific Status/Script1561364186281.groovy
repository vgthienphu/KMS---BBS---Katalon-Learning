import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

def chkBoxes = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Page_Admin Dashboard/chk_Checkboxes with Status', [status: 'Paid']), GlobalVariable.MediumTime)

for (def chk: chkBoxes) {
	chk.click()
}

WebUI.scrollToElement(findTestObject('Object Repository/Page_Admin Dashboard/chk_Checkboxes with Status', [status: 'Paid']), GlobalVariable.MediumTime)

WebUI.delay(GlobalVariable.LongTime)
