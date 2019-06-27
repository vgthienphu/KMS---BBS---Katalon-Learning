import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to get employee'
response = WS.sendRequest(findTestObject('API/Employee/Get Employee', [:]))

'Parse response body to JSON'
ArrayList jsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(response)

'Return response and json response body'
return [response: response, jsonBody: jsonBody]