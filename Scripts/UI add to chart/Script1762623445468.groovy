import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Open the browser and navigate to Saucedemo login page
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com')

// Log in with valid credentials
WebUI.setText(findTestObject('Page_Swag Labs/input_Username'), 'standard_user')
WebUI.setText(findTestObject('Page_Swag Labs/input_Password'), 'secret_sauce')
WebUI.click(findTestObject('Page_Swag Labs/input_Login_Button'))

// Add first product to cart
WebUI.click(findTestObject('Page_Swag Labs/button_Add_to_Cart_Product_1'))

// Add second product to cart
WebUI.click(findTestObject('Page_Swag Labs/button_Add_to_Cart_Product_2'))

// Verify that the cart badge shows 2
String cartBadge = WebUI.getText(findTestObject('Page_Swag Labs/span_Cart_Badge'))
WebUI.verifyEqual(cartBadge, '2')

// Close the browser
WebUI.closeBrowser()
