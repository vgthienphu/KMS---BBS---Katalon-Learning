import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to add employee'
response = WS.sendRequest(findTestObject('API/Employee/Add Employee', [city: p_City, country: p_Country, street: p_Street, firstName: p_FirstName, lastName: p_LastName]))

'Parse response body to JSON'
Map jsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(response)

'Return response and json response body'
return [response: response, jsonBody: jsonBody]