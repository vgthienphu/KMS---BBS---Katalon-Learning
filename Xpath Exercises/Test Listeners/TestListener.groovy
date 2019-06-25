import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class TestListener {
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		WebUI.openBrowser('')
		
		WebUI.callTestCase(findTestCase('Common/WEB/Log In'), [:], FailureHandling.STOP_ON_FAILURE)
	}


	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		WebUI.closeBrowser()
	}
}