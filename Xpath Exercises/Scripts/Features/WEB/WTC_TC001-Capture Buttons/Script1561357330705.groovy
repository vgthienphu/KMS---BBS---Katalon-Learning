import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Verify button \'Website\' is visible'
WebUI.verifyElementVisible(findTestObject('Page_Admin Dashboard/btn_Buttons on Page', [('btnTxt') : 'Website']))

'Verify button \'Delete Selected\' is visible'
WebUI.verifyElementVisible(findTestObject('Page_Admin Dashboard/btn_Buttons on Page', [('btnTxt') : 'Delete Selected']))

'Verify button \'Search\' is visible'
WebUI.verifyElementVisible(findTestObject('Page_Admin Dashboard/btn_Buttons on Page', [('btnTxt') : 'Search']))

'Verify button \'Reset Chart\' is visible'
WebUI.verifyElementVisible(findTestObject('Page_Admin Dashboard/btn_Buttons on Page', [('btnTxt') : 'Reset Chart']))


