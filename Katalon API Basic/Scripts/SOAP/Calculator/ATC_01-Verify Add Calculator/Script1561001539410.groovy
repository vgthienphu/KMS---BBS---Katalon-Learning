import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to calculate add'
_Response = WS.sendRequest(findTestObject('SOAP/Calculator/Add Calculator', [url: GlobalVariable.CalculatorUrl]))

'Verify status code'
WS.verifyResponseStatusCode(_Response, 200)

'Verify add result'
WS.verifyElementPropertyValue(_Response, 'AddResult', 15)

