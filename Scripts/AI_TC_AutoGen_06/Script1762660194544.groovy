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
// Generate code for checkout flow
// Open the Cura site using custom keyword
CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()

// Navigate to the appointment page
CustomKeywords.'com.yudi.helpers.NavigateHelper.goTo'('Make Appointment')

// Wait for the appointment page to load
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'), 30)

// Fill in the appointment form fields
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Healthcare Program'), 'Medicare')
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date'), '12/31/2024')
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/textarea_Comment'), 'Please handle with care.')

// Click the Book Appointment button
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'))

// Verify the appointment confirmation page is displayed
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Appointment Confirmation'))

// Capture screenshot of the confirmation page
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('AppointmentConfirmation')

// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()

