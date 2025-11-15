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

// Generate API test to verify 200 OK response status
// Send a GET request to the specified API endpoint and store the response
def response = WS.sendRequest(findTestObject('Object Repository/API/YourApiEndpoint'))
// Verify that the response status code is 200 OK
WS.verifyResponseStatusCode(response, 200)
/*
*  Verify that the API response status code is 200 OK
*
*  1. Use the WS keyword to check the status code of the response object.
*  2. Confirm that the status code equals 200, indicating a successful request.
*/
// Generate API test to validate response time below 3 seconds
// Send a GET request to the specified API endpoint and store the response
def response = WS.sendRequest(findTestObject('Object Repository/API/YourApiEndpoint'))
// Verify that the response time is less than 3000 milliseconds (3 seconds)
WS.verifyResponseTime(response, 3000)
