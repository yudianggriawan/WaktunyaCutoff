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

// Generate custom keyword to handle file upload using WebUI
/*
 * Upload a file to a file input element using WebUI
 *
 * @param testObject The TestObject representing the file input element
 * @param filePath The absolute path of the file to upload
 */
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

@Keyword
def uploadFile(TestObject testObject, String filePath) {
    // Set the file path to the file input element to upload the file
    WebUI.uploadFile(testObject, filePath)
}
// Generate custom keyword to read data from Excel file
/*
 * Read data from an Excel file and return it as a list of maps
 *
 * @param filePath The absolute path of the Excel file
 * @param sheetName The name of the sheet to read data from
 * @return List of maps where each map represents a row with column headers as keys
 */
import com.kms.katalon.core.annotation.Keyword
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Cell
import java.io.FileInputStream

@Keyword
def readExcelData(String filePath, String sheetName) {
    FileInputStream fis = new FileInputStream(filePath) // Open Excel file input stream
    def workbook = WorkbookFactory.create(fis) // Create workbook from input stream
    Sheet sheet = workbook.getSheet(sheetName) // Get the specified sheet
    List<Map<String, String>> data = [] // Initialize list to hold row data maps
    Row headerRow = sheet.getRow(0) // Get header row
    int lastRowNum = sheet.getLastRowNum() // Get last row number
    int lastCellNum = headerRow.getLastCellNum() // Get number of columns

    for (int i = 1; i <= lastRowNum; i++) { // Iterate over rows starting from 1 (skip header)
        Row currentRow = sheet.getRow(i)
        if (currentRow == null) {
            continue // Skip empty rows
        }
        Map<String, String> rowData = [:] // Map to hold current row data
        for (int j = 0; j < lastCellNum; j++) { // Iterate over columns
            Cell headerCell = headerRow.getCell(j)
            Cell currentCell = currentRow.getCell(j)
            String key = headerCell != null ? headerCell.toString() : "Column" + j
            String value = currentCell != null ? currentCell.toString() : ""
            rowData.put(key, value) // Put cell value into map with header as key
        }
        data.add(rowData) // Add row map to list
    }
    workbook.close() // Close workbook
    fis.close() // Close file input stream
    return data // Return list of row data maps
}
// Generate code for checkout flow
// Open the Cura site
CustomKeywords.'com.yudi.helpers.LoginHelper.openCuraSite'()

// Navigate to the login page
CustomKeywords.'com.yudi.helpers.NavigateHelper.goTo'('Login Page')

// Enter username
WebUI.setText(findTestObject('Object Repository/LoginPage/input_username'), 'JohnDoe')

// Enter password
WebUI.setEncryptedText(findTestObject('Object Repository/LoginPage/input_password'), 'encryptedPasswordHere')

// Click login button
WebUI.click(findTestObject('Object Repository/LoginPage/button_login'))

// Verify successful login by checking page title contains 'CURA Healthcare Service'
CustomKeywords.'com.yudi.helpers.TitleHelper.verifyTitleContains'('CURA Healthcare Service')

// Navigate to the appointment page
CustomKeywords.'com.yudi.helpers.NavigateHelper.goTo'('Make Appointment')

// Select facility from dropdown
WebUI.selectOptionByLabel(findTestObject('Object Repository/AppointmentPage/select_facility'), 'Hongkong CURA Healthcare Center', false)

// Check hospital readmission checkbox
WebUI.check(findTestObject('Object Repository/AppointmentPage/checkbox_hospital_readmission'))

// Select healthcare program radio button
WebUI.click(findTestObject('Object Repository/AppointmentPage/radio_medicare'))

// Set visit date
WebUI.setText(findTestObject('Object Repository/AppointmentPage/input_visit_date'), '12/25/2024')

// Enter comment
WebUI.setText(findTestObject('Object Repository/AppointmentPage/textarea_comment'), 'Looking forward to the appointment.')

// Click book appointment button
WebUI.click(findTestObject('Object Repository/AppointmentPage/button_book_appointment'))

// Verify appointment confirmation page title contains 'Appointment Confirmation'
CustomKeywords.'com.yudi.helpers.TitleHelper.verifyTitleContains'('Appointment Confirmation')

// Capture screenshot of confirmation page
CustomKeywords.'com.yudi.helpers.ScreenshotHelper.capture'('AppointmentConfirmation')

// Close the browser
CustomKeywords.'com.yudi.helpers.CloseHelper.closeBrowser'()
