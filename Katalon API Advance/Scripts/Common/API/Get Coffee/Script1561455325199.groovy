import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

'Send request to get coffee'
response = WS.sendRequest(findTestObject('API/Coffee/Get Coffee with Id', [id: p_Id]))

'Parse response body to JSON'
def jsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(response)

'Return response and json response body'
return [response: response, jsonBody: jsonBody]