import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

'Set expected pet id'
def _PetID = 2

'Send request to get pet'
_Response = WS.sendRequest(findTestObject('RESTful/Pet/Get a Pet', [petId: _PetID, baseUrl: GlobalVariable.PetBaseUrl]))

'Verify status code'
WS.verifyResponseStatusCode(_Response, 200)

'Verify response pet id'
WS.verifyElementPropertyValue(_Response, 'id', _PetID)

'Verify response pet name'
WS.verifyElementPropertyValue(_Response, 'name', 'name2')

