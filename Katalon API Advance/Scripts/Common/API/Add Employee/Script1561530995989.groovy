import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to add employee'
_Response = WS.sendRequest(findTestObject('API/Employee/Add Employee', [city: p_City, country: p_Country, street: p_Street, firstName: p_FirstName, lastName: p_LastName, baseUrl: GlobalVariable.BaseUrl]))

'Parse response body to JSON'
Map _JsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(_Response)

'Return response and json response body'
return [response: _Response, jsonBody: _JsonBody]