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

// Generate code for verifying cart badge
// Verify that the cart badge is visible on the page
WebUI.verifyElementVisible(findTestObject('Object Repository/cart_badge'))
// Generate API test to parse JSON response and verify specific field value
// Send a GET request to the API endpoint and store the response
def response = WS.sendRequest(findTestObject('Object Repository/api_endpoint'))
// Verify that the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200)
// Parse the JSON response text
def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseBodyContent())
// Verify that the specific field 'fieldName' has the expected value 'expectedValue'
assert jsonResponse.fieldName == 'expectedValue'
