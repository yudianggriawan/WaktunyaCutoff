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
// Set viewport size to 1280x720 using custom keyword
CustomKeywords.'com.yudi.helpers.ViewportHelper.setViewport'(1280, 720)
// Wait for 2 seconds to ensure page is loaded using custom keyword
CustomKeywords.'com.yudi.helpers.WaitHelper.waitForSeconds'(2)
// Click the login button to open login form
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))
// Set invalid username in username field
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), 'invalidUser')
// Set invalid password in password field
WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), 'invalidPassword')
// Click the login submit button
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_LoginSubmit'))
// Verify error message is visible indicating invalid login
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_CURA Healthcare Service/div_Login failed'))
// Capture screenshot of the error state using custom keyword
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('InvalidLoginError')
// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()

