import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Go to File Uploader page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'File Upload', ('p_PageHeader') : 'File Uploader'], 
    FailureHandling.STOP_ON_FAILURE)

'Check which browser the test is being run on'
if (p_ExecutedBrowser == WebUIDriverType.IE_DRIVER) {
    'Upload file on IE'
    CustomKeywords.'utils.FileHandleHelper.uploadFileOnIE'(findTestObject('Page_File Upload/btn_Choose File'), p_FileLocation)
} else {
    'Upload file on Edge, Chrome or Firefox'
    WebUI.uploadFile(findTestObject('Page_File Upload/btn_Choose File'), p_FileLocation)
}

'Click on \'Upload\' button'
WebUI.click(findTestObject('Page_File Upload/btn_File Upload'))

'Verify page\'s header is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Base/lbl_Header', [('pageHeader') : 'File Uploaded!']))

'Verify the png file is uploaded successfully'
WebUI.verifyElementText(findTestObject('Page_File Upload/lbl_Uploaded Result'), p_ExecutedBrowser == WebUIDriverType.EDGE_DRIVER ? 'image1.png ' : 'image1.png')

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	'Get which browser is being run on'
	p_ExecutedBrowser = DriverFactory.getExecutedBrowser()

	'Set file location'
	p_FileLocation = RunConfiguration.getProjectDir().replace('/', '\\') + '\\Plugins\\Test Data Files\\Test Images\\image1.png'
}

