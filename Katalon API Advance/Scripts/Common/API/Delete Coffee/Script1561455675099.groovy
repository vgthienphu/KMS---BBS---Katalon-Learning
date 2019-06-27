import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to delete coffee'
_Response = WS.sendRequest(findTestObject('API/Coffee/Delete Coffee', [id: p_Id, baseUrl: GlobalVariable.BaseUrl]))

'return response'
return [response: _Response]