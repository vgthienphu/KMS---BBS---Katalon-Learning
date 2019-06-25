import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Go to base URL'
WebUI.navigateToUrl(GlobalVariable.BaseUrl)

'Select entry link'
WebUI.click(findTestObject('Object Repository/Page_The Internet/lnk_Entry to Page', [linkText: p_LinkText]))

'Verify page\'s header is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Base/lbl_Header', [pageHeader: p_PageHeader]))