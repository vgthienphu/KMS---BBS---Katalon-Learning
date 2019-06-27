import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to log in'
_Response = WS.sendRequest(findTestObject('API/General/Log in', [username: p_Username, password: p_Password, baseUrl: GlobalVariable.BaseUrl]))

'Parse response body to JSON'
Map _JsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(_Response)

'Return response and json response body'
return [response: _Response, jsonBody: _JsonBody]


