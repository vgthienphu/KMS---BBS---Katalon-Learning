import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Send request to delete coffe'
def _Result = WS.callTestCase(findTestCase('Common/API/Delete Coffee'), [p_Id: p_CreatedCoffeeId], FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(_Result.response, 204)

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	def _Result = WS.callTestCase(findTestCase('Common/API/Add Coffee'), [('p_Description') : 'Test', ('p_Name') : 'Test'], FailureHandling.STOP_ON_FAILURE)
	p_CreatedCoffeeId = _Result.jsonBody.get('Id')
}

