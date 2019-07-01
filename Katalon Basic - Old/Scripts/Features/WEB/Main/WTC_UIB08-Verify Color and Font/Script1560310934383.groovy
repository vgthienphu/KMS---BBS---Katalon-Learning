import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

'Go to Challenging DOM page'
WebUI.callTestCase(findTestCase('Common/WEB/Go to page'), [('p_LinkText') : 'Challenging DOM', ('p_PageHeader') : 'Challenging DOM'], 
    FailureHandling.STOP_ON_FAILURE)

'Get border color of \'foo\' button'
def _FontSize = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 1'), 'font-size')

'Verify font size of \'foo\' button'
WebUI.verifyEqual(_FontSize, '16px')

'Get background-color of \'qux\' button'
def _BackgroundColor = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 2'), 'background-color')

'Verify background-color of \'qux\' button'
WebUI.verifyEqual((_BackgroundColor == 'rgba(198, 15, 19, 1)') || (_BackgroundColor == 'rgb(198, 15, 19)'), true)

'Get border-left-color of \'baz\' button'
def _BorderLeftColor = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 3'), 'border-left-color')

'Get border-right-color of \'baz\' button'
def _BorderRightColor = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 3'), 'border-right-color')

'Get border-top-color of \'baz\' button'
def _BorderTopColor = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 3'), 'border-top-color')

'Get border-bottom-color of \'baz\' button'
def _BorderBottomColor = WebUI.getCSSValue(findTestObject('Object Repository/Page_Challenging DOM/btn_DOM button 3'), 'border-bottom-color')

'Verify border-color of \'baz\' button'
WebUI.verifyEqual(((borderColorIsCorrect(_BorderLeftColor) && borderColorIsCorrect(_BorderRightColor)) && borderColorIsCorrect(
        _BorderTopColor)) && borderColorIsCorrect(_BorderBottomColor), true)

boolean borderColorIsCorrect(String p_BorderColor) {
    return ((p_BorderColor == 'rgb(69, 122, 26)') || (p_BorderColor == 'rgba(69, 122, 26, 1)')) || (p_BorderColor == '#457a1a')
}

