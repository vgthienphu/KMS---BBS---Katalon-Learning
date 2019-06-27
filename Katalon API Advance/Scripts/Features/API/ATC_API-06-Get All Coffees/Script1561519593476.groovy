import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Send request to get all coffee'
def res = WS.callTestCase(findTestCase('Common/API/Get Coffee'), [('p_Id') : ''], FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(res.response, 200)

'Get the coffee with biggest id'
Map coffeeWithBiggestId = CustomKeywords.'Utils.getMapWithBiggestValueOfPropertyInArray'(res.jsonBody, 'Id')

'Send request to get coffee with the id at the step above'
res = WS.callTestCase(findTestCase('Common/API/Get Coffee'), [('p_Id') : coffeeWithBiggestId.Id], FailureHandling.STOP_ON_FAILURE)

'Verify the response Description and Name match the Description and Name of the coffee with biggest id'
CustomKeywords.'Utils.verifyResponsePropertiesValue'(res.response, [('Description') : coffeeWithBiggestId.Description, ('Name') : coffeeWithBiggestId.Name])
