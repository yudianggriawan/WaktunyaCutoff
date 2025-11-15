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

// Open the Sauce Demo website
WebUI.openBrowser('https://www.saucedemo.com')

// Maximize the browser window
WebUI.maximizeWindow()

// Wait for the username field to be visible
WebUI.waitForElementVisible(findTestObject('Page_SauceDemo/input_Username'), 10)

// Set username
WebUI.setText(findTestObject('Page_SauceDemo/input_Username'), 'standard_user')

// Set password
WebUI.setText(findTestObject('Page_SauceDemo/input_Password'), 'secret_sauce')

// Click on the login button
WebUI.click(findTestObject('Page_SauceDemo/input_Login'))

// Verify login was successful by checking the presence of the product page element
WebUI.verifyElementPresent(findTestObject('Page_SauceDemo/div_Products'), 10)

// Close the browser
WebUI.closeBrowser()