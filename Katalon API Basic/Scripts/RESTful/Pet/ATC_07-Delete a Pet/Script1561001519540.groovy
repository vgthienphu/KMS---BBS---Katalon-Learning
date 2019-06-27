import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

'Send request to delete a pet'
_Response = WS.sendRequest(findTestObject('RESTful/Pet/Delete a Pet', [petId: 300, baseUrl: GlobalVariable.PetBaseUrl]))

'Verify status code'
WS.verifyResponseStatusCode(_Response, 404)

'Verify response message'
WS.verifyElementPropertyValue(_Response, 'message', "Pet not found")

