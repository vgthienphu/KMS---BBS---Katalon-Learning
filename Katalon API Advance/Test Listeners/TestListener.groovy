import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

class TestListener {
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		def res = WS.callTestCase(findTestCase('Common/API/Log In'), [:], FailureHandling.STOP_ON_FAILURE)
		
		GlobalVariable.Token = res.jsonBody.Token
	}
}