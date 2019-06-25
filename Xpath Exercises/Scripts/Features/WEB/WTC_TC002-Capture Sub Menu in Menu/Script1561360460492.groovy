import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Verify sub menu \'Hotels\' in menu \'Hotels\' present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Admin Dashboard/mnu_Sub Menu in Menu', [mnuTxt: 'Hotels', subMnuTxt: 'Hotels']), GlobalVariable.MediumTime)

'Verify sub menu \'Extras\' in menu \'Hotels\' present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Admin Dashboard/mnu_Sub Menu in Menu', [mnuTxt: 'Hotels', subMnuTxt: 'Extras']), GlobalVariable.MediumTime)

'Verify sub menu \'Reviews\' in menu \'Hotels\' present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Admin Dashboard/mnu_Sub Menu in Menu', [mnuTxt: 'Hotels', subMnuTxt: 'Reviews']), GlobalVariable.MediumTime)