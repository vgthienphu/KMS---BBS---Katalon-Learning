import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Send request to add coffee'
def res = WS.callTestCase(findTestCase('Common/API/Add Coffee'), [('p_Description') : p_Description, ('p_Name') : p_Name], 
    FailureHandling.STOP_ON_FAILURE)

'Verify status code'
WS.verifyResponseStatusCode(res.response, 200)

'Verify response Description and Name'
CustomKeywords.'Utils.verifyResponsePropertiesValue'(res.response, [('Description') : p_Description, ('Name') : p_Name])

'Set the created coffee Id to delete after test'
p_IdToDelete = res.jsonBody.Id

@com.kms.katalon.core.annotation.SetUp
def setUp() {
    p_Description = 'DescriptionXX'

    p_Name = 'NameXX'
}

@com.kms.katalon.core.annotation.TearDown
def tearDown() {
	'Delete created coffee after test'
	WebUI.callTestCase(findTestCase('Common/API/Delete Coffee'), [('p_Id') : p_IdToDelete], FailureHandling.STOP_ON_FAILURE)
}

