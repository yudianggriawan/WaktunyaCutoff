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

// Generate test for invalid login case
// Open the Cura site using custom keyword
CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()

// Wait for 2 seconds to ensure page is loaded
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(2)

// Set invalid username in the username input field
WebUI.setText(findTestObject('Object Repository/Page_CuraLogin/input_username'), 'invalidUser')

// Set invalid password in the password input field
WebUI.setEncryptedText(findTestObject('Object Repository/Page_CuraLogin/input_password'), 'invalidPasswordEncrypted')

// Click the login button
WebUI.click(findTestObject('Object Repository/Page_CuraLogin/button_Login'))

// Wait for 2 seconds to allow error message to appear
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(2)

// Verify that the error message is visible
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_CuraLogin/div_LoginFailedMessage'))

// Capture screenshot of the error message
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('InvalidLoginError')

// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()
/*
*  Close the browser window to end the test session
*
*  1. Call the custom keyword method closeBrowser() from the CloseHelper class
*  2. This method handles closing the active browser instance used in the test
*/
