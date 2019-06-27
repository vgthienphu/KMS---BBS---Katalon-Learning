import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

'Send request to add employee without zipcode field'
def res = WS.callTestCase(findTestCase('Common/API/Add Employee'), [('p_City') : p_City, ('p_Country') : p_Country, ('p_Street') : p_Street
        , ('p_FirstName') : p_FirstName, ('p_LastName') : p_LastName], FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(res.response, 200)

'Call request to get all employees'
res = WS.callTestCase(findTestCase('Common/API/Get Employee'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify no employee has first name and last name which match the ones in the step of adding new employee without zipcode'
CustomKeywords.'Utils.verifyNoElementWithPropertiesValue'(res.jsonBody, [FirstName: p_FirstName, LastName: p_LastName])

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	p_City = 'CityX'
	p_Country = 'CountryX'
	p_Street = 'StreetX'
	p_FirstName = 'FirstNameX'
	p_LastName = 'LastNameX'
}

