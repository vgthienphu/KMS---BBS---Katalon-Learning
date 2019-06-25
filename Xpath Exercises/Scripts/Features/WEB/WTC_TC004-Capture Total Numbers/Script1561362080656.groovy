import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Verify total number of \'Total Admins\' is 35'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Admin Dashboard/lbl_Total Numbers', [totalTxt: 'Total Admins']), '35')

'Verify total number of \'Total Customers\' is 14'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Admin Dashboard/lbl_Total Numbers', [totalTxt: 'Total Customers']), '14')

'Verify total number of \'Total Bookings\' is 6'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Admin Dashboard/lbl_Total Numbers', [totalTxt: 'Total Bookings']), '6')
