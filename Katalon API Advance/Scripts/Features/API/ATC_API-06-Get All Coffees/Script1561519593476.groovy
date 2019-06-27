import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Send request to get all coffee'
def _Result = WS.callTestCase(findTestCase('Common/API/Get Coffee'), [('p_Id') : ''], FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(_Result.response, 200)

'Get the coffee with biggest id'
Map coffeeWithBiggestId = CustomKeywords.'Utils.getMapWithBiggestValueOfPropertyInArray'(_Result.jsonBody, 'Id')

'Send request to get coffee with the id at the step above'
_Result = WS.callTestCase(findTestCase('Common/API/Get Coffee'), [('p_Id') : coffeeWithBiggestId.Id], FailureHandling.STOP_ON_FAILURE)

'Verify the response Description and Name match the Description and Name of the coffee with biggest id'
CustomKeywords.'Utils.verifyResponsePropertiesValue'(_Result.response, [('Description') : coffeeWithBiggestId.Description, ('Name') : coffeeWithBiggestId.Name])
