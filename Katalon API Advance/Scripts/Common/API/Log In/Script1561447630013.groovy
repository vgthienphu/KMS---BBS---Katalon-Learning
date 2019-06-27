import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

'Send request to log in'
response = WS.sendRequest(findTestObject('API/General/Log in', [username: p_Username, password: p_Password]))

'Parse response body to JSON'
Map jsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(response)

'Return response and json response body'
return [response: response, jsonBody: jsonBody]


