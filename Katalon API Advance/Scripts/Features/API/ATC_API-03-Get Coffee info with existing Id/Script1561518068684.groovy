import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Send request with id to get coffee'
def _Result = WS.callTestCase(findTestCase('Common/API/Get Coffee'), [('p_Id') : p_Id], FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(_Result.response, 200)

'Verify response Description and Name'
CustomKeywords.'Utils.verifyResponsePropertiesValue'(_Result.response, [('Description') : p_ExpectedDescription, ('Name') : p_ExpectedName])

@com.kms.katalon.core.annotation.SetUp
def setUp() {
    p_Id = '38'
    p_ExpectedDescription = 'DescriptionXX'
    p_ExpectedName = 'NameXX'
}

