import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Go to Horizontal Slider page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Horizontal Slider', ('p_PageHeader') : 'Horizontal Slider'], 
    FailureHandling.STOP_ON_FAILURE)

'Set expected values to slide the slider to'
def _Values = [1, 2.5, 4.5]

'Get slider web element'
TestObject _Slider = findTestObject('Page_Horizontal Slider/sld_Horizontal Slider')

for (double _Value : _Values) {
	'Check which browser the test is being run on'
	if (p_ExecutedBrowser == WebUIDriverType.EDGE_DRIVER) {
		'Set additional pixels when dragging'
		double additionalPixels = _Value < 5 ? _Value + 6 : _Value + 10
	
		'Slide slider to each value on Edge'
		CustomKeywords.'utils.SliderHelper.slideTo'(_Slider, _Value, additionalPixels)
	
		'Delay a second'
		WebUI.delay(GlobalVariable.ShortTime)
	} else {
		if (p_ExecutedBrowser == WebUIDriverType.IE_DRIVER) {
			'Slide slider to each value on IE'
			CustomKeywords.'utils.SliderHelper.slideToByPressingArrowKeys'(_Slider, _Value)
		} else {
			'Slide slider to each value on other browsers'
			CustomKeywords.'utils.SliderHelper.slideTo'(_Slider, _Value)
		}
	}
}


@com.kms.katalon.core.annotation.SetUp
def setUp() {
	'Get which browser is being run on'
	p_ExecutedBrowser = DriverFactory.getExecutedBrowser()
}
