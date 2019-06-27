import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

'Send request to get coffee'
_Response = WS.sendRequest(findTestObject('API/Coffee/Get Coffee with Id', [id: p_Id, baseUrl: GlobalVariable.BaseUrl]))

'Parse response body to JSON'
def _JsonBody = CustomKeywords.'Utils.parseResponeBodytoJSON'(_Response)

'Return response and json response body'
return [response: _Response, jsonBody: _JsonBody]