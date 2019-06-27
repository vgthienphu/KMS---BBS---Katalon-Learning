import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send requrest to log in to the system'
def res = WS.callTestCase(findTestCase('Common/API/Log In'), [p_Username: GlobalVariable.ValidUsername, p_Password: GlobalVariable.ValidPassword], FailureHandling.STOP_ON_FAILURE)

'Verify response status'
WS.verifyResponseStatusCode(res.response, 200)

'Verify token is not null'
WS.verifyNotEqual(res.jsonBody.Token, null)

