import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Go to JQueryUI - Menu page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'JQuery UI Menus', ('p_PageHeader') : 'JQueryUI - Menu'], 
    FailureHandling.STOP_ON_FAILURE)

'Select Enabled -> \'Back to JQuery UI\' menu'
CustomKeywords.'com.kms.web.Elements.selectContextMenu'(Arrays.asList('Enabled', 'Back to JQuery UI'))

'Verify page\'s header is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Base/lbl_Header', [pageHeader: 'JQuery UI']))

'Click on Menu link'
WebUI.click(findTestObject('Page_JQuery UI/lnk_Menu'))

'Verify page\'s header is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Base/lbl_Header', [pageHeader: 'JQueryUI - Menu']))

'Delete file before downloading it'
CustomKeywords.'com.kms.web.Utilities.deleteFile'(p_DownloadLocation, p_FileName)

'Select Enabled -> Downloads -> CSV menu'
CustomKeywords.'com.kms.web.Elements.selectContextMenu'(Arrays.asList('Enabled', 'Downloads', 'CSV'))

'Check if the test is being run on IE browser'
if (p_ExecutedBrowser == WebUIDriverType.IE_DRIVER) {
	'Wait until download alert is displayed'
    WebUI.delay(GlobalVariable.MediumTime)

	'Press Alt + S to save file'
    CustomKeywords.'com.kms.web.Utilities.pressAltS'()
}

'Wait until file downloaded successfully'
CustomKeywords.'com.kms.web.Utilities.waitUntilFileDownloaded'(p_DownloadLocation, p_FileName, GlobalVariable.LongTime, GlobalVariable.ShortTime)

@com.kms.katalon.core.annotation.SetUp
def setUp() {
    'Get which browser is being run on'
    p_ExecutedBrowser = DriverFactory.getExecutedBrowser()
	
	'Set download location'
	p_DownloadLocation = System.getProperty('user.home') + '\\Downloads\\'
	
	'Set the file name which will be downloaded'
	p_FileName = 'menu.csv'
}
