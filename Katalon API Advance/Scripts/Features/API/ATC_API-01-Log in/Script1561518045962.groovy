import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to log in to the system'
def _Result = WS.callTestCase(findTestCase('Common/API/Log In'), [p_Username: GlobalVariable.ValidUsername, p_Password: GlobalVariable.ValidPassword], FailureHandling.STOP_ON_FAILURE)

'Verify response status'
WS.verifyResponseStatusCode(_Result.response, 200)

'Verify token is not null'
WS.verifyNotEqual(_Result.jsonBody.Token, null)

