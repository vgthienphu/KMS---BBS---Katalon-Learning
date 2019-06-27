import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to get employee'
_Response = WS.sendRequest(findTestObject('API/Employee/Get Employee', [baseUrl: GlobalVariable.BaseUrl]))

'Parse response body to JSON'
ArrayList _JsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(_Response)

'Return response and json response body'
return [response: _Response, jsonBody: _JsonBody]