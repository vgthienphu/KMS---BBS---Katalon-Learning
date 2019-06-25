import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.navigateToUrl('https://www.phptravels.net/admin-portal/admin')

WebUI.setText(findTestObject('Page_Administator Login/txt_Login Email'), 'admin@phptravels.com')

WebUI.setEncryptedText(findTestObject('Page_Administator Login/txt_Login Password'), 'orSGNCvhf+w8SKCExcig5g==')

WebUI.click(findTestObject('Page_Administator Login/btn_Login'))

WebUI.verifyElementVisible(findTestObject('Page_Admin Dashboard/lnk_Logout'))


