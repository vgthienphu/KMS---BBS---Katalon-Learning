import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable

'Send request to calculate multiply'
_Response = WS.sendRequest(findTestObject('SOAP/Calculator/Multiply Calculator', [url: GlobalVariable.CalculatorUrl]))

'Verify status code'
WS.verifyResponseStatusCode(_Response, 200)

'Verify calculate result'
WS.verifyElementPropertyValue(_Response, 'MultiplyResult', 24)

