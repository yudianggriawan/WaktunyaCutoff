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

// Generate test for invalid logout case
// Open the Cura site using custom keyword
CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()

// Attempt to navigate to logout URL directly without login
CustomKeywords.'com.yudi.helpers.NavigateHelper.goTo'('/profile.php#logout')

// Verify that the title contains expected text indicating user is not logged in or redirected
CustomKeywords.'com.yudi.helpers.TitleHelper.verifyTitleContains'('CURA Healthcare Service')

// Capture screenshot of the invalid logout attempt
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('invalid_logout_attempt')

*  Capture a screenshot with a specified filename
*
*      - Parameters:
*          - String 'invalid_logout_attempt': the name to save the screenshot file as
*      - Steps:
*          1. Invoke the capture method of ScreenshotHelper with the given filename
*          2. Take a screenshot of the current browser view
*          3. Save the screenshot using the provided filename
* /

// Close the browser using custom keyword
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()
